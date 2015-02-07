package org.usfirst.frc.team1675.robot.utils;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VictorSPSP extends VictorSP{
	
	private String name;
	
	
    public VictorSPSP(int channel, String name) {
		super(channel);
		this.name = name;
	}

	public void pidWrite(double output) {
		SmartDashboard.putNumber("VictorSPSP: "+name, output);		
        set(output);
    }

}
