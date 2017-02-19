package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.GearTargetInfo;
import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAtPeg extends Command {

    public DriveAtPeg() {
    	requires(Robot.gearEjector);
    	requires(Robot.driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Math.abs(GearTargetInfo.getGearCenterX()) > 5 ){
    		if(GearTargetInfo.getGearCenterX() < -5){
    			Robot.driveTrain.drive(-0.3, -0.1);
    		}
    		if(GearTargetInfo.getGearCenterX() > 5){
    			Robot.driveTrain.drive(-0.3, 0.1);
    		}
    		
    	}else{
    		Robot.driveTrain.drive(-0.4, 0.0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
