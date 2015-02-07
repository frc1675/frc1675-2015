package org.usfirst.frc.team1675.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static class PWMChannels {
		public static final int FRONT_LEFT_DRIVE = 8;
		public static final int FRONT_RIGHT_DRIVE = 9;
		public static final int BACK_LEFT_DRIVE = 0;
		public static final int BACK_RIGHT_DRIVE = 1;
		public static final int ARM_MOTOR = 8;
	}
	
	public static class PDChannels {
		public static final int BACK_RIGHT_DRIVE = 1;
		public static final int BACK_LEFT_DRIVE = 0;
		public static final int FRONT_RIGHT_DRIVE = 14;
		public static final int FRONT_LEFT_DRIVE = 15;
	}
	
	public static class DIOChannels {
		public static final int BACK_RIGHT_ENCODER_A = 8;
		public static final int BACK_RIGHT_ENCODER_B = 9;
		public static final int BACK_LEFT_ENCODER_A = 6;
		public static final int BACK_LEFT_ENCODER_B = 7;
		public static final int FRONT_RIGHT_ENCODER_A = 4;
		public static final int FRONT_RIGHT_ENCODER_B = 5;
		public static final int FRONT_LEFT_ENCODER_A = 2;
		public static final int FRONT_LEFT_ENCODER_B = 3;
	}
	public static class AIOChannels {
		public static final int POT_CHANNEL = 2;
	}
	
	public static class DriverConstants {
		public static final double DEAD_ZONE_TOLERANCE = .1675;
	}
	
	//Container PID
	public static final double CONTAINER_ARM_P = .05;
	public static final double CONTAINER_ARM_I = 0;
	public static final double CONTAINER_ARM_D = 0;
	
	public static class SolenoidChannels{
		public static final int WRIST_DOWN = 0;		
		public static final int WRIST_UP = 1;		
		public static final int LEFT_CLAW_EXTEND = 2;		
		public static final int LEFT_CLAW_RETRACT = 3;
		public static final int RIGHT_CLAW_EXTEND = 4;		
		public static final int RIGHT_CLAW_RETRACT = 5;
	}

	public static final double SOLENOID_ACTIVE_TIME = .5;
	
	
}
