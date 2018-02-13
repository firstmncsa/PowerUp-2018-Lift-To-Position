
package org.usfirst.frc3840.LiftPosition.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3840.LiftPosition.Robot;

/**
 *  Command to run lift to switch position.
 *  Calls lift elevator subsystem
 */
public class LiftToSwitch extends Command {

	final String travelLocation = "LiftToSwitch";

    public LiftToSwitch() {

        requires(Robot.liftElevator);

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	Robot.liftElevator.LiftToPosition(travelLocation);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	if(Robot.liftElevator.intSensorPosition > Robot.liftElevator.intLowwerRange || Robot.liftElevator.intSensorPosition >= Robot.liftElevator.intUpperRange || true) { 
    		return true;
    	}
    	
		return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
