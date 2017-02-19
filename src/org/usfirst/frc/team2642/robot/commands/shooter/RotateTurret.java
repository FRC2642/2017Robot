package org.usfirst.frc.team2642.robot.commands.shooter;

import org.usfirst.frc.team2642.robot.OI;
import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateTurret extends Command {

    public RotateTurret() {
    	requires(Robot.turret);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.turret.setSetpoint(0);
    	Robot.turret.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.turret.getPosition() - Robot.turret.getSetpoint()) < 5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.turret.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
