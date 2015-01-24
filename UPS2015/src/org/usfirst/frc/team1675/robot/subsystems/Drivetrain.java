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
		frontLeftMotor = new Talon(RobotMap.FRONT_LEFT_MOTOR_CHANNEL);
		frontRightMotor = new Talon(RobotMap.FRONT_RIGHT_MOTOR_CHANNEL);
		backLeftMotor = new Talon(RobotMap.BACK_LEFT_MOTOR_CHANNEL);
		backRightMotor = new Talon(RobotMap.BACK_RIGHT_MOTOR_CHANNEL);
	}
	
	public void setFrontLeftSpeed(double speed) {
		frontLeftMotor.set(-speed);	
	}
	
	public void setFrontRightSpeed(double speed) {
		frontRightMotor.set(speed);
	}
	
	public void setBackLeftSpeed(double speed) {
		backLeftMotor.set(-speed);
	}
	
	public void setBackRightSpeed(double speed) {
		backRightMotor.set(speed);
	}

    public void initDefaultCommand() {
    	
    	setDefaultCommand(new MecanumDriveWithJoysticks());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

