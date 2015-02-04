package org.usfirst.frc.team1675.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class ContainerArm extends PIDSubsystem {

    // Initialize your subsystem here
	
	SpeedController motor;
	Potentiometer pot;
	
    public ContainerArm(double p, double i, double d) {
    	// Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	super(p,i,d);
    }
    
    
    
    public void setArmPosition(double angle){
    	this.setSetpoint(angle);
    	this.enable();
    }
    
    public void rawSetArm(double value){
    	motor.set(value);
    }
     
    public void stopAndDisable(){
    	this.disable();
    	motor.set(0);	
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
