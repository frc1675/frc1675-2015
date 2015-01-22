package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerClaw extends Subsystem {
    
	Solenoid extend; 
	Solenoid retract;
	
	public ContainerClaw() {
		
		extend = new Solenoid(RobotMap.UPPER_CYLINDER);
		retract = new Solenoid(RobotMap.LOWER_CYLINDER);
	}
	
	public void open(){
		
		extend.set(false);
		retract.set(true);
		
	}
	
	public void close(){
		
		extend.set(true);
		retract.set(false);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

