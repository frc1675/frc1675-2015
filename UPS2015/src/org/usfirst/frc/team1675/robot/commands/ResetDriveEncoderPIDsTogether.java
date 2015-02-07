package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ResetDriveEncoderPIDsTogether extends Command {

    public ResetDriveEncoderPIDsTogether() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.drivetrain.backLeftMotor.setPIDF(
//    			SmartDashboard.getNumber("All The Drive P", RobotMap.DriveEncoders.AllThePIDs.P),
//				SmartDashboard.getNumber("All The Drive I", RobotMap.DriveEncoders.AllThePIDs.I),
//				SmartDashboard.getNumber("All The Drive D", RobotMap.DriveEncoders.AllThePIDs.D),
//				SmartDashboard.getNumber("All The Drive F", RobotMap.DriveEncoders.AllThePIDs.F));
//    	Robot.drivetrain.backRightMotor.setPIDF(
//    			SmartDashboard.getNumber("All The Drive P", RobotMap.DriveEncoders.AllThePIDs.P),
//				SmartDashboard.getNumber("All The Drive I", RobotMap.DriveEncoders.AllThePIDs.I),
//				SmartDashboard.getNumber("All The Drive D", RobotMap.DriveEncoders.AllThePIDs.D),
//				SmartDashboard.getNumber("All The Drive F", RobotMap.DriveEncoders.AllThePIDs.F));
//		Robot.drivetrain.frontLeftMotor.setPIDF(
//				SmartDashboard.getNumber("All The Drive P", RobotMap.DriveEncoders.AllThePIDs.P),
//				SmartDashboard.getNumber("All The Drive I", RobotMap.DriveEncoders.AllThePIDs.I),
//				SmartDashboard.getNumber("All The Drive D", RobotMap.DriveEncoders.AllThePIDs.D),
//				SmartDashboard.getNumber("All The Drive F", RobotMap.DriveEncoders.AllThePIDs.F));
//		Robot.drivetrain.frontRightMotor.setPIDF(
//				SmartDashboard.getNumber("All The Drive P", RobotMap.DriveEncoders.AllThePIDs.P),
//				SmartDashboard.getNumber("All The Drive I", RobotMap.DriveEncoders.AllThePIDs.I),
//				SmartDashboard.getNumber("All The Drive D", RobotMap.DriveEncoders.AllThePIDs.D),
//				SmartDashboard.getNumber("All The Drive F", RobotMap.DriveEncoders.AllThePIDs.F));		
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
