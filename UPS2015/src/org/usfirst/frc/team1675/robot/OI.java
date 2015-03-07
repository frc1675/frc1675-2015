package org.usfirst.frc.team1675.robot;

import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPosition;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPositionIncrementingSetpoint;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPositionOnDashboard;
import org.usfirst.frc.team1675.robot.commands.containerarm.ResetArmPID;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawClose;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawOpen;
import org.usfirst.frc.team1675.robot.commands.containerwrist.WristDown;
import org.usfirst.frc.team1675.robot.commands.containerwrist.WristUp;
import org.usfirst.frc.team1675.robot.commands.totestacker.DriveBackBeforeDroppingTotes;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoDownOneTote;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoUpOneTote;
import org.usfirst.frc.team1675.robot.commands.totestacker.ResetTotevatorPID;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToggleTotevatorPID;
import org.usfirst.frc.team1675.robot.utils.DPadButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	// Constants specific to this class
	static final int DRIVER_CONTROLLER_PORT = 0;
	static final int OPERATOR_CONTROLLER_PORT = 1;
	
	Joystick driverController;
	Joystick operatorController;
	
	JoystickButton driverXButton;
	JoystickButton driverYButton;	
	JoystickButton driverBButton;
	JoystickButton driverAButton;
	
	JoystickButton operatorXButton;
	JoystickButton operatorYButton;
	JoystickButton operatorBButton;
	JoystickButton operatorAButton;
	
	DPadButton operatorDPadUp;
	DPadButton operatorDPadDown;
	DPadButton operatorDPadLeft;
	DPadButton operatorDPadRight;
	
	JoystickButton operatorRightBumperButton;
	JoystickButton operatorLeftBumperButton;
	
	
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public OI(){
		driverController = new Joystick(DRIVER_CONTROLLER_PORT);
		operatorController = new Joystick(OPERATOR_CONTROLLER_PORT);
		driverYButton = new JoystickButton(driverController, XBoxControllerMap.Y_BUTTON);
		driverAButton = new JoystickButton(driverController, XBoxControllerMap.A_BUTTON);
		
		operatorXButton = new JoystickButton(operatorController, XBoxControllerMap.X_BUTTON);
		operatorYButton = new JoystickButton(operatorController, XBoxControllerMap.Y_BUTTON);
		operatorAButton = new JoystickButton(operatorController, XBoxControllerMap.A_BUTTON);
		operatorBButton = new JoystickButton(operatorController, XBoxControllerMap.B_BUTTON);
		operatorRightBumperButton = new JoystickButton(operatorController,XBoxControllerMap.RIGHT_BUMPER_BUTTON);
		operatorLeftBumperButton = new JoystickButton(operatorController,XBoxControllerMap.LEFT_BUMPER_BUTTON);
		operatorDPadUp = new DPadButton(operatorController, DPadButton.Direction.UP);
		operatorDPadDown = new DPadButton(operatorController, DPadButton.Direction.DOWN);
		operatorDPadLeft = new DPadButton(operatorController, DPadButton.Direction.LEFT);
		operatorDPadRight = new DPadButton(operatorController, DPadButton.Direction.RIGHT);
		
		driverAButton.whenPressed(new GoDownOneTote());
		driverYButton.whenPressed(new GoUpOneTote());
		
		operatorXButton.whenPressed(new ContainerClawOpen());
		operatorXButton.whenReleased(new ContainerClawClose());
		operatorBButton.whenPressed(new MoveContainerArmToPositionOnDashboard());//193
		operatorYButton.whenPressed(new WristUp());
		operatorAButton.whenPressed(new WristDown());
		//operatorYButton.whenPressed(new GoUpOneTote());
		//operatorAButton.whenPressed(new GoDownOneTote());
		//operatorBButton.whenPressed(new DriveBackBeforeDroppingTotes());
		//operatorXButton.whenPressed(new ResetToteStacker());
		operatorRightBumperButton.whenPressed(new ResetTotevatorPID());
		operatorLeftBumperButton.whenPressed(new ToggleTotevatorPID());
		operatorDPadUp.whenPressed(new ResetArmPID());
		operatorDPadDown.whenPressed(new DriveBackBeforeDroppingTotes());
		operatorDPadLeft.whenPressed(new MoveContainerArmToPosition(180.0));
		operatorDPadRight.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(150.0));

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
		leftTriggerValue = checkForDeadzone(leftTriggerValue);
		return (-leftTriggerValue * scaleValue);
	}

	public double getDriverRightTrigger(double scaleValue){
		double rightTriggerValue = driverController.getRawAxis(XBoxControllerMap.RIGHT_TRIGGER_AXIS);
		rightTriggerValue = checkForDeadzone(rightTriggerValue);
		return (rightTriggerValue * scaleValue);
	}
	
	public double getOperatorLeftYAxis(double scaleValue){
		double leftYControllerValue = operatorController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		leftYControllerValue = checkForDeadzone(leftYControllerValue);
		return (leftYControllerValue * scaleValue);
	}
	
	public double getOperatorRightYAxis(double scaleValue){
		double rightYControllerValue = operatorController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		return checkForDeadzone(rightYControllerValue * scaleValue);
	}
	
	public double checkForDeadzone(double input) {
		if (Math.abs(input) <= RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE) {
			return 0.0;
		} else {
			return advancedCheckForDeadzone(input, input);
		}
	}
	
	public double advancedCheckForDeadzone(double magnitude, double inputSign){
		double scaledVector;
		int sign = (int) (inputSign/Math.abs(inputSign));
		SmartDashboard.putNumber("sign: ", sign);
		scaledVector = sign*((Math.abs(magnitude)-RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE)
				/(1-RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE));
		SmartDashboard.putNumber("scaledVector: ", scaledVector);
		return scaledVector;
	}

}
