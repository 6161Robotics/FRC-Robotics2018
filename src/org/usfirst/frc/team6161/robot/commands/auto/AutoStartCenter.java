package org.usfirst.frc.team6161.robot.commands.auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class AutoStartCenter extends CommandGroup {

    public AutoStartCenter() {

		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
                if(gameData.length() > 0)
                {
		  if(gameData.charAt(0) == 'L')
		  {
			addSequential(new AutoStartCenterGoLeft());
			
		  } 
		  else {
			addSequential(new AutoStartCenterGoRight());
		  }
                }
    }
}


