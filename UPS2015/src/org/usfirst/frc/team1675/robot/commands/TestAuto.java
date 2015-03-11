package org.usfirst.frc.team1675.robot.commands;

import org.usfirst.frc.team1675.robot.commands.drivetrain.PolarMecanumForTime;
import org.usfirst.frc.team1675.robot.commands.totestacker.TotevateForTime;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestAuto extends CommandGroup {
    
    public  TestAuto() {
    	addSequential(new PolarMecanumForTime(0.5, 0.0, 0.0, 0.2));
    	addSequential(new TotevateForTime(1.0, 1.5));
    }
}
