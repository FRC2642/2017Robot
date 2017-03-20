package org.usfirst.frc.team2642.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team2642.robot.RobotMap;

/**
 * Subsystem for the floor gear collector
 */
public class GearFloor extends PIDSubsystem {
	Victor floorGearAngle = new Victor(RobotMap.floorGearAngle);
	Victor floorGearEjector = new Victor(RobotMap.floorGearEjector);
	AnalogPotentiometer floorGearPot = new AnalogPotentiometer(RobotMap.floorGearPot);
	DigitalInput intakeLimitSwitch = new DigitalInput(RobotMap.intakeLimitSwitch);

	// Initialize your subsystem here
	public GearFloor() {
		super(RobotMap.floorGearP, RobotMap.floorGearI, RobotMap.floorGearD);
		disable();
	}

	public void moveAngle(double speed) {
		floorGearAngle.set(speed * 0.2);
	}

	public void collect() {
		if (!intakeLimitSwitch.get())
			floorGearEjector.set(RobotMap.floorGearCollectSpeed);
	}

	public void eject() {
		floorGearEjector.set(-RobotMap.floorGearCollectSpeed);
	}

	public void initDefaultCommand() {
	}

	protected double returnPIDInput() {
		System.out.println(floorGearPot.get());
		return floorGearPot.get() * 5;
	}

	protected void usePIDOutput(double output) {
		//moveAngle(output);
	}
}
