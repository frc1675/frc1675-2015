
package org.usfirst.frc.team1675.robot.commands.containerarm;

import org.usfirst.frc.team1675.robot.RobotMap;
import org.usfirst.frc.team1675.robot.commands.PolarMecanumForTime;
import org.usfirst.frc.team1675.robot.commands.Wait;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawClose;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawOpen;
import org.usfirst.frc.team1675.robot.commands.containerwrist.WristDown;
import org.usfirst.frc.team1675.robot.commands.containerwrist.WristUp;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThatStupidFreakinAutoCanPickupRoutine extends CommandGroup {
    public  ThatStupidFreakinAutoCanPickupRoutine(double waitBeforeRetract) {
    	//addParallel(new MoveContainerArmToPosition(RobotMap.ContainerArmConstants.PICK_UP_POSITION));
    	//addSequential(new PolarMecanumForTime(.4, 0.0, 0.0, .3));
    	addSequential(new ContainerClawOpen());
    	addSequential(new WristDown());
    	addSequential(new Wait(waitBeforeRetract));
    	addSequential(new ContainerClawClose());
    	addSequential(new WristUp());    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel(
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
