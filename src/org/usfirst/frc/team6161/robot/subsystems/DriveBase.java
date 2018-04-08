package org.usfirst.frc.team6161.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team6161.robot.Constants; 

import org.usfirst.frc.team6161.robot.RobotMap;
import org.usfirst.frc.team6161.robot.Robot;
//import com.analog.adis16448.frc.ADIS16448_IMU;

public class DriveBase extends Subsystem {
	public static final double autoSpeed = 0.95;
	
	public double lastForward = 0.25; //used to be 0.25 for Xbox drive
	
	public double lastTurn = 0.2; 
	
    public double curve = 0.07; //used to be 0.07 for Xbox
    
/*    public static long startTime = System.currentTimeMillis();
    public static int autoDuration = 15;
    public static long autoDurationMilis = autoDuration*1000; */
//    private ADIS16448_IMU gyro;
    
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private DifferentialDrive the4Motors; 
	public void init(){
		the4Motors = RobotMap.driveBaseThe4Motors;
//		gyro = new ADIS16448_IMU ();
//		gyro.calibrate();
	}
    public void initDefaultCommand() {
    	//setDefaultCommand(new DriveWithJoystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public DifferentialDrive getRobotDrive(){
    	return the4Motors;
    }
    public void driveWithXbox(){
    	if (Robot.oi.getTheJoystick().getRawButton(8)){
    		Robot.driveBase.getRobotDrive().arcadeDrive(Robot.oi.theXbox.getRawAxis(1), Robot.oi.theXbox.getRawAxis(4));
    		return;                                         //Xbox axes are raw 1 and raw 4 in this order
    	}
    	
    	if (Robot.oi.theXbox.getRawAxis(1) > lastForward) {
    		lastForward += curve;
    		//lastForward = lastForward + 0.02; <--- same as above
    	}
    	else {
    		lastForward -= curve;
    	}
    	if (Robot.oi.theXbox.getRawAxis(4) > lastTurn) {
    		lastTurn += curve;
    		//lastTurn = lastTurn + 0.02; <--- same as above
    	}
    	else {
    		lastTurn -= curve;
    	}
/*		Robot.driveBase.getRobotDrive().arcadeDrive(lastForward, lastTurn);
				Before---^    	 */
    	Robot.driveBase.getRobotDrive().arcadeDrive(lastForward, Robot.oi.theXbox.getRawAxis(4));
    }
   
/*       double Kp = 0.03;

       public void autonomous() {
//    	   gyro.reset();
           while (isAutonomous()) {
               double angle = gyro.getAngleZ(); // get current heading
              // System.out.println("angle= "+angle);
               the4Motors.arcadeDrive(-1.0, -angle*Kp); // drive towards heading 0
               Timer.delay(0.004);
           }
           the4Motors.arcadeDrive(0.0, 0.0);
      }*/
    
 /*   private boolean isAutonomous() {
		long currentTime = System.currentTimeMillis();
		
		if (currentTime - startTime > autoDurationMilis) {
			startTime = currentTime;
			return false;
		} else {
			return true;
		}
    }*/
	public void Forward(){
    	the4Motors.arcadeDrive(-autoSpeed, 0);
    }
    public void AutoForward(){
 //   	autonomous();
    	the4Motors.arcadeDrive((-autoSpeed*0.75), 0);
    }
    public void SlowForward(){
    	the4Motors.arcadeDrive((-autoSpeed*0.68), 0);//mid gear
    }
    public void SlowBackward(){
    	the4Motors.arcadeDrive((autoSpeed/2), 0);
    }
    
    public void turnRight() {
    	the4Motors.arcadeDrive(0.0, Constants.RIGHT_TURN_ROTATION);
    }
    
    public void turnLeft() {
    	the4Motors.arcadeDrive(0.0, Constants.LEFT_TURN_ROTATION);
    }    	
    public void Stop(){
    	the4Motors.arcadeDrive(0,0);
    }
    
    
}

