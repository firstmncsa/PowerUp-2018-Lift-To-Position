
package org.usfirst.frc3840.LiftPosition;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    public static WPI_TalonSRX liftElevatorliftMotor5;
    static double iaccum = 0;

    public static void init() {
      
        liftElevatorliftMotor5 = new WPI_TalonSRX(5);
        LiveWindow.addActuator("Lift Motor", "Lift Elevator", (WPI_TalonSRX) liftElevatorliftMotor5);
        
        //Setups the encoder position sensor
        liftElevatorliftMotor5.clearStickyFaults(20);

		/* first choose the sensor */
		liftElevatorliftMotor5.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		liftElevatorliftMotor5.setSensorPhase(false);
		liftElevatorliftMotor5.setInverted(true);
		
		liftElevatorliftMotor5.setIntegralAccumulator(iaccum, 0, 10);

		/* Set relevant frame periods to be at least as fast as periodic rate */
		liftElevatorliftMotor5.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		liftElevatorliftMotor5.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);

		/* set the peak and nominal outputs */
		liftElevatorliftMotor5.configNominalOutputForward(0, Constants.kTimeoutMs);
		liftElevatorliftMotor5.configNominalOutputReverse(0, Constants.kTimeoutMs);
		liftElevatorliftMotor5.configPeakOutputForward(1, Constants.kTimeoutMs);
		liftElevatorliftMotor5.configPeakOutputReverse(-1, Constants.kTimeoutMs);

		/* set closed loop gains in slot0 - see documentation */
		liftElevatorliftMotor5.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
		liftElevatorliftMotor5.config_kF(0, 0.2481, Constants.kTimeoutMs);
		liftElevatorliftMotor5.config_kP(0, 2.0, Constants.kTimeoutMs);
		liftElevatorliftMotor5.config_kI(0, 0, Constants.kTimeoutMs);
		liftElevatorliftMotor5.config_kD(0, 0, Constants.kTimeoutMs);
		/* set acceleration and vcruise velocity - see documentation */
		liftElevatorliftMotor5.configMotionCruiseVelocity(1443, Constants.kTimeoutMs);
		liftElevatorliftMotor5.configMotionAcceleration(1443, Constants.kTimeoutMs);
		/* zero the sensor */
		liftElevatorliftMotor5.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		
    }

}
