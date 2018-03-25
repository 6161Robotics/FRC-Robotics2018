package org.usfirst.frc.team6161.robot.commands.auto;

import org.usfirst.frc.team6161.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAutoRightTurn extends Command {
		private double timeout;
    public DriveAutoRightTurn(double autoFullTurningDuration) {
    	this.timeout = autoFullTurningDuration;   
    	requires(Robot.driveBase);
    }


	// Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeout);
    	Robot.driveBase.turnRight();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
