
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.commands.Christmas;
import org.usfirst.frc.team2212.robot.commands.MovePiston;

import com.spikes2212.utils.XboXUID;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /* GEVALD */ {
	private XboXUID navigator = new XboXUID(0);

	// navigator
	private Button piston1Open;
	private Button piston1Close;
	private Button piston2Open;
	private Button piston2Close;
	private Button christmasTree;

	public OI() {
		initNavigator();
	}

	private void initNavigator() {
		piston1Open = navigator.getBlueButton();
		piston1Close = navigator.getRedButton();
		piston2Open = navigator.getLeftButton();
		piston2Close = navigator.getRightButton();
		christmasTree = navigator.getRBButton();

		piston1Close.whenPressed(new MovePiston(Robot.piston1, DoubleSolenoid.Value.kReverse, 1));
		piston2Close.whenPressed(new MovePiston(Robot.piston2, DoubleSolenoid.Value.kReverse, 1));
		piston1Open.whenPressed(new MovePiston(Robot.piston1, DoubleSolenoid.Value.kForward, 1));
		piston2Open.whenPressed(new MovePiston(Robot.piston2, DoubleSolenoid.Value.kForward, 1));
		christmasTree.toggleWhenPressed(new Christmas(Robot.ledStrip));
	}

}