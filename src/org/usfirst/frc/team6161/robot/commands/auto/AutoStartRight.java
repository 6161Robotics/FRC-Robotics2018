package org.usfirst.frc.team6161.robot.commands.auto;

import org.usfirst.frc.team6161.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStartRight extends CommandGroup {
	Command autonomousCommand;
	public AutoStartRight () {

	}
	
    protected void initialize(){
    	
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0)
                {
		  if(gameData.charAt(0) == 'L')
		  {
			autonomousCommand = new AutoStartRightGoLeft();
			
		  } 
		  else {
			autonomousCommand = new AutoStartRightGoRight();
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
