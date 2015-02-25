package org.usfirst.frc.team1675.robot.commands.totestacker;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.subsystems.ToteStacker;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DropTote extends Command {

    public DropTote() {
    	requires(Robot.toteStacker);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.toteStacker.moveRelative(-(ToteStacker.TICKS_PER_TOTEHOOK/2));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
        //goes until the motors have rotated a set number of times/distance. need encoder to code it
    }

    // Called once after isFinished returns true
    protected void end() {
    	//stop the thing from moving here
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
