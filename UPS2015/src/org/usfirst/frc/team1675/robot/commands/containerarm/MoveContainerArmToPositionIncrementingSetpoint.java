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
	double currentSetpoint;
	double ultimateSetpoint;
	double setpointIncrement;
    public MoveContainerArmToPositionIncrementingSetpoint(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.containerArm);
    	ultimateSetpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//ultimateSetpoint = SmartDashboard.getNumber("ContainerArmSetpoint");  //comment this out to make go to value passed in instead of the one on dashboard.  	
    	currentSetpoint = Robot.containerArm.getPotValue();
    	Robot.containerArm.getPIDController().setSetpoint(currentSetpoint);
    	setpointIncrement =(ultimateSetpoint-currentSetpoint)/(50*RAMP_TIME);
    	Robot.containerArm.enable();
    }

    // Called repeatedly when this Command is scheduled to run
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

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {    	
    	Robot.containerArm.stopAndDisable();
    	System.out.println("ended");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
