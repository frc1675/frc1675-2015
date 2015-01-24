package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.Robot;
import org.usfirst.frc.team1675.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ContainerClawClose extends Command
{
    Timer timer;

    public ContainerClawClose() {
        
        requires(Robot.containerclaw);
        timer = new Timer();

    }
    @Override
    protected void initialize()
    { 
        timer.start();
    }

    @Override
    protected void execute()
    {
        Robot.containerclaw.closeBoth();
    }

    @Override
    protected boolean isFinished()
    {
        if (timer.get() > RobotMap.CLAW_CYLINDER_FIRE_TIME)
           
        return true;
        else {
            return false; }
    }

    @Override
    protected void end(){
    	
    	Robot.containerclaw.closeBoth();
    }

    @Override
    protected void interrupted()
    {
    }
    
}
