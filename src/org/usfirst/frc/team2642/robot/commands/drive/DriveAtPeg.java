package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.GearTargetInfo;
import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAtPeg extends Command {

	double timeout;
	
    public DriveAtPeg(double timeout) {
    	requires(Robot.gearEjector);
    	requires(Robot.driveTrain);
    	this.timeout = timeout;
    }
    

    protected void initialize() {
    	setTimeout(timeout);
    }

    
    protected void execute() {
    	//Gear center is outside of the offset area
    	if(Math.abs(GearTargetInfo.getGearCenterX()) > RobotMap.drivePegOffset){
    		//Too far right
    		if(GearTargetInfo.getGearCenterX() < -5){
    			Robot.driveTrain.drive(RobotMap.drivePegForward, -RobotMap.drivePegCorrection);
    		}
    		if(GearTargetInfo.getGearCenterX() > 5){
    			Robot.driveTrain.drive(RobotMap.drivePegForward, RobotMap.drivePegCorrection);
    		}
    	}else{
    		Robot.driveTrain.drive(RobotMap.drivePegDefault, 0.0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((Robot.gearEjector.getUltraInches() < RobotMap.pegDistance) || isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
