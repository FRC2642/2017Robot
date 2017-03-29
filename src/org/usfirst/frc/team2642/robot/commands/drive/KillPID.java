package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class KillPID extends InstantCommand {

    public KillPID() {
    	requires(Robot.driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.driveTrain.disable();
    }

}
