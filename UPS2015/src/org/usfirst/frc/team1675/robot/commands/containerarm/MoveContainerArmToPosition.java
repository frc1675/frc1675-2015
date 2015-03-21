package org.usfirst.frc.team1675.robot.commands.containerarm;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveContainerArmToPosition extends Command {
	double angle;
    public MoveContainerArmToPosition(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.containerArm);
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {   
    	Robot.containerArm.enable();
    	Robot.containerArm.setArmPosition(angle);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("containerPot", Robot.containerArm.getPotValue());
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {    	
    	Robot.containerArm.stopAndDisable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
