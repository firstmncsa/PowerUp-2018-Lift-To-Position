package org.usfirst.frc3840.LiftPosition.commands;

import org.usfirst.frc3840.LiftPosition.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *  Command to run lift to cube pickup position.
 *  Calls lift elevator subsystem
 */
public class LiftToPickUp extends Command {
	final String travelLocation = "LiftToPickUp";
	
    public LiftToPickUp() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.liftElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.liftElevator.LiftToPosition(travelLocation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.liftElevator.intSensorPosition > Robot.liftElevator.intLowwerRange || Robot.liftElevator.intSensorPosition >= Robot.liftElevator.intUpperRange || true) { 
    		return true;
    	}
    	
		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
