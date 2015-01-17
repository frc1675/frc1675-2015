package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.TankDriveWithJoysticks;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Represents the drivetrain of the robot. 4 direct-driven wheels.
 */
public class Drivetrain extends Subsystem {
    
	Talon frontLeftMotor;
	Talon frontRightMotor;
	Talon backLeftMotor;
	Talon backRightMotor;
	GyroPIDSubsystem gyroSubsystem;
	
	public Drivetrain() {
		frontLeftMotor = new Talon(RobotMap.FRONT_LEFT_MOTOR_CHANNEL);
		frontRightMotor = new Talon(RobotMap.FRONT_RIGHT_MOTOR_CHANNEL);
		backLeftMotor = new Talon(RobotMap.BACK_LEFT_MOTOR_CHANNEL);
		backRightMotor = new Talon(RobotMap.BACK_RIGHT_MOTOR_CHANNEL);
		gyroSubsystem = new GyroPIDSubsystem(RobotMap.P, RobotMap.I, RobotMap.D, RobotMap.SETPOINT);
	}
	
	public void setFrontLeftSpeed(double speed) {
		frontLeftMotor.set(-speed);	
	}
	
	public void setFrontRightSpeed(double speed) {
		frontRightMotor.set(speed);
	}
	
	public void setBackLeftSpeed(double speed) {
		backLeftMotor.set(-speed);
	}
	
	public void setBackRightSpeed(double speed) {
		backRightMotor.set(speed);
	}

    public void initDefaultCommand() {
    	
    	setDefaultCommand(new TankDriveWithJoysticks());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public class GyroPIDSubsystem extends PIDSubsystem{
    	
    	Gyro gyro = new Gyro(RobotMap.GYRO_CHANNEL);
    	

		public GyroPIDSubsystem(double p, double i, double d, double setpoint) {
			super(p, i, d);
			// TODO Auto-generated constructor stub
			gyro.setSensitivity(.007);
			this.setSetpoint(setpoint);
			
			
		}
		
		public void start(){
			this.enable();
		}
		
		public void stop(){
			this.disable();
			this.getPIDController().reset();
		}

		public void resetGyro(){
			gyro.reset();
		}
		
		@Override
		protected double returnPIDInput() {
			// TODO Auto-generated method stub
			return gyro.getAngle();
		}

		@Override
		protected void usePIDOutput(double output) {
			// TODO Auto-generated method stub
			setFrontLeftSpeed(output);
			setBackLeftSpeed(output);
			setFrontRightSpeed(-output);
			setBackRightSpeed(-output);
			
		}

		@Override
		protected void initDefaultCommand() {
			// TODO Auto-generated method stub
			
		}
    	
    }
    
    
    
    
    
    
    
}

