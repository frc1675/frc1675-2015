package org.usfirst.frc.team1675.robot.commands.containerclaw;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Closes both sides of the container claw
 *
 */
public class ContainerClawClose extends Command {
	Timer timer;

	public ContainerClawClose() {
		requires(Robot.containerClaw);
		timer = new Timer();
	}

	@Override
	protected void initialize() {
		timer.start();
	}

	@Override
	protected void execute() {
		Robot.containerClaw.closeBoth();
	}

	@Override
	protected boolean isFinished() {
		return (timer.get() > RobotMap.CLAW_CYLINDER_FIRE_TIME);
	}

	@Override
	protected void end() {
		Robot.containerClaw.closeBoth();
	}

	@Override
	protected void interrupted() {
	}

}
