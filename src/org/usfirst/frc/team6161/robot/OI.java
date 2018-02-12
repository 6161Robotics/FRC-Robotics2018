/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6161.robot;

import org.usfirst.frc.team6161.robot.commands.*;

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
	public JoystickButton joyRoombaIn;
	public JoystickButton joyRoombaOut;
	public JoystickButton joyClimbUp;
	public JoystickButton joyClimbDown;
	public JoystickButton joyDumpUp;
	public JoystickButton joyDumpDown;
	public Joystick theJoystick;

	public OI() {
		theJoystick = new Joystick(0);
		
		// TODO: Initialize buttons
		joyDumpDown = new JoystickButton(theJoystick, 3);
        joyDumpDown.whileHeld(new DumpDown());
		
        joyDumpUp = new JoystickButton(theJoystick, 4);
        joyDumpUp.whileHeld(new DumpUp());
		
//        joyClimbUp = new JoystickButton(theJoystick, 6);
//        joyClimbUp.whileHeld(new climberUp());
		
//        joyClimbDown = new JoystickButton(theJoystick, 5);
//        joyClimbDown.whileHeld(new climberDown());
		
//        joyRoombaOut = new JoystickButton(theJoystick, 2);
//        joyRoombaOut.whileHeld(new roombaOut());
		
//        joyRoombaIn = new JoystickButton(theJoystick, 1);
//        joyRoombaIn.whileHeld(new roombaIn());
        
	}
	//a method for the joystick
	public Joystick getTheJoystick() {
        return theJoystick;
    }
}
