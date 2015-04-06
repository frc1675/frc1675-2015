package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPosition;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoUpOneTote;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TwoGreyToteAutoWithoutDrivingBack extends CommandGroup {

    public  TwoGreyToteAutoWithoutDrivingBack() {
    	
    	addParallel(new MoveContainerArmToPosition(RobotMap.getHomePosition()));
    	addSequential(new PolarMecanumForTime(RobotMap.TwoGreyToteAutoConstants.PICKUP_DRIVE_POWER, Math.PI, 0, .32));
    	addSequential(new Wait(.2));
    	addParallel(new GoUpOneTote());
    	addSequential(new Wait(RobotMap.TwoGreyToteAutoConstants.WAIT_AFTER_PICKUP));
    	addSequential(new PolarMecanumForTime(RobotMap.TwoGreyToteAutoConstants.PICKUP_DRIVE_POWER, Math.PI, 0, .65));
    	addSequential(new Wait(1));
    	addParallel(new GoUpOneTote());
    	addSequential(new Wait(RobotMap.TwoGreyToteAutoConstants.WAIT_AFTER_PICKUP));
    }
}
