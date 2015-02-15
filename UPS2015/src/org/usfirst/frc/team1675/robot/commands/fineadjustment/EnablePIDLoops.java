package org.usfirst.frc.team1675.robot.commands.fineadjustment;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EnablePIDLoops extends Command {

    public EnablePIDLoops() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.frontLeftPID.enablePID();    	
    	Robot.drivetrain.frontRightPID.enablePID();
    	Robot.drivetrain.backLeftPID.enablePID();
    	Robot.drivetrain.backRightPID.enablePID();
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
