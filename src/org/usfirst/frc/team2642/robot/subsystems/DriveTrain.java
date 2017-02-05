package org.usfirst.frc.team2642.robot.subsystems;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.RobotMap;
import org.usfirst.frc.team2642.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DriveTrain extends PIDSubsystem {
	private boolean isDriveStraight = true;
	
	public DriveTrain() {
		super(RobotMap.driveP, RobotMap.driveI, RobotMap.driveD);
		disable();
	}

	RobotDrive robotdrive = new RobotDrive(RobotMap.frontLeft,
										   RobotMap.rearLeft,
										   RobotMap.frontRight,
										   RobotMap.rearRight);		
	
	Encoder lEncoder = new Encoder(RobotMap.lEncoder1, RobotMap.lEncoder2, false, Encoder.EncodingType.k4X);
	Encoder rEncoder = new Encoder(RobotMap.rEncoder1, RobotMap.rEncoder2, false, Encoder.EncodingType.k4X);


	public void drive(double y, double x){
		robotdrive.arcadeDrive(-y, -x);
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
	
	public double encoderInches(double encoderValue){
		return encoderValue;
	}

	public double leftEncoderInches(){
		return encoderInches(getEncoderLeft());
	}
	
	public double rightEncoderInches(){
		return encoderInches(getEncoderRight());
	}
	
	public void setIsDriveStraight(boolean state){
		isDriveStraight = state;
	}
	
	public void driveStraight(double speed){
		double correction = 0.0;
		if(Math.abs(leftEncoderInches() - rightEncoderInches()) > RobotMap.driveForwardOffset){
			if(leftEncoderInches() < rightEncoderInches()){
				correction = -RobotMap.driveCorrection;
			}else{
				correction = RobotMap.driveCorrection;
			}
		}
		drive(speed, correction);
	}
	
	public void driveTurn(double speed){
		double correctionL = 0.0;
		double correctionR = 0.0;
		if(Math.abs(leftEncoderInches() + rightEncoderInches()) > RobotMap.driveForwardOffset){
			if(leftEncoderInches() > rightEncoderInches())
				correctionR = -RobotMap.driveCorrection;
			}else{
				correctionL = -RobotMap.driveCorrection;
			}
		robotdrive.tankDrive(-speed + correctionL, speed + correctionR);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ArcadeDrive());
    }
    
	@Override
	protected double returnPIDInput() {
		if(isDriveStraight)
			return (rightEncoderInches() + leftEncoderInches()) / 2.0;
		else
			return (rightEncoderInches() - leftEncoderInches()) / 2.0;
	}

	@Override
	protected void usePIDOutput(double output) {
		if(isDriveStraight)
			driveStraight(output);		
		else
			driveTurn(output);
	}

}

