package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class GyroPIDCommand extends PIDCommand {
	


    public GyroPIDCommand(double p, double i, double d, double setPoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	super(p, i, d);
    	requires(Robot.drivetrain);
    	this.setSetpoint(setPoint);
    	this.getPIDController().setAbsoluteTolerance(4);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.drivetrain.resetGyro();
    	
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
    	System.out.println("Ending the Gyro Command");
    	System.out.println("Final Gyro Value:"+Robot.drivetrain.getGyroAngle());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	protected double returnPIDInput() {
		
		double angle = Robot.drivetrain.getGyroAngle();
		System.out.println("Gyro Angle: "+angle);
		return angle;
		
	}

	@Override
	protected void usePIDOutput(double output) {
		System.out.println("Output: "+output);
		Robot.drivetrain.setBackLeftSpeed(-output);
		Robot.drivetrain.setBackRightSpeed(output);
		Robot.drivetrain.setFrontLeftSpeed(-output);
		Robot.drivetrain.setFrontRightSpeed(output);
				
	}
}
