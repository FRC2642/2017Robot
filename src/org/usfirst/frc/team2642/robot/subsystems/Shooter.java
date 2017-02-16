package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.shooter.ShooterOff;
import org.usfirst.frc.team2642.robot.commands.shooter.SpinUp;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	Victor flywheel = new Victor(RobotMap.flywheel);
	Victor shooterControl = new Victor(RobotMap.shooterControl);
	
	public void spinUp(){
		flywheel.set(1.0);
	}
	public void shoot(){
		shooterControl.set(1.0);
	}

	public void stuck(){
		flywheel.set(-0.5);
		shooterControl.set(-1.0);
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

