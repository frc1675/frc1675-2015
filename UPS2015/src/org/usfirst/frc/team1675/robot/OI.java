package org.usfirst.frc.team1675.robot;


import org.usfirst.frc.team1675.robot.RobotMap.ControllerPorts;
import org.usfirst.frc.team1675.robot.commands.PickUpCanFromStep;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPositionIncrementingSetpoint;
import org.usfirst.frc.team1675.robot.commands.containerarm.MoveContainerArmToPositionOnDashboard;
import org.usfirst.frc.team1675.robot.commands.containerarm.RawMoveContainerArm;
import org.usfirst.frc.team1675.robot.commands.containerarm.ThatStupidFreakinAutoCanPickupRoutine;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawClose;
import org.usfirst.frc.team1675.robot.commands.containerclaw.ContainerClawOpen;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoDownOneTote;
import org.usfirst.frc.team1675.robot.commands.totestacker.GoUpOneTote;
import org.usfirst.frc.team1675.robot.commands.totestacker.ResetToteStacker;
import org.usfirst.frc.team1675.robot.commands.totestacker.Score;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToggleTotevatorPID;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerBumpDown;
import org.usfirst.frc.team1675.robot.commands.totestacker.ToteStackerBumpUp;
import org.usfirst.frc.team1675.robot.utils.DPadButton;
import org.usfirst.frc.team1675.robot.utils.TriggerButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
	
	private JoystickButton driverRightBumperButton;
	private JoystickButton driverLeftBumperButton;
	
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
	private TriggerButton operatorRightTriggerButton;
	private TriggerButton operatorLeftTriggerButton;
	
	public OI(){
		driverController = new Joystick(ControllerPorts.DRIVER);
		operatorController = new Joystick(ControllerPorts.OPERATOR);
		
		driverYButton = new JoystickButton(driverController, XBoxControllerMap.Y_BUTTON);
		driverAButton = new JoystickButton(driverController, XBoxControllerMap.A_BUTTON);
		driverBButton = new JoystickButton(driverController, XBoxControllerMap.B_BUTTON);
		driverXButton = new JoystickButton(driverController, XBoxControllerMap.X_BUTTON);
		
		driverLeftBumperButton = new JoystickButton(driverController, XBoxControllerMap.LEFT_BUMPER_BUTTON);
		driverRightBumperButton = new JoystickButton(driverController, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
		
		operatorXButton = new JoystickButton(operatorController, XBoxControllerMap.X_BUTTON);
		operatorYButton = new JoystickButton(operatorController, XBoxControllerMap.Y_BUTTON);
		operatorAButton = new JoystickButton(operatorController, XBoxControllerMap.A_BUTTON);
		operatorBButton = new JoystickButton(operatorController, XBoxControllerMap.B_BUTTON);
		
		operatorRightBumperButton = new JoystickButton(operatorController,XBoxControllerMap.RIGHT_BUMPER_BUTTON);
		operatorLeftBumperButton = new JoystickButton(operatorController,XBoxControllerMap.LEFT_BUMPER_BUTTON);
		
		operatorRightTriggerButton = new TriggerButton(operatorController,false, .4);
		operatorLeftTriggerButton = new TriggerButton(operatorController,true, .7);
		
		operatorDPadUp = new DPadButton(operatorController, DPadButton.Direction.UP);
		operatorDPadDown = new DPadButton(operatorController, DPadButton.Direction.DOWN);
		operatorDPadLeft = new DPadButton(operatorController, DPadButton.Direction.LEFT);
		operatorDPadRight = new DPadButton(operatorController, DPadButton.Direction.RIGHT);
		
		driverAButton.whenPressed(new GoDownOneTote());
		driverYButton.whenPressed(new GoUpOneTote());
		driverBButton.whenPressed(new ToteStackerBumpUp());
		driverXButton.whenPressed(new ToteStackerBumpDown());
		driverRightBumperButton.whenPressed(new Score());
		driverLeftBumperButton.whenPressed(new ResetToteStacker());
	
		operatorXButton.whenPressed(new ContainerClawOpen());
		operatorXButton.whenReleased(new ContainerClawClose());
		operatorBButton.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.getPickupPosition()));
		operatorYButton.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.getStepCanPosition()));
		operatorAButton.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.getHomePosition()));
		operatorRightBumperButton.whenPressed(new RawMoveContainerArm());
		operatorLeftBumperButton.whenPressed(new PickUpCanFromStep());
		
		operatorLeftTriggerButton.whenPressed(new ToggleTotevatorPID());
		operatorRightTriggerButton.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.getHomePosition()));
		
		
		operatorDPadUp.whenPressed(new ThatStupidFreakinAutoCanPickupRoutine(1.0));
		operatorDPadDown.whenPressed(new ResetToteStacker());
		operatorDPadRight.whenPressed(new MoveContainerArmToPositionIncrementingSetpoint(RobotMap.getPickupPosition()));
		operatorDPadLeft.whenPressed(new MoveContainerArmToPositionOnDashboard());
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
