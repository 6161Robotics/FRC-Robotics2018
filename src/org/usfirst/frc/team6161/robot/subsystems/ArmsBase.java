package org.usfirst.frc.team6161.robot.subsystems;

import org.usfirst.frc.team6161.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmsBase extends Subsystem {
	public static final double FullRightSpeed = 1;
	public static final double ReducedRightSpeed = 0.1;
	
	public static final double SomeLeftSpeed = 0.5;
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
    public void Intake(){
    	RightMotor.set(-FullRightSpeed);
    	LeftMotor.set(SomeLeftSpeed);
    }
    public void Outtake(){
    	RightMotor.set(FullRightSpeed);
    	LeftMotor.set(-SomeLeftSpeed);
    }
    public void Stay(){
    	RightMotor.set(ReducedRightSpeed);
    	LeftMotor.set(ReducedLeftSpeed);
    }
    public void ArmStop(){
    	RightMotor.set(0);
    	LeftMotor.set(0);
    }
}
