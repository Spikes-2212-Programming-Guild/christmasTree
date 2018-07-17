package org.usfirst.frc.team2212.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Piston extends Subsystem {

	private DoubleSolenoid solenoid;
	
	public Piston(DoubleSolenoid solo){
		this.solenoid = solo;
	}
	
	public Piston(int forwardChannel, int reverseChannel){
		this(new DoubleSolenoid(forwardChannel, reverseChannel));
	}
	
	public void setSolenoid(DoubleSolenoid.Value value){
		solenoid.set(value);
	}
	
	@Override
	protected void initDefaultCommand() {
	}
}