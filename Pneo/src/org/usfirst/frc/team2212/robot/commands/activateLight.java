package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class activateLight extends Command {

	private int port;
	private boolean buttonStart;

	public activateLight(double timeout) {
		requires(Robot.signalLight);
		setTimeout(timeout);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (Robot.signalLight.isGameRunning()) {
			this.port = Robot.random.nextInt(7);
			buttonStart = Robot.signalLight.buttons[port].get();
			Robot.signalLight.changeLight(port, true);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Robot.signalLight.isGameRunning() && Robot.signalLight.buttons[port].get() ^ buttonStart)
			Robot.score++;
		return isTimedOut()
				|| (Robot.signalLight.buttons[port].get() ^ buttonStart && Robot.signalLight.isGameRunning());
	}

	// Called once after isFinished returns true
	protected void end() {
		if (Robot.signalLight.isGameRunning()) {
			Robot.signalLight.addTime();
		}
		Robot.signalLight.changeLight(port, false);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
