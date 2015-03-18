package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PIDDriveForDistance extends PIDCommand {
	public static final double SCALING_FACTOR = .6;
	private static final double ABSOLUTE_TOLERANCE = 2;//inches
	private static final double TICKS_PER_INCH = 250/(RobotMap.DriveEncoders.DRIVE_WHEEL_DIAMETER*Math.PI);
	private static final double ON_TARGET_TIME = 2;
    double setpointInEncoderTicks;
    Timer timer;
	public PIDDriveForDistance(double p, double i, double d, double setpointInInches) {
    	super(p,i,d);
    	this.getPIDController().setAbsoluteTolerance(ABSOLUTE_TOLERANCE*TICKS_PER_INCH);
    	setpointInEncoderTicks = setpointInInches*TICKS_PER_INCH;
    	timer = new Timer();
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
    	boolean onTarget = this.getPIDController().onTarget();
        if (onTarget && (timer.get() == 0)) {
            timer.start();
        } else if (timer.get() > 0 && !onTarget) {
            timer.stop();
            timer.reset();
        } else if (timer.get() > ON_TARGET_TIME) {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("ended");
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
		SmartDashboard.putNumber("Drive Output", output);
		// TODO Auto-generated method stub
		Robot.drivetrain.setBackLeftSpeed(output* SCALING_FACTOR);
		Robot.drivetrain.setBackRightSpeed(output* SCALING_FACTOR);
		Robot.drivetrain.setFrontLeftSpeed(output* SCALING_FACTOR);
		Robot.drivetrain.setFrontRightSpeed(output* SCALING_FACTOR);
		
	}
	public void resetPID(double p, double i, double d){
		this.getPIDController().setPID(p, i, d);
	}
}
