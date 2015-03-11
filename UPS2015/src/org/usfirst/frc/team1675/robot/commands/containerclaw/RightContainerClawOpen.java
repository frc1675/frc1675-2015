package org.usfirst.frc.team1675.robot.commands.containerclaw;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command opens the right side of the claw.
 */
public class RightContainerClawOpen extends Command {

	public RightContainerClawOpen() {		
		requires(Robot.containerClaw);
		this.setTimeout(RobotMap.ContainerClawConstants.CLAW_CYLINDER_FIRE_TIME);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.containerClaw.openRight();
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
