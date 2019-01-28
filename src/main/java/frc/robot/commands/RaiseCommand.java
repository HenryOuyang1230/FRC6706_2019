/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class RaiseCommand extends Command {

  int m_setPosition, m_getPosition, m_absvalue;
	double error, m_kP;

  public RaiseCommand(int setPosition, int absvalue, double kP){
    requires(Robot.mRaiseSubsystem);
    m_setPosition = setPosition;
    m_kP = kP;
    m_absvalue = absvalue;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    setTimeout(1.35);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    m_getPosition = Robot.mRaiseSubsystem.getClawPosition();
    error = ((m_setPosition - m_getPosition + 180) * m_kP);
    Robot.mRaiseSubsystem.setClaw(error); 
     
    Robot.mDriveSubsystem.teleopDrive(Robot.m_oi.getJoystick());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
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
