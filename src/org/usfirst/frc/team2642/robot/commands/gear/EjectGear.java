package org.usfirst.frc.team2642.robot.commands.gear;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EjectGear extends Command {

    public EjectGear() {
    	requires(Robot.gearEjector);
    }

    protected void initialize() {}

    //Ejects the gear
    protected void execute() {
    	Robot.gearEjector.eject();
    }

    //Stops when the switch is triggered
    protected boolean isFinished() {
        return Robot.gearEjector.getSwitchState();
    }

    protected void end() {}

    protected void interrupted() {}
}
