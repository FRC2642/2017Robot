package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;
import edu.wpi.first.wpilibj.Servo;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Hood extends Subsystem {
	
	Servo hood = new Servo(RobotMap.hood);
	
	public void setHood(double position){
		hood.setPosition(position);
	}
	
    public void initDefaultCommand() {}
}

