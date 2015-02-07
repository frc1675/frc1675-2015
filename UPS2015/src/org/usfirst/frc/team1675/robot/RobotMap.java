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
	}
	
	public static class PDChannels {
		public static final int BACK_RIGHT_DRIVE = 1;
		public static final int BACK_LEFT_DRIVE = 0;
		public static final int FRONT_RIGHT_DRIVE = 14;
		public static final int FRONT_LEFT_DRIVE = 15;
	}
	
	public static class DIOChannels {
    	public static final int BACK_RIGHT_ENCODER_A = 8;	//double checked
    	public static final int BACK_RIGHT_ENCODER_B = 9;
    	public static final int BACK_LEFT_ENCODER_A = 4;	//double checked
    	public static final int BACK_LEFT_ENCODER_B = 5;
    	public static final int FRONT_RIGHT_ENCODER_A = 7;	//double checked
    	public static final int FRONT_RIGHT_ENCODER_B = 6;
    	public static final int FRONT_LEFT_ENCODER_A = 2;	//double checked
    	public static final int FRONT_LEFT_ENCODER_B = 3;

	}
	public static class DriveEncoders {
		public static final double DRIVE_MAX_SPEED = 10;  // feet per second of slowest wheel	
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
	}

	
	
}
