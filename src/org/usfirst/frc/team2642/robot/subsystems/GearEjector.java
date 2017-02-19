package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearEjector extends PIDSubsystem {
	Victor gearEjector = new Victor(RobotMap.gearEjector);
	AnalogPotentiometer gearEncoder = new AnalogPotentiometer(RobotMap.gearPot);
	AnalogInput gearUltra = new  AnalogInput(RobotMap.gearUltra);
	
    // Initialize your subsystem here
    public GearEjector() {
	super(RobotMap.gearP, RobotMap.gearI, RobotMap.gearD);
    	disable();
    }

    public void eject(double speed){
    	if(speed >= 0.0)
    		gearEjector.set(-speed);
    	else
    		gearEjector.set(speed);
	}
	
    public void initDefaultCommand() {}

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return gearEncoder.get()*5;
    }

    protected void usePIDOutput(double output) {
//    	System.out.println(output);
    	eject(output);
    	
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
    
    public void climbUp(){
		eject(1.0);
	}
	
	//Grab the rope
	public void grabRope(){
		eject(0.5);
	}
	
	//Stop climbing
	public void climbStop(){
		eject(0.0);
	}
	
	public double getUltraInches(){
		return (gearUltra.getAverageVoltage() * 1000 / 9.8);
	}
}
