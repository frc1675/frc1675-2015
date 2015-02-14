package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.MecanumDriveWithJoysticks;
import org.usfirst.frc.team1675.robot.commands.TankDriveWithJoysticks;
import org.usfirst.frc.team1675.robot.utils.AccelerationSpeedController;
import org.usfirst.frc.team1675.robot.utils.PIDSpeedControllerForVelocity;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private AccelerationSpeedController frontLeftMotor;
	public PIDSpeedControllerForVelocity frontLeftPID;
	
	private AccelerationSpeedController frontRightMotor;
	public PIDSpeedControllerForVelocity frontRightPID;
	
	private AccelerationSpeedController backLeftMotor;
	public PIDSpeedControllerForVelocity backLeftPID;
	
	private AccelerationSpeedController backRightMotor;
	public PIDSpeedControllerForVelocity backRightPID;
		
	public Drivetrain(){				
		{
			String nameFL = "Front Left";		
			VictorSP frontLeftVSP = new VictorSP(RobotMap.PWMChannels.FRONT_LEFT_DRIVE);
			Encoder frontLeftEnc = new Encoder(RobotMap.DIOChannels.FRONT_LEFT_ENCODER_A, RobotMap.DIOChannels.FRONT_LEFT_ENCODER_B);
			frontLeftPID = new PIDSpeedControllerForVelocity(frontLeftVSP, frontLeftEnc, 250,
			RobotMap.DriveEncoders.FrontLeftPIDDefaults.P,
			RobotMap.DriveEncoders.FrontLeftPIDDefaults.I,
			RobotMap.DriveEncoders.FrontLeftPIDDefaults.D,
			RobotMap.DriveEncoders.FrontLeftPIDDefaults.F);
			frontLeftMotor = new AccelerationSpeedController(frontLeftPID, 
					RobotMap.DriverConstants.ACCELERATION_THRESHOLD,
					RobotMap.DriverConstants.ACCELERATION_RAMP, nameFL);
		}
		
		{
			String nameFR= "Front Right";		
			VictorSP frontRightVSP = new VictorSP(RobotMap.PWMChannels.FRONT_RIGHT_DRIVE);
			Encoder frontRightEnc = new Encoder(RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_A, RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_B, true);
			frontRightPID = new PIDSpeedControllerForVelocity(frontRightVSP, frontRightEnc, 250,
			RobotMap.DriveEncoders.FrontRightPIDDefaults.P,
			RobotMap.DriveEncoders.FrontRightPIDDefaults.I,
			RobotMap.DriveEncoders.FrontRightPIDDefaults.D,
			RobotMap.DriveEncoders.FrontRightPIDDefaults.F);
			frontRightMotor = new AccelerationSpeedController(frontRightPID, 
					RobotMap.DriverConstants.ACCELERATION_THRESHOLD,
					RobotMap.DriverConstants.ACCELERATION_RAMP, nameFR);
		}
		
		{
			String nameBL = "Back Left";
			VictorSP backLeftVSP = new VictorSP(RobotMap.PWMChannels.BACK_LEFT_DRIVE);
			Encoder backLeftEnc = new Encoder(RobotMap.DIOChannels.BACK_LEFT_ENCODER_A, RobotMap.DIOChannels.BACK_LEFT_ENCODER_B, true);
			backLeftPID = new PIDSpeedControllerForVelocity(backLeftVSP, backLeftEnc, 250,
			RobotMap.DriveEncoders.BackLeftPIDDefaults.P,
			RobotMap.DriveEncoders.BackLeftPIDDefaults.I,
			RobotMap.DriveEncoders.BackLeftPIDDefaults.D,
			RobotMap.DriveEncoders.BackLeftPIDDefaults.F);
			backLeftMotor = new AccelerationSpeedController(backLeftPID, 
					RobotMap.DriverConstants.ACCELERATION_THRESHOLD, 
					RobotMap.DriverConstants.ACCELERATION_RAMP, nameBL);
		}
		
		{
			String nameBR = "Back Right";
			VictorSP backRightVSP = new VictorSP(RobotMap.PWMChannels.BACK_RIGHT_DRIVE);
			Encoder backRightEnc = new Encoder(RobotMap.DIOChannels.BACK_RIGHT_ENCODER_A, RobotMap.DIOChannels.BACK_RIGHT_ENCODER_B, true);
			backRightPID = new PIDSpeedControllerForVelocity(backRightVSP, backRightEnc, 250,
			RobotMap.DriveEncoders.BackRightPIDDefaults.P,
			RobotMap.DriveEncoders.BackRightPIDDefaults.I,
			RobotMap.DriveEncoders.BackRightPIDDefaults.D,
			RobotMap.DriveEncoders.BackRightPIDDefaults.F);
			backRightMotor = new AccelerationSpeedController(backRightPID,
					RobotMap.DriverConstants.ACCELERATION_THRESHOLD, 
					RobotMap.DriverConstants.ACCELERATION_RAMP, nameBR);
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
    	setDefaultCommand(new MecanumDriveWithJoysticks());
    }
    
    
    public void ezDrive(double magnitude, double direction, double rotation) {
    	double upscaledMagnitude = magnitude * Math.sqrt(2.0);
    	
    	double dirInRad = direction + (Math.PI/4);
    	
    	double cosD = Math.cos(dirInRad);
    	double sinD = Math.sin(dirInRad);
    	
    	double frontLeftSpeed = sinD * upscaledMagnitude - rotation;
    	double frontRightSpeed = cosD * upscaledMagnitude + rotation;
    	double backLeftSpeed = cosD * upscaledMagnitude - rotation;
    	double backRightSpeed = sinD * upscaledMagnitude + rotation;
    	
    	double coefficient = getNormalizingCoefficient(magnitude, frontLeftSpeed, frontRightSpeed, backLeftSpeed, backRightSpeed);
    	
    	frontLeftSpeed *= coefficient;
    	frontRightSpeed *= coefficient;
    	backLeftSpeed *= coefficient;
    	backRightSpeed *= coefficient;
    	
    	frontLeftMotor.set(frontLeftSpeed);
    	frontRightMotor.set(frontRightSpeed);
    	backLeftMotor.set(backLeftSpeed);
    	backRightMotor.set(backRightSpeed);
    }
    
    private boolean anyOutsideNormalMagnitude(double normalMagnitude, double frontLeftSpeed, double frontRightSpeed, double backLeftSpeed, double backRightSpeed){
    	
    	return Math.abs(frontLeftSpeed) > 1.0 ||
    			Math.abs(frontRightSpeed) > 1.0 ||
    			Math.abs(backLeftSpeed) > 1.0 ||
    			Math.abs(backRightSpeed) > 1.0;
    }
    private double getNormalizingCoefficient(double stanMagnitude, double frontLeftSpeed, double frontRightSpeed, double backLeftSpeed, double backRightSpeed){
    	double maxLeft = Math.max(Math.abs(frontLeftSpeed), Math.abs(frontRightSpeed));
    	double maxRight = Math.max(Math.abs(backLeftSpeed), Math.abs(backRightSpeed));
    	double max = Math.max(maxLeft, maxRight);
    	
    	if (max > 1.0){
    		return 1.0 / max;
    	} else {
    		return 1.0;
    	}
    }
}

