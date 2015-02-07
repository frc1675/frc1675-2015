package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.TankDriveWithJoysticks;
import org.usfirst.frc.team1675.robot.utils.AccelerationSpeedController;
import org.usfirst.frc.team1675.robot.utils.PIDSpeedControllerForVelocity;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
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
//		{
//			VictorSP frontLeftVSP = new VictorSP(RobotMap.PWMChannels.FRONT_LEFT_DRIVE);
//			AccelerationSpeedController frontLeftAccel = new AccelerationSpeedController(frontLeftVSP, 0.10, 120);
//			Encoder frontLeftEnc = new Encoder(RobotMap.DIOChannels.FRONT_LEFT_ENCODER_B, RobotMap.DIOChannels.FRONT_LEFT_ENCODER_A);
//			frontLeftMotor = new PIDSpeedControllerForVelocity(frontLeftAccel, frontLeftEnc, 250,
//			RobotMap.DriveEncoders.FrontLeftPIDDefaults.P,
//			RobotMap.DriveEncoders.FrontLeftPIDDefaults.I,
//			RobotMap.DriveEncoders.FrontLeftPIDDefaults.D,
//			RobotMap.DriveEncoders.FrontLeftPIDDefaults.F);
//		}
//		
//		{
//			VictorSP frontRightVSP = new VictorSP(RobotMap.PWMChannels.FRONT_RIGHT_DRIVE);
//			AccelerationSpeedController frontRightAccel = new AccelerationSpeedController(frontRightVSP, 0.10, 120);		
//			Encoder frontRightEnc = new Encoder(RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_B, RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_A, true);
//			frontRightMotor = new PIDSpeedControllerForVelocity(frontRightAccel, frontRightEnc, 250,
//			RobotMap.DriveEncoders.FrontRightPIDDefaults.P,
//			RobotMap.DriveEncoders.FrontRightPIDDefaults.I,
//			RobotMap.DriveEncoders.FrontRightPIDDefaults.D,
//			RobotMap.DriveEncoders.FrontRightPIDDefaults.F);
//		}
//
//		{
//			VictorSP backLeftVSP = new VictorSP(RobotMap.PWMChannels.BACK_LEFT_DRIVE);
//			AccelerationSpeedController backLeftAccel = new AccelerationSpeedController(backLeftVSP, 0.10, 120);
//			Encoder backLeftEnc = new Encoder(RobotMap.DIOChannels.BACK_LEFT_ENCODER_B, RobotMap.DIOChannels.BACK_LEFT_ENCODER_A, true);
//			backLeftMotor = new PIDSpeedControllerForVelocity(backLeftAccel, backLeftEnc, 360,
//			RobotMap.DriveEncoders.BackLeftPIDDefaults.P,
//			RobotMap.DriveEncoders.BackLeftPIDDefaults.I,
//			RobotMap.DriveEncoders.BackLeftPIDDefaults.D,
//			RobotMap.DriveEncoders.BackLeftPIDDefaults.F);
//		}
//		
//		{
//			VictorSP backRightVSP = new VictorSP(RobotMap.PWMChannels.BACK_RIGHT_DRIVE);
//			AccelerationSpeedController backRightAccel = new AccelerationSpeedController(backRightVSP, 0.10, 120);
//			Encoder backRightEnc = new Encoder(RobotMap.DIOChannels.BACK_RIGHT_ENCODER_B, RobotMap.DIOChannels.BACK_RIGHT_ENCODER_A, true);
//			backRightMotor = new PIDSpeedControllerForVelocity(backRightAccel, backRightEnc, 250,
//			RobotMap.DriveEncoders.BackRightPIDDefaults.P,
//			RobotMap.DriveEncoders.BackRightPIDDefaults.I,
//			RobotMap.DriveEncoders.BackRightPIDDefaults.D,
//			RobotMap.DriveEncoders.BackRightPIDDefaults.F);		
//		}
	}
	
//	public void setFrontLeftSpeed(double speed) {
//		System.out.println("Set the front q	`1left speed!");
//		frontLeftMotor.set(-speed);	
//		SmartDashboard.putNumber("Sent To Front Left", frontLeftMotor.get());
//		SmartDashboard.putNumber("front left value sticks say to go", speed);
//	}
//	
//	public void setFrontRightSpeed(double speed) {
//		frontRightMotor.set(speed);
//		SmartDashboard.putNumber("Sent To Front Right", frontRightMotor.get());
//		SmartDashboard.putNumber("front right value sticks say to go", speed);
//	}
//	public void setBackLeftSpeed(double speed) {
//		backLeftMotor.set(speed);
//		SmartDashboard.putNumber("Sent To Back Left", backLeftMotor.get());
//		SmartDashboard.putNumber("back left value sticks say to go", speed);
//	}
//	
//	public void setBackRightSpeed(double speed) {
//		backRightMotor.set(speed);
//		SmartDashboard.putNumber("back right value sticks say to go", speed);
//		SmartDashboard.putNumber("Sent To Back Right Motor", backRightMotor.get());
//	}

    public void initDefaultCommand() {
    	
    	setDefaultCommand(new TankDriveWithJoysticks());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

