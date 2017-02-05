package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	
	Spark climber = new Spark(RobotMap.climber);
	
	public void climbUp(){
		climber.set(1.0);
	}
	
	public void grabRope(){
		climber.set(0.5);
	}
	
	public void climbStop(){
		climber.set(0.0);
	}
	
	public void climbBack(){
		climber.set(-0.25);
	}
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

