package org.usfirst.frc.team1675.robot.commands.containerclaw;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command opens the left side of the claw.
 */
public class LeftContainerClawOpen extends Command {

	public LeftContainerClawOpen() {
		requires(Robot.containerClaw);
		setTimeout(RobotMap.ContainerClawConstants.CLAW_CYLINDER_FIRE_TIME);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.containerClaw.openLeft();
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.containerClaw.turnOff();
	}

	protected void interrupted() {
		end();
	}
}
