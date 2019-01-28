/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
/**
 * Add your docs here.
 */
public class DriveSubsysetm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  PWMVictorSPX mSPLeftMotor;
  PWMVictorSPX mSPRightMotor;
  DifferentialDrive mDrive;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }

  public DriveSubsysetm(){
    mSPLeftMotor = new PWMVictorSPX(RobotMap.MOTOR_LEFT);
    mSPRightMotor = new PWMVictorSPX(RobotMap.MOTOR_RIGHT);
    mSPLeftMotor.setInverted(true);
    mSPRightMotor.setInverted(true);
    mDrive= new DifferentialDrive(mSPLeftMotor, mSPRightMotor);
  }

  public void stopDrive(){
    mDrive.stopMotor();
  }

  public void autoArcadeDrive(double xSpeed, double zRotation) {
		mDrive.arcadeDrive(xSpeed, zRotation);
  }

  public void autoTankDrive(double leftSpeed, double rightSpeed) {
		mDrive.tankDrive(leftSpeed, rightSpeed);
  }
  
  public void teleopDrive(Joystick MyJoystick){
    if(MyJoystick.getRawButton(5)) {
      mDrive.tankDrive(MyJoystick.getThrottle()*-1.0, MyJoystick.getY()*-1.0);
    }
    else if(MyJoystick.getRawButton(7)){
      mDrive.tankDrive(MyJoystick.getThrottle()*0.6,MyJoystick.getThrottle()*0.6);
    }
    else{
      mDrive.tankDrive(MyJoystick.getThrottle()*-0.8, MyJoystick.getY()*-0.8);
    }
  } 
}
