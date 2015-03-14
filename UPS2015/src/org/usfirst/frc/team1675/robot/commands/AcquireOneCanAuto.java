package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPositionIncrementingSetpoint;
import org.usfirst.frc.team1675.robot.commands.containerarm.ThatStupidFreakinAutoCanPickupRoutine;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawClose;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AcquireOneCanAuto extends CommandGroup {
    private static final double TIME_FOR_ARM_TO_GET_TO_HOME = .7;
    public  AcquireOneCanAuto() {
    	addParallel(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.ContainerArmConstants.HOME_POSITION));
    	//addParallel(new ContainerClawClose());
    	addSequential(new Wait(TIME_FOR_ARM_TO_GET_TO_HOME));
    	addSequential(new PolarMecanumForTime(.4, 0, 0, 1));
    	addParallel(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.ContainerArmConstants.PICK_UP_POSITION));
    	addSequential(new Wait(1.5));
    	addSequential(new PolarMecanumForTime(.4, 0, 0, .33));
    	addParallel(new ThatStupidFreakinAutoCanPickupRoutine(1.5));
    	addSequential(new Wait(3.2));
    	addSequential(new PolarMecanumForTime(.4, Math.PI, 0, .5));
    	//addSequential(new PolarMecanumForTime(.4, 0, 0, 1));
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
