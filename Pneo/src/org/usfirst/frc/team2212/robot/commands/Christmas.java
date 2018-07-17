package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.subsystems.LedStrip;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Christmas extends Command {

	private LedStrip ledStrip;

	private int color;

	private boolean prevLight;
	// private boolean prevInput;

	public Christmas(LedStrip ledStrip) {
		requires(ledStrip);

		prevLight = ledStrip.getSensor();
		// prevLight = ledStrip.getInput();

		color = 0;
		this.ledStrip = ledStrip;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		System.out.println("color " + color);

		boolean currentLight = ledStrip.getSensor();

		// if (ledStrip.getInput() && !prevInput) {
		// numOfLights++;
		// numOfLights %= 3;
		// }

		if (currentLight && !prevLight) {
			color++;
			color %= 3;
		}

		// switch (numOfLights) {
		// case 0:
		ledStrip.setColor(color % 3 == 0, color % 3 == 1, color % 3 == 2);
		// case 1:
		// ledStrip.setColor(!(color % 3 == 0), !(color % 3 == 1), !(color % 3
		// == 2));
		// case 2:
		// ledStrip.setColor(true, true, true);
		// }

		// prevInput = ledStrip.getInput();
		prevLight = currentLight;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
