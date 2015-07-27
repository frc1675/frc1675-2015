package org.usfirst.frc.team1675.robot.subsystems;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.PolarMecanum;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerManualButtonBox;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerManualXbox;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToteStacker extends PIDSubsystem {
	public static int TICKS_PER_TOTEHOOK = RobotMap.getTicksPerTote();
	public static final int TICKS_TO_DROP = 75; //maybe?
	public static final int TICKS_PER_BUMP = 14;
	
	SpeedController toteMotor;
	Encoder totevatorEncoder;
	int totalToteLevel;
	int totalBumps;
	DigitalInput hallEffect;
	boolean lastHallEffectValue = false;
	boolean lastLastHallEffectValue = false;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ToteStacker(double p, double i, double d){
		super(p, i, d);
		toteMotor = new VictorSP(RobotMap.PWMChannels.TOTE_ELEVATOR);
		totevatorEncoder = new Encoder(RobotMap.DIOChannels.TOTEVATOR_ENCODER_A, RobotMap.DIOChannels.TOTEVATOR_ENCODER_B);
		totevatorEncoder.setDistancePerPulse(1.0);
    	hallEffect = new DigitalInput(RobotMap.DIOChannels.HALL_EFFECT);
		this.enable();
		this.setSetpoint(0);
		SmartDashboard.putBoolean("TotePIDEnabled", true);
		totalToteLevel = 0;
		totalBumps = 0;
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ToteStackerManualXbox());
    }

    public void resetEncoderUponRisingEdge(){
    	boolean currentHallEffectValue = hallEffect.get();
    	if (!lastLastHallEffectValue && lastHallEffectValue && currentHallEffectValue){
    		totevatorEncoder.reset();
    	}
    	lastLastHallEffectValue = lastHallEffectValue;
    	lastHallEffectValue = currentHallEffectValue;
    }
    
    /**
     * 
     * @param point tells the exact point the tote stacker will move to
     */
    public void goToPoint(int point){
    	this.setSetpoint(point);
    	System.out.println("goToPoint new setpoint: " + this.getSetpoint());
    }
    
    /**
     * 
     * @param distance tells how far the tote stacker moves from it's current point
     */
    public void moveRelative(double distance){
    	this.setSetpoint(this.getSetpoint() + distance);
    	System.out.println("moveRelative new setpoint: " + this.getSetpoint());
    }
    
    public void setManualMovement(double MotorValue){
    	if (!this.getPIDController().isEnable()){
    		toteMotor.set(MotorValue);
    	}
    	SmartDashboard.putNumber("Encoder", totevatorEncoder.getDistance());
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		SmartDashboard.putNumber("totevatorEncoder", totevatorEncoder.getDistance());
		return totevatorEncoder.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		toteMotor.set(output);
		//resetEncoderUponRisingEdge();
	}

	public void resetEncoder() {
		this.totevatorEncoder.reset();
	}
	
	public void togglePID() {
		if(this.getPIDController().isEnable()){
			this.getPIDController().disable();
			SmartDashboard.putBoolean("TotePIDEnabled", false);
		} else {			
			this.getPIDController().enable();
			SmartDashboard.putBoolean("TotePIDEnabled", true);
		}
	}
	
	public boolean canIToteUpQuestionMark(){
		return this.totalToteLevel < 3;
	}
	
	public void countToteUp(){
		totalToteLevel++;
	}
	
	public void countToteDown(){
		totalToteLevel--;
	}

	public void resetToteLevel() {
		totalToteLevel = 0;
	}
	
	public int countAndReturnBumpUp(){
		totalBumps++;
		return totalBumps;
	}	
	public int countAndReturnBumpDown(){
		totalBumps--;
		return totalBumps;
	}
	public int resetAndReturnBumpLevel() {
		totalBumps = 0;
		return totalBumps;
	}
}

