package org.usfirst.frc.team1675.robot.commands.containerarm;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveContainerArmToPositionOnDashboard extends Command {
    public MoveContainerArmToPositionOnDashboard() {
    	requires(Robot.containerArm);
    }

    protected void initialize() {   	
    	Robot.containerArm.setArmPosition(SmartDashboard.getNumber("ContainerArmSetpoint"));
    	
    }

    protected void execute() {
    	SmartDashboard.putNumber("containerPot", Robot.containerArm.getPotValue());
    	
    	
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {    	
    	Robot.containerArm.stopAndDisable();
    }

    protected void interrupted() {
    }
}
