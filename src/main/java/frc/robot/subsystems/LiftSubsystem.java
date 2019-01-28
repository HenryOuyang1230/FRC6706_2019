/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class LiftSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  TalonSRX mSRXLiftMotor1;
  TalonSRX mSRXLiftMotor2;

  public LiftSubsystem(){
    mSRXLiftMotor1 = new TalonSRX(RobotMap.MOTOR_LIFT_1);
    mSRXLiftMotor2 = new TalonSRX(RobotMap.MOTOR_LIFT_2);
    mSRXLiftMotor1.setInverted(false);
    mSRXLiftMotor2.setInverted(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void startMotor(double speed){
    mSRXLiftMotor1.set(ControlMode.PercentOutput, speed);
    mSRXLiftMotor2.set(ControlMode.PercentOutput, speed);
  }

  public void stopMotor(){
    mSRXLiftMotor1.set(ControlMode.PercentOutput, 0);
    mSRXLiftMotor2.set(ControlMode.PercentOutput, 0);
  }
}
