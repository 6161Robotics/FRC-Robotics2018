package org.usfirst.frc.team6161.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;
 

public class Gyro {
	
	private ADIS16448_IMU sensor;
	
	public Gyro() {
		// TODO Auto-generated constructor stub
		sensor = new ADIS16448_IMU();
		
	}

	public double calculateCorrection (double correctAngle) {
		return correctAngle - getZ();
	}
		
	public double getZ(){
		return sensor.getAngleZ();
	}
}
