package org.usfirst.frc.team2212.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LedStrip extends Subsystem {

	private Solenoid blue;
	private Solenoid green;
	private Solenoid red;

	private DigitalInput lightSensor;
	private DigitalInput digitalInput;

	public LedStrip(Solenoid blue, Solenoid green, Solenoid red, DigitalInput lightSensor, DigitalInput digitalInput) {
		this.blue = blue;
		this.green = green;
		this.red = red;
		this.lightSensor = lightSensor;
		this.digitalInput = digitalInput;
	}

	public void setColor(boolean isBlueOn, boolean isGreenOn, boolean isRedOn) {
		blue.set(isBlueOn);
		green.set(isGreenOn);
		red.set(isRedOn);
	}

	public boolean getSensor() {
		return lightSensor.get();
	}

	public boolean getInput() {
		return digitalInput.get();
	}

	@Override
	protected void initDefaultCommand() {
	}

}
