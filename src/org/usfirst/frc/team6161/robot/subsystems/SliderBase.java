package org.usfirst.frc.team6161.robot.subsystems;

import org.usfirst.frc.team6161.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SliderBase extends Subsystem {

	public static final double VerticalSpeed = 0.75;
	public static final double HorzontalSpeed = 0.75;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private SpeedController VerticalMotor;
	private SpeedController HorzontalMotor;
	
	DigitalInput topVerticalLimitSwitch = new DigitalInput(1);
	DigitalInput botVerticalLimitSwitch = new DigitalInput(2);
	
	DigitalInput frontHorizontalLimitSwitch = new DigitalInput(11);
	DigitalInput rearHorizontalLimitSwitch = new DigitalInput(13);
	
	
	public void init(){
		VerticalMotor = RobotMap.sliderBaseVerticalMotor;
		HorzontalMotor = RobotMap.sliderBaseHorizontalMotor;
		
		 
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean isAtTop(){
    	return !topVerticalLimitSwitch.get();
 //   	return false;
    }
    public void VerticalUp(){
   		VerticalMotor.set(VerticalSpeed);
    	
    	
    	
    }
    public void VerticalDown(){
    	SmartDashboard.putBoolean("Bottom HE sensor", botVerticalLimitSwitch.get());
    	VerticalMotor.set(-VerticalSpeed);
    }
    public void VerticalStop(){
    	VerticalMotor.set(0);
    }
    
    
    
    public void HorzontalForward(){
    	HorzontalMotor.set(-HorzontalSpeed);
    }
    public void HorzontalBackward(){
    	HorzontalMotor.set(HorzontalSpeed);
    }
    public void HorzontalStop(){
    	HorzontalMotor.set(0);
    }
}
