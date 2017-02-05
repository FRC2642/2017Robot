package org.usfirst.frc.team2642.robot.commands.gear;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SetCameraGearVision extends InstantCommand {
	
	private boolean state;

    public SetCameraGearVision(boolean state) {
        super();
        this.state = state;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.setCameraGearVision(state);
    }

}
