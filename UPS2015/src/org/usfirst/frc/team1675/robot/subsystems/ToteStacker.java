package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerManual;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class ToteStacker extends PIDSubsystem {
	public static final int TICKS_PER_TOTEHOOK = 100;
	SpeedController toteMotor;
   
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ToteStacker(double p, double i, double d){
		super(p, i, d);
		toteMotor = new VictorSP(RobotMap.PWMChannels.TOTE_ELEVATOR);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ToteStackerManual());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * 
     * @param point tells the exact point the tote stacker will move to
     */
    public void goToPoint(int point){
    }
    /**
     * 
     * @param distance tells how far the tote stacker moves from it's current point
     */
    public void moveRelative(int distance){
    	
    }
    public void setManualMovement(double MotorValue){
    	toteMotor.set(MotorValue);
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
}

