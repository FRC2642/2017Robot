package org.usfirst.frc.team2642.robot.commands.auto;

import org.usfirst.frc.team2642.robot.commands.drive.DriveAtPeg;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;
import org.usfirst.frc.team2642.robot.commands.gear.EjectGear;
import org.usfirst.frc.team2642.robot.commands.shooter.SetCameraBoilerVision;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGear extends CommandGroup {

    public PlaceGear() {
    	/*
    	 * Places the gear from a point somewhat near the peg.
    	 * This could still be improved but it works pretty well
    	 * 
    	 * Process:
    	 * 1. Change camera to dark mode
    	 * 2. Drive to the peg
    	 * 3. Eject the gear
    	 * 4. Drive back from the peg
    	 * 5. Change camera to drive mode
    	 */
    	addSequential(new SetCameraBoilerVision(true));
    	addSequential(new DriveAtPeg(5.0));
    	addSequential(new InchesDrive(-16.0));
    	addSequential(new EjectGear());
    	addSequential(new InchesDrive(30.0));
    	addSequential(new SetCameraBoilerVision(false));
    }
}
