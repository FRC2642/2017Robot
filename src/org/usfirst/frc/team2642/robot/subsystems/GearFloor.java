package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class GearFloor extends PIDSubsystem {
	Victor gearRotate = new Victor(RobotMap.gearIntakeRotate);		//Good
	AnalogPotentiometer gearIntakePot = new AnalogPotentiometer(RobotMap.gearIntakePot);
	
    // Initialize your subsystem here
    public GearFloor() {
    	super(RobotMap.gearFloorP, RobotMap.gearFloorI, RobotMap.gearFloorD);	//Good
    	setSetpoint(RobotMap.ground);
    	enable();
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
//    	System.out.println(gearIntakePot.get());
    	return gearIntakePot.pidGet();				//Good
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    }

    protected void usePIDOutput(double output) {
    	gearRotate.set(output * RobotMap.gearFloorAdjust);		//Good
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
