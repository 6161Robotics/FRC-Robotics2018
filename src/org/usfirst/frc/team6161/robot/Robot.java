/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6161.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import com.analog.adis16448.frc.ADIS16448_IMU;

import org.usfirst.frc.team6161.robot.subsystems.*;
import org.usfirst.frc.team6161.robot.commands.auto.AutoStartCenter;
import org.usfirst.frc.team6161.robot.commands.auto.AutoStartLeft;
import org.usfirst.frc.team6161.robot.commands.auto.AutoStartRight;
// TODO import org.usfirst.frc.team6161.robot.subsystems.AutoDrive;

import org.usfirst.frc.team6161.robot.commands.auto.AutoStraight;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {


	//	public static final ADIS16448_IMU imu = new ADIS16448_IMU();
	public static final DriveBase driveBase = new DriveBase();
//	TODO is this nessary?	public static final AutoDrive autoDrive = new AutoDrive();
//	public static final climberBase climberBase = new climberBase();
	public static final SliderBase SliderBase = new SliderBase();
	public static final DumpBase DumpBase = new DumpBase();
	public static final ArmsBase ArmsBase = new ArmsBase();
//	public static final roombaBase roombaBase = new roombaBase();
	public static OI oi;
	
	PowerDistributionPanel pdp; 
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		CameraServer.getInstance().startAutomaticCapture();
		RobotMap.init();
		oi = new OI();
		pdp = new PowerDistributionPanel();
		

		// Add Commands to show in Autonomous drop-down on Smart Dashboard
		chooser.addDefault("Default Auto", new AutoStraight());
		chooser.addObject("Auto Start Left", new AutoStartLeft());
		chooser.addObject("Auto Start Right", new AutoStartRight());
		chooser.addObject("Auto Start Center", new AutoStartCenter());
		SmartDashboard.putData("Autonomous Scenarios", chooser);
	
		
		driveBase.init();
		

//		climberBase.init();
		DumpBase.init();
		SliderBase.init();
		ArmsBase.init();
//		roombaBase.init();
		// call other subsystem inits here
		
		
		
	}

	@Override
	public void robotPeriodic() {
		
/*	    SmartDashboard.putNumber("Gyro-X", imu.getAngleX());
	    SmartDashboard.putNumber("Gyro-Y", imu.getAngleY());
	    SmartDashboard.putNumber("Gyro-Z", imu.getAngleZ());

	    
	    SmartDashboard.putNumber("Accel-X", imu.getAccelX());
	    SmartDashboard.putNumber("Accel-Y", imu.getAccelY());
	    SmartDashboard.putNumber("Accel-Z", imu.getAccelZ());
	    
	    SmartDashboard.putNumber("Pitch", imu.getPitch());
	    SmartDashboard.putNumber("Roll", imu.getRoll());
	    SmartDashboard.putNumber("Yaw", imu.getYaw());
	    
	    SmartDashboard.putNumber("Pressure: ", imu.getBarometricPressure());
	    SmartDashboard.putNumber("Temperature: ", imu.getTemperature()); 
	*/
		

		

	}
	
	
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */


	
	@Override
	public void disabledInit() {
		//autonomousCommand.isCanceled();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {

		//autonomousCommand = new AutoStartCenterGoLeft();
		autonomousCommand = chooser.getSelected();
		
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		if (autonomousCommand != null)
			autonomousCommand.cancel();
//		imu.reset();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		Robot.driveBase.drivewithJoystick();
		

//		//Brownout Protection
//		if (pdp.getCurrent(0) > 60.0 ||
//	    		pdp.getCurrent(1) > 60.0 ||
//	    		pdp.getCurrent(2) > 60.0 ||
//	    		pdp.getCurrent(3) > 60.0) {
//	    		
//			//---> modifies joystick inputs
//	    	}
		}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
