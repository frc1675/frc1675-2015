package org.usfirst.frc.team1675.robot.commands.containerclaw;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This opens both sides of the container claw.
 */
public class ContainerClawOpen extends Command {

	public ContainerClawOpen() {
		requires(Robot.containerClaw);
		this.setTimeout(RobotMap.ContainerClawConstants.CLAW_CYLINDER_FIRE_TIME);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.containerClaw.openBoth();
	}

	protected boolean isFinished() {
		return this.isTimedOut();
	}

	protected void end() {
		Robot.containerClaw.turnOff();

	}

	protected void interrupted() {
		end();
	}
}
