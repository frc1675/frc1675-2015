package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.commands.ToteStackerManual;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteStacker extends Subsystem {
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ToteStacker(){
		
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ToteStackerManual());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void goToPoint(){
    }
    public void setManualMovement(double MotorValue){
    }
}

