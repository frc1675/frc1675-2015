package org.usfirst.frc.team1675.robot;


import org.usfirst.frc.team1675.robot.RobotMap.ControllerPorts;
import org.usfirst.frc.team1675.robot.commands.PickUpCanFromStep;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPosition;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPositionIncrementingSetpoint;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPositionOnDashboard;
import org.usfirst.frc.team1675.robot.commands.containerarm.RawMoveContainerArmButtonBox;
import org.usfirst.frc.team1675.robot.commands.containerarm.RawMoveContainerArmXbox;
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
import org.usfirst.frc.team1675.robot.commands.totestacker.DriveBackBeforeDroppingTotes;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoDownOneTote;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoUpOneTote;
import org.usfirst.frc.team1675.robot.commands.totestacker.ResetToteStacker;
import org.usfirst.frc.team1675.robot.commands.totestacker.Score;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToggleTotevatorPID;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerBumpDown;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerBumpUp;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerManualButtonBox;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerManualXbox;
import org.usfirst.frc.team1675.robot.utils.DPadButton;
import org.usfirst.frc.team1675.robot.utils.TriggerButton;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {	
	private Joystick driverController = new Joystick(ControllerPorts.DRIVER);		
	private JoystickButton driverXButton = new JoystickButton(driverController, XBoxControllerMap.X_BUTTON);
	private JoystickButton driverYButton = new JoystickButton(driverController, XBoxControllerMap.Y_BUTTON);	
	private JoystickButton driverBButton = new JoystickButton(driverController, XBoxControllerMap.B_BUTTON);
	private JoystickButton driverAButton = new JoystickButton(driverController, XBoxControllerMap.A_BUTTON);	
	private JoystickButton driverRightBumperButton = new JoystickButton(driverController, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
	private JoystickButton driverLeftBumperButton = new JoystickButton(driverController, XBoxControllerMap.LEFT_BUMPER_BUTTON);
		
	private Joystick operatorController = new Joystick(ControllerPorts.OPERATOR);
	private JoystickButton operatorXButton = new JoystickButton(operatorController, XBoxControllerMap.X_BUTTON);
	private JoystickButton operatorYButton = new JoystickButton(operatorController, XBoxControllerMap.Y_BUTTON);
	private JoystickButton operatorBButton = new JoystickButton(operatorController, XBoxControllerMap.B_BUTTON);
	private JoystickButton operatorAButton = new JoystickButton(operatorController, XBoxControllerMap.A_BUTTON);	
	private DPadButton operatorDPadUp = new DPadButton(operatorController, DPadButton.Direction.UP);
	private DPadButton operatorDPadDown = new DPadButton(operatorController, DPadButton.Direction.DOWN);
	private DPadButton operatorDPadLeft  = new DPadButton(operatorController, DPadButton.Direction.LEFT);
	private DPadButton operatorDPadRight = new DPadButton(operatorController, DPadButton.Direction.RIGHT);	
	private JoystickButton operatorRightBumperButton = new JoystickButton(operatorController,XBoxControllerMap.RIGHT_BUMPER_BUTTON);
	private JoystickButton operatorLeftBumperButton = new JoystickButton(operatorController,XBoxControllerMap.LEFT_BUMPER_BUTTON);
		
	private Joystick buttonBox = new Joystick(ControllerPorts.BUTTON_BOX);	
	private JoystickButton leftSideButtonFive = new JoystickButton(buttonBox, ButtonBoxMap.tenButton);
	private JoystickButton leftSideButtonFour = new JoystickButton(buttonBox, ButtonBoxMap.elevenButton);
	private JoystickButton leftSideButtonThree = new JoystickButton(buttonBox, ButtonBoxMap.thirteenButton);
	private JoystickButton leftSideButtonTwo = new JoystickButton(buttonBox, ButtonBoxMap.fourteenButton);
	private JoystickButton leftSideButtonOne = new JoystickButton(buttonBox, ButtonBoxMap.fifteenButton);	
	private JoystickButton bottomLeftflipSwitchOne = new JoystickButton(buttonBox, ButtonBoxMap.nineteeenButton);	
	private JoystickButton bottomButtonLeft = new JoystickButton(buttonBox, ButtonBoxMap.sixteenButton);
	private JoystickButton bottomButtonMiddle = new JoystickButton(buttonBox, ButtonBoxMap.seventeenButton);
	private JoystickButton bottomButtonRight = new JoystickButton(buttonBox, ButtonBoxMap.eighteenButton);	
	private JoystickButton upperLeftSquareButton = new JoystickButton(buttonBox, ButtonBoxMap.threeButton);
	private JoystickButton bottomLeftSquareButton = new JoystickButton(buttonBox, ButtonBoxMap.fiveButton);	
	private JoystickButton bottomRightSquareButton = new JoystickButton(buttonBox, ButtonBoxMap.fourButton);
	private JoystickButton upperRightSquareButton = new JoystickButton(buttonBox, ButtonBoxMap.twoButton);
	private JoystickButton upperRightFlipSwitch = new JoystickButton(buttonBox, ButtonBoxMap.sixButton);
	
	public OI(){		
		driverXButton.whenPressed(new ToteStackerBumpDown());
		driverYButton.whenPressed(new GoUpOneTote());
		driverBButton.whenPressed(new ToteStackerBumpUp());
		driverAButton.whenPressed(new GoDownOneTote());
		driverRightBumperButton.whenPressed(new Score());

		operatorXButton.whenPressed(new ContainerClawOpen());
		operatorXButton.whenReleased(new ContainerClawClose());
		operatorBButton.whenPressed(new MoveContainerArmToPositionOnDashboard());//193
		operatorYButton.whenPressed(new WristUp());
		operatorAButton.whenPressed(new WristDown());
		//operatorYButton.whenPressed(new GoUpOneTote());
		//operatorAButton.whenPressed(new GoDownOneTote());
		//operatorBButton.whenPressed(new DriveBackBeforeDroppingTotes());
		//operatorXButton.whenPressed(new ResetToteStacker());
		//operatorRightBumperButton.whenPressed(new ResetTotevatorPID());
		operatorRightBumperButton.whenPressed(new RawMoveContainerArmXbox());
		operatorLeftBumperButton.whenPressed(new ToggleTotevatorPID());
		operatorDPadUp.whenPressed(new ThatStupidFreakinAutoCanPickupRoutine(1.0));
		operatorDPadDown.whenPressed(new DriveBackBeforeDroppingTotes());
		operatorDPadLeft.whenPressed(new MoveContainerArmToPosition(75.0));
		operatorDPadRight.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.ContainerArmConstants.PICK_UP_POSITION));
	
		leftSideButtonThree.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.getStepCanPosition()));
		leftSideButtonTwo.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.getPickupPosition()));
		leftSideButtonOne.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.getHomePosition()));		
		bottomLeftflipSwitchOne.whenPressed(new ContainerClawOpen());
		bottomLeftflipSwitchOne.whenReleased(new ContainerClawClose());		
		bottomButtonLeft.whenPressed(new LeftContainerClawOpen());
		bottomButtonLeft.whenReleased(new LeftContainerClawClose());
		bottomButtonMiddle.whenPressed(new ContainerClawOpen());
		bottomButtonMiddle.whenReleased(new ContainerClawClose());
		bottomButtonRight.whenPressed(new RightContainerClawOpen());
		bottomButtonRight.whenReleased(new RightContainerClawClose());		
		upperLeftSquareButton.whenPressed(new PickUpCanFromStep());
		bottomLeftSquareButton.whenPressed(new ThatStupidFreakinAutoCanPickupRoutine(1.0));		
		bottomRightSquareButton.whenPressed(new ResetToteStacker());
		upperRightSquareButton.whenPressed(new ToteStackerManualButtonBox());
		upperRightFlipSwitch.whenPressed(new RawMoveContainerArmButtonBox());	
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
	
	public double getButtonBoxLeftYAxis(){
		double leftYAxis = buttonBox.getRawAxis(ButtonBoxMap.LEFT_Y_AXIS);
		return checkForDeadzone(leftYAxis);		
	}
	
	public double getButtonBoxRightYAxis(){
		double rightYAxis = buttonBox.getRawAxis(ButtonBoxMap.RIGHT_Y_AXIS);
		return checkForDeadzone(rightYAxis);
	}
	
	public boolean isOperatorXboxPluggedIn(){ 
		return DriverStation.getInstance().getStickButtonCount(ControllerPorts.OPERATOR)>0;
	}
	
	public boolean isOperatorButtonBoxPluggedIn(){
		return DriverStation.getInstance().getStickButtonCount(ControllerPorts.BUTTON_BOX)>0;
	}

}
