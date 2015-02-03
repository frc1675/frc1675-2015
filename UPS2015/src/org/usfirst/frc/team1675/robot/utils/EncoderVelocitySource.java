package org.usfirst.frc.team1675.robot.utils;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.RobotMap.DriveEncoders;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
/* 
 * This class is used in PIDSpeedControllerForVelocity.  It makes it so the pidGet gets rate
 * which is more analogous to speed than the unknown thing it gets otherwise.  
*/
public class EncoderVelocitySource implements PIDSource{
	Encoder encoder;
	EncoderVelocitySource(Encoder encoder, int ticksPerRevolution){
		this.encoder = encoder;	
		this.encoder.setSamplesToAverage(4);
		this.encoder.setDistancePerPulse(((RobotMap.DriveEncoders.DRIVE_WHEEL_DIAMETER * Math.PI)/12)/ (ticksPerRevolution));
	}
	public double pidGet() {
		return encoder.getRate();
	}
	public double getRate(){
		return encoder.getRate();
	}
}
