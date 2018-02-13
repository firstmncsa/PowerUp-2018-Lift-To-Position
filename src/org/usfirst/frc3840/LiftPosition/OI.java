
package org.usfirst.frc3840.LiftPosition;

import org.usfirst.frc3840.LiftPosition.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING JOYSTICK & BUTTONS
      
    public XboxController actuatorJoyStick;
    public JoystickButton buttonLiftToPickup;
    public JoystickButton butttonLiftSwitch;
    public JoystickButton butttonLiftScale;
    public JoystickButton butttonLiftTravel;
    
    public OI() {
    	//XboxController declare
        actuatorJoyStick = new XboxController(0);
        //---------------------------------------------
        //button declares for commands to subsystems
        //---------------------------------------------
        // Button #1
        buttonLiftToPickup = new JoystickButton(actuatorJoyStick, 1);
        buttonLiftToPickup.whenPressed(new LiftToPickUp());
        // Button #2
        butttonLiftTravel = new JoystickButton(actuatorJoyStick, 2);
        butttonLiftTravel.whenPressed(new LiftToTravel());
        // Button #3
        butttonLiftSwitch = new JoystickButton(actuatorJoyStick, 3);
        butttonLiftSwitch.whenPressed(new LiftToSwitch());
        // Button #4
        butttonLiftScale = new JoystickButton(actuatorJoyStick, 4);
        butttonLiftScale.whenPressed(new LiftToScale());
        
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("LiftToTravel", new LiftToTravel());
        SmartDashboard.putData("LiftToSwitch", new LiftToSwitch());
        SmartDashboard.putData("LiftToScale", new LiftToScale());
        SmartDashboard.putData("LiftToPickup", new LiftToPickUp());

    }

   
    public XboxController getactuatorJoyStick() {
        return actuatorJoyStick;
    }

}

