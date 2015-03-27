package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.containerclaw.OpenAtMatchEnd;

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
		leftextend = new Solenoid(RobotMap.SolenoidChannels.LEFT_CLAW_EXTEND);
		rightretract = new Solenoid(RobotMap.SolenoidChannels.RIGHT_CLAW_RETRACT);
		rightextend = new Solenoid(RobotMap.SolenoidChannels.RIGHT_CLAW_EXTEND);
		leftretract = new Solenoid(RobotMap.SolenoidChannels.LEFT_CLAW_RETRACT);
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
	
	public void closeLeft(){
		leftextend.set(false);
		leftretract.set(true);
		rightextend.set(false);
		rightretract.set(false);
	}

	public void openRight() {
		leftextend.set(false);
		leftretract.set(false);
		rightextend.set(true);
		rightretract.set(false);
	}
	
	public void closeRight(){
		leftextend.set(false);
		leftretract.set(false);
		rightextend.set(false);
		rightretract.set(true);
	}
	
	public void turnOff() {
		leftextend.set(false);
		leftretract.set(false);
		rightextend.set(false);
		rightretract.set(false);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new OpenAtMatchEnd());
	}

}
