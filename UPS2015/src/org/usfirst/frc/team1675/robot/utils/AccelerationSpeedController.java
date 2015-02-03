package org.usfirst.frc.team1675.robot.utils;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AccelerationSpeedController implements SpeedController{
	
	private final SpeedController speedController;
    private final static double msPerLoop = 20.0;
    
    double threshold;
    double rampTime;
    
    double previousPower;
    double accelerationDebt;

    double initialPower;

    boolean inAccelerationSession;	
	
	public AccelerationSpeedController(SpeedController speedController, double threshold, double rampTime){
		this.speedController = speedController;
		
        threshold = 0.10; //got this from xbox controller
        rampTime = 120; //rampTime affects the amount of time it takes to ramp, but does not directly correlate.		
	}

	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		this.set(output);		
	}

	@Override
	public double get() {
		return speedController.get();
	}

	@Override
	public void set(double speed, byte syncGroup) {
		this.set(speed);		
	}

	@Override
	public void set(double speed) {
		double accleratedSpeed = accelerate(speed);
		speedController.set(accleratedSpeed);		
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		speedController.disable();
	}

    public double accelerate(double speed) {
        double difference = speed - previousPower;
        accelerationDebt = accelerationDebt + difference; //AccelerationDebts has a maximum size?

        double motorPower;
        if (Math.abs(accelerationDebt) < threshold) {
            initialPower = 0;
            accelerationDebt = 0;
            inAccelerationSession = false;
            motorPower = speed;
            SmartDashboard.putBoolean("Accelerating?", inAccelerationSession);
        } else {
            SmartDashboard.putBoolean("Accelerating?", inAccelerationSession);
            if (!inAccelerationSession) {
                inAccelerationSession = true;
                initialPower = previousPower;
            }
            double loopsToRamp = Math.ceil(rampTime * (1 / msPerLoop));
            double increment = 1 / loopsToRamp * accelerationDebt;
            motorPower = initialPower + increment;
            initialPower = motorPower;
            accelerationDebt = accelerationDebt - increment;

            SmartDashboard.putNumber("Increment", increment);
        }
        previousPower = speed;
        SmartDashboard.putNumber("AccelerationDebt", accelerationDebt);
        SmartDashboard.putNumber("MotorPower", motorPower);
        
        return motorPower;        
    }
	
}
