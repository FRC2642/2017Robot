package org.usfirst.frc.team2642.robot.commands.climber;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbUp extends Command {

    public ClimbUp() {
    	requires(Robot.climber);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.climber.climbUp();
    }

    protected boolean isFinished() {
        return false;
   }

    protected void end() {}

    protected void interrupted() {}
}
