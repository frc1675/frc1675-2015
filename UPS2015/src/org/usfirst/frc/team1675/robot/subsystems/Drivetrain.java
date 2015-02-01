package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.PIDSpeedControllerForVelocity;
import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.TankDriveWithJoysticks;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Represents the drivetrain of the robot. 4 direct-driven wheels.
 */
public class Drivetrain extends Subsystem {
    
	public PIDSpeedControllerForVelocity frontLeftMotor;
	public PIDSpeedControllerForVelocity frontRightMotor;
	public PIDSpeedControllerForVelocity backLeftMotor;
	public PIDSpeedControllerForVelocity backRightMotor;
	
	public Drivetrain() {
		frontLeftMotor = new PIDSpeedControllerForVelocity(new VictorSP(RobotMap.PWMChannels.FRONT_LEFT_DRIVE), 
				new Encoder(RobotMap.DIOChannels.FRONT_LEFT_ENCODER_B, RobotMap.DIOChannels.FRONT_LEFT_ENCODER_A), 250,
				RobotMap.DriveEncoders.FrontLeftPIDDefaults.P,
				RobotMap.DriveEncoders.FrontLeftPIDDefaults.I,
				RobotMap.DriveEncoders.FrontLeftPIDDefaults.D,
				RobotMap.DriveEncoders.FrontLeftPIDDefaults.F);		
		frontRightMotor = new PIDSpeedControllerForVelocity(new VictorSP(RobotMap.PWMChannels.FRONT_RIGHT_DRIVE), 
				new Encoder(RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_A, RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_B), 250,
				RobotMap.DriveEncoders.FrontRightPIDDefaults.P,
				RobotMap.DriveEncoders.FrontRightPIDDefaults.I,
				RobotMap.DriveEncoders.FrontRightPIDDefaults.D,
				RobotMap.DriveEncoders.FrontRightPIDDefaults.F);		
		backLeftMotor = new PIDSpeedControllerForVelocity(new VictorSP(RobotMap.PWMChannels.BACK_LEFT_DRIVE), 
				new Encoder(RobotMap.DIOChannels.BACK_LEFT_ENCODER_A, RobotMap.DIOChannels.BACK_LEFT_ENCODER_B), 360,
				RobotMap.DriveEncoders.BackLeftPIDDefaults.P,
				RobotMap.DriveEncoders.BackLeftPIDDefaults.I,
				RobotMap.DriveEncoders.BackLeftPIDDefaults.D,
				RobotMap.DriveEncoders.BackLeftPIDDefaults.F);				
		backRightMotor = new PIDSpeedControllerForVelocity(new VictorSP(RobotMap.PWMChannels.BACK_RIGHT_DRIVE), 
				new Encoder(RobotMap.DIOChannels.BACK_RIGHT_ENCODER_A, RobotMap.DIOChannels.BACK_RIGHT_ENCODER_B), 250,
				RobotMap.DriveEncoders.BackRightPIDDefaults.P,
				RobotMap.DriveEncoders.BackRightPIDDefaults.I,
				RobotMap.DriveEncoders.BackRightPIDDefaults.D,
				RobotMap.DriveEncoders.BackRightPIDDefaults.F);		

	}
	
	public void setFrontLeftSpeed(double speed) {
		frontLeftMotor.set(-speed);	
		SmartDashboard.putNumber("Sent To Front Left", frontLeftMotor.get());
		SmartDashboard.putNumber("front left value sticks say to go", speed);
	}
	
	public void setFrontRightSpeed(double speed) {
		frontRightMotor.set(speed);
		SmartDashboard.putNumber("Sent To Front Right", frontRightMotor.get());
		SmartDashboard.putNumber("front right value sticks say to go", speed);
	}
	public void setBackLeftSpeed(double speed) {
		backLeftMotor.set(speed);
		SmartDashboard.putNumber("Sent To Back Left", backLeftMotor.get());
		SmartDashboard.putNumber("back left value sticks say to go", speed);
	}
	
	public void setBackRightSpeed(double speed) {
		backRightMotor.set(speed);
		SmartDashboard.putNumber("back right value sticks say to go", speed);
		SmartDashboard.putNumber("Sent To Back Right Motor", backRightMotor.get());
	}

    public void initDefaultCommand() {
    	
    	setDefaultCommand(new TankDriveWithJoysticks());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

