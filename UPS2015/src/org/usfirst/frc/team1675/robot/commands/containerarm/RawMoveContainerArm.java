package org.usfirst.frc.team1675.robot.commands.containerarm;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RawMoveContainerArm extends Command {

    public RawMoveContainerArm() {
    	requires(Robot.containerArm);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.containerArm.disable();
    	Robot.containerArm.rawSetArm(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double value = Robot.oi.getOperatorRightYAxis(RobotMap.ContainerArmConstants.MANUAL_SCALE_FACTOR);
    	Robot.containerArm.rawSetArm(value);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}