package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class GearEjector extends Subsystem {
	Spark gearEjector = new Spark(RobotMap.gearEjector);
	
	//Ejects the gear
	public void eject(){
		gearEjector.set(.3);
	}
	
    public void initDefaultCommand() {}
}

