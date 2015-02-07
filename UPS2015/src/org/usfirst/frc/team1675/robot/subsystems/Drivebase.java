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
		
		VictorSPSP frontLeftVSP = new VictorSPSP(RobotMap.PWMChannels.FRONT_LEFT_DRIVE, "Front Left");
		Encoder frontLeftEnc = new Encoder(RobotMap.DIOChannels.FRONT_LEFT_ENCODER_A, RobotMap.DIOChannels.FRONT_LEFT_ENCODER_B);
		PIDSpeedControllerForVelocity frontLeftPID = new PIDSpeedControllerForVelocity(frontLeftVSP, frontLeftEnc, 250,
		RobotMap.DriveEncoders.FrontLeftPIDDefaults.P,
		RobotMap.DriveEncoders.FrontLeftPIDDefaults.I,
		RobotMap.DriveEncoders.FrontLeftPIDDefaults.D,
		RobotMap.DriveEncoders.FrontLeftPIDDefaults.F);
		frontLeftMotor = new AccelerationSpeedController(frontLeftPID, .10, 250);
		
		VictorSPSP frontRightVSP = new VictorSPSP(RobotMap.PWMChannels.FRONT_RIGHT_DRIVE, "Front Right");
		Encoder frontRightEnc = new Encoder(RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_A, RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_B);
		PIDSpeedControllerForVelocity frontRightPID = new PIDSpeedControllerForVelocity(frontRightVSP, frontRightEnc, 250,
		RobotMap.DriveEncoders.FrontRightPIDDefaults.P,
		RobotMap.DriveEncoders.FrontRightPIDDefaults.I,
		RobotMap.DriveEncoders.FrontRightPIDDefaults.D,
		RobotMap.DriveEncoders.FrontRightPIDDefaults.F);
		frontRightMotor = new AccelerationSpeedController(frontRightPID, .10, 250);
		
		VictorSPSP backLeftVSP = new VictorSPSP(RobotMap.PWMChannels.BACK_LEFT_DRIVE, "Back Left");
		Encoder backLeftEnc = new Encoder(RobotMap.DIOChannels.BACK_LEFT_ENCODER_A, RobotMap.DIOChannels.BACK_LEFT_ENCODER_B);
		PIDSpeedControllerForVelocity backLeftPID = new PIDSpeedControllerForVelocity(backLeftVSP, backLeftEnc, 360,
		RobotMap.DriveEncoders.BackLeftPIDDefaults.P,
		RobotMap.DriveEncoders.BackLeftPIDDefaults.I,
		RobotMap.DriveEncoders.BackLeftPIDDefaults.D,
		RobotMap.DriveEncoders.BackLeftPIDDefaults.F);
		backLeftMotor = new AccelerationSpeedController(backLeftPID, .10, 250);
		
		VictorSPSP backRightVSP = new VictorSPSP(RobotMap.PWMChannels.BACK_RIGHT_DRIVE, "Back Right");
		Encoder backRightEnc = new Encoder(RobotMap.DIOChannels.BACK_RIGHT_ENCODER_A, RobotMap.DIOChannels.BACK_RIGHT_ENCODER_B);
		PIDSpeedControllerForVelocity backRightPID = new PIDSpeedControllerForVelocity(backRightVSP, backRightEnc, 250,
		RobotMap.DriveEncoders.BackRightPIDDefaults.P,
		RobotMap.DriveEncoders.BackRightPIDDefaults.I,
		RobotMap.DriveEncoders.BackRightPIDDefaults.D,
		RobotMap.DriveEncoders.BackRightPIDDefaults.F);
		backRightMotor = new AccelerationSpeedController(backRightPID, .10, 250);
		
	}
	
	public void setFrontLeftSpeed(double speed) {
		SmartDashboard.putNumber("Set FrontLeftSpeed Drivebase", speed);		
		frontLeftMotor.set(-speed);	
//		SmartDashboard.putNumber("Sent To Front Left", frontLeftMotor.get());
//		SmartDashboard.putNumber("front left value sticks say to go", speed);
	}
	
	public void setFrontRightSpeed(double speed) {
		frontRightMotor.set(speed);
//		SmartDashboard.putNumber("Sent To Front Right", frontRightMotor.get());
//		SmartDashboard.putNumber("front right value sticks say to go", speed);
	}
	public void setBackLeftSpeed(double speed) {
		backLeftMotor.set(speed);
//		SmartDashboard.putNumber("Sent To Back Left", backLeftMotor.get());
//		SmartDashboard.putNumber("back left value sticks say to go", speed);
	}
	
	public void setBackRightSpeed(double speed) {
		backRightMotor.set(speed);
//		SmartDashboard.putNumber("back right value sticks say to go", speed);
//		SmartDashboard.putNumber("Sent To Back Right Motor", backRightMotor.get());
	}

    public void initDefaultCommand() {
    	
    	setDefaultCommand(new TankDriveWithJoysticks());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

