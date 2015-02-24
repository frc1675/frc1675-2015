package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.XBoxControllerMap;
import org.usfirst.frc.team1675.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PolarMecanum extends Command {

    public PolarMecanum() {
    	requires(Robot.drivetrain);
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.ezDrive(getMagnitude(), getDirection(), getRotation());
    	System.out.println("Mag: \t" + getMagnitude() + " Dir: \t" + getDirection() + " Rot: " + getRotation());
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
    
    public double getMagnitude(){
		double x = Robot.oi.getDriverLeftXAxisWODeadzone();
		double y = Robot.oi.getDriverLeftYAxisWODeadzone();
		
		double returnMagnitude = 0.0;
		double squareMagnitude = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0));
		
		if (x != 0.0 && y != 0.0){
			double borderX;
			double borderY;
			if (Math.abs(x) > Math.abs(y)){
				
				borderX = x / Math.abs(x);
				borderY = y / Math.abs(x);
			} else {
				borderX = x / Math.abs(y);
				borderY = y / Math.abs(y);
			}
			double borderMagnitude = Math.sqrt(Math.pow(borderX, 2.0) + Math.pow(borderY, 2.0));
			returnMagnitude = squareMagnitude / borderMagnitude;
		} else {
			returnMagnitude = squareMagnitude;
		}
		if (returnMagnitude < RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE){
			returnMagnitude = 0.0;
		}
		return returnMagnitude;
    }
    
	public double getRotation(){
		double x = Robot.oi.getDriverRightXAxisWODeadzone();
		double rotation = x;
		if (Math.abs(rotation) < RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE){
			rotation = 0;
		}
		return rotation;
	}
	public double getDirection(){
		double direction;
		double x = Robot.oi.getDriverLeftXAxisWODeadzone();
		double y = Robot.oi.getDriverLeftYAxisWODeadzone();
		
		double magnitude = getMagnitude();
		
		if (magnitude < RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE){
			direction = 0.0;
		} else {
			direction = Math.atan2(y, x);
		}
		direction -= Math.PI / 2;
		return direction;
	}
	
	
}





	
