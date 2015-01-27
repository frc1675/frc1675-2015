package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.PIDSpeedControllerForVelocity;
import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.MecanumDriveWithJoysticks;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Represents the drivetrain of the robot. 4 direct-driven wheels.
 */
public class Drivetrain extends Subsystem {
    
	SpeedController frontLeftMotor;
	SpeedController frontRightMotor;
	SpeedController backLeftMotor;
	SpeedController backRightMotor;
	
	public Drivetrain() {
		frontLeftMotor = new PIDSpeedControllerForVelocity(new Victor(RobotMap.PWMChannels.FRONT_LEFT_DRIVE), 
				new Encoder(RobotMap.DIOChannels.FRONT_LEFT_ENCODER_A, RobotMap.DIOChannels.FRONT_LEFT_ENCODER_B), 250,
				SmartDashboard.getNumber("FrontLeftP", RobotMap.DriveEncoders.FrontLeftPIDDefaults.P),
				SmartDashboard.getNumber("FrontLeftI", RobotMap.DriveEncoders.FrontLeftPIDDefaults.I),
				SmartDashboard.getNumber("FrontLeftD", RobotMap.DriveEncoders.FrontLeftPIDDefaults.D),
				SmartDashboard.getNumber("FrontLeftF", RobotMap.DriveEncoders.FrontLeftPIDDefaults.F));		
		frontRightMotor = new PIDSpeedControllerForVelocity(new Victor(RobotMap.PWMChannels.FRONT_RIGHT_DRIVE), 
				new Encoder(RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_A, RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_B), 360,
				SmartDashboard.getNumber("FrontRightP", RobotMap.DriveEncoders.FrontRightPIDDefaults.P),
				SmartDashboard.getNumber("FrontRightI", RobotMap.DriveEncoders.FrontRightPIDDefaults.I),
				SmartDashboard.getNumber("FrontRightD", RobotMap.DriveEncoders.FrontRightPIDDefaults.D),
				SmartDashboard.getNumber("FrontRightF", RobotMap.DriveEncoders.FrontRightPIDDefaults.F));		
		backLeftMotor = new PIDSpeedControllerForVelocity(new Victor(RobotMap.PWMChannels.BACK_LEFT_DRIVE), 
				new Encoder(RobotMap.DIOChannels.BACK_LEFT_ENCODER_A, RobotMap.DIOChannels.BACK_LEFT_ENCODER_B), 250,
				SmartDashboard.getNumber("BackLeftP", RobotMap.DriveEncoders.BackLeftPIDDefaults.P),
				SmartDashboard.getNumber("BackLeftI", RobotMap.DriveEncoders.BackLeftPIDDefaults.I),
				SmartDashboard.getNumber("BackLeftD", RobotMap.DriveEncoders.BackLeftPIDDefaults.D),
				SmartDashboard.getNumber("BackLeftF", RobotMap.DriveEncoders.BackLeftPIDDefaults.F));				
		backRightMotor = new PIDSpeedControllerForVelocity(new Victor(RobotMap.PWMChannels.BACK_RIGHT_DRIVE), 
				new Encoder(RobotMap.DIOChannels.BACK_RIGHT_ENCODER_A, RobotMap.DIOChannels.BACK_RIGHT_ENCODER_B), 250,
				SmartDashboard.getNumber("BackRightP", RobotMap.DriveEncoders.BackRightPIDDefaukts.P),
				SmartDashboard.getNumber("BackRightI", RobotMap.DriveEncoders.BackRightPIDDefaukts.I),
				SmartDashboard.getNumber("BackRightD", RobotMap.DriveEncoders.BackRightPIDDefaukts.D),
				SmartDashboard.getNumber("BackRightF", RobotMap.DriveEncoders.BackRightPIDDefaukts.F));		

	}
	
	public void setFrontLeftSpeed(double speed) {
		frontLeftMotor.set(-speed);	
	}
	
	public void setFrontRightSpeed(double speed) {
		frontRightMotor.set(speed);
	}
	
	public void setBackLeftSpeed(double speed) {
		backLeftMotor.set(speed);
	}
	
	public void setBackRightSpeed(double speed) {
		backRightMotor.set(speed);
	}

    public void initDefaultCommand() {
    	
    	setDefaultCommand(new MecanumDriveWithJoysticks());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

