package org.usfirst.frc.team1675.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ContainerArm extends PIDSubsystem {

    // Initialize your subsystem here
	
	Solenoid openWrist;
	Solenoid closeWrist;
	SpeedController MotorOne;
	SpeedController MotorTwo;
	
    public ContainerArm(double p, double i, double d) {
    	// Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(p,i,d);
    }
    
    public void moveWristUp(){

    }
    
    public void moveWristDown(){
    	
    }
    
    public void setArmPosition(double angle){
    	
    }
    
    public void setArmVoltage(double value){
    	
    }
     
    public void stopAndReset(){
    	
    }
    public double getP(){
    	return this.getPIDController().getP();
    }
    public double getI(){
    	return this.getPIDController().getI();   			
    }
    public double getD(){
    	return this.getPIDController().getD();
    }
    public void setPID(double p, double i, double d){
    	this.getPIDController().setPID(p, i, d);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
