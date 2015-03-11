package org.usfirst.frc.team1675.robot.commands.containerarm;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveContainerArmToPosition extends Command {
	private double angle;
    public MoveContainerArmToPosition(double angle) {
    	requires(Robot.containerArm);
    	this.angle = angle;
    }

    protected void initialize() {   	
    	Robot.containerArm.setArmPosition(angle);
    	
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
