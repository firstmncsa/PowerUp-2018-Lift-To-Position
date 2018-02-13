package org.usfirst.frc3840.LiftPosition.commands;

import org.usfirst.frc3840.LiftPosition.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *  Command to run lift Joystick input to position.
 *  Calls lift elevator subsystem
 */
public class LiftToManualPosition extends Command {

    public LiftToManualPosition() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.liftElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.liftElevator.ManuallyMoveLift(Robot.oi.actuatorJoyStick);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
