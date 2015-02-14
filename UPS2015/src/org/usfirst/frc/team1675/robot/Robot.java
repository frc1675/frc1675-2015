
package org.usfirst.frc.team1675.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1675.robot.commands.ExampleCommand;
import org.usfirst.frc.team1675.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1675.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static OI oi;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    			SmartDashboard.putNumber("BackLeftP", RobotMap.DriveEncoders.BackRightPIDDefaults.P);
				SmartDashboard.putNumber("BackLeftI", RobotMap.DriveEncoders.BackRightPIDDefaults.I);
				SmartDashboard.putNumber("BackLeftD", RobotMap.DriveEncoders.BackRightPIDDefaults.D);
				SmartDashboard.putNumber("BackLeftF", RobotMap.DriveEncoders.BackRightPIDDefaults.F);
				SmartDashboard.putNumber("BackRightP", RobotMap.DriveEncoders.BackRightPIDDefaults.P);
				SmartDashboard.putNumber("BackRightI", RobotMap.DriveEncoders.BackRightPIDDefaults.I);
				SmartDashboard.putNumber("BackRightD", RobotMap.DriveEncoders.BackRightPIDDefaults.D);
				SmartDashboard.putNumber("BackRightF", RobotMap.DriveEncoders.BackRightPIDDefaults.F);
				SmartDashboard.putNumber("FrontLeftP", RobotMap.DriveEncoders.FrontLeftPIDDefaults.P);
				SmartDashboard.putNumber("FrontLeftI", RobotMap.DriveEncoders.FrontLeftPIDDefaults.I);
				SmartDashboard.putNumber("FrontLeftD", RobotMap.DriveEncoders.FrontLeftPIDDefaults.D);
				SmartDashboard.putNumber("FrontLeftF", RobotMap.DriveEncoders.FrontLeftPIDDefaults.F);
				SmartDashboard.putNumber("FrontRightP", RobotMap.DriveEncoders.FrontRightPIDDefaults.P);
				SmartDashboard.putNumber("FrontRightI", RobotMap.DriveEncoders.FrontRightPIDDefaults.I);
				SmartDashboard.putNumber("FrontRightD", RobotMap.DriveEncoders.FrontRightPIDDefaults.D);
				SmartDashboard.putNumber("FrontRightF", RobotMap.DriveEncoders.FrontRightPIDDefaults.F);		
				SmartDashboard.putNumber("All The Drive P", RobotMap.DriveEncoders.AllThePIDs.P);
				SmartDashboard.putNumber("All The Drive I", RobotMap.DriveEncoders.AllThePIDs.I);
				SmartDashboard.putNumber("All The Drive D", RobotMap.DriveEncoders.AllThePIDs.D);
				SmartDashboard.putNumber("All The Drive F", RobotMap.DriveEncoders.AllThePIDs.F);	

		oi = new OI();
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
//    	drivetrain.backLeftMotor.setPIDF(SmartDashboard.getNumber("BackLeftP", RobotMap.DriveEncoders.BackRightPIDDefaults.P),
//				SmartDashboard.getNumber("BackLeftI", RobotMap.DriveEncoders.BackRightPIDDefaults.I),
//				SmartDashboard.getNumber("BackLeftD", RobotMap.DriveEncoders.BackRightPIDDefaults.D),
//				SmartDashboard.getNumber("BackLeftF", RobotMap.DriveEncoders.BackRightPIDDefaults.F));
//    	drivetrain.backRightMotor.setPIDF(SmartDashboard.getNumber("BackRightP", RobotMap.DriveEncoders.BackRightPIDDefaults.P),
//				SmartDashboard.getNumber("BackRightI", RobotMap.DriveEncoders.BackRightPIDDefaults.I),
//				SmartDashboard.getNumber("BackRightD", RobotMap.DriveEncoders.BackRightPIDDefaults.D),
//				SmartDashboard.getNumber("BackRightF", RobotMap.DriveEncoders.BackRightPIDDefaults.F));
//		drivetrain.frontLeftMotor.setPIDF(SmartDashboard.getNumber("FrontLeftP", RobotMap.DriveEncoders.FrontLeftPIDDefaults.P),
//				SmartDashboard.getNumber("FrontLeftI", RobotMap.DriveEncoders.FrontLeftPIDDefaults.I),
//				SmartDashboard.getNumber("FrontLeftD", RobotMap.DriveEncoders.FrontLeftPIDDefaults.D),
//				SmartDashboard.getNumber("FrontLeftF", RobotMap.DriveEncoders.FrontLeftPIDDefaults.F));
//		drivetrain.frontRightMotor.setPIDF(SmartDashboard.getNumber("FrontRightP", RobotMap.DriveEncoders.FrontRightPIDDefaults.P),
//				SmartDashboard.getNumber("FrontRightI", RobotMap.DriveEncoders.FrontRightPIDDefaults.I),
//				SmartDashboard.getNumber("FrontRightD", RobotMap.DriveEncoders.FrontRightPIDDefaults.D),
//				SmartDashboard.getNumber("FrontRightF", RobotMap.DriveEncoders.FrontRightPIDDefaults.F));		

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
