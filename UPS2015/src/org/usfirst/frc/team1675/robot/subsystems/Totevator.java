package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerManual;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Totevator extends PIDSubsystem {
	public static final int TICKS_PER_TOTEHOOK = 270;
	public static final int TICKS_TO_DROP = 75; //maybe?
	
	SpeedController toteMotor;
	Encoder totevatorEncoder;
	
	public Totevator(double p, double i, double d){
		super(p, i, d);
		toteMotor = new VictorSP(RobotMap.PWMChannels.TOTE_ELEVATOR);
		totevatorEncoder = new Encoder(RobotMap.DIOChannels.TOTEVATOR_ENCODER_A, RobotMap.DIOChannels.TOTEVATOR_ENCODER_B);
		totevatorEncoder.setDistancePerPulse(1.0);
		this.enable();
		this.setSetpoint(0);
		SmartDashboard.putBoolean("TotePIDEnabled", true);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ToteStackerManual());
    }
    
    /**
     * 
     * @param point tells the exact point the tote stacker will move to
     */
    public void goToPoint(int point){
    	this.setSetpoint(point);
    	System.out.println("goToPoint new setpoint: " + this.getSetpoint());

    }
    
    /**
     * 
     * @param distance tells how far the tote stacker moves from it's current point
     */
    public void moveRelative(int distance){
    	this.setSetpoint(this.getSetpoint() + distance);
    	System.out.println("moveRelative new setpoint: " + this.getSetpoint());
    }
    
    public void setManualMovement(double MotorValue){
    	if (!this.getPIDController().isEnable()){
    		toteMotor.set(MotorValue);
    	}
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		SmartDashboard.putNumber("totevatorEncoder", totevatorEncoder.getDistance());
		return totevatorEncoder.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		toteMotor.set(output);
		
	}

	public void resetEncoder() {
		this.totevatorEncoder.reset();
	}
	
	public void togglePID() {
		if(this.getPIDController().isEnable()){
			this.getPIDController().disable();
			SmartDashboard.putBoolean("TotePIDEnabled", false);
		} else {			
			this.getPIDController().enable();
			SmartDashboard.putBoolean("TotePIDEnabled", true);
		}
	}
}

