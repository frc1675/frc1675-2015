package org.usfirst.frc.team1675.robot.commands.totestacker;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TotevateForTime extends Command {

	Timer timer;
	double timeToTotevate;
	double totevation;
	
    public TotevateForTime(double totevation, double timeToTotevate) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	timer = new Timer();
    	this.totevation = totevation;
    	this.timeToTotevate = timeToTotevate;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.toteStacker.setManualMovement(totevation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > timeToTotevate;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.toteStacker.setManualMovement(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
