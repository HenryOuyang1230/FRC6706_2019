/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.KaiDefFunc;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class RaiseSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  TalonSRX mSRXRaiseMotor;

  public RaiseSubsystem(){
    /* initiate the motor object */
    mSRXRaiseMotor = new TalonSRX(RobotMap.MOTOR_RAISE);
    
    /* choose the sensor and sensor direction */
    mSRXRaiseMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx, Constants.kTimeoutMs);

    /* choose to ensure sensor is positive when output is positive */
    mSRXRaiseMotor.setSensorPhase(Constants.kSensorPhase);

    /* choose based on what direction you want forward/positive to be.
		 * This does not affect sensor phase. */ 
    mSRXRaiseMotor.setInverted(Constants.kMotorInvert);

    /* set the peak and nominal outputs, 12V means full */
    mSRXRaiseMotor.configNominalOutputForward(0, Constants.kTimeoutMs);
    mSRXRaiseMotor.configNominalOutputReverse(0, Constants.kTimeoutMs);
    mSRXRaiseMotor.configPeakOutputForward(1, Constants.kTimeoutMs);
    mSRXRaiseMotor.configPeakOutputReverse(-1, Constants.kTimeoutMs);

    /*
		 * set the allowable closed-loop error, Closed-Loop output will be
		 * neutral within this range. See Table in Section 17.2.1 for native
		 * units per rotation.
		 */
    mSRXRaiseMotor.configAllowableClosedloopError(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);

    /* set closed loop gains in slot0, typically kF stays zero. */
    mSRXRaiseMotor.config_kP(Constants.kPIDLoopIdx, 0.0, Constants.kTimeoutMs);
    mSRXRaiseMotor.config_kI(Constants.kPIDLoopIdx, 0.1, Constants.kTimeoutMs);
    mSRXRaiseMotor.config_kI(Constants.kPIDLoopIdx, 0.0, Constants.kTimeoutMs);
		mSRXRaiseMotor.config_kD(Constants.kPIDLoopIdx, 0.0, Constants.kTimeoutMs);

    /*
		 * lets grab the 360 degree position of the MagEncoder's absolute
		 * position, and intitally set the relative sensor to match.
		 */
    int absolutePosition = mSRXRaiseMotor.getSensorCollection().getPulseWidthPosition();
    /* mask out overflows, keep bottom 12 bits */
		absolutePosition &= 0xFFF;
		if (Constants.kSensorPhase)
			absolutePosition *= -1;
		if (Constants.kMotorInvert)
      absolutePosition *= -1;
    /* set the quadrature (relative) sensor to match absolute */
		mSRXRaiseMotor.setSelectedSensorPosition(absolutePosition, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new RaiseCommand());
  }
  public void setClaw(double percentOutput) {
		mSRXRaiseMotor.set(ControlMode.PercentOutput, KaiDefFunc.limitAToB(percentOutput, -0.25, 0.25));
	}

  public void holdClaw() {
		mSRXRaiseMotor.set(ControlMode.Position, getClawPosition());
	}
	
	public void holdElevator2(double position) {
		mSRXRaiseMotor.set(ControlMode.Position, position);
	}
	
	public int getClawPosition() {
		return (Math.abs(mSRXRaiseMotor.getSensorCollection().getQuadraturePosition()));
	}
	public void resetClawEncoder() {
		mSRXRaiseMotor.getSensorCollection().setQuadraturePosition(10000, Constants.kTimeoutMs);
	}
}
