package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.drivetrain.CheezyDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	private SpeedController frontLeftMotor;
	private SpeedController frontRightMotor;
	private SpeedController backLeftMotor;
	private SpeedController backRightMotor;
	
	private Encoder frontLeftEncoder;
	private Encoder frontRightEncoder;
	private Encoder backLeftEncoder;
	private Encoder backRightEncoder;
	
	private Gyro gyro;
		
	public Drivetrain(){	
		frontLeftMotor = new VictorSP(RobotMap.PWMChannels.FRONT_LEFT_DRIVE);
		frontRightMotor = new VictorSP(RobotMap.PWMChannels.FRONT_RIGHT_DRIVE);
		backLeftMotor = new VictorSP(RobotMap.PWMChannels.BACK_LEFT_DRIVE);
		backRightMotor = new VictorSP(RobotMap.PWMChannels.BACK_RIGHT_DRIVE);		
	
		frontLeftEncoder = new Encoder(RobotMap.DIOChannels.FRONT_LEFT_ENCODER_A, RobotMap.DIOChannels.FRONT_LEFT_ENCODER_B);
		frontRightEncoder = new Encoder(RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_A, RobotMap.DIOChannels.FRONT_RIGHT_ENCODER_B);
		backLeftEncoder = new Encoder(RobotMap.DIOChannels.BACK_LEFT_ENCODER_A, RobotMap.DIOChannels.BACK_LEFT_ENCODER_B);
		backRightEncoder = new Encoder(RobotMap.DIOChannels.BACK_RIGHT_ENCODER_A, RobotMap.DIOChannels.BACK_RIGHT_ENCODER_B);
	
		gyro = new Gyro(RobotMap.AIOChannels.GYRO_CHANNEL);
		gyro.setSensitivity(.007);
	}	
	
	public void setFrontLeftSpeed(double speed) {	
		frontLeftMotor.set(RobotMap.DrivePolarities.FRONT_LEFT_DRIVE_POLARITY * speed);
	}
	
	public void setFrontRightSpeed(double speed) {
		frontRightMotor.set(RobotMap.DrivePolarities.FRONT_RIGHT_DRIVE_POLARITY * speed);
	}
	public void setBackLeftSpeed(double speed) {
		backLeftMotor.set(RobotMap.DrivePolarities.BACK_LEFT_DRIVE_POLARITY * speed);
	}
	
	public void setBackRightSpeed(double speed) {
		backRightMotor.set(RobotMap.DrivePolarities.BACK_RIGHT_DRIVE_POLARITY * speed);
	}

    public void initDefaultCommand() {    	
    	setDefaultCommand(new CheezyDrive());
    }
    
    public void resetDriveEncoders(){
    	frontLeftEncoder.reset();
    	frontRightEncoder.reset();
    	backLeftEncoder.reset();
    	backRightEncoder.reset();
    }
    public double getFrontLeftEncoder(){
    	return frontLeftEncoder.get();
    }
    public double getFrontRightEncoder(){
    	return frontRightEncoder.get();
    }
    public double getBackLeftEncoder(){
    	return backRightEncoder.get();    	
    }
    public double getBackRightEncoder(){
    	return backRightEncoder.get();
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
    	
    	//Left side is flipped due to polar algorithm
    	frontLeftMotor.set(-frontLeftSpeed);
    	frontRightMotor.set(frontRightSpeed);
    	backLeftMotor.set(-backLeftSpeed);
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

	public void resetGyro() {
		gyro.reset();
		
	}

	public double getGyroAngle() {
		// TODO Auto-generated method stub
		return gyro.getAngle();
	}
}

