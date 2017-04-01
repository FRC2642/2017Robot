package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.BoilerTargetInfo;
import org.usfirst.frc.team2642.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;


public class Turret extends PIDSubsystem {
	Victor shooterTurret = new Victor(RobotMap.shooterRotate);
	static AnalogPotentiometer turretPot = new AnalogPotentiometer(RobotMap.turretPot);
	
    // Initialize your subsystem here
    public Turret() {
    	super(RobotMap.turretP, RobotMap.turretI, RobotMap.turretD);
    	setSetpoint(0);
    	disable();
    	
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
    	//setDefaultCommand(new RotateTurret());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public double returnPIDInput() {
    		return BoilerTargetInfo.getBoilerCenterX();
    }
    
    protected void usePIDOutput(double output) {
    	moveTurret(-output);
    }
    
    public static double getPot(){
    	return turretPot.get();
    }
    
    public void moveTurret(double speed){
    	System.out.println("Output: " + speed + " Pot: " + getPot());
    	
    	if((speed > 0) && (getPot() > RobotMap.turretLower)){
    		System.out.println("Right");
    		shooterTurret.set(-0.5*speed);
    	}else if((speed < 0) && (getPot() < RobotMap.turretUpper)){
    		System.out.println("Left");
    		shooterTurret.set(-0.5*speed);
    	}else{
    		shooterTurret.set(0.0);
    	}
    }
    
    
}
