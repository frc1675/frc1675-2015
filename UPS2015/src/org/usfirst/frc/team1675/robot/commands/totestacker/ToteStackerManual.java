package org.usfirst.frc.team1675.robot.commands.totestacker;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToteStackerManual extends Command {

    public ToteStackerManual() {
    	requires(Robot.toteStacker);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double downwardMotion = Robot.oi.getDriverLeftTrigger(0.5);
    	double upwardMotion = Robot.oi.getDriverRightTrigger(0.5);
    	
    	if(Math.abs(downwardMotion) > 0 && Math.abs(upwardMotion) > 0){
    		downwardMotion = 0;
    		upwardMotion = 0;
    	}
    	Robot.toteStacker.setManualMovement(upwardMotion + downwardMotion);
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
