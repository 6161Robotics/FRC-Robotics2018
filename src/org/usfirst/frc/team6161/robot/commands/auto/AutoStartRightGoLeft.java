package org.usfirst.frc.team6161.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team6161.robot.Constants;

/**
 *
 */
public class AutoStartRightGoLeft extends CommandGroup {

    public AutoStartRightGoLeft() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new WaitCommand(Constants.AUTO_START_WAIT));
    	addSequential(new DriveAutoForward(Constants.AUTO_PASS_SWITCH_TRAVEL_DURATION));
    	addSequential(new DriveAutoLeftTurn(Constants.AUTO_FULL_TURNING_DURATION));
    	addSequential(new DriveAutoForward(Constants.AUTO_LATERAL_TRAVEL_DURATION));
    	addSequential(new DriveAutoLeftTurn(Constants.AUTO_FULL_TURNING_DURATION));
    	addSequential(new DriveAutoOuttake());
    }
}
