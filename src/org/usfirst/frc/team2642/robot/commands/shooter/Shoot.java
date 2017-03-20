package org.usfirst.frc.team2642.robot.commands.shooter;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {

    public Shoot() {
    	requires(Robot.shooter);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.shooter.spinUp();
    	Robot.shooter.shoot();
    	//Robot.shooter.ballSpinnerForward();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.shooter.off();
    }

    protected void interrupted() {}
}
