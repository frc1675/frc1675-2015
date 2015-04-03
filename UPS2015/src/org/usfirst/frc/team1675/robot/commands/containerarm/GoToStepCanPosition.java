package org.usfirst.frc.team1675.robot.commands.containerarm;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawOpen;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GoToStepCanPosition extends CommandGroup {
    
    public  GoToStepCanPosition() {
    	addParallel(new ContainerClawOpen());
    	addParallel(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.getStepCanPosition()));
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
