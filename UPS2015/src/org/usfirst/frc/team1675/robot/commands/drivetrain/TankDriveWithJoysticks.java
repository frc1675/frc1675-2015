package org.usfirst.frc.team1675.robot.commands.drivetrain;


import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Controls the drivetrain in a Tank-Drive style, with each joystick controlling 1 side.
 */
public class TankDriveWithJoysticks extends Command {

    public TankDriveWithJoysticks() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	double leftStick = Robot.oi.getDriverLeftYAxis();
    	double rightStick = Robot.oi.getDriverRightYAxis();
    	
    	Robot.drivetrain.setBackLeftSpeed(leftStick);
    	Robot.drivetrain.setBackRightSpeed(rightStick);
    	Robot.drivetrain.setFrontLeftSpeed(leftStick);
    	Robot.drivetrain.setFrontRightSpeed(rightStick);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
