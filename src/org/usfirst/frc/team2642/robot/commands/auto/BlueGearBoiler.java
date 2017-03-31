package org.usfirst.frc.team2642.robot.commands.auto;

import org.usfirst.frc.team2642.robot.commands.drive.DegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.DriveAtPeg;
import org.usfirst.frc.team2642.robot.commands.drive.GyroDegreesTurnDrive;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;
import org.usfirst.frc.team2642.robot.commands.drive.LookForGear;
import org.usfirst.frc.team2642.robot.commands.gear.EjectGear;
import org.usfirst.frc.team2642.robot.commands.gear.SetCameraGearVision;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BlueGearBoiler extends CommandGroup {

    public BlueGearBoiler() {
    	/*
    	 * Autonomous mode that places a gear, backs up into the hopper for balls, turns, and shoots at the boiler
    	 * TODO add shooter
    	 * 
    	 * Process:
    	 * 1.Set gear cam to dark mode
    	 * 2.Turn and place the gear
    	 * 3.Back up and turn
    	 * 4.Hit hopper and wait a second
    	 * 5.Turn, rotate turret, and shoot at boiler
    	 * 6. ???
    	 * 7.Profit
    	 * 
    	 */
    	addSequential(new SetCameraGearVision(true));
    	addSequential(new InchesDrive(-76));
    	addSequential(new LookForGear(false));
//    	addSequential(new DegreesTurnDrive(55));
    	addSequential(new DriveAtPeg(5.0));
    	addSequential(new InchesDrive(-15.0));
    	addSequential(new EjectGear());
    	addSequential(new InchesDrive(42.0));
//    	addSequential(new DegreesTurnDrive(48.0));
    	addSequential(new GyroDegreesTurnDrive(90.0));
    	addSequential(new InchesDrive(30.0));
    	addSequential(new SetCameraGearVision(false));
//    	addSequential(new DegreesTurnDrive(-65.0));
    	addSequential(new GyroDegreesTurnDrive(35.0));
    	addSequential(new InchesDrive(36.0));
    	addSequential(new AimAndShoot());
    	addSequential(new SetCameraGearVision(false));
    }
}
