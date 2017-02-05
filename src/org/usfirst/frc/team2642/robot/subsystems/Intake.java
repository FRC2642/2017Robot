package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	
	Spark intake = new Spark(RobotMap.intake);
	
	public void intakeOn(){
		intake.set(1.0);	
	}
	
	public void intakeOff(){
		intake.set(0.0);
	}
	
	public void intakeStuck(){
		intake.set(-0.25);
	}
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

