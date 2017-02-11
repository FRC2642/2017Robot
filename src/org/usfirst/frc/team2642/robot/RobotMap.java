package org.usfirst.frc.team2642.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//PWM
	//RobotDrive
	public static int frontLeft = 2;
	public static int rearLeft = 0;
	public static int frontRight = 1;
	public static int rearRight = 3;
	//Other
	public static int intake = 4;
	public static int climber = 5;
	public static int gearEjector = 6;

	//Analog
	public static int gearUltra;
	public static int turretPot;
	
	//Relay
	
	// USB
	//Cameras
	public static int cameraBoiler = 0;
	public static int cameraGear = 1;
	
	
	//DIO
	//Encoders
	public static int lEncoder1 = 0;
	public static int lEncoder2 = 1;
	public static int rEncoder1 = 2;
	public static int rEncoder2 = 3;
	public static int gearEncoder1 = 4;
	public static int gearEncoder2 = 5;
	//Other
	
	
	//PID
	//Drive
	public static double driveP = 1.0;
	public static double driveI = 0.0;
	public static double driveD = 0.0;
	//Turret
	public static double turretP;	//TODO assign values to these when the turret system is created
	public static double turretI;
	public static double turretD;
	//Gear
	public static double gearP;
	public static double gearI;
	public static double gearD;
	
	

	//Variables
	//Drive
	public static double driveForwardOffset = 0.5;
	public static double driveTurnOffset = 0.5;
	public static double driveCorrection = 0.2;
	//Gear
	public static double gearTwoRev = 100;
	public static double gearOffset = 0.1;
	//Image resoulution constants
	public static final int IMG_WIDTH = 320;
	public static final int IMG_HEIGHT = 240;
	
	
	
}



