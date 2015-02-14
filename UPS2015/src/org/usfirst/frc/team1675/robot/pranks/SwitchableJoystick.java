package org.usfirst.frc.team1675.robot.pranks;

import edu.wpi.first.wpilibj.Joystick;

public class SwitchableJoystick extends Joystick{

	Joystick joystick;
	
	public SwitchableJoystick(int port) {
		super(port);
		// TODO Auto-generated constructor stub
		joystick = new Joystick(port);
	}
	
	public Joystick getJoystick(){
		return joystick;
	}
	
	public void switchJoysticks(Joystick joystick){
		this.joystick = joystick;
	}
}
