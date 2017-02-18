package org.usfirst.frc.team2642.robot.commands.climber;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GrabRope extends Command {

    public GrabRope() {
    	requires(Robot.gearEjector);
    }

    protected void initialize() {
    	Robot.gearEjector.disable();
    }

    //Runs slowly to grab the rope
    protected void execute() {
    	Robot.gearEjector.grabRope();
    }

    protected boolean isFinished() {
        return false;
   }

    protected void end() {}

    protected void interrupted() {}
}
