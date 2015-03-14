package org.usfirst.frc.team1675.robot;


import org.usfirst.frc.team1675.robot.commands.containerarm.ThatStupidFreakinAutoCanPickupRoutine;

import org.usfirst.frc.team1675.robot.RobotMap.ControllerPorts;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPosition;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPositionIncrementingSetpoint;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPositionOnDashboard;
import org.usfirst.frc.team1675.robot.commands.containerarm.RawMoveContainerArm;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawClose;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawOpen;
import org.usfirst.frc.team1675.robot.commands.containerwrist.WristDown;
import org.usfirst.frc.team1675.robot.commands.containerwrist.WristUp;
import org.usfirst.frc.team1675.robot.commands.totestacker.DriveBackBeforeDroppingTotes;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoDownOneTote;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoUpOneTote;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToggleTotevatorPID;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerBumpDown;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerBumpUp;
import org.usfirst.frc.team1675.robot.utils.DPadButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick driverController;
	private Joystick operatorController;
	
	private JoystickButton driverXButton;
	private JoystickButton driverYButton;	
	private JoystickButton driverBButton;
	private JoystickButton driverAButton;
	
	private JoystickButton operatorXButton;
	private JoystickButton operatorYButton;
	private JoystickButton operatorBButton;
	private JoystickButton operatorAButton;
	
	private DPadButton operatorDPadUp;
	private DPadButton operatorDPadDown;
	private DPadButton operatorDPadLeft;
	private DPadButton operatorDPadRight;
	
	private JoystickButton operatorRightBumperButton;
	private JoystickButton operatorLeftBumperButton;
	
	public OI(){
		driverController = new Joystick(ControllerPorts.DRIVER);
		operatorController = new Joystick(ControllerPorts.OPERATOR);
		
		driverYButton = new JoystickButton(driverController, XBoxControllerMap.Y_BUTTON);
		driverAButton = new JoystickButton(driverController, XBoxControllerMap.A_BUTTON);
		driverBButton = new JoystickButton(driverController, XBoxControllerMap.B_BUTTON);
		driverXButton = new JoystickButton(driverController, XBoxControllerMap.X_BUTTON);
		
		operatorXButton = new JoystickButton(operatorController, XBoxControllerMap.X_BUTTON);
		operatorYButton = new JoystickButton(operatorController, XBoxControllerMap.Y_BUTTON);
		operatorAButton = new JoystickButton(operatorController, XBoxControllerMap.A_BUTTON);
		operatorBButton = new JoystickButton(operatorController, XBoxControllerMap.B_BUTTON);
		
		operatorRightBumperButton = new JoystickButton(operatorController,XBoxControllerMap.RIGHT_BUMPER_BUTTON);
		operatorLeftBumperButton = new JoystickButton(operatorController,XBoxControllerMap.LEFT_BUMPER_BUTTON);
		
		operatorDPadUp = new DPadButton(operatorController, DPadButton.Direction.UP);
		operatorDPadDown = new DPadButton(operatorController, DPadButton.Direction.DOWN);
		operatorDPadLeft = new DPadButton(operatorController, DPadButton.Direction.LEFT);
		operatorDPadRight = new DPadButton(operatorController, DPadButton.Direction.RIGHT);
		
		driverAButton.whenPressed(new GoDownOneTote());
		driverYButton.whenPressed(new GoUpOneTote());
		driverBButton.whenPressed(new ToteStackerBumpUp());
		driverXButton.whenPressed(new ToteStackerBumpDown());
		
		operatorXButton.whenPressed(new ContainerClawOpen());
		operatorXButton.whenReleased(new ContainerClawClose());
		operatorBButton.whenPressed(new MoveContainerArmToPositionOnDashboard());//193
		operatorYButton.whenPressed(new WristUp());
		operatorAButton.whenPressed(new WristDown());
		//operatorYButton.whenPressed(new GoUpOneTote());
		//operatorAButton.whenPressed(new GoDownOneTote());
		//operatorBButton.whenPressed(new DriveBackBeforeDroppingTotes());
		//operatorXButton.whenPressed(new ResetToteStacker());
		//operatorRightBumperButton.whenPressed(new ResetTotevatorPID());
		operatorRightBumperButton.whenPressed(new RawMoveContainerArm());
		operatorLeftBumperButton.whenPressed(new ToggleTotevatorPID());
		operatorDPadUp.whenPressed(new ThatStupidFreakinAutoCanPickupRoutine(1.0));
		operatorDPadDown.whenPressed(new DriveBackBeforeDroppingTotes());
		operatorDPadLeft.whenPressed(new MoveContainerArmToPosition(75.0));
		operatorDPadRight.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.ContainerArmConstants.PICK_UP_POSITION));

	}	
	
	public double getDriverLeftXAxis() {
		double leftXControllerValue = driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
		return checkForDeadzone(leftXControllerValue);
	}

	public double getDriverLeftYAxis() {
		double leftYControllerValue = driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		return checkForDeadzone(leftYControllerValue);
	}

	public double getDriverRightXAxis() {
		double rightXControllerValue = driverController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
		return checkForDeadzone(rightXControllerValue);
	}

	public double getDriverRightYAxis() {
		double rightYControllerValue = driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		return checkForDeadzone(rightYControllerValue);
	}
	
	public double getDriverLeftTrigger(double scaleValue){
		double leftTriggerValue = driverController.getRawAxis(XBoxControllerMap.LEFT_TRIGGER_AXIS);
		return checkForDeadzone(-leftTriggerValue);
	}

	public double getDriverRightTrigger(){
		double rightTriggerValue = driverController.getRawAxis(XBoxControllerMap.RIGHT_TRIGGER_AXIS);
		return checkForDeadzone(rightTriggerValue);
	}
	
	public double getOperatorLeftYAxis(){
		double leftYControllerValue = operatorController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
		return checkForDeadzone(leftYControllerValue);
	}
	
	public double getOperatorRightYAxis(){
		double rightYControllerValue = operatorController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
		return checkForDeadzone(rightYControllerValue);
	}
	
	public double checkForDeadzone(double input) {
		if (Math.abs(input) <= RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE) {
			return 0.0;
		} else {
			return scaleToDeadzone(input);
		}
	}
	
	/**
	 * Calculates scalar deadzone. Start from 0 at deadzone border instead of deadzone value
	 * @param magnitude magnitude of current stick position
	 * @return scaled value
	 */
	public double scaleToDeadzone(double magnitude){
		double scaledVector;
		int sign = (int) (magnitude/Math.abs(magnitude));
		scaledVector = sign*((Math.abs(magnitude)-RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE)
				/(1-RobotMap.DriverConstants.DEAD_ZONE_TOLERANCE));
		return scaledVector;
	}

}
