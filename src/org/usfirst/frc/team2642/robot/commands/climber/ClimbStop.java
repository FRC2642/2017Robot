package org.usfirst.frc.team2642.robot.commands.climber;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClimbStop extends Command {

    public ClimbStop() {
    	requires(Robot.gearEjector);
    }

    protected void initialize() {}

    //Stops the climber
    protected void execute() {
    	Robot.gearEjector.climbStop();
    }

    protected boolean isFinished() {
        return false;
   }

    protected void end() {}

    protected void interrupted() {}
}
