
	package org.usfirst.frc.team2212.robot.commands;

	import org.usfirst.frc.team2212.robot.subsystems.Piston;

	import edu.wpi.first.wpilibj.DoubleSolenoid;
	import edu.wpi.first.wpilibj.command.Command;

	/**
	 *
	 */
	public class MovePiston extends Command {
		Piston piston;
		DoubleSolenoid.Value value;

	    public MovePiston(Piston piston, DoubleSolenoid.Value vlaue,double time) {
	        requires(piston);
	        this.piston = piston;
	        this.value = vlaue;
	        setTimeout(time);
	    }

	    // Called just before this Command runs the first time
	    protected void initialize() {
	    	piston.setSolenoid(value);
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	        return isTimedOut();
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    	piston.setSolenoid(DoubleSolenoid.Value.kOff);
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    }
	}

