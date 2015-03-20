package org.usfirst.frc.team1675.robot.utils;

import org.usfirst.frc.team1675.robot.XBoxControllerMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class TriggerButton extends Button{
	Joystick stick;
	boolean isLeft;
	private static final double DEADZONE = .6;
	public TriggerButton(Joystick joystick, boolean isLeft){
		this.isLeft = isLeft;
		stick = joystick;
	}

	public boolean get() {
		if(isLeft){
			System.out.println(Math.abs(stick.getRawAxis(XBoxControllerMap.LEFT_TRIGGER_AXIS))>DEADZONE);
			return Math.abs(stick.getRawAxis(XBoxControllerMap.LEFT_TRIGGER_AXIS))>DEADZONE;
		}else{
			System.out.println(Math.abs(stick.getRawAxis(XBoxControllerMap.RIGHT_TRIGGER_AXIS))>DEADZONE);
			return Math.abs(stick.getRawAxis(XBoxControllerMap.RIGHT_TRIGGER_AXIS))>DEADZONE;
		}
	}
	
}



