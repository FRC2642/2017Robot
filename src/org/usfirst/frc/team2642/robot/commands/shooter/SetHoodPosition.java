package org.usfirst.frc.team2642.robot.commands.shooter;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SetHoodPosition extends InstantCommand {

	double position;
	
    public SetHoodPosition(double position) {
    	requires(Robot.hood);
    	this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.hood.setHood(position);
    }

}
