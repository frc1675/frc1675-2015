package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MecanumDriveWithJoysticks extends Command {

    public MecanumDriveWithJoysticks() {
    	requires(Robot.drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//they are multiplied by the sqrt of 2 in order to make diagonals on the Left stick have 1 as their value
    	double leftYAxis = Robot.oi.getDriverLeftYAxis() * Math.sqrt(2);
    	double leftXAxis = Robot.oi.getDriverLeftXAxis() * Math.sqrt(2);
    	double rightXAxis = Robot.oi.getDriverRightXAxis() * Math.sqrt(2);
    	    	
    	double frontLeft = leftYAxis - rightXAxis - leftXAxis;
    	double backLeft = leftYAxis - rightXAxis + leftXAxis;
    	double frontRight = leftYAxis + rightXAxis + leftXAxis;
    	double backRight = leftYAxis + rightXAxis - leftXAxis;
    	
    	SmartDashboard.putNumber("prescaleFrontLeft", frontLeft);
    	SmartDashboard.putNumber("prescaleBackLeft", backLeft);
    	SmartDashboard.putNumber("prescaleFrontRight", frontRight);
    	SmartDashboard.putNumber("prescaleBackRight", backRight);
    	
    	if(Math.abs(frontLeft) > 1 || Math.abs(backLeft) > 1 || Math.abs(frontRight) > 1 || Math.abs(backRight) > 1 ){
    		double frontHigh = Math.max(Math.abs(frontLeft), Math.abs(frontRight));
    		double backHigh = Math.max(Math.abs(backLeft), Math.abs(backRight));
    		double highestMotorValue = Math.max(frontHigh, backHigh);
    		frontLeft = frontLeft / highestMotorValue;
    		backLeft = backLeft / highestMotorValue;
    		frontRight = frontRight / highestMotorValue;
    		backRight = backRight / highestMotorValue;
    		
    		
    		//if(Math.abs(frontLeft) > Math.abs(backLeft) && Math.abs(frontLeft) > Math.abs(frontRight) && Math.abs(frontLeft) > Math.abs(backRight)){
    			//backLeft = backLeft / Math.abs(frontLeft);
    			//frontRight = frontRight / Math.abs(frontLeft);
    			//backRight = backRight / Math.abs(frontLeft);
    			//frontLeft = frontLeft / Math.abs(frontLeft);
    		//} else if(Math.abs(backLeft) > Math.abs(frontLeft) && Math.abs(backLeft) > Math.abs(frontRight) && Math.abs(backLeft) > Math.abs(backRight)){
    			//frontLeft = frontLeft / Math.abs(backLeft);
    			//frontRight = frontRight / Math.abs(backLeft);
    			//backRight = backRight / Math.abs(backLeft);
    			//backLeft = backLeft / Math.abs(backLeft);
    		//} else if(Math.abs(frontRight) > Math.abs(frontLeft) && Math.abs(frontRight) > Math.abs(backLeft) && Math.abs(frontRight) > Math.abs(backRight)){
    			//frontLeft = frontLeft / Math.abs(frontRight);
    			//backLeft = backLeft / Math.abs(frontRight);
    			//backRight = backRight / Math.abs(frontRight);
    			//frontRight = frontRight / Math.abs(frontRight);
    		//} else if(Math.abs(backRight) > Math.abs(frontLeft) && Math.abs(backRight) > Math.abs(backLeft) && Math.abs(backRight) > Math.abs(frontRight)){
    			//frontLeft = frontLeft / Math.abs(backRight);
    			//backLeft = backLeft / Math.abs(backRight);
    			//frontRight = frontRight / Math.abs(backRight);
    			//backRight = backRight / Math.abs(backRight);
    		//}
    		
    	}
    	
    	SmartDashboard.putNumber("postscaleFrontLeft", frontLeft);
    	SmartDashboard.putNumber("postscaleBackLeft", backLeft);
    	SmartDashboard.putNumber("postscaleFrontRight", frontRight);
    	SmartDashboard.putNumber("postscaleBackRight", backRight);
    	Robot.drivetrain.setFrontLeftSpeed(frontLeft);
    	Robot.drivetrain.setBackLeftSpeed(backLeft);
    	Robot.drivetrain.setFrontRightSpeed(frontRight);
    	Robot.drivetrain.setBackRightSpeed(backRight);

    	Robot.drivetrain.setFrontLeftSpeed(leftYAxis - rightXAxis - leftXAxis);
    	Robot.drivetrain.setBackLeftSpeed(leftYAxis - rightXAxis + leftXAxis);
    	Robot.drivetrain.setFrontRightSpeed(leftYAxis + rightXAxis + leftXAxis);
    	Robot.drivetrain.setBackRightSpeed(leftYAxis + rightXAxis - leftXAxis);
    	
    	SmartDashboard.putNumber("Back Left Encoder Rate", Robot.drivetrain.backLeftPID.getEncoderRate());
    	SmartDashboard.putNumber("Back Right Encoder Rate", Robot.drivetrain.backRightPID.getEncoderRate());
    	SmartDashboard.putNumber("Front left Encoder Rate", Robot.drivetrain.frontLeftPID.getEncoderRate());
    	SmartDashboard.putNumber("Front Right Encoder Rate", Robot.drivetrain.frontRightPID.getEncoderRate());
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
