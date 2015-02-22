package org.usfirst.frc.team1675.robot.commands.totestacker;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ResetTotevatorPID extends Command {

    public ResetTotevatorPID() {

    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.toteStacker.getPIDController().setPID(
    			SmartDashboard.getNumber("TotevatorP", RobotMap.ToteStackerConstants.P), 
				SmartDashboard.getNumber("TotevatorI", RobotMap.ToteStackerConstants.I), 
				SmartDashboard.getNumber("TotevatorD", RobotMap.ToteStackerConstants.D));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
