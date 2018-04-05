/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6161.robot;


import  org.usfirst.frc.team6161.robot.Constants;

import org.usfirst.frc.team6161.robot.Gamepad;
import org.usfirst.frc.team6161.robot.commands.*;
import org.usfirst.frc.team6161.robot.commands.auto.DriveAutoLeftTurn;
import org.usfirst.frc.team6161.robot.commands.auto.DriveAutoOuttake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public JoystickButton joyClimbUp;
	public JoystickButton joyClimbDown;
	public JoystickButton joySlideForwards;
	public JoystickButton joySlideBackwards;
	public JoystickButton joySlideDownwards;
	public JoystickButton joySlideUpwards;
	public JoystickButton joyMoveToSwitch;
	public JoystickButton joyMoveToSafety;
	public AxisButton joyIntake;
	public AxisButton joyOuttake;

	public Joystick theXbox;
	public Joystick theXboxOne;
	


	public OI() {
		theXbox = new Joystick(0);
		theXboxOne = new Joystick(1);
		
		
		
        joyIntake = new AxisButton(theXbox, Gamepad.Axes.RIGHT_TRIGGER.getNumber(), Constants.AXIS_BUTTON_THRESHHOLD);
        joyIntake.whileHeld(new Intake());
        
        joyOuttake = new AxisButton(theXbox, Gamepad.Axes.LEFT_TRIGGER.getNumber(), Constants.AXIS_BUTTON_THRESHHOLD);
        joyOuttake.whileHeld(new Outtake());
        
        
		joySlideBackwards = new JoystickButton(theXbox, 1);
        joySlideBackwards.whileHeld(new SlideUpwards());
		
        joySlideDownwards = new JoystickButton(theXbox, 2);
        joySlideDownwards.whileHeld(new SlideDownwards());
        
        joyMoveToSwitch = new JoystickButton(theXbox, 3);
        joyMoveToSwitch.whenPressed(new DriveAutoOuttake());
        
  //      joyMoveToSafety = new JoystickButton(theXbox, 4);
  //      joyMoveToSafety.whileHeld(new ());
        
        joySlideForwards = new JoystickButton(theXbox, 6);
        joySlideForwards.whileHeld(new SlideForwards());  
        
        joySlideUpwards = new JoystickButton(theXbox, 5);
        joySlideUpwards.whileHeld(new SlideBackwards());
        
//        joyClimbUp = new JoystickButton(theJoystick, 6);
//        joyClimbUp.whileHeld(new climberUp());
		
//        joyClimbDown = new JoystickButton(theJoystick, 5);
//        joyClimbDown.whileHeld(new climberDown());
		
//        joyRoombaOut = new JoystickButton(theJoystick, 2);
//        joyRoombaOut.whileHeld(new roombaOut());
		
//        joyRoombaIn = new JoystickButton(theJoystick, 1);
//        joyRoombaIn.whileHeld(new roombaIn());
        
	}

/*    private double transformStickToSpeed(Gamepad.Axes stick) {
        double result = theXboxOne.getRawAxis(stick) * -1;
        result = Helpers.applyDeadband(result, Constants.Deadbands.DRIVE_STICK);
        result = Helpers.applySensitivityTransform(result);
        return result;
    }*/


	//a method for the joystick
	public Joystick getTheJoystick() {
        return theXbox;
    }
}
