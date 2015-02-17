package org.usfirst.frc.team1675.robot.commands.fineadjustment;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.utils.AccelerationSpeedController;
import org.usfirst.frc.team1675.robot.utils.PIDSpeedControllerForVelocity;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EnableFineAdjustment extends Command {

    public EnableFineAdjustment() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.disableSpeedControllers();
    	RobotMap.DriveNonConstants.FINE_ADJUSTMENT_SCALE_FACTOR=0.333;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
