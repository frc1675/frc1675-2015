package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPosition;
import org.usfirst.frc.team1675.robot.commands.containerarm.RawMoveContainerArm;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ContainerArm extends PIDSubsystem {

    // Initialize your subsystem here
	
	SpeedController motor;
	AnalogPotentiometer pot;
	private static final double POT_SCALE = 250.0;
	
    public ContainerArm(double p, double i, double d) {
    	super(p,i,d);
    	this.setOutputRange(-.5, .5);

    	pot = new AnalogPotentiometer(RobotMap.AIOChannels.POT_CHANNEL, POT_SCALE);
    	motor = new VictorSP(RobotMap.PWMChannels.ARM_MOTOR);    	
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
    public double getPotValue(){
    	return pot.get();
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
        setDefaultCommand(new RawMoveContainerArm());
    }
    
    protected double returnPIDInput() {
    	return pot.get();
    }
    
    protected void usePIDOutput(double output) {
    	SmartDashboard.putNumber("arm Output", output);
    	motor.set(output);
    }
}
