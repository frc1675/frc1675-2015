package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CheezyDrive extends Command {

    public CheezyDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double turn = Robot.oi.getDriverRightXAxis(); //fill in with get right x axis method later
    	double forward = Robot.oi.getDriverLeftYAxis(); //fill in with get left y axis method later
    	
    	double left;
    	double right;
    	
    	left = forward - turn;
    	right = forward + turn;
    	
    	Robot.drivetrain.setFrontLeftSpeed(left);
    	Robot.drivetrain.setBackLeftSpeed(left);
    	Robot.drivetrain.setFrontRightSpeed(right);
    	Robot.drivetrain.setBackRightSpeed(right);
    	
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
