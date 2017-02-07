package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Climber extends Subsystem {
	
	//Climber motor
	Spark climber = new Spark(RobotMap.climber);
	
	//Climb up the rope
	public void climbUp(){
		climber.set(1.0);
	}
	
	//Grab the rope
	public void grabRope(){
		climber.set(0.5);
	}
	
	//Stop climbing
	public void climbStop(){
		climber.set(0.0);
	}
	
	//Go back down the rope
	public void climbBack(){
		climber.set(-0.25);
	}
	
    public void initDefaultCommand() {}
}

