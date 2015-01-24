package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetToteStacker extends Command {

    public ResetToteStacker() {
    	requires(Robot.toteStacker);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.toteStacker.goToPoint(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
        //goes until the motors have reached the bottom area. need encoder to code it
    }

    // Called once after isFinished returns true
    protected void end() {
    	//make the tote stacker stop moving here
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
