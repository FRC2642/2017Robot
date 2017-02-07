package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	
	//Intake motor
	Spark intake = new Spark(RobotMap.intake);
	
	//Take in
	public void intakeOn(){
		intake.set(1.0);	
	}
	
	//OFf
	public void intakeOff(){
		intake.set(0.0);
	}
	
	//Backwards (just in case)
	public void intakeStuck(){
		intake.set(-0.25);
	}

    public void initDefaultCommand() {}
}

