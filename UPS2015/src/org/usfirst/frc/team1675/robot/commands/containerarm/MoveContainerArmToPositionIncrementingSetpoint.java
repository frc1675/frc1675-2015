package org.usfirst.frc.team1675.robot.commands.containerarm;

import org.usfirst.frc.team1675.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveContainerArmToPositionIncrementingSetpoint extends Command {
	private static final double RAMP_TIME = .5;
	private double currentSetpoint;
	private double ultimateSetpoint;
	private double setpointIncrement;
    public MoveContainerArmToPositionIncrementingSetpoint(double setpoint) {
    	requires(Robot.containerArm);
    	ultimateSetpoint = setpoint;
    }

    protected void initialize() {
    	ultimateSetpoint = SmartDashboard.getNumber("ContainerArmSetpoint");  //comment this out to make go to value passed in instead of the one on dashboard.  	
    	currentSetpoint = Robot.containerArm.getPotValue();
    	Robot.containerArm.getPIDController().setSetpoint(currentSetpoint);
    	setpointIncrement =(ultimateSetpoint-currentSetpoint)/(50*RAMP_TIME);
    	Robot.containerArm.enable();
    }

    protected void execute() {
    	currentSetpoint = Robot.containerArm.getPIDController().getSetpoint();
    	SmartDashboard.putNumber("containerPot", Robot.containerArm.getPotValue());
    	SmartDashboard.putNumber("Current Setpoint", currentSetpoint);
    	if (Math.abs(currentSetpoint-ultimateSetpoint )< .0001){//rounding error
    	}else if(Math.abs(currentSetpoint-ultimateSetpoint)> Math.abs(setpointIncrement)){
    		Robot.containerArm.setSetpoint(currentSetpoint += setpointIncrement);
    	}else{  //currentSetpoint != ultimateSetpoint
    		currentSetpoint = ultimateSetpoint;
    		Robot.containerArm.setSetpoint(currentSetpoint);    		
    	}
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {    	
    	Robot.containerArm.stopAndDisable();
    	System.out.println("ended");
    }

    protected void interrupted() {
    	end();
    }
}
