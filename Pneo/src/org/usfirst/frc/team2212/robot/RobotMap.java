/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2212.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public interface PCM0{
		public static final int Piston1Forward = 5;
		public static final int Piston1Reverse = 4;
		public static final int Piston2Forward = 7;
		public static final int Piston2Reverse = 6;
	}
	
	public interface PCM1{
		public static final int PCM_ID_NUMBER = 1;
		public static final int BLUE_LED = 0;
		public static final int RED_LED = 1;
		public static final int GREEN_LED = 2;
	}
	
	public interface DIO{
		public static final int LIGHT_SENSOR = 0;
	}
	
}