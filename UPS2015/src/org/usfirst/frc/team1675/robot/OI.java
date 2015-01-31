package org.usfirst.frc.team1675.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team1675.robot.commands.ExampleCommand;
import org.usfirst.frc.team1675.robot.commands.GyroPIDTurnToAngleCommand;
import org.usfirst.frc.team1675.robot.commands.GyroPrintout;
import org.usfirst.frc.team1675.robot.commands.ResetGyro;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	Joystick driverController = new Joystick(0);
	JoystickButton xButton = new JoystickButton(driverController, 1); //change these back before we commit
	JoystickButton yButton = new JoystickButton(driverController, 2);
	JoystickButton aButton = new JoystickButton(driverController, 3);
	JoystickButton bButton = new JoystickButton(driverController, 4);
	
	
	//left x 0
	//left y 1
	//right x 4
	//right y 5
	
	public OI(){
		
		xButton.whenPressed(new GyroPIDTurnToAngleCommand(RobotMap.P, RobotMap.I, RobotMap.D, 90));
		yButton.whenPressed(new GyroPIDTurnToAngleCommand(RobotMap.P, RobotMap.I, RobotMap.D, 180));
//		aButton.whenPressed(new GyroPIDTurnToAngleCommand(RobotMap.P, RobotMap.I, RobotMap.D, 270));
//		bButton.whenPressed(new GyroPIDTurnToAngleCommand(RobotMap.P, RobotMap.I, RobotMap.D, 360));
		aButton.whenPressed(new ResetGyro());
		bButton.whenPressed(new GyroPrintout());
	}
	
	public double getLeftXAxis() {
		return driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
	}
	
	public double getLeftYAxis() {
		return driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
	}
	
	public double getRightXAxis() {
		return driverController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
	}
	
	public double getRightYAxis() {
		return driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
	}
}

