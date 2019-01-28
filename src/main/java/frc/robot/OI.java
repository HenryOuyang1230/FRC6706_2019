/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.LiftCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick mJoystick = new Joystick(0);
	Joystick secJoystick = new Joystick(1);
  
	public Joystick getJoystick() {
		return mJoystick;
  }
  
  //Second Joystick
  Button btnRaise1 = new JoystickButton(secJoystick, RobotMap.BUTTON_RAISE1);
  Button btnRaise2 = new JoystickButton(secJoystick, RobotMap.BUTTON_RAISE2);
  Button btnRaise3 = new JoystickButton(secJoystick, RobotMap.BUTTON_RAISE3);
  Button btnRaise4 = new JoystickButton(secJoystick, RobotMap.BUTTON_RAISE4);

  Button btnLiftUp = new JoystickButton(secJoystick, RobotMap.BUTTON_LIFT_UP);
  Button btnLiftDown = new JoystickButton(secJoystick, RobotMap.BUTTON_LIFT_DOWN);
  Button btnLiftReset = new JoystickButton(secJoystick, RobotMap.BUTTON_LIFT_RESET);

  public OI(){
    //Second Joystick

    /* Raising Buttons */
    /*
    btnRaise1.whenPressed(new RaiseCommand( 9800, 200, 0.0005));
    btnRaise2.whenPressed(new RaiseCommand(10300, 200, 0.0005));
    btnRaise3.whenPressed(new RaiseCommand(11100, 200, 0.0005));
    btnRaise4.whenPressed(new RaiseCommand(12200, 200, 0.0007));
    */

    /* Lifting Buttons */
    btnLiftUp.whileHeld(new LiftCommand(0.2));
    btnLiftUp.whenReleased(new LiftCommand(0.1));
    btnLiftDown.whileHeld(new LiftCommand(-0.1));
    btnLiftReset.whenPressed(new LiftCommand(0.0));
    
  }
	
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
