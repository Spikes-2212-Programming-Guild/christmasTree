package org.usfirst.frc.team2212.robot.subsystems;

import java.util.function.Supplier;

import org.usfirst.frc.team2212.robot.Robot;
import org.usfirst.frc.team2212.robot.RobotMap;
import org.usfirst.frc.team2212.robot.commands.ActiveAndWait;
import org.usfirst.frc.team2212.robot.commands.activateLight;

import com.spikes2212.dashboard.ConstantHandler;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SignalLight extends Subsystem {

	public final DigitalInput[] buttons = new DigitalInput[7];
	public final Solenoid[] lights = new Solenoid[7];
	public static final Supplier<Double> TIME_OF_ROUND= ConstantHandler.addConstantDouble("Time of round", 60); 
	public static double counter = TIME_OF_ROUND.get();

	public SignalLight(int[] buttonPorts, int[] lightPorts) {
		for (int i = 0; i < buttons.length; i++)
			buttons[i] = new DigitalInput(buttonPorts[i]);
		for (int i = 0; i < lights.length; i++)
			lights[i] = new Solenoid(RobotMap.WACK_EM_ALL.PCM_ID_NUMBER, lightPorts[i]);
	}

	public void changeLight(int port, boolean on){
		lights[port].set(on);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new ActiveAndWait(1));
	}
}
