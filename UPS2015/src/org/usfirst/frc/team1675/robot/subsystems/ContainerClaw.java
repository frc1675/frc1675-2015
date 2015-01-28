package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.RobotMap.PCMChannels;
import org.usfirst.frc.team1675.robot.commands.ContainerClawClose;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Represents the claw that picks up containers.
 */
public class ContainerClaw extends Subsystem {

	Solenoid leftextend;
	Solenoid leftretract;
	Solenoid rightextend;
	Solenoid rightretract;

	public ContainerClaw() {
		leftextend = new Solenoid(RobotMap.PCMChannels.LEFT_UPPER_CYLINDER);
		rightretract = new Solenoid(RobotMap.PCMChannels.LEFT_LOWER_CYLINDER);
		rightextend = new Solenoid(RobotMap.PCMChannels.RIGHT_UPPER_CYLINDER);
		leftretract = new Solenoid(RobotMap.PCMChannels.RIGHT_LOWER_CYLINDER);
	}

	public void openBoth() {
		leftextend.set(false);
		leftretract.set(true);
		rightextend.set(false);
		rightretract.set(true);
	}

	public void closeBoth() {
		leftextend.set(true);
		leftretract.set(false);
		rightextend.set(true);
		rightretract.set(false);
	}

	public void openLeft() {
		leftextend.set(true);
		leftretract.set(false);
		rightextend.set(false);
		rightretract.set(false);
	}

	public void openRight() {
		leftextend.set(false);
		leftretract.set(false);
		rightextend.set(true);
		rightretract.set(false);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ContainerClawClose());
	}

}
