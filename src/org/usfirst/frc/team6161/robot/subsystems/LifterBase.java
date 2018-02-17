package org.usfirst.frc.team6161.robot.subsystems;

import org.usfirst.frc.team6161.robot.RobotMap;


import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LifterBase extends Subsystem {

	public static final double lifterSpeed = 1;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private SpeedController lifterMotor;
	
	
	public void init(){
		lifterMotor = RobotMap.lifterBaseLifterMotor;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void DumpUp(){
    	dumpMotor.set(dumpSpeed);
    }
    public void DumpDown(){
    	dumpMotor.set(-dumpSpeed);
    }
    public void DumpStop(){
    	dumpMotor.set(0);
    }
}
