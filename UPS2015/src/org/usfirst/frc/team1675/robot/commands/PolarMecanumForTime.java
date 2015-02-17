package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PolarMecanumForTime extends Command {

	Timer timer;
	double magnitude;
	double direction;
	double rotation;
	double timeToDrive;
	
    public PolarMecanumForTime(double magnitude, double direction, double rotation, double timeToDrive) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	timer = new Timer();
    	this.magnitude = magnitude;
    	this.direction = direction;
    	this.rotation = rotation;
    	this.timeToDrive = timeToDrive;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.ezDrive(magnitude, direction, rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > timeToDrive;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.ezDrive(0.0, 0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
