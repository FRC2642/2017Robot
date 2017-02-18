package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.drive.ArcadeDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;



public class DriveTrain extends PIDSubsystem {
	//Determines drive type
	private boolean isDriveStraight = true;
	
	public DriveTrain() {
		super(RobotMap.driveP, RobotMap.driveI, RobotMap.driveD);
		disable();
	}

	//Drive
	RobotDrive robotdrive = new RobotDrive(RobotMap.left,
										   RobotMap.right);
	
	//Encoders for drive
	Encoder lEncoder = new Encoder(RobotMap.lEncoder1, RobotMap.lEncoder2, false, Encoder.EncodingType.k4X);
	Encoder rEncoder = new Encoder(RobotMap.rEncoder1, RobotMap.rEncoder2, false, Encoder.EncodingType.k4X);

	//Standard driving
	public void drive(double y, double x){
		robotdrive.arcadeDrive(-y, -x);
	}
	
	public void stop(){
		robotdrive.arcadeDrive(0, 0);
	}
	
	public double getEncoderLeft(){
		return lEncoder.getDistance();
	}
	
	public double getEncoderRight(){
		return rEncoder.getDistance();
	}
	
	public void resetBothEncoders(){
		lEncoder.reset();
		rEncoder.reset();
	}
	
	//Returns a given encoder value as inches
	public double encoderInches(double encoderValue){
		return encoderValue / 12.9;
	}
	
	//Returns the left encoder distance as inches
	public double leftEncoderInches(){
		System.out.println(encoderInches(getEncoderLeft()));
		return encoderInches(getEncoderLeft());
	}
	
	//Returns the right encoder distance as inches
	public double rightEncoderInches(){
		return encoderInches(getEncoderRight());
	}
	
	
	//Changes the autonomous driving type
	public void setIsDriveStraight(boolean state){
		isDriveStraight = state;
	}
	
	//Drives straight in autonomous with PID control
	public void driveStraight(double speed){
		double correction = 0.0;
		//Checks to see if the difference between the left and right is within a margin of error
		if(Math.abs(leftEncoderInches() - rightEncoderInches()) > RobotMap.driveForwardOffset){	
			//Left distance is less than right distance
			if(leftEncoderInches() < rightEncoderInches()){
				correction = -RobotMap.driveCorrection;
			}else{	//Right distance is less than left distance
				correction = RobotMap.driveCorrection;
			}
		}
		drive(-speed, correction);	//Drives with the correction value
	}
	
	//Turns in autonomous with PID control
	public void driveTurn(double speed){
		double correctionL = 0.0;
		double correctionR = 0.0;
		//Checks to see if the difference between the left and right is within a margin of error
		if(Math.abs(leftEncoderInches() + rightEncoderInches()) > RobotMap.driveForwardOffset){
			if(leftEncoderInches() > rightEncoderInches())	//Left distance is greater than right distance
				correctionR = -RobotMap.driveCorrection;
			}else{
				correctionL = -RobotMap.driveCorrection;
			}
		robotdrive.tankDrive(-speed + correctionL, speed + correctionR);	//Drives as a tank drive to correct turning drift
	}
	
	//Drives off of a controller by default
    public void initDefaultCommand() {
    	setDefaultCommand(new ArcadeDrive());
    }
    
	@Override
	protected double returnPIDInput() {
		if(isDriveStraight)
			return (rightEncoderInches() + leftEncoderInches()) / 2.0;	//Returns the average distance of both encoders
		else
			return (rightEncoderInches() - leftEncoderInches()) / 2.0;	//Returns the average distance of both encoders
	}

	@Override
	protected void usePIDOutput(double output) {	//Changes the output based on what driving we are doing
		if(isDriveStraight)
			driveStraight(output);		
		else
			driveTurn(output);
	}

}

