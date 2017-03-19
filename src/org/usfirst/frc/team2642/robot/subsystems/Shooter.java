package org.usfirst.frc.team2642.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.shooter.ShooterOff;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	Victor flywheel = new Victor(RobotMap.flywheel);
	Victor shooterControl = new Victor(RobotMap.shooterControl);
	Relay ballSpinner = new Relay(RobotMap.ballSpinner);
	
	public void spinUp(){
		flywheel.set(-1.0);
	}
	public void shoot(){
		shooterControl.set(-1.0);
	}

	public void ballSpinnerForward() {
		ballSpinner.set(Relay.Value.kForward);
	}

	public void ballSpinnerReverse() {
		ballSpinner.set(Relay.Value.kReverse);
	}

	public void ballSpinnerOff() {
		ballSpinner.set(Relay.Value.kOff);
	}

	public void stuck(){
		flywheel.set(0.5);
		shooterControl.set(1.0);
	}
	
	public void off(){
		flywheel.set(0);
		shooterControl.set(0);
	}
	
	public void setSpeed(double speed){
		flywheel.set(speed);
		shooterControl.set(.5);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ShooterOff());
    }
}

