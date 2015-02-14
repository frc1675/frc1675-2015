package org.usfirst.frc.team1675.robot;

import org.usfirst.frc.team1675.robot.commands.ResetDriveEncoderPIDsIndividually;
import org.usfirst.frc.team1675.robot.commands.ResetDriveEncoderPIDsTogether;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick driverController;
	JoystickButton driverYButton;
	JoystickButton driverAButton;
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
		driverController = new Joystick(0);
		driverYButton = new JoystickButton(driverController, XBoxControllerMap.Y_BUTTON);
		driverAButton = new JoystickButton(driverController, XBoxControllerMap.A_BUTTON);
		
		driverAButton.whenPressed(new ResetDriveEncoderPIDsIndividually());
		driverYButton.whenPressed(new ResetDriveEncoderPIDsTogether());
	}	
	
	public double getDriverLeftXAxis() {
		double leftXControllerValue = driverController
				.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
		return checkForDeadzone(leftXControllerValue);

	}

	public double getDriverLeftYAxis() {
		double leftYControllerValue = driverController
				.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		return checkForDeadzone(leftYControllerValue);
	}

	public double getDriverRightXAxis() {
		double rightXControllerValue = driverController
				.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
		return checkForDeadzone(rightXControllerValue);
	}

	public double getDriverRightYAxis() {
		double rightYControllerValue = driverController
				.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
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
	
	public double checkForDeadzone(double input) {
		if (Math.abs(input) <= RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE) {
			return 0;
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
