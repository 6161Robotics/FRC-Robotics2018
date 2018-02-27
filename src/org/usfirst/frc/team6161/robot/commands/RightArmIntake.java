package org.usfirst.frc.team6161.robot.commands;

import org.usfirst.frc.team6161.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RightArmIntake extends Command{

    public RightArmIntake() {
    	requires(Robot.ArmsBase);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ArmsBase.RightIntake();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ArmsBase.RightStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
