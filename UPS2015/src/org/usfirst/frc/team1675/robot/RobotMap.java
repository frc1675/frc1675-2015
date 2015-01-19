package org.usfirst.frc.team1675.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

	public static final int FRONT_LEFT_MOTOR_CHANNEL = 2;
	
	public static final int FRONT_RIGHT_MOTOR_CHANNEL = 0;
	
	public static final int BACK_LEFT_MOTOR_CHANNEL = 3;
	
	public static final int BACK_RIGHT_MOTOR_CHANNEL = 1;
	
	public static final double DEAD_ZONE_TOLERANCE = .1675;

	
	
	public static final double DRIVE_MAX_SPEED = 10;  // feet per second of slowest wheel	
	public static final double DRIVE_WHEEL_DIAMETER = 6; //inches	
	public static final double DRIVE_ENCODER_TICKS_PER_REVOLUTION = 360;
	
	
}
