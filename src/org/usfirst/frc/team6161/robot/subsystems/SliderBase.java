package org.usfirst.frc.team6161.robot.subsystems;

import org.usfirst.frc.team6161.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SliderBase extends Subsystem {

	public static final double VerticalSpeed = 1;
	public static final double HorzontalSpeed = .9;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private SpeedController VerticalMotor;
	private SpeedController HorzontalMotor;
	
	DigitalInput topVerticalLimitSwitch = new DigitalInput(3);
	DigitalInput botVerticalLimitSwitch = new DigitalInput(2);
	
	public DigitalInput frontHorizontalLimitSwitch = new DigitalInput(0);
	public DigitalInput rearHorizontalLimitSwitch = new DigitalInput(1);
	
	
	
	public void init(){
		VerticalMotor = RobotMap.sliderBaseVerticalMotor;
		HorzontalMotor = RobotMap.sliderBaseHorizontalMotor;
		SmartDashboard.putBoolean("Front HE sensor", frontHorizontalLimitSwitch.get());
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
    	SmartDashboard.putBoolean("Bottom HE sensor", botVerticalLimitSwitch.get());
    	VerticalMotor.set(-VerticalSpeed);
    }
    public void VerticalStop(){
    	VerticalMotor.set(0);
    }
    
    
    
    public void HorzontalForward(){
    	System.out.println("update");
    	SmartDashboard.putBoolean("Front HE sensor", frontHorizontalLimitSwitch.get());
    	HorzontalMotor.set(-HorzontalSpeed);
    }
    public void HorzontalBackward(){
    	HorzontalMotor.set(HorzontalSpeed);
    }
    public void HorzontalStop(){
    	HorzontalMotor.set(0);
    }
}
