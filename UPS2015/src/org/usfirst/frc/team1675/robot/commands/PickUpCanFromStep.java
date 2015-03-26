package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPosition;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawClose;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawOpen;
import org.usfirst.frc.team1675.robot.commands.containerwrist.WristDown;
import org.usfirst.frc.team1675.robot.commands.containerwrist.WristUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PickUpCanFromStep extends CommandGroup {
    
    public  PickUpCanFromStep() {
    	//addParallel(new MoveContainerArmToPosition(RobotMap.ContainerArmConstants.STEP_PICKUP_HEIGHT));
    	//addSequential(new Wait(.5));
    	addParallel(new ContainerClawOpen());
    	addSequential(new Wait(.15));
    	addParallel(new WristDown());
    	addSequential(new Wait(RobotMap.getStepCanExtendTime()));
    	addParallel(new ContainerClawClose());
    	addSequential(new Wait(.1));
    	addParallel(new WristUp());
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
