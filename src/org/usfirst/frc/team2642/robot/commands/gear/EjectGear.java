package org.usfirst.frc.team2642.robot.commands.gear;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class EjectGear extends Command {

    public EjectGear() {
    	requires(Robot.gearEjector);
    }

    protected void initialize() {
    	Robot.gearEjector.disable();
    	setTimeout(RobotMap.gearTimeout);
    }

    protected void execute() {
    	Robot.gearEjector.eject(1.0);
    }

    protected boolean isFinished() {
    	return isTimedOut();
    }

    protected void end() {
    	Robot.gearEjector.setSetpoint(RobotMap.gearRest);
    	Robot.gearEjector.enable();

    }

    protected void interrupted() {}
}
