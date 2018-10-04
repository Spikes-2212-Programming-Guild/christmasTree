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
    	buttonStart = Robot.signalLight.buttons[port].get();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.port = Robot.random.nextInt(7);
    	Robot.signalLight.changeLight(port, true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.signalLight.buttons[port].get()^buttonStart)
    		Robot.score++;
        return isTimedOut()||(Robot.signalLight.buttons[port].get()^buttonStart);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.signalLight.changeLight(port, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.signalLight.changeLight(port, false);
    }
}
