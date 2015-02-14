package org.usfirst.frc.team1675.robot;

import org.usfirst.frc.team1675.robot.RobotMap.PCMChannels;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static class PWMChannels {
		public static final int FRONT_LEFT_DRIVE = 5;
		public static final int FRONT_RIGHT_DRIVE = 4;
		public static final int BACK_LEFT_DRIVE = 3;
		public static final int BACK_RIGHT_DRIVE = 2;
		public static final int TOTE_ELEVATOR = 0;
		public static final int ARM_MOTOR = 6;
	}
	
	public static class PDChannels {
		public static final int BACK_RIGHT_DRIVE = 3;
		public static final int BACK_LEFT_DRIVE = 2;
		public static final int FRONT_RIGHT_DRIVE = 12;
		public static final int FRONT_LEFT_DRIVE = 13;
	}
	
	public static class DIOChannels {
		public static final int BACK_RIGHT_ENCODER_A = 2;
		public static final int BACK_RIGHT_ENCODER_B = 3;
		public static final int BACK_LEFT_ENCODER_A = 0;
		public static final int BACK_LEFT_ENCODER_B = 1;
		public static final int FRONT_RIGHT_ENCODER_A = 8;
		public static final int FRONT_RIGHT_ENCODER_B = 9;
		public static final int FRONT_LEFT_ENCODER_A = 6;
		public static final int FRONT_LEFT_ENCODER_B = 7;
	}
	
	public static class AIOChannels {
		public static final int POT_CHANNEL = 2;
	}
	
	public static class DriveEncoders {
		public static final double DRIVE_MAX_SPEED = 15;  // feet per second of slowest wheel	
		public static final double DRIVE_WHEEL_DIAMETER = 6;
		public static class BackRightPIDDefaults{
			public static final double P = .07;
			public static final double I = .03;
			public static final double D = .001;
			public static final double F = 0;
		}
		public static class BackLeftPIDDefaults{
			public static final double P = .07;
			public static final double I = .03;
			public static final double D = .001;
			public static final double F = 0;
		}
		public static class FrontRightPIDDefaults {
			public static final double P = .07;
			public static final double I = .03;
			public static final double D = .001;
			public static final double F = 0;
		}
		public static class FrontLeftPIDDefaults  {
			public static final double P = .07;
			public static final double I = .03;
			public static final double D = .001;
			public static final double F = 0;
		}
		public static class AllThePIDs	{
			public static final double P = .07;
			public static final double I = .03;
			public static final double D = .001;
			public static final double F = 0;
		}
	}

	public static class DriverConstants {
		public static final double DEAD_ZONE_TOLERANCE = .1675;
		public static final double MOTOR_DEADZONE_TOLERANCE = .2;
		public static final double ACCELERATION_RAMP = 120;
		public static final double ACCELERATION_THRESHOLD = .07;
	}
	public static class ToteStackerConstants {
		public static final double MANUAL_SCALE_FACTOR = 0.5;
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

	public static final double SOLENOID_ACTIVE_TIME = .25;
	
	public static class PCMChannels {

		public static final int RIGHT_UPPER_CYLINDER = 9;
		public static final int RIGHT_LOWER_CYLINDER = 10;
		public static final int LEFT_UPPER_CYLINDER = 5;
		public static final int LEFT_LOWER_CYLINDER = 6;
		
	}
	
	public static final double CLAW_CYLINDER_FIRE_TIME = .1;
	
}
