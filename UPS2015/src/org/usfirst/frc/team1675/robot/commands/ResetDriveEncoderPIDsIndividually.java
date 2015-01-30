package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ResetDriveEncoderPIDsIndividually extends Command {

    public ResetDriveEncoderPIDsIndividually() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.backLeftMotor.setPIDF(SmartDashboard.getNumber("BackLeftP", RobotMap.DriveEncoders.BackRightPIDDefaults.P),
				SmartDashboard.getNumber("BackLeftI", RobotMap.DriveEncoders.BackRightPIDDefaults.I),
				SmartDashboard.getNumber("BackLeftD", RobotMap.DriveEncoders.BackRightPIDDefaults.D),
				SmartDashboard.getNumber("BackLeftF", RobotMap.DriveEncoders.BackRightPIDDefaults.F));
    	Robot.drivetrain.backRightMotor.setPIDF(SmartDashboard.getNumber("BackRightP", RobotMap.DriveEncoders.BackRightPIDDefaults.P),
				SmartDashboard.getNumber("BackRightI", RobotMap.DriveEncoders.BackRightPIDDefaults.I),
				SmartDashboard.getNumber("BackRightD", RobotMap.DriveEncoders.BackRightPIDDefaults.D),
				SmartDashboard.getNumber("BackRightF", RobotMap.DriveEncoders.BackRightPIDDefaults.F));
		Robot.drivetrain.frontLeftMotor.setPIDF(SmartDashboard.getNumber("FrontLeftP", RobotMap.DriveEncoders.FrontLeftPIDDefaults.P),
				SmartDashboard.getNumber("FrontLeftI", RobotMap.DriveEncoders.FrontLeftPIDDefaults.I),
				SmartDashboard.getNumber("FrontLeftD", RobotMap.DriveEncoders.FrontLeftPIDDefaults.D),
				SmartDashboard.getNumber("FrontLeftF", RobotMap.DriveEncoders.FrontLeftPIDDefaults.F));
		Robot.drivetrain.frontRightMotor.setPIDF(SmartDashboard.getNumber("FrontRightP", RobotMap.DriveEncoders.FrontRightPIDDefaults.P),
				SmartDashboard.getNumber("FrontRightI", RobotMap.DriveEncoders.FrontRightPIDDefaults.I),
				SmartDashboard.getNumber("FrontRightD", RobotMap.DriveEncoders.FrontRightPIDDefaults.D),
				SmartDashboard.getNumber("FrontRightF", RobotMap.DriveEncoders.FrontRightPIDDefaults.F));		
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
