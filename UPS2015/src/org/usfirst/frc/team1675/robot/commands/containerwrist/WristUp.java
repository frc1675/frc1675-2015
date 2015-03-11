package org.usfirst.frc.team1675.robot.commands.containerwrist;


import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WristUp extends Command {

	public WristUp() {
    	requires(Robot.containerWrist);
    	this.setTimeout(RobotMap.ContainerWristConstants.SOLENOID_ACTIVE_TIME);
    }

    protected void initialize() {
    	Robot.containerWrist.moveWristUp();
    }

    protected void execute() {
    	Robot.containerWrist.moveWristUp();
    }

    protected boolean isFinished() {
    	return this.isTimedOut();
    }

    protected void end() {
    	Robot.containerWrist.solenoidsOff();
    }

    protected void interrupted() {
    	end();
    }
}
