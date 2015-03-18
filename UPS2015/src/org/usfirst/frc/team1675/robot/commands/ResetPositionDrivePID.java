package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ResetPositionDrivePID extends Command {
	PIDDriveForDistance pidCommand;
    public ResetPositionDrivePID(PIDDriveForDistance pidCommand) {
    	this.pidCommand = pidCommand;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	pidCommand.resetPID(SmartDashboard.getNumber("Position Encoder P",  RobotMap.DriveEncoders.PositionPIDDefaults.P),
    			SmartDashboard.getNumber("Position Encoder I",  RobotMap.DriveEncoders.PositionPIDDefaults.I),
    			SmartDashboard.getNumber("Position Encoder D",  RobotMap.DriveEncoders.PositionPIDDefaults.D));
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
