package org.usfirst.frc.team1675.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
/* 
 * This class is used in PIDSpeedControllerForVelocity.  It makes it so the pidGet gets rate
 * which is more analogous to speed than the unknown thing it gets otherwise.  
*/
public class EncoderVelocitySource implements PIDSource{
	Encoder encoder;
	EncoderVelocitySource(Encoder encoder){
		this.encoder = encoder;		
	}
	public double pidGet() {
		return encoder.getRate();
	}
}
