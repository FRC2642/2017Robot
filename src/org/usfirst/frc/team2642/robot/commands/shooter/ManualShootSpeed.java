package org.usfirst.frc.team2642.robot.commands.shooter;

import org.usfirst.frc.team2642.robot.OI;
import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualShootSpeed extends Command {

    public ManualShootSpeed() {
    	requires(Robot.shooter);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.shooter.setSpeed((OI.getAux().getThrottle()+1.0)/2);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
