package org.usfirst.frc.team6161.robot.subsystems;

import org.usfirst.frc.team6161.robot.Robot;
import org.usfirst.frc.team6161.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


public class SliderBase extends Subsystem {

	public static final double VerticalSpeed = 1;
	public static final double HorzontalSpeed = 1;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private SpeedController VerticalMotor;
	private SpeedController HorzontalMotor;
	
	public DigitalInput topVerticalLimitSwitch = new DigitalInput(3);
	public DigitalInput botVerticalLimitSwitch = new DigitalInput(2);
	
	public DigitalInput frontHorizontalLimitSwitch = new DigitalInput(0);
	public DigitalInput rearHorizontalLimitSwitch = new DigitalInput(1);
	
	
	
	public void init(){
		VerticalMotor = RobotMap.sliderBaseVerticalMotor;
		HorzontalMotor = RobotMap.sliderBaseHorizontalMotor;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean isAtFront(){
    	return !frontHorizontalLimitSwitch.get();
 //   	return false;
    }
    
    public boolean isAtRear(){
    	return !rearHorizontalLimitSwitch.get();
    }
    public boolean isAtTop(){
    	return !topVerticalLimitSwitch.get();
    }
    
   public boolean isAtBot(){
	   return !botVerticalLimitSwitch.get();
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


