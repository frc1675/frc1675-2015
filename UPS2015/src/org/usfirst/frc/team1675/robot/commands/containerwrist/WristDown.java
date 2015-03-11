package org.usfirst.frc.team1675.robot.commands.containerwrist;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WristDown extends Command {
    public WristDown() {
    	requires(Robot.containerWrist);
    	this.setTimeout(RobotMap.ContainerWristConstants.SOLENOID_ACTIVE_TIME);
    }

    protected void initialize() {
    	Robot.containerWrist.moveWristDown();
    }

    protected void execute() {
    	Robot.containerWrist.moveWristDown();
    }

    protected boolean isFinished() {
    	return isTimedOut();
    }

    protected void end() {
    	Robot.containerWrist.solenoidsOff();
    }

    protected void interrupted() {
    	end();
    }
}
