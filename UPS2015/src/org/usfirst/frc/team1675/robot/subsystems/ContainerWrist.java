package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerWrist extends Subsystem {
    
	Solenoid wristUp;
	Solenoid wristDown;

	public ContainerWrist(){
		wristUp = new Solenoid(RobotMap.SolenoidChannels.WRIST_UP);
    	wristDown = new Solenoid(RobotMap.SolenoidChannels.WRIST_DOWN);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	
	public void moveWristUp(){
    	wristDown.set(false);
    	wristUp.set(true);
    }
    
    public void moveWristDown(){
    	wristUp.set(false);
    	wristDown.set(true);
    }
    
    public void solenoidsOff(){
    	wristUp.set(false);
    	wristDown.set(false);
    }
}

