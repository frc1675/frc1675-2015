package org.usfirst.frc.team1675.robot;


import org.usfirst.frc.team1675.robot.RobotMap.ControllerPorts;
import org.usfirst.frc.team1675.robot.commands.PickUpCanFromStep;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPositionIncrementingSetpoint;
import org.usfirst.frc.team1675.robot.commands.containerarm.RawMoveContainerArm;
import org.usfirst.frc.team1675.robot.commands.containerarm.ResetArmPID;
import org.usfirst.frc.team1675.robot.commands.containerarm.ThatStupidFreakinAutoCanPickupRoutine;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawClose;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawOpen;
import org.usfirst.frc.team1675.robot.commands.containerclaw.LeftContainerClawClose;
import org.usfirst.frc.team1675.robot.commands.containerclaw.LeftContainerClawOpen;
import org.usfirst.frc.team1675.robot.commands.containerclaw.RightContainerClawClose;
import org.usfirst.frc.team1675.robot.commands.containerclaw.RightContainerClawOpen;
import org.usfirst.frc.team1675.robot.commands.containerwrist.WristDown;
import org.usfirst.frc.team1675.robot.commands.containerwrist.WristUp;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoDownOneTote;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoUpOneTote;
import org.usfirst.frc.team1675.robot.commands.totestacker.ResetToteStacker;
import org.usfirst.frc.team1675.robot.commands.totestacker.Score;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToggleTotevatorPID;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerBumpDown;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerBumpUp;
import org.usfirst.frc.team1675.robot.utils.DPadButton;
import org.usfirst.frc.team1675.robot.utils.TriggerButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick driverController;
	private Joystick operatorController;
	
	private JoystickButton driverXButton;
	private JoystickButton driverYButton;	
	private JoystickButton driverBButton;
	private JoystickButton driverAButton;
	
	private JoystickButton driverRightBumperButton;
	private JoystickButton driverLeftBumperButton;
	
	
	private JoystickButton armButtonFive = new JoystickButton(operatorController, ButtonBoxMap.tenButton);
	private JoystickButton armButtonFour = new JoystickButton(operatorController, ButtonBoxMap.elevenButton);
	private JoystickButton armButtonThree = new JoystickButton(operatorController, ButtonBoxMap.thirteenButton);
	private JoystickButton armButtonTwo = new JoystickButton(operatorController, ButtonBoxMap.fourteenButton);
	private JoystickButton armButtonOne = new JoystickButton(operatorController, ButtonBoxMap.fifteenButton);
	
	private JoystickButton flipSwitchOne = new JoystickButton(operatorController, ButtonBoxMap.nineteeenButton);
	
	private JoystickButton clawButtonLeft = new JoystickButton(operatorController, ButtonBoxMap.sixteenButton);
	private JoystickButton clawButtonMiddle = new JoystickButton(operatorController, ButtonBoxMap.seventeenButton);
	private JoystickButton clawButtonRight = new JoystickButton(operatorController, ButtonBoxMap.eighteenButton);
	
	private JoystickButton armButtonSeven = new JoystickButton(operatorController, ButtonBoxMap.threeButton);
	private JoystickButton armButtonSix = new JoystickButton(operatorController, ButtonBoxMap.fiveButton);
	
	private JoystickButton totevatorOne = new JoystickButton(operatorController, ButtonBoxMap.fourButton);
	
	
