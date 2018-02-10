package org.usfirst.frc.team6161.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6161.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class dumpBase extends Subsystem {

	public static final double dumpSpeed = 1;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private SpeedController dumpMotor;
	private Encoder dumpEncoder; 
	
	
	public void init(){
		dumpMotor = RobotMap.dumpBaseDumpMotor;
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

