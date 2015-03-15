package org.usfirst.frc.team1675.robot.commands.totestacker;

import org.usfirst.frc.team1675.robot.commands.PolarMecanumForTime;
import org.usfirst.frc.team1675.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveBackBeforeDroppingTotes extends CommandGroup {
    private static final double BUMP_DOWN_TIME = .5;
    public  DriveBackBeforeDroppingTotes() {
//    	addParallel(new ToteStackerBumpDown());
//    	addSequential(new Wait(BUMP_DOWN_TIME));
//    	addParallel(new ToteStackerBumpDown());
//    	addSequential(new Wait(BUMP_DOWN_TIME));
    	addSequential(new PolarMecanumForTime(.4, 0.0, 0.0, .1));
    	addSequential(new ResetToteStacker());
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
