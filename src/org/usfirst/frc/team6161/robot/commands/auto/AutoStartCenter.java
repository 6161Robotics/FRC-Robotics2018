package org.usfirst.frc.team6161.robot.commands.auto;


import org.usfirst.frc.team6161.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;



public class AutoStartCenter extends Command {
	Command autonomousCommand;
    public AutoStartCenter() {

    }

    protected void initialize(){
    	
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0)
                {
		  if(gameData.charAt(0) == 'L')
		  {
			autonomousCommand = new AutoStartCenterGoLeft();
			
		  } 
		  else {
			autonomousCommand = new AutoStartCenterGoRight();
		  }
                }
    }
    
    protected void execute(){
    	autonomousCommand.start();
    }
    
	protected boolean isFinished() {
		return false;
	}
	
    protected void end() {
    	Robot.driveBase.Stop();
    }
}


