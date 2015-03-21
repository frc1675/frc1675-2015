package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPosition;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoUpOneTote;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickUpTwoGreyTotes extends CommandGroup {
	private static final double DRIVE_POWER = .47;
    private static final double  PICKUP_DRIVE_POWER = .35;
    private static final double WAIT_AFTER_PICKUP = 1.5;
    public  PickUpTwoGreyTotes() {
    	addParallel(new MoveContainerArmToPosition(RobotMap.ContainerArmConstants.HOME_POSITION));
    	addSequential(new PolarMecanumForTime(PICKUP_DRIVE_POWER, Math.PI, 0, .32));
    	addSequential(new Wait(.2));
    	addParallel(new GoUpOneTote());
    	addSequential(new Wait(WAIT_AFTER_PICKUP));
    	addSequential(new PolarMecanumForTime(PICKUP_DRIVE_POWER, Math.PI, 0, .62));
    	addSequential(new Wait(1));
    	addParallel(new GoUpOneTote());
    	addSequential(new Wait(WAIT_AFTER_PICKUP));
    	addSequential(new PolarMecanumForTime(DRIVE_POWER, 0, 0, 1.6));
    	addSequential(new PolarMecanumForTime(DRIVE_POWER, Math.PI, 0, .24));

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
