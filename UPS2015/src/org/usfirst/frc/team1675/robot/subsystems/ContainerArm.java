package org.usfirst.frc.team1675.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class ContainerArm extends PIDSubsystem {

    // Initialize your subsystem here
	
	Solenoid openWrist;
	Solenoid closedWrist;
	
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
