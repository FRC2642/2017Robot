package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SwitchCameras extends InstantCommand {

	private boolean boiler;
    public SwitchCameras(boolean boiler) {
    	this.boiler = boiler;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(boiler){
    		CameraServer.getInstance().removeCamera("Boiler");
    		Robot.cameraBoiler = CameraServer.getInstance().startAutomaticCapture("Boiler", RobotMap.cameraBoiler);
    		Robot.cameraBoiler.setFPS(10);
    		Robot.cameraBoiler.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);

    	}else{
    		CameraServer.getInstance().removeCamera("Boiler");
    		Robot.cameraBoiler = CameraServer.getInstance().startAutomaticCapture("Boiler", RobotMap.cameraFront);
    		Robot.cameraBoiler.setFPS(10);
    		Robot.cameraBoiler.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
    	}
    }
}
