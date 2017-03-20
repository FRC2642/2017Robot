package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.GearTargetInfo;
import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LookForGear extends Command {

	boolean left;
	
    public LookForGear(boolean left) {
    	left = this.left;
    	requires(Robot.driveTrain);
    	requires(Robot.gearEjector);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(left){
    		Robot.driveTrain.drive(0, -RobotMap.drivePegCorrection);
    	}else{
    		Robot.driveTrain.drive(0, RobotMap.drivePegCorrection);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(GearTargetInfo.getGearCenterX()) < 30);
    }

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}