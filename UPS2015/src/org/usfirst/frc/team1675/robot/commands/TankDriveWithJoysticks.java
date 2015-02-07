package org.usfirst.frc.team1675.robot.commands;


import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Controls the drivetrain in a Tank-Drive style, with each joystick controlling 1 side.
 */
public class TankDriveWithJoysticks extends Command {

    public TankDriveWithJoysticks() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftStick = Robot.oi.getLeftYAxis();
    	//Add values later
    	double rightStick = Robot.oi.getRightYAxis();
    	
    	Robot.drivetrain.setBackLeftSpeed(leftStick);
    	Robot.drivetrain.setBackRightSpeed(rightStick);
    	Robot.drivetrain.setFrontLeftSpeed(leftStick);
    	Robot.drivetrain.setFrontRightSpeed(rightStick);
//    	SmartDashboard.putNumber("Back left Encoder Rate", Robot.drivetrain.backLeftMotor.getEncoderRate());
//    	SmartDashboard.putNumber("Back right Encoder Rate", Robot.drivetrain.backRightMotor.getEncoderRate());
//    	SmartDashboard.putNumber("Front left Encoder Rate", Robot.drivetrain.frontLeftMotor.getEncoderRate());
//    	SmartDashboard.putNumber("Front right Encoder Rate", Robot.drivetrain.frontRightMotor.getEncoderRate());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
