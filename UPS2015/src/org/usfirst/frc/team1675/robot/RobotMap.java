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
	
	//Container PID
	public static final double CONTAINER_ARM_P = .05;
	public static final double CONTAINER_ARM_I = 0;
	public static final double CONTAINER_ARM_D = 0;
	
	public static class SolenoidStuff{
		public static final double SOLENOID_ACTIVE_TIME = .5;
		public static final int WRIST_DOWN = 0;		
		public static final int WRIST_UP = 1;		
		public static final int LEFT_CLAW_EXTEND = 2;		
		public static final int LEFT_CLAW_RETRACT = 3;
		public static final int RIGHT_CLAW_EXTEND = 4;		
		public static final int RIGHT_CLAW_RETRACT = 5;
	}
	
	
}
