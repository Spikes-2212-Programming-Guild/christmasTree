package org.usfirst.frc.team2212.robot.commands;

import org.usfirst.frc.team2212.robot.subsystems.LedStrip;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

/**
 * WARNING
 * 
 * this code sucks. terrible variable names.
 * 
 * nice class documentation tho
 * 
 * @author probably satan
 * @see WPI_TalonSRX
 * @alsosee PANDORA_SERVER
 * 
 * @version im afraid that's the final one
 * 
 * @category bad design
 * 
 *           hell yea
 * 
 *           merry christmas
 */
public class Christmas extends Command {

	private LedStrip ledStrip;

	private int colorIndex;
	private int numColorsIndex;

	private boolean lastColorChangerValue;
	private boolean lastNumberChangerValue;
	private boolean lastLedButtonValue;

	private boolean ledsOn = true;
	// private boolean prevInput;

	public Christmas(LedStrip ledStrip) {
		requires(ledStrip);

		lastColorChangerValue = ledStrip.getSwitchColorValue();
		lastNumberChangerValue = ledStrip.getSetNumberValue();
		lastLedButtonValue = ledStrip.getTurnOnOffValue();
		// prevLight = ledStrip.getInput();

		colorIndex = 0;
		numColorsIndex = 0;
		this.ledStrip = ledStrip;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		boolean currentColorChangerValue = ledStrip.getSwitchColorValue();
		boolean currentNumberChangerValue = ledStrip.getSetNumberValue();
		boolean currentLedButtonValue = ledStrip.getTurnOnOffValue();

		if (!currentLedButtonValue && lastLedButtonValue) {
			ledsOn = !ledsOn;
		}

		boolean setColor = !currentColorChangerValue && lastColorChangerValue;
		if (setColor) {
			colorIndex++;
			colorIndex %= 3;
		}

		boolean setNumber = !currentNumberChangerValue && lastNumberChangerValue;
		if (setNumber) {

			numColorsIndex++;
			numColorsIndex %= 3;
		}
		System.out.println("color index " + colorIndex);
		System.out.println("color number " + numColorsIndex);

		if (ledsOn) {
			switch (numColorsIndex) {
			case 0:
				ledStrip.setColor(colorIndex == 0, colorIndex == 1, colorIndex == 2);
				break;
			case 1:
				ledStrip.setColor(colorIndex != 0, colorIndex != 1, colorIndex != 2);
				break;
			case 2:
				ledStrip.setColor(true, true, true);
				break;
			}
		} else
			ledStrip.setColor(false, false, false);

		lastColorChangerValue = currentColorChangerValue;
		lastNumberChangerValue = currentNumberChangerValue;
		lastLedButtonValue = currentLedButtonValue;
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