//	private JoystickButton operatorXButton;
//	private JoystickButton operatorYButton;
//	private JoystickButton operatorBButton;
//	private JoystickButton operatorAButton;
//	
//	private DPadButton operatorDPadUp;
//	private DPadButton operatorDPadDown;
//	private DPadButton operatorDPadLeft;
//	private DPadButton operatorDPadRight;
//	
//	private JoystickButton operatorRightBumperButton;
//	private JoystickButton operatorLeftBumperButton;
//	private TriggerButton operatorRightTriggerButton;
//	private TriggerButton operatorLeftTriggerButton;
	
	public OI(){
		driverController = new Joystick(ControllerPorts.DRIVER);
		operatorController = new Joystick(ControllerPorts.OPERATOR);
		
		driverYButton = new JoystickButton(driverController, XBoxControllerMap.Y_BUTTON);
		driverAButton = new JoystickButton(driverController, XBoxControllerMap.A_BUTTON);
		driverBButton = new JoystickButton(driverController, XBoxControllerMap.B_BUTTON);
		driverXButton = new JoystickButton(driverController, XBoxControllerMap.X_BUTTON);
		
		driverLeftBumperButton = new JoystickButton(driverController, XBoxControllerMap.LEFT_BUMPER_BUTTON);
		driverRightBumperButton = new JoystickButton(driverController, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
		
		
		
		
//		operatorXButton = new JoystickButton(operatorController, XBoxControllerMap.X_BUTTON);
//		operatorYButton = new JoystickButton(operatorController, XBoxControllerMap.Y_BUTTON);
//		operatorAButton = new JoystickButton(operatorController, XBoxControllerMap.A_BUTTON);
//		operatorBButton = new JoystickButton(operatorController, XBoxControllerMap.B_BUTTON);
//		
//		operatorRightBumperButton = new JoystickButton(operatorController,XBoxControllerMap.RIGHT_BUMPER_BUTTON);
//		operatorLeftBumperButton = new JoystickButton(operatorController,XBoxControllerMap.LEFT_BUMPER_BUTTON);
//		
//		operatorRightTriggerButton = new TriggerButton(operatorController,false, .4);
//		operatorLeftTriggerButton = new TriggerButton(operatorController,true, .7);
//		
//		operatorDPadUp = new DPadButton(operatorController, DPadButton.Direction.UP);
//		operatorDPadDown = new DPadButton(operatorController, DPadButton.Direction.DOWN);
//		operatorDPadLeft = new DPadButton(operatorController, DPadButton.Direction.LEFT);
//		operatorDPadRight = new DPadButton(operatorController, DPadButton.Direction.RIGHT);
		
		driverAButton.whenPressed(new GoDownOneTote());
		driverYButton.whenPressed(new GoUpOneTote());
		driverBButton.whenPressed(new ToteStackerBumpUp());
		driverXButton.whenPressed(new ToteStackerBumpDown());
		driverRightBumperButton.whenPressed(new Score());
	
			
		
		armButtonThree.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.getStepCanPosition()));
		armButtonTwo.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.getPickupPosition()));
		armButtonOne.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.getHomePosition()));
		
		flipSwitchOne.whenPressed(new ContainerClawOpen());
		flipSwitchOne.whenReleased(new ContainerClawClose());
		
		clawButtonLeft.whenPressed(new LeftContainerClawOpen());
		clawButtonLeft.whenReleased(new LeftContainerClawClose());
		clawButtonMiddle.whenPressed(new ContainerClawOpen());
		clawButtonMiddle.whenReleased(new ContainerClawClose());
		clawButtonRight.whenPressed(new RightContainerClawOpen());
		clawButtonRight.whenReleased(new RightContainerClawClose());
		
		armButtonSeven.whenPressed(new PickUpCanFromStep());
		armButtonSix.whenPressed(new ThatStupidFreakinAutoCanPickupRoutine(1.0));
		
		totevatorOne.whenPressed(new ResetToteStacker());
		
				
		
		
//		operatorBButton.whenPressed(new ResetArmPID());

//		operatorRightBumperButton.whenPressed(new RawMoveContainerArm());
//				
//		operatorLeftTriggerButton.whenPressed(new ToggleTotevatorPID());
//		operatorDPadDown.whenPressed(new ResetToteStacker());
		
	}	
	
	public double getDriverLeftXAxis() {
		double leftXControllerValue = driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
		return checkForDeadzone(leftXControllerValue);
	}

	public double getDriverLeftYAxis() {
		double leftYControllerValue = driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		return checkForDeadzone(leftYControllerValue);
	}

	public double getDriverRightXAxis() {
		double rightXControllerValue = driverController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
		return checkForDeadzone(rightXControllerValue);
	}

	public double getDriverRightYAxis() {
		double rightYControllerValue = driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		return checkForDeadzone(rightYControllerValue);
	}
	
	public double getDriverLeftTrigger(double scaleValue){
		double leftTriggerValue = driverController.getRawAxis(XBoxControllerMap.LEFT_TRIGGER_AXIS);
		return checkForDeadzone(-leftTriggerValue);
	}

	public double getDriverRightTrigger(){
		double rightTriggerValue = driverController.getRawAxis(XBoxControllerMap.RIGHT_TRIGGER_AXIS);
		return checkForDeadzone(rightTriggerValue);
	}
	
	public double getOperatorLeftYAxis(){
		double leftYControllerValue = operatorController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		return checkForDeadzone(leftYControllerValue);
	}
	
	public double getOperatorRightYAxis(){
		double rightYControllerValue = operatorController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		return checkForDeadzone(rightYControllerValue);
	}
	
	public double checkForDeadzone(double input) {
		if (Math.abs(input) <= RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE) {
			return 0.0;
		} else {
			return scaleToDeadzone(input);
		}
	}
	
	/**
	 * Calculates scalar deadzone. Start from 0 at deadzone border instead of deadzone value
	 * @param magnitude magnitude of current stick position
	 * @return scaled value
	 */
	public double scaleToDeadzone(double magnitude){
		double scaledVector;
		int sign = (int) (magnitude/Math.abs(magnitude));
		scaledVector = sign*((Math.abs(magnitude)-RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE)
				/(1-RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE));
		return scaledVector;
	}

}
