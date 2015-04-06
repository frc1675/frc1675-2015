package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPosition;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoUpOneTote;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickUpTwoGreyTotes extends CommandGroup {

    public  PickUpTwoGreyTotes() {
    	
    	addParallel(new MoveContainerArmToPosition(RobotMap.getHomePosition()));
    	addSequential(new PolarMecanumForTime(RobotMap.TwoGreyToteAutoConstants.PICKUP_DRIVE_POWER, Math.PI, 0, .32));
    	addSequential(new Wait(.2));
    	addParallel(new GoUpOneTote());
    	addSequential(new Wait(RobotMap.TwoGreyToteAutoConstants.WAIT_AFTER_PICKUP));
    	addSequential(new PolarMecanumForTime(RobotMap.getTwoTotePickupPower(), Math.PI, 0, .65));//.65
    	addSequential(new Wait(.6));
    	addParallel(new GoUpOneTote());
    	addSequential(new Wait(RobotMap.TwoGreyToteAutoConstants.WAIT_AFTER_PICKUP));
    	addSequential(new PolarMecanumForTime(RobotMap.TwoGreyToteAutoConstants.DRIVE_POWER, 0, 0, 1.6));
    	addSequential(new PolarMecanumForTime(RobotMap.TwoGreyToteAutoConstants.DRIVE_POWER, Math.PI, 0, .24));

        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
