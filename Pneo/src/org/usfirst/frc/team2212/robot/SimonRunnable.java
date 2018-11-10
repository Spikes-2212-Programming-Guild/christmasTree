package org.usfirst.frc.team2212.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SimonRunnable implements Runnable {

	private Solenoid[] lights = new Solenoid[RobotMap.SIMON.LIGHTS.length];
	private DigitalInput[] buttons = new DigitalInput[RobotMap.SIMON.BUTTONS.length];
	private Calculator calculator;
	private int pressed = -1;

	public SimonRunnable() {
		for (int i = 0; i < lights.length; i++) {
			lights[i] = new Solenoid(RobotMap.SIMON.LIGHTS[i]);
			buttons[i] = new DigitalInput(RobotMap.SIMON.BUTTONS[i]);
		}
		calculator = new Calculator(RobotMap.SIMON.BUTTONS.length);
	}

	public void invert(int num) {
		lights[num].set(!lights[num].get());
	}
	
	public void blinkAll() {
		for (int i = 0; i < lights.length; i++) {
			lights[i].set(true);
		}
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			System.out.println("Sleep Error");
		}
		for (int i = 0; i < lights.length; i++) {
			lights[i].set(false);
		}
		
	}

	public double getScore() {
		return calculator.getScore() - 1;
	}

	@Override
	public void run() {
		int nextColor;
		calculator.resetGame();
		while (true) {
			nextColor = -1;
			if (calculator.isPrinting()) {
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					System.out.println("Sleep Error");
				}

				nextColor = calculator.getNextColor();
				SmartDashboard.putNumber("next", nextColor);
				if (nextColor != -1)
					lights[nextColor].set(true);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Sleep Error");
				}
			}

			else {
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					System.out.println("Sleep Error");
				}
				while (pressed == -1) {
					for (int i = 0; i < buttons.length; i++) {
						if (buttons[i].get())
							pressed = i;
					}
				}
				int action;
				nextColor = pressed;
				SmartDashboard.putNumber("next", nextColor);
				lights[nextColor].set(true);
				pressed = -1;

				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					System.out.println("Sleep Error");
				}
				action = calculator.checkNextColor(nextColor);
				if (action == 2) {
					break;
				} else if (action == 0) {
					break;
				}
			}
			if (nextColor != -1) {
				lights[nextColor].set(false);
			}
		}
		blinkAll();
		pressed = -1;
	}
}
