package org.usfirst.frc.team1675.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;

/* 
 * This class acts like a speedcontroller, but it actually controls speed, instead of voltage.
 * The pidController is internal, but you can access its values for P, I, D, and F through this 
 * class.  You can also set P, I, D, and F so tuning from smartDashboard can be implemented.
 * The idea is that each wheel would have its own set of PID constants, which are passed in here.
*/
public class PIDSpeedControllerForVelocity implements SpeedController{
	SpeedController motor;
	EncoderVelocitySource encoderSource;
	PIDController pid;
	public PIDSpeedControllerForVelocity(SpeedController motor, Encoder encoder, int ticksPerRevolution, double p, double i, double d, double f){
		this.motor = motor;
		encoderSource = new EncoderVelocitySource(encoder, ticksPerRevolution);
		pid = new PIDController(p, i , d, f, encoderSource , motor);
		pid.enable();
		pid.setSetpoint(0);
	}
	public void disablePID(){
		pid.disable();
		motor.set(0);
	}
	public void pidWrite(double output) {
		motor.pidWrite(output);		
	}

	public double get() {  //returns the actual value(voltage) given to the speedController, I don't know how to make this return the last thing this was asked to do
		return motor.get();
	}

	public void set(double speed, byte syncGroup) {  //this method still controls voltage.  I'm not sure what a 'syncgroup' is.
		motor.set(speed, syncGroup);		
	}

	public void set(double proportionOfMax) {
		pid.setSetpoint(RobotMap.DriveEncoders.DRIVE_MAX_SPEED * proportionOfMax);
	}
	public void disable() {
		motor.disable();
		pid.disable();		
	}
	public double getP(){
		return pid.getP();
	}
	public double getI(){
		return pid.getI();
	}
	public double getD(){
		return pid.getD();
	}
	public double getF(){
		return pid.getF();
	}
	public void setPIDF(double p, double i, double d, double f){ 
		pid.setPID(p, i, d, f);
	}
	public void setRawPower(double power){
		motor.set(power);
	}

}
