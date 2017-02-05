package org.usfirst.frc.team2642.robot.commands.shooter;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SetCameraBoilerVision extends InstantCommand {
	
	private boolean state;

    public SetCameraBoilerVision(boolean state) {
        super();
        this.state = state;
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.setCameraBoilerVision(state);
    }

}
