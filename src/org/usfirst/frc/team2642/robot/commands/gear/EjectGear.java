package org.usfirst.frc.team2642.robot.commands.gear;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class EjectGear extends Command {

    public EjectGear() {
    	requires(Robot.gearEjector);
    }

    protected void initialize() {
    	Robot.gearEjector.resetEncoder();
    	Robot.gearEjector.setSetpoint(RobotMap.gearTwoRev);
    	Robot.gearEjector.enable();
    	
    }

    protected void execute() {}

    protected boolean isFinished() {
        return Math.abs(Robot.gearEjector.getSetpoint() - Robot.gearEjector.getPosition()) < RobotMap.gearOffset;
    }

    protected void end() {
    	Robot.gearEjector.disable();
    	Robot.gearEjector.resetEncoder();
    	Robot.gearEjector.setSetpoint(0);
    }

    protected void interrupted() {}
}
