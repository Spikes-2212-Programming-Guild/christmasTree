/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2212.robot;

import java.util.Random;
import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.subsystems.LedStrip;

import com.spikes2212.dashboard.DashBoardController;
import com.spikes2212.utils.RunnableCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI oi;
	public static LedStrip ledStrip;
	public static DashBoardController dbc = new DashBoardController();
	public static int score = 0;
	public static Random random = new Random();
	public static SimonRunnable simonRunnable;

	// TODO delete me
	// public static DigitalInput button = new
	// public static final Supplier<Boolean> PORT0 = dbc.addBoolean("port 0", );

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */

	@Override
	public void robotInit() {
		oi = new OI();
		dbc.addDouble("score: ", () -> {
			return (double) score;
		});
		ledStrip = new LedStrip(new Solenoid(RobotMap.CHRISTMASS.PCM_ID_NUMBER, RobotMap.CHRISTMASS.BLUE_LED),
				new Solenoid(RobotMap.CHRISTMASS.PCM_ID_NUMBER, RobotMap.CHRISTMASS.GREEN_LED),
				new Solenoid(RobotMap.CHRISTMASS.PCM_ID_NUMBER, RobotMap.CHRISTMASS.RED_LED),
				new DigitalInput(RobotMap.DIO.LIGHT_SENSOR/* FIXME return to light sensor */),
				new DigitalInput(RobotMap.DIO.DIGITAL_INPUT), new DigitalInput(RobotMap.DIO.HALL_EFFECT/* FIXME */));
		simonRunnable = new SimonRunnable();
		dbc.addDouble("Score", simonRunnable::getScore);
		SmartDashboard.putData("start", new RunnableCommand(simonRunnable));
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		dbc.update();
		Preferences.getInstance().putDouble("High Score",
				Math.max(Preferences.getInstance().getDouble("High Score", 0), simonRunnable.getScore()));
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
