package org.usfirst.frc.team2642.robot.commands.gearFloor;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class MoveToHold extends InstantCommand {

    public MoveToHold() {
        super();
        requires(Robot.gearFloor);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.gearFloor.setSetpoint(RobotMap.hold);
    }

}
