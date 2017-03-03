package org.usfirst.frc.team2642.robot.commands.auto;

import org.usfirst.frc.team2642.robot.commands.intake.IntakeIn;
import org.usfirst.frc.team2642.robot.commands.shooter.Shoot;
import org.usfirst.frc.team2642.robot.commands.shooter.SpinUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AimAndShoot extends CommandGroup {

    public AimAndShoot() {
    	addParallel(new AimTurret(), 1);
    	addSequential(new SpinUp(), 1);
    	addParallel(new IntakeIn(), 5);
    	addSequential(new Shoot(), 5);
    }
}
