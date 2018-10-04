package org.usfirst.frc.team2212.robot.commands;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ActiveAndWait extends CommandGroup {
	public static final Supplier<Double> WAIT_TIME = ConstantHandler.addConstantDouble("wait time", 0.1);

    public ActiveAndWait(double timeout) {
        addSequential(new activateLight(timeout));
        addSequential(new WaitCommand(WAIT_TIME.get()));
    }
}
