package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPosition;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoUpOneTote;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OpenFieldOneToteAuto extends CommandGroup {
    private static final double DRIVE_POWER = .47;
    public  OpenFieldOneToteAuto() {
    	addParallel(new MoveContainerArmToPosition(RobotMap.getHomePosition()));
    	addParallel(new GoUpOneTote());
    	addSequential(new Wait(.7));
    	addSequential(new PolarMecanumForTime(DRIVE_POWER, 0, 0, 1.53));
    	addSequential(new PolarMecanumForTime(DRIVE_POWER, Math.PI, 0, .31));
    	addSequential(new PolarMecanumForTime(0, 0, 1, RobotMap.getTurnNinetyDegreesTime()));
    	addSequential(new PolarMecanumForTime(.47, Math.PI, 0, .4));
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