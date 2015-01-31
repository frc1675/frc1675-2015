package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MecanumDriveWithJoysticks extends Command {

    public MecanumDriveWithJoysticks() {
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftYAxis = Robot.oi.getDriverLeftYAxis();
    	double leftXAxis = Robot.oi.getDriverLeftXAxis();
    	double rightXAxis = Robot.oi.getDriverRightXAxis();
    	
    	Robot.drivetrain.setFrontLeftSpeed(leftYAxis - rightXAxis - leftXAxis);
    	Robot.drivetrain.setBackLeftSpeed(leftYAxis - rightXAxis + leftXAxis);
    	Robot.drivetrain.setFrontRightSpeed(leftYAxis + rightXAxis + leftXAxis);
    	Robot.drivetrain.setBackRightSpeed(leftYAxis + rightXAxis - leftXAxis);
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
