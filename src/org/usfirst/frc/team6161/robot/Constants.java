package org.usfirst.frc.team6161.robot;

public class Constants {

	// Time to wait before starting autonomous mode
	public static final double AUTO_START_WAIT = 3;
	
	// Travel time from auto start to switch
	public static final double AUTO_FULL_TRAVEL_DURATION = 1.0;
	
	//90 degree turn with turn rotation set to 0.6	
	public static final double AUTO_FULL_TURNING_DURATION = 1.0;
	
	// First half of travel time from auto start to switch (used by a center starting robot)
	public static final double AUTO_FIRST_HALF_TRAVEL_DURATION = 1.0;
	
	// Travel time for center starting robots after making first turn
	public static final double AUTO_LATERAL_TRAVEL_DURATION = 1.0;
	
	// Second half of travel time form auto start to switch (used by a center starting robot)
	public static final double AUTO_SECOND_HALF_TRAVEL_DURATION = 1.5;
	
	
	
	// Turn rotations
	public static final double RIGHT_TURN_ROTATION = 0.6;
	public static final double LEFT_TURN_ROTATION = -0.6;	
	
	
}
