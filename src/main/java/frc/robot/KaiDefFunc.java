/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class KaiDefFunc {

    public static double limitAToB(double value, Double min, double max) {
	    if (value > max) {
	      return max;
	    }
	    if (value < min) {
	      return min;
	    }
	    return value;
	}
	
	public static double limitN1ToP1(double value) {
	    if (value > 1.0) {
	      return 1.0;
	    }
	    if (value < -1.0) {
	      return -1.0;
	    }
	    return value;
	}
	
	public static double limit0To1(double value) {
	    if (value > 1.0) {
	      return 1.0;
	    }
	    if (value < 0) {
	      return 0;
	    }
	    return value;
	}
	
    public static double applyDeadband(double value, double deadband) {
	    if (Math.abs(value) > deadband) {
	      if (value > 0.0) {
	        return (value - deadband) / (1.0 - deadband);
	      } else {
	        return (value + deadband) / (1.0 - deadband);
	      }
	    } else {
	      return 0.0;
	    }
    }
}
