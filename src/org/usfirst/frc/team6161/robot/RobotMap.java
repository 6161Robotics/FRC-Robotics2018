/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6161.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static SpeedController driveBaseRightFront;
    public static SpeedController driveBaseRightRear;
    public static SpeedController driveBaseLeftFront;
    public static SpeedController driveBaseLeftRear;
    public static DifferentialDrive driveBaseThe4Motors;
    public static SpeedController dumpBaseDumpMotor;
    public static SpeedController sliderBaseVerticalMotor;
    public static SpeedController sliderBaseHorizontalMotor; 
    public static SpeedController armsBaseRightMotor;
    public static SpeedController armsBaseLeftMotor;
    
    
    
    
    public static void init() {
    	 driveBaseRightFront = new Spark(3);
//         LiveWindow.addActuator("DriveBase", "RightFront", (Spark) driveBaseRightFront);
         
         driveBaseRightRear = new Victor(2);
//         LiveWindow.addActuator("DriveBase", "RightRear", (Spark) driveBaseRightRear);

         SpeedControllerGroup rightSpeedController = new SpeedControllerGroup(driveBaseRightFront, driveBaseRightRear);
         
         
         
         driveBaseLeftFront = new Spark(1);
//         LiveWindow.addActuator("DriveBase", "LeftFront", (Spark) driveBaseLeftFront);
         
         driveBaseLeftRear = new Victor(0);
//         LiveWindow.addActuator("DriveBase", "LeftRear", (Spark) driveBaseLeftRear);
  
         SpeedControllerGroup leftSpeedController = new SpeedControllerGroup(driveBaseLeftFront, driveBaseLeftRear);

       
         
         driveBaseThe4Motors = new DifferentialDrive(leftSpeedController, rightSpeedController);
         
         driveBaseThe4Motors.setSafetyEnabled(false);
         driveBaseThe4Motors.setExpiration(0.1);//0.1 default
// TODO: update to new API         driveBaseThe4Motors.setSensitivity(0.5);
         driveBaseThe4Motors.setMaxOutput(0.9);
         
//         driveBaseThe4Motors. setInvertedMotor(DifferentialDrive.MotorType.kFrontLeft, true);
//         driveBaseThe4Motors.setInvertedMotor(DifferentialDrive.MotorType.kRearLeft, true);
         leftSpeedController.setInverted(false);
         
//         driveBaseThe4Motors.setInvertedMotor(DifferentialDrive.MotorType.kFrontRight, true);
//         driveBaseThe4Motors.setInvertedMotor(DifferentialDrive.MotorType.kRearRight, true);
         rightSpeedController.setInverted(false);
         
         sliderBaseVerticalMotor = new Spark(5);
         sliderBaseHorizontalMotor = new Spark(4);
         
         armsBaseRightMotor = new Spark(7);
         armsBaseLeftMotor = new Spark(6);
         
         // TODO: Get rid of this eventually since we do not need this functionality
     //    dumpBaseDumpMotor = new Victor(6);
//         LiveWindow.addActuator("RoombaBase", "RoombaMotor", (Victor) roombaBaseRoombaMotor);
    }
}
