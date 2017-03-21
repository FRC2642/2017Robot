package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearIntake extends Subsystem {
	Victor gearIntake = new Victor(RobotMap.gearIntake);
	public DigitalInput gearLimit = new DigitalInput(RobotMap.gearLimit);

			//Good
	public void gearIntakeCollect(){
		System.out.print(gearLimit.get());
		if(!gearLimit.get()){
			gearIntake.set(-1.0);
		}
	}
	
	public void gearIntakeEject(){
		gearIntake.set(1.0);
	}
	
	public void gearIntakeOff() {
		gearIntake.set(0.0);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

