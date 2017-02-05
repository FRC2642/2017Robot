package org.usfirst.frc.team2642.robot.commands.intake;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeOff extends Command {

    public IntakeOff() {
    	requires(Robot.intake);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.intake.intakeOff();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
