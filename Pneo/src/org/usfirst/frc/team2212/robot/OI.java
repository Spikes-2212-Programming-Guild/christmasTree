
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.Christmas;

import com.spikes2212.utils.XboXUID;

import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /* GEVALD */ {
	private XboXUID navigator = new XboXUID(0);

	// navigator
	private Button christmasTree;

	public OI() {
		initNavigator();
	}

	private void initNavigator() {
		christmasTree = navigator.getRBButton();

		christmasTree.toggleWhenPressed(new Christmas(Robot.ledStrip));
	}

}