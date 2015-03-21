package org.usfirst.frc.team1675.robot.utils;

import org.usfirst.frc.team1675.robot.XBoxControllerMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class TriggerButton extends Button{
	Joystick stick;
	boolean isLeft;
	double deadzone;
	public TriggerButton(Joystick joystick, boolean isLeft, double deadzone){
		this.isLeft = isLeft;
		stick = joystick;
		this.deadzone = deadzone;
	}

	public boolean get() {
		if(isLeft){
			System.out.println(Math.abs(stick.getRawAxis(XBoxControllerMap.LEFT_TRIGGER_AXIS))>deadzone);
			return Math.abs(stick.getRawAxis(XBoxControllerMap.LEFT_TRIGGER_AXIS))>deadzone;
		}else{
			System.out.println(Math.abs(stick.getRawAxis(XBoxControllerMap.RIGHT_TRIGGER_AXIS))>deadzone);
			return Math.abs(stick.getRawAxis(XBoxControllerMap.RIGHT_TRIGGER_AXIS))>deadzone;
		}
	}
	
}



