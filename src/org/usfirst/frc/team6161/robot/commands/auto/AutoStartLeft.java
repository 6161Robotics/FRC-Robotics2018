package org.usfirst.frc.team6161.robot.commands.auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStartLeft extends CommandGroup{
	
	public AutoStartLeft () {

		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0)
                {
		  if(gameData.charAt(0) == 'L')
		  {
			addSequential(new AutoStartLeftGoLeft());
			
		  } 
		  else {
			addSequential(new AutoStartLeftGoRight());
		  }
                }
    }
}