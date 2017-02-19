package org.usfirst.frc.team2642.robot.commands.auto;

import org.usfirst.frc.team2642.robot.commands.drive.DegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.DriveAtPeg;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;
import org.usfirst.frc.team2642.robot.commands.gear.EjectGear;
import org.usfirst.frc.team2642.robot.commands.gear.SetCameraGearVision;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearAuto extends CommandGroup {

    public GearAuto() {
    	addSequential(new SetCameraGearVision(true));
    	addSequential(new InchesDrive(-70));
    	addSequential(new DegreesTurnDrive(55));
    	addSequential(new DriveAtPeg(5.0));
    	addSequential(new InchesDrive(-16.0));
    	addSequential(new EjectGear());
    	addSequential(new InchesDrive(36.0));
    	addSequential(new DegreesTurnDrive(29.0));
    	addSequential(new InchesDrive(50.0));
    	addSequential(new Wait(1.5));
    	addSequential(new InchesDrive(-18.0));
    	addSequential(new DegreesTurnDrive(-70.0));
    	addSequential(new AimTurret());
    	addSequential(new SetCameraGearVision(false));
    }
}
