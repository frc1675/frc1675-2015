package org.usfirst.frc.team1675.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	private static final boolean IS_COMPETITION = true;
	
	public static int getTicksPerTote(){
		if(IS_COMPETITION){
			return CompConstants.TICKS_PER_TOTE;
		}else{
			return PracticeConstants.TICKS_PER_TOTE;
		}
	}
	public static double getTurnNinetyDegreesTime(){
		if(IS_COMPETITION){
			return CompConstants.TURN_NINETY_DEGREES_TIME;
		}else{
			return PracticeConstants.TURN_NINETY_DEGREES_TIME;
		}
	}
	public static double getPotScale(){
		if(IS_COMPETITION){
			return CompConstants.POT_COUNTS;
		}else{
			return PracticeConstants.POT_COUNTS;
		}
	}
	public static double getStepCanExtendTime(){
		if(IS_COMPETITION){
			return CompConstants.STEP_CAN_EXTEND_TIME;
		}else{
			return PracticeConstants.STEP_CAN_EXTEND_TIME;
		}
	}
	public static double getHomePosition(){
		if(IS_COMPETITION){
			return CompConstants.HOME_POSITION;
		}else{
			return PracticeConstants.HOME_POSITION;
		}
	}
	public static double getPickupPosition(){
		if(IS_COMPETITION){
			return CompConstants.PICK_UP_POSITION;
		}else{
			return PracticeConstants.PICK_UP_POSITION;
		}
	}
	public static double getStepCanPosition(){
		if(IS_COMPETITION){
			return CompConstants.STEP_CAN_POSITION ;
		}else{
			return PracticeConstants.STEP_CAN_POSITION ;
		}
	}
	public static double getStepBlockHeight(){
		if(IS_COMPETITION){
			return CompConstants.STEP_BLOCK_HEIGHT ;
		}else{
			return PracticeConstants.STEP_BLOCK_HEIGHT ;
		}
	}
	public static double getMaxHeight(){
		if(IS_COMPETITION){
			return CompConstants.MAX_HEIGHT ;
		}else{
			return PracticeConstants.MAX_HEIGHT ;
		}
	}
	public static double getTwoTotePickupPower(){
		if(IS_COMPETITION){
			return CompConstants.TWO_TOTE_AUTO_PICKUP_POWER ;
		}else{
			return PracticeConstants.TWO_TOTE_AUTO_PICKUP_POWER ;
		}
	}
	
	private static class CompConstants {
		private static final int TICKS_PER_TOTE = 85;
		private static final double TURN_NINETY_DEGREES_TIME = .7;
		private static final double POT_COUNTS = 360;
		private static final double STEP_CAN_EXTEND_TIME = .45;
		private static final double STEP_BLOCK_HEIGHT = 202;
		private static final double STEP_CAN_POSITION = 100;
		private static final double PICK_UP_POSITION = 118;
		private static final double HOME_POSITION = 145;
		private static final double MAX_HEIGHT = 38;
		private static final double TWO_TOTE_AUTO_PICKUP_POWER = .37;
	}
	private static class PracticeConstants {
		private static final int TICKS_PER_TOTE = 272;
		private static final double TURN_NINETY_DEGREES_TIME = .9;
		private static final int POT_COUNTS = 250;
		private static final double STEP_CAN_EXTEND_TIME = .6;
		private static final double STEP_BLOCK_HEIGHT = 208;
		private static final double HOME_POSITION = 226;
		private static final double STEP_CAN_POSITION = 181;
		private static final double PICK_UP_POSITION = 216;
		private static final double MAX_HEIGHT = 150;
		private static final double TWO_TOTE_AUTO_PICKUP_POWER = .4;

	}
	public static class TwoGreyToteAutoConstants {
		public static final double DRIVE_POWER = .47;
	    public static final double  PICKUP_DRIVE_POWER = .32;
	    public static final double WAIT_AFTER_PICKUP = 2;
	}

	public static class PWMChannels {
		public static final int FRONT_LEFT_DRIVE = 5;
		public static final int FRONT_RIGHT_DRIVE = 4;
		public static final int BACK_LEFT_DRIVE = 2;
		public static final int BACK_RIGHT_DRIVE = 3;
		public static final int TOTE_ELEVATOR = 7;
		public static final int ARM_MOTOR = 1;
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
		public static final int TOTEVATOR_ENCODER_A = 4;
		public static final int TOTEVATOR_ENCODER_B = 5;
		public static final int HALL_EFFECT = 11;
	}
	
	public static class ControllerPorts {
		static final int DRIVER = 0;
		static final int OPERATOR = 1;
		static final int BUTTON_BOX=2;
	}
	
	public static class AIOChannels {
		public static final int POT_CHANNEL = 3;
	}
	
	public static class DriveEncoders {
		public static final double DRIVE_MAX_SPEED = 7;  // feet per second of slowest wheel	
		public static final double DRIVE_WHEEL_DIAMETER = 6;
		public static class PositionPIDDefaults{
			public static final double P = .0035;
			public static final double I = .00;
			public static final double D = .065;
		}
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
	public static class AutoConstants{
		public static final double TURN_NINETY_DEGREES_TIME = .7;
	}

	public static class DriverConstants {
		public static final double DEAD_ZONE_TOLERANCE = .1675; //i'm glad we arent FRC 5543
		public static final double MOTOR_DEADZONE_TOLERANCE = .2;
		public static final double ACCELERATION_RAMP = 120;
		public static final double ACCELERATION_THRESHOLD = .07;
	}
	
	public static class ToteStackerConstants {
		public static final double MANUAL_SCALE_FACTOR = 1;
		public static final double P = .04;
		public static final double I = 0;
		public static final double D = 0;
	}
	
	public static class ContainerArmConstants{
//		public static final double MAX_HEIGHT = 85;
//		public static final double FIVE_STACK_HEIGHT = 92;
//		public static final double FOUR_STACK_HEIGHT = 111;
//		public static final double THREE_STACK_HEIGHT = 120;
//		public static final double STEP_BLOCK_HEIGHT = 202;
//		public static final double STEP_PICKUP_HEIGHT = 175;
		public static final double PICK_UP_POSITION = 118;
//		public static final double HOME_POSITION = 145;
//
//
//
//

		public static final double MANUAL_SCALE_FACTOR = 1;
		public static final double P = .03;  
		public static final double I = .00015;
		public static final double D = .1;		
	}
	
	public static class ContainerWristConstants{
		public static final double SOLENOID_ACTIVE_TIME = .25;
	}
	
	public static class ContainerClawConstants{
		public static final double CLAW_CYLINDER_FIRE_TIME = .1;
	}	
	
	public static class SolenoidChannels{
		public static final int WRIST_DOWN = 6;		
		public static final int WRIST_UP = 1;		
		public static final int LEFT_CLAW_EXTEND = 2;		
		public static final int LEFT_CLAW_RETRACT = 5;
		public static final int RIGHT_CLAW_EXTEND = 3;		
		public static final int RIGHT_CLAW_RETRACT = 4;
	}
	
	public static class DrivePolarities {
		public static final double FRONT_LEFT_DRIVE_POLARITY = -1.0;
		public static final double FRONT_RIGHT_DRIVE_POLARITY = 1.0;
		public static final double BACK_LEFT_DRIVE_POLARITY = -1.0;
		public static final double BACK_RIGHT_DRIVE_POLARITY = 1.0;
	}
	
}
