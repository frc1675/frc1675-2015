package org.usfirst.frc.team1675.robot.commands.drivetrain;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PolarMecanumForTime extends Command {

	private double magnitude;
	private double direction;
	private double rotation;
	
    public PolarMecanumForTime(double magnitude, double direction, double rotation, double timeToDrive) {
    	requires(Robot.drivetrain);    	
    	this.magnitude = magnitude;
    	this.direction = direction;
    	this.rotation = rotation;    	
    	this.setTimeout(timeToDrive);
    }

    protected void initialize() {    	
    }

    protected void execute() {
    	Robot.drivetrain.ezDrive(magnitude, direction, rotation);
    }

    protected boolean isFinished() {
        return this.isTimedOut();
    }

    protected void end() {
    	Robot.drivetrain.ezDrive(0.0, 0.0, 0.0);
    }

    protected void interrupted() {
    }
}
