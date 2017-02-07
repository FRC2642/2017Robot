package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class GearEjector extends Subsystem {
	Spark gearEjector = new Spark(RobotMap.gearEjector);
	DigitalInput gearEjectorSwitch = new DigitalInput(RobotMap.gearEjectorSwitch);
	
	//Gets if the switch is triggered
	public boolean getSwitchState(){
		return gearEjectorSwitch.get();
	}
	
	//Runs the ejector motor
	public void eject(){
		gearEjector.set(.3);
	}
	
    public void initDefaultCommand() {}
}

