package org.usfirst.frc.team6161.robot.subsystems;

import org.usfirst.frc.team6161.robot.RobotMap;


import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SliderBase extends Subsystem {

	public static final double VerticalSpeed = 0.5;
	public static final double HorzontalSpeed = 0.25;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private SpeedController VerticalMotor;
	private SpeedController HorzontalMotor;
	
	
	public void init(){
		VerticalMotor = RobotMap.sliderBaseVerticalMotor;
		HorzontalMotor = RobotMap.sliderBaseHorizontalMotor;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void VerticalUp(){
    	VerticalMotor.set(VerticalSpeed);
    }
    public void VerticalDown(){
    	VerticalMotor.set(-VerticalSpeed);
    }
    public void VerticalStop(){
    	VerticalMotor.set(0);
    }
    
    
    
    public void HorzontalUp(){
    	HorzontalMotor.set(HorzontalSpeed);
    }
    public void HorzontalDown(){
    	HorzontalMotor.set(-HorzontalSpeed);
    }
    public void HorzontalStop(){
    	HorzontalMotor.set(0);
    }
}
