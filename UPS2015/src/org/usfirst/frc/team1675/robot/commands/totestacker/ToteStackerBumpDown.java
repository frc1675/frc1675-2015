package org.usfirst.frc.team1675.robot.commands.totestacker;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.subsystems.Totevator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToteStackerBumpDown extends Command {

    public ToteStackerBumpDown() {
    	requires(Robot.totevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putNumber("Number Of Bumps", Robot.totevator.countAndReturnBumpDown());
    	Robot.totevator.moveRelative(-Totevator.TICKS_PER_BUMP);
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
