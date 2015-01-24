package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerClaw extends Subsystem {
    
	Solenoid leftextend; 
	Solenoid leftretract;
	Solenoid rightextend;
	Solenoid rightretract;
	
	public ContainerClaw() {
		
		leftextend = new Solenoid(RobotMap.LEFT_UPPER_CYLINDER);
		rightretract = new Solenoid(RobotMap.LEFT_LOWER_CYLINDER);
		rightextend = new Solenoid(RobotMap.RIGHT_UPPER_CYLINDER);
		leftretract = new Solenoid(RobotMap.RIGHT_LOWER_CYLINDER);
	}
	
	public void openBoth(){
		
		leftextend.set(false);
		leftretract.set(true);
		rightextend.set(false);
		rightretract.set(true);
		
	}
	
	public void closeBoth(){
		
		leftextend.set(true);
		leftretract.set(false);
		rightextend.set(true);
		rightretract.set(false);
		
	}
	
	public void openLeft(){
		
		leftextend.set(true);
		leftretract.set(false);
		rightextend.set(false);
		rightretract.set(false);
	}
	
	public void openRight(){
		
		leftextend.set(false);
		leftretract.set(false);
		rightextend.set(true);
		rightretract.set(false);
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
	
		
	}


