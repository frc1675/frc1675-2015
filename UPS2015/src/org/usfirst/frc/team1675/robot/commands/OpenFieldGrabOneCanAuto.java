package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPosition;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawClose;
import org.usfirst.frc.team1675.robot.commands.drivetrain.PolarMecanumForTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OpenFieldGrabOneCanAuto extends CommandGroup {
    
    	private static final double DRIVE_POWER = .59;
    	private static final double DRIVE_TIME = 1.26;
        public  OpenFieldGrabOneCanAuto() {
        	addParallel(new MoveContainerArmToPosition(RobotMap.ContainerArmConstants.HOME_POSITION));
        	addSequential(new Wait(1));
        	addSequential(new ContainerClawClose());
        	addSequential(new PolarMecanumForTime(DRIVE_POWER, Math.PI, 0, DRIVE_TIME));
        	addParallel(new MoveContainerArmToPosition(RobotMap.ContainerArmConstants.HOME_POSITION-15));
        	addSequential(new PolarMecanumForTime(DRIVE_POWER, 0, 0, .255));
        	addSequential(new PolarMecanumForTime(0, 0, -1, RobotMap.AutoConstants.TURN_NINETY_DEGREES_TIME));
        	addSequential(new PolarMecanumForTime(.47, Math.PI, 0, .6));
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
