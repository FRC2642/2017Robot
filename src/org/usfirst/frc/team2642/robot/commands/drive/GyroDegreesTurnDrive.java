package org.usfirst.frc.team2642.robot.commands.drive;

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

public class GyroDegreesTurnDrive extends PIDCommand {

	private double degrees;

	public GyroDegreesTurnDrive(double degrees) {
		super(RobotMap.driveGTurnP, RobotMap.driveGTurnI, RobotMap.driveGTurnD);
		requires(Robot.driveTrain);
		this.degrees = degrees;
		setTimeout(2.0);
	}

	protected void initialize() {
//		Robot.driveTrain.resetBothEncoders();
		setSetpoint(degrees);
	}

	protected void execute() {}

	protected boolean isFinished() {
//		System.out.print("Setpoint: " + getSetpoint()+ " Position: " + getPosition());
		return Math.abs(getSetpoint() - getPosition()) < RobotMap.driveGTurnOffset || isTimedOut();
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
		Robot.driveTrain.driveTurn(-output);
	}
}
