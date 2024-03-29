package org.usfirst.frc.team1675.robot;

public class XBoxControllerMap {
	   
    /* CURRENTLY NOT MAPPED:
     * D-Pad vertical axis
     */
    
    //AXES
    
    //Left analog stick
    public static final int LEFT_X_AXIS = 0;
    public static final int LEFT_Y_AXIS = 1;
    
    //Right analog stick
    public static final int RIGHT_X_AXIS = 4;
    public static final int RIGHT_Y_AXIS = 5;
    
    //Trigger axis.
    //Starts at 0. Left trigger increases value, right trigger decreases value.
    //NOTE that this means you cannot "detect" both triggers being pulled at 
    //  any degree.
    public static final int LEFT_TRIGGER_AXIS = 2;
    public static final int RIGHT_TRIGGER_AXIS = 3;
    
    //Directional Pad horizontal axis.
    //Starts at 0, goes down when left is pressed, up when right is pressed.
    public static final int DPAD_AXIS = 6;
    
    //BUTTONS
    
    //Face buttons
    public static final int A_BUTTON = 1;
    public static final int B_BUTTON = 2;
    public static final int X_BUTTON = 3;
    public static final int Y_BUTTON = 4;
    
    //Bumpers (shoulders)
    public static final int LEFT_BUMPER_BUTTON = 5;
    public static final int RIGHT_BUMPER_BUTTON = 6;
    
    //Other Buttons
    public static final int BACK_BUTTON = 7;
    public static final int START_BUTTON = 8;
    
    //Joystick buttons (clicking in stick)
    public static final int LEFT_JOYSTICK_BUTTON = 9;
    public static final int RIGHT_JOYSTICK_BUTTON = 10;


}
