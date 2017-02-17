package org.usfirst.frc.team2642.robot.commands.gear;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GearPID extends Command {

    public GearPID() {
    	requires(Robot.gearEjector);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearEjector.setSetpoint(RobotMap.gearRest);
    	Robot.gearEjector.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	System.out.println(Robot.gearEjector.getPosition());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	System.out.println(Robot.gearEjector.getSetpoint() - Robot.gearEjector.getPosition());
        return Math.abs(Robot.gearEjector.getSetpoint() - Robot.gearEjector.getPosition()) < 0.1;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
