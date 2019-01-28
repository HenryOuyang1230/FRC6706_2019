/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //Motors  
  public static final int MOTOR_LEFT = 0;
  public static final int MOTOR_RIGHT = 1;

  /* Raising Motors */
  public static final int MOTOR_RAISE = 0;

  /* Lifting Motors (PWM) */
  public static final int MOTOR_LIFT_1 = 0;
  public static final int MOTOR_LIFT_2 = 1;


  //Buttons(mStick)

  /* Raising Buttons */
  public static final int BUTTON_RAISE = 7;
  public static final int BUTTON_RAISE_F = 8;

  /* Lifting Buttons */
  public static final int BUTTON_LIFT_UP = 5;
  public static final int BUTTON_LIFT_DOWN = 6;
  public static final int BUTTON_LIFT_RESET = 2;

  //Buttons(secStick)
  public static final int BUTTON_RAISE1 = 1;
  public static final int BUTTON_RAISE2 = 2;
  public static final int BUTTON_RAISE3 = 3;
  public static final int BUTTON_RAISE4 = 4;

  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
