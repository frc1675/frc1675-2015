package org.usfirst.frc.team1675.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1675.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
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

	Joystick driverController = new Joystick(0);
	Solenoid solenoidStatus = new Solenoid(0);

	// left x 0
	// left y 1
	// right x 4
	// right y 5

	public double getLeftXAxis() {
		double leftXControllerValue = driverController
				.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);

		return checkForDeadzone(leftXControllerValue);
	}

	public double getLeftYAxis() {
		double leftYControllerValue = driverController
				.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);

		return checkForDeadzone(leftYControllerValue);
	}

	public double getRightXAxis() {
		double rightXControllerValue = driverController
				.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);

		return checkForDeadzone(rightXControllerValue);
	}

	public double getRightYAxis() {
		double rightYControllerValue = driverController
				.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);

		return checkForDeadzone(rightYControllerValue);
	}


	public double checkForDeadzone(double input) {
		if (Math.abs(input) <= RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE) {
			return 0;
		} else {
			return input;
		}
	}

}
