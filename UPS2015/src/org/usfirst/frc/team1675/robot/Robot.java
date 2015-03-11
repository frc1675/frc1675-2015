
package org.usfirst.frc.team1675.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1675.robot.commands.TestAuto;
import org.usfirst.frc.team1675.robot.commands.drivetrain.PolarMecanumForTime;
import org.usfirst.frc.team1675.robot.commands.totestacker.TotevateForTime;
import org.usfirst.frc.team1675.robot.subsystems.ContainerArm;
import org.usfirst.frc.team1675.robot.subsystems.ContainerWrist;
import org.usfirst.frc.team1675.robot.subsystems.ContainerClaw;
import org.usfirst.frc.team1675.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1675.robot.subsystems.Totevator;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static Drivetrain drivetrain;
	public static Totevator totevator;
	public static ContainerArm containerArm;
	public static ContainerWrist containerWrist;
	public static ContainerClaw containerClaw;
	public static OI oi;
	
	public Robot(){
		// Instantiating subsystems in a explicit Robot constructor to ensure they are constructed after RobotBase
		// which was before causing the NetworkTable to throw exceptions
		try{
			drivetrain = new Drivetrain();
			totevator = new Totevator(RobotMap.ToteStackerConstants.P, RobotMap.ToteStackerConstants.I,	RobotMap.ToteStackerConstants.D);
			containerArm = new ContainerArm(RobotMap.ContainerArmConstants.P, RobotMap.ContainerArmConstants.I, RobotMap.ContainerArmConstants.D);
			containerWrist = new ContainerWrist();
			containerClaw = new ContainerClaw();
		}catch(Exception e){
			e.printStackTrace();			
		}		
	}
	
    private Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {    	
    	SmartDashboard.putNumber("TotevatorP", RobotMap.ToteStackerConstants.P);
    	SmartDashboard.putNumber("TotevatorI", RobotMap.ToteStackerConstants.I);
    	SmartDashboard.putNumber("TotevatorD", RobotMap.ToteStackerConstants.D);
		SmartDashboard.putNumber("ContainerArmP",RobotMap.ContainerArmConstants.P);
		SmartDashboard.putNumber("ContainerArmI",RobotMap.ContainerArmConstants.I);
		SmartDashboard.putNumber("ContainerArmD",RobotMap.ContainerArmConstants.D);
		SmartDashboard.putNumber("ContainerArmSetpoint", 150);
    	
        if (autonomousCommand != null) {
        	autonomousCommand.cancel();
        }

		oi = new OI();
		    
		
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonomousCommand = new TestAuto();
    	
        if (autonomousCommand != null) {
        	autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	totevator.getPIDController().reset();
    	totevator.getPIDController().enable();
		SmartDashboard.putBoolean("TotePIDEnabled", true);
        if (autonomousCommand != null) {
        	autonomousCommand.cancel();
        }

    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }
    


    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
