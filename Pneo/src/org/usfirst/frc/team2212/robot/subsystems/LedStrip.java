package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.commands.Christmas;
import org.usfirst.frc.team2212.robot.commands.Halloween;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LedStrip extends Subsystem {

	private Solenoid blue;
	private Solenoid green;
	private Solenoid red;

	public DigitalInput turnOnOff;
	private DigitalInput switchColor;
	private DigitalInput setColorNumber;

	public LedStrip(Solenoid blue, Solenoid green, Solenoid red, DigitalInput switchColor, DigitalInput turnOnOff,
			DigitalInput setColorNumber) {
		this.blue = blue;
		this.green = green;
		this.red = red;
		this.turnOnOff = turnOnOff;
		this.switchColor = switchColor;
		this.setColorNumber = setColorNumber;
	}

	public void setColor(boolean isBlueOn, boolean isGreenOn, boolean isRedOn) {
		blue.set(isBlueOn);
		green.set(isGreenOn);
		red.set(isRedOn);
		System.out.println("value 1 " + isBlueOn);
		System.out.println("value 2 " + isGreenOn);
		System.out.println("value 3 " + isRedOn);
	}

	public boolean getTurnOnOffValue() {
		return turnOnOff.get();
	}

	public boolean getSwitchColorValue() {
		return switchColor.get();
	}

	public boolean getSetNumberValue() {
		return setColorNumber.get();
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new Christmas(this));
	}

}