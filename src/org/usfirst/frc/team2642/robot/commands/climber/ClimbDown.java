package org.usfirst.frc.team2642.robot.commands.climber;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbDown extends Command {

    public ClimbDown() {
    	requires(Robot.gearEjector);
    }

    protected void initialize() {}

    //Reverses the direction of the climber
    protected void execute() {
    	Robot.gearEjector.climbBack();
    }

    protected boolean isFinished() {
        return false;
   }

    protected void end() {}

    protected void interrupted() {}
}
