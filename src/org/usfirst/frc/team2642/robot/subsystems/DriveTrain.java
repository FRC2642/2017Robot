package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	RobotDrive robotdrive = new RobotDrive(RobotMap.frontLeft,
										   RobotMap.rearLeft,
										   RobotMap.frontRight,
										   RobotMap.rearRight);		
		
	
	

	public void drive(double y, double x){
		robotdrive.arcadeDrive(-y, -x);
		
	}
	

	
    public void initDefaultCommand() {
    	setDefaultCommand(new ArcadeDrive());

    }

}

