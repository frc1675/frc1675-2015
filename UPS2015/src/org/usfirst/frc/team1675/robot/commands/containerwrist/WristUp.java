package org.usfirst.frc.team1675.robot.commands.containerwrist;


import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WristUp extends Command {
	Timer timer;
    public WristUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.containerWrist);
    	timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.containerWrist.moveWristUp();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.containerWrist.moveWristUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return timer.get() >= RobotMap.ContainerWristConstants.SOLENOID_ACTIVE_TIME;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.containerWrist.solenoidsOff();
    	timer.stop();
    	timer.reset();
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
