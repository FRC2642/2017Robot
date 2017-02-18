package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;


public class InchesDrive extends Command {

	private double inches;
	
    public InchesDrive(double inches) {
    	requires(Robot.driveTrain);
    	this.inches = inches;
    }

    protected void initialize() {
    	Robot.driveTrain.resetBothEncoders();
    	Robot.driveTrain.setSetpoint(inches);
    	Robot.driveTrain.setIsDriveStraight(true);
    	Robot.driveTrain.enable();
    }

    protected void execute() {}

    protected boolean isFinished() {
        return Math.abs(Robot.driveTrain.getSetpoint() - Robot.driveTrain.getPosition()) < RobotMap.driveForwardOffset;
    }

    protected void end() {
    	Robot.driveTrain.disable();
    }

    protected void interrupted() {}
}
