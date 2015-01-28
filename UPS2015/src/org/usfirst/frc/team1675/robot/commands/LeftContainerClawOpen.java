package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command opens the left side of the claw.
 */
public class LeftContainerClawOpen extends Command {

	Timer timer;

	public LeftContainerClawOpen() {

		requires(Robot.containerClaw);
		timer = new Timer();
	}

	protected void initialize() {

		timer.start();
	}

	protected void execute() {

		Robot.containerClaw.openLeft();
	}

	protected boolean isFinished() {

		return (timer.get() > RobotMap.CLAW_CYLINDER_FIRE_TIME);
	}

	protected void end() {

		Robot.containerClaw.closeBoth();
	}

	protected void interrupted() {
	}
}
