package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;


public class DegreesTurnDrive extends Command {

	private double degrees;
	
    public DegreesTurnDrive(double degrees) {
    	requires(Robot.driveTrain);
    	this.degrees = degrees;
    }
 
    protected void initialize() {
    	Robot.driveTrain.setDegrees(degrees);
    	Robot.driveTrain.setIsDriveStraight(false);
    	Robot.driveTrain.resetBothEncoders();
    	Robot.driveTrain.enable();
    }

    protected void execute() {}

    protected boolean isFinished() {
        return Math.abs(Robot.driveTrain.getSetpoint() - Robot.driveTrain.getPosition()) < RobotMap.driveTurnOffset;
    }

    protected void end() {
    	Robot.driveTrain.disable();
    }

    protected void interrupted() {
    }
}
