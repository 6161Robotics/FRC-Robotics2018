package org.usfirst.frc.team6161.robot.subsystems;

import org.usfirst.frc.team6161.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmsBase extends Subsystem {
	public static final double FullRightSpeed = 1;
	public static final double ReducedRightSpeed = 0.1;
	
	public static final double FullLeftSpeed = 1;
	public static final double ReducedLeftSpeed = 0.1;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private SpeedController RightMotor;
	private SpeedController LeftMotor;
	
	
	public void init(){
		RightMotor = RobotMap.armsBaseRightMotor;
		LeftMotor = RobotMap.armsBaseLeftMotor;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void RightIntake(){
    	RightMotor.set(FullRightSpeed);
    }
    public void RightOuttake(){
    	RightMotor.set(-FullRightSpeed);
    }
    public void RightStay(){
    	RightMotor.set(ReducedRightSpeed);
    }
    public void RightStop(){
    	RightMotor.set(0);
    }
    
    
    
    public void LeftIntake(){
    	LeftMotor.set(FullLeftSpeed);
    }
    public void LeftOuttake(){
    	LeftMotor.set(-FullLeftSpeed);
    }
    public void LeftStay(){
    	LeftMotor.set(ReducedLeftSpeed);
    }
    public void LeftStop(){
    	LeftMotor.set(0);
    }
}
