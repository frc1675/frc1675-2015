package org.usfirst.frc.team1675.robot.commands.containerclaw;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LeftContainerClawClose extends Command {

	Timer timer;

	public LeftContainerClawClose() {

		requires(Robot.containerClaw);
		timer = new Timer();
	}

	protected void initialize() {

		timer.start();
	}

	protected void execute() {

		Robot.containerClaw.closeLeft();
	}

	protected boolean isFinished() {

		return (timer.get() > RobotMap.ContainerClawConstants.CLAW_CYLINDER_FIRE_TIME);
	}

	protected void end() {
		Robot.containerClaw.turnOff();
	}

	protected void interrupted() {
		end();
	}
}
