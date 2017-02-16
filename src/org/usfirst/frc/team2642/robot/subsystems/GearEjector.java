package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class GearEjector extends PIDSubsystem {
	Victor gearEjector = new Victor(RobotMap.gearEjector);
	AnalogPotentiometer gearEncoder = new AnalogPotentiometer(RobotMap.gearPot);
    // Initialize your subsystem here
    public GearEjector() {
	super(RobotMap.gearP, RobotMap.gearI, RobotMap.gearD);
    	disable();
    }

    public void eject(double speed){
		gearEjector.set(speed);
	}
	
    public void initDefaultCommand() {}

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return gearEncoder.pidGet();
    }

    protected void usePIDOutput(double output) {
    	eject(output);
    	
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
    
    public void climbUp(){
		gearEjector.set(1.0);
	}
	
	//Grab the rope
	public void grabRope(){
		gearEjector.set(0.5);
	}
	
	//Stop climbing
	public void climbStop(){
		gearEjector.set(0.0);
	}
	
	//Go back down the rope
	public void climbBack(){
		gearEjector.set(-0.25);
	}
    
    
    
    
}
