package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.MecanumDriveWithJoysticks;
import org.usfirst.frc.team1675.robot.commands.TankDriveWithJoysticks;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Represents the drivetrain of the robot. 4 direct-driven wheels.
 */
public class Drivetrain extends Subsystem {
    
	Talon frontLeftMotor;
	Talon frontRightMotor;
	Talon backLeftMotor;
	Talon backRightMotor;
	
	public Drivetrain() {
		frontLeftMotor = new Talon(RobotMap.PWMChannels.FRONT_LEFT_DRIVE);
		frontRightMotor = new Talon(RobotMap.PWMChannels.FRONT_RIGHT_DRIVE);
		backLeftMotor = new Talon(RobotMap.PWMChannels.BACK_LEFT_DRIVE);
		backRightMotor = new Talon(RobotMap.PWMChannels.BACK_RIGHT_DRIVE);
	}
	
	public void setFrontLeftSpeed(double speed) {
		frontLeftMotor.set(speed);	
	}
	
	public void setFrontRightSpeed(double speed) {
		frontRightMotor.set(-speed);
	}
	
	public void setBackLeftSpeed(double speed) {
		backLeftMotor.set(-speed);
	}
	
	public void setBackRightSpeed(double speed) {
		backRightMotor.set(-speed);
	}

    public void initDefaultCommand() {
    	
    	setDefaultCommand(new MecanumDriveWithJoysticks());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

