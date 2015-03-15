package org.usfirst.frc.team1675.robot.commands.totestacker;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.subsystems.ToteStacker;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoUpOneTote extends Command {

    public GoUpOneTote() {
    	requires(Robot.totevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.totevator.canIToteUpQuestionMark()){
    		Robot.totevator.countToteUp();
    		Robot.totevator.moveRelative(ToteStacker.TICKS_PER_TOTEHOOK);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
