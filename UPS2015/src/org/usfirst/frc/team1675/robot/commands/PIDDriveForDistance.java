package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class PIDDriveForDistance extends PIDCommand {
	private static final double ABSOLUTE_TOLERANCE = 1;//inches
	private static final double TICKS_PER_INCH = 250/(RobotMap.DriveEncoders.DRIVE_WHEEL_DIAMETER*Math.PI);
    double setpointInEncoderTicks;
	public PIDDriveForDistance(double p, double i, double d, double setpointInInches) {
    	super(p,i,d);
    	this.getPIDController().setAbsoluteTolerance(ABSOLUTE_TOLERANCE*TICKS_PER_INCH);
    	setpointInEncoderTicks = setpointInInches*TICKS_PER_INCH;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetDriveEncoders();
    	this.setSetpoint(setpointInEncoderTicks);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	protected double returnPIDInput() {
		return Robot.drivetrain.getFrontLeftEncoder();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		Robot.drivetrain.setBackLeftSpeed(output);
		Robot.drivetrain.setBackRightSpeed(output);
		Robot.drivetrain.setFrontLeftSpeed(output);
		Robot.drivetrain.setFrontRightSpeed(output);
		
	}
	public void resetPID(double p, double i, double d){
		this.getPIDController().setPID(p, i, d);
	}
}
