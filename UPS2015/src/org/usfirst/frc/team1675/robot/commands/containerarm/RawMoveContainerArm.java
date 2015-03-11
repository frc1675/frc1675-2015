package org.usfirst.frc.team1675.robot.commands.containerarm;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RawMoveContainerArm extends Command {

    public RawMoveContainerArm() {
    	requires(Robot.containerArm);
    }

    protected void initialize() {
    	Robot.containerArm.disable();
    	Robot.containerArm.rawSetArm(0);
    }

    protected void execute() {
    	double value = Robot.oi.getOperatorRightYAxis() * RobotMap.ContainerArmConstants.MANUAL_SCALE_FACTOR;
    	Robot.containerArm.rawSetArm(value);
    	SmartDashboard.putNumber("containerPot", Robot.containerArm.getPotValue());    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}