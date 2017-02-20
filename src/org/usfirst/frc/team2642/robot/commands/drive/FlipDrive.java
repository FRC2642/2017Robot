package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class FlipDrive extends InstantCommand {

    public FlipDrive() {
    	requires(Robot.driveTrain);
    }

    //Reverses the drive orientation
    protected void initialize() {
    	ArcadeDrive.setFlip();
    }

}
