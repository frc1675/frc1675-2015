package org.usfirst.frc.team1675.robot.commands.totestacker;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToteStackerManualXbox extends Command {

    public ToteStackerManualXbox() {
    	requires(Robot.totevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.isOperatorXboxPluggedIn()){    	
	    	double toteStackerMovement = -Robot.oi.getOperatorLeftYAxis() * RobotMap.ToteStackerConstants.MANUAL_SCALE_FACTOR;
	    	Robot.totevator.setManualMovement(toteStackerMovement);
    	}
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
