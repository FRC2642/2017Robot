package org.usfirst.frc.team2642.robot.commands.gearFloor;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class MoveToGround extends InstantCommand {

    public MoveToGround() {
    	super();
    	requires(Robot.gearFloor);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearFloor.setSetpoint(RobotMap.ground);
    }
}
