package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.TankDriveWithJoysticks;
import org.usfirst.frc.team1675.robot.utils.AccelerationSpeedController;
import org.usfirst.frc.team1675.robot.utils.PIDSpeedControllerForVelocity;
import org.usfirst.frc.team1675.robot.utils.VictorSPSP;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivebase extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private AccelerationSpeedController frontLeftMotor;
	private AccelerationSpeedController frontRightMotor;
	private AccelerationSpeedController backLeftMotor;
	private AccelerationSpeedController backRightMotor;
	
	
	
	public Drivebase(){				
		{
			String nameFL = "Front Left";		
			VictorSPSP frontLeftVSP = new VictorSPSP(RobotMap.PWMChannels.FRONT_LEFT_DRIVE, nameFL);
			Encoder frontLeftEnc = new Encoder(RobotMap.DIOChannels.FRONT_LEFT_ENCODER_A, RobotMap.DIOChannels.FRONT_LEFT_ENCODER_B);
			PIDSpeedControllerForVelocity frontLeftPID = new PIDSpeedControllerForVelocity(frontLeftVSP, frontLeftEnc, 250,
			RobotMap.DriveEncoders.FrontLeftPIDDefaults.P,
			RobotMap.DriveEncoders.FrontLeftPIDDefaults.I,
			RobotMap.DriveEncoders.FrontLeftPIDDefaults.D,
			RobotMap.DriveEncoders.FrontLeftPIDDefaults.F,
			nameFL);
			frontLeftMotor = new AccelerationSpeedController(frontLeftPID, .10, 250, nameFL);
		}
		
		{
			String nameFR= "Front Right";		
			VictorSPSP frontRightVSP = new VictorSPSP(RobotMap.PWMChannels.FRONT_RIGHT_DRIVE, nameFR);
			Encoder frontRightEnc = new Encoder(RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_A, RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_B, true);
			PIDSpeedControllerForVelocity frontRightPID = new PIDSpeedControllerForVelocity(frontRightVSP, frontRightEnc, 250,
			RobotMap.DriveEncoders.FrontRightPIDDefaults.P,
			RobotMap.DriveEncoders.FrontRightPIDDefaults.I,
			RobotMap.DriveEncoders.FrontRightPIDDefaults.D,
			RobotMap.DriveEncoders.FrontRightPIDDefaults.F,
			nameFR);
			frontRightMotor = new AccelerationSpeedController(frontRightPID, .10, 250, nameFR);
		}
		
		{
			String nameBL = "Back Left";
			VictorSPSP backLeftVSP = new VictorSPSP(RobotMap.PWMChannels.BACK_LEFT_DRIVE, nameBL);
			Encoder backLeftEnc = new Encoder(RobotMap.DIOChannels.BACK_LEFT_ENCODER_A, RobotMap.DIOChannels.BACK_LEFT_ENCODER_B, true);
			PIDSpeedControllerForVelocity backLeftPID = new PIDSpeedControllerForVelocity(backLeftVSP, backLeftEnc, 250,
			RobotMap.DriveEncoders.BackLeftPIDDefaults.P,
			RobotMap.DriveEncoders.BackLeftPIDDefaults.I,
			RobotMap.DriveEncoders.BackLeftPIDDefaults.D,
			RobotMap.DriveEncoders.BackLeftPIDDefaults.F,
			nameBL);
			backLeftMotor = new AccelerationSpeedController(backLeftPID, .10, 250, nameBL);
		}
		
		{
			String nameBR = "Back Right";
			VictorSPSP backRightVSP = new VictorSPSP(RobotMap.PWMChannels.BACK_RIGHT_DRIVE, nameBR);
			Encoder backRightEnc = new Encoder(RobotMap.DIOChannels.BACK_RIGHT_ENCODER_A, RobotMap.DIOChannels.BACK_RIGHT_ENCODER_B, true);
			PIDSpeedControllerForVelocity backRightPID = new PIDSpeedControllerForVelocity(backRightVSP, backRightEnc, 250,
			RobotMap.DriveEncoders.BackRightPIDDefaults.P,
			RobotMap.DriveEncoders.BackRightPIDDefaults.I,
			RobotMap.DriveEncoders.BackRightPIDDefaults.D,
			RobotMap.DriveEncoders.BackRightPIDDefaults.F,
			nameBR);
			backRightMotor = new AccelerationSpeedController(backRightPID, .10, 250, nameBR);
		}
		
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
    	setDefaultCommand(new TankDriveWithJoysticks());
    }
}

