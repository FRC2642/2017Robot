package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class GearEjector extends PIDSubsystem {
	Victor gearEjector = new Victor(RobotMap.gearEjector);
	Encoder gearEncoder = new Encoder(RobotMap.gearEncoder1, RobotMap.gearEncoder2, false, Encoder.EncodingType.k4X);
	
    // Initialize your subsystem here
    public GearEjector() {
    	super(RobotMap.gearP, RobotMap.gearI, RobotMap.gearD);
    	disable();
    }

    public void eject(double speed){
		gearEjector.set(speed);
	}
	
	public double getEncoderDistance(){
		return gearEncoder.getDistance();
	}
	
	public void resetEncoder(){
		gearEncoder.reset();
	}
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return gearEncoder.getDistance();
    }

    protected void usePIDOutput(double output) {
    	eject(output);
    	
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
