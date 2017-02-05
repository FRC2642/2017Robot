package org.usfirst.frc.team2642.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// PWM
	public static int frontLeft = 2;
	public static int rearLeft = 0;
	public static int frontRight = 1;
	public static int rearRight = 3;
	public static int intake = 4;
	public static int climber = 5;

	
	// USB
	public static int cameraBoiler = 0;
	public static int cameraGear = 1;
	
	
	//DIO
	public static int lEncoder1 = 0;
	public static int lEncoder2 = 1;
	public static int rEncoder1 = 2;
	public static int rEncoder2 = 3;
	
	
	//PID
	public static double driveP = 1.0;
	public static double driveI = 0.0;
	public static double driveD = 0.0;

	//Variables
	public static double driveForwardOffset = 0.5;
	public static double driveTurnOffset = 0.5;
	public static double driveCorrection = 0.2;
	
	
	
	
	
}



