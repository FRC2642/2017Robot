package org.usfirst.frc.team2642.robot.commands.auto;

import org.usfirst.frc.team2642.robot.commands.drive.DegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.DriveAtPeg;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;
import org.usfirst.frc.team2642.robot.commands.drive.LookForGear;
import org.usfirst.frc.team2642.robot.commands.gear.EjectGear;
import org.usfirst.frc.team2642.robot.commands.gear.SetCameraGearVision;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedFeederGear extends CommandGroup {

    public RedFeederGear() {
    	/*
    	 * Autonomous to place the gear by the feeder station and prepare for gear runs
    	 * 
    	 * Process:
    	 * 1.Set vision mode, drive to near the peg, and turn
    	 * 2.Place the gear
    	 * 3.Back up
    	 * 4.Turn toward feeder station on other side
    	 * 5.TODO add driving through most of neutral zone to get close to feeder station
    	 * 6.TODO determine if the robot's orientation should be flipped in this auto for faster gear runs
    	 */
    	addSequential(new SetCameraGearVision(true));
    	addSequential(new InchesDrive(-70));
    	addSequential(new LookForGear(false));
//    	addSequential(new DegreesTurnDrive(55));
    	addSequential(new DriveAtPeg(5.0));
    	addSequential(new InchesDrive(-16.0));
    	addSequential(new EjectGear());
    	addSequential(new InchesDrive(36.0));
    	addSequential(new DegreesTurnDrive(-55.0));
    	addSequential(new SetCameraGearVision(true));

    }
}
