package org.usfirst.frc.team2642.robot.commands.drive;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

public class GyroDegreesTurnDrive extends PIDCommand {

	private double degrees;

	public GyroDegreesTurnDrive(double degrees) {
		super(RobotMap.driveTurnP, RobotMap.driveTurnI, RobotMap.driveTurnD);
		requires(Robot.driveTrain);
		this.degrees = degrees;
//		setTimeout(Math.abs(degrees / 360.0) * 3.0);
	}

	protected void initialize() {
		Robot.driveTrain.resetBothEncoders();
		setSetpoint(Robot.driveTrain.setDegrees(degrees));
	}

	protected void execute() {}

	protected boolean isFinished() {
		return Math.abs(getSetpoint() - getPosition()) < RobotMap.driveTurnOffset || isTimedOut();
	}

	protected void end() {
		Robot.driveTrain.disable();
	}

	protected void interrupted() {
		Robot.driveTrain.disable();
	}

	@Override
	protected double returnPIDInput() {
		return Robot.driveTrain.getGyro();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.driveTrain.driveTurn(output);
	}
}
