package org.usfirst.frc.team2642.robot.commands.auto;

import org.usfirst.frc.team2642.robot.commands.shooter.Shoot;
import org.usfirst.frc.team2642.robot.commands.shooter.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AimAndShoot extends CommandGroup {

    public AimAndShoot() {
    	addParallel(new AimTurret(), 2);
    	addSequential(new SpinUp(), 2);
    	addSequential(new Shoot(), 5);
    }
}
