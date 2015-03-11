package org.usfirst.frc.team1675.robot.commands.containerarm;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ResetArmPID extends Command {

    public ResetArmPID() {
    }

	protected void initialize() {
		Robot.containerArm.getPIDController().setPID(
		SmartDashboard.getNumber("ContainerArmP"),
		SmartDashboard.getNumber("ContainerArmI"),
		SmartDashboard.getNumber("ContainerArmD"));
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
