package org.usfirst.frc.team1675.robot.commands.containerclaw;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenAtMatchEnd extends Command {
	DriverStation currentInstance;
	private static final double TIME_TO_FIRE = .5;
    public OpenAtMatchEnd() {
    	requires(Robot.containerClaw);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentInstance = DriverStation.getInstance();    	
    	if ((currentInstance.getMatchTime() <TIME_TO_FIRE) && (currentInstance.isOperatorControl()) && currentInstance.isFMSAttached()){
    		Robot.containerClaw.openBoth();
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
