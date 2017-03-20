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
	public static int left = 0;
	public static int right = 1;
	//Shooter
	public static int flywheel = 4;
	public static int shooterControl = 5;
	public static int shooterRotate = 6;
	public static int ballSpinner = 8;
	//Other
	public static int intake = 2;
	public static int gearEjector = 3;
	public static int hood = 7;
	public static int floorGearAngle = 9;
	public static int floorGearEjector = 2;

	//Analog
	public static int gearUltra = 3;
	public static int turretPot = 0;
	public static int gearPot = 1;
	public static int floorGearPot = 2;

	//Relay
	
	// USB
	//Cameras
	public static int cameraBoiler = 0;
	public static int cameraGear = 1;
	public static int cameraDriver = 2;
	
	//DIO
	//Encoders
	public static int lEncoder1 = 0;
	public static int lEncoder2 = 1;
	public static int rEncoder1 = 2;
	public static int rEncoder2 = 3;
	public static int intakeLimitSwitch = 4;
	//Other
	
	//PID
	//Drive
	public static double driveStraightP = 0.05;
	public static double driveStraightI = 0.0;
	public static double driveStraightD = 0.001;
	public static double driveTurnP = 0.15;
	public static double driveTurnI = 0.0;
	public static double driveTurnD = 0.0005;
	
	//Turret
	public static double turretP = 0.025;
	public static double turretI = 0.0;
	public static double turretD = 0.0002;
	//Gear
	public static double gearP = 0.1;
	public static double gearI = 0.0;
	public static double gearD = 0.0;
	//Floor Gear
	public static double floorGearP = 0.1;
	public static double floorGearI = 0.0;
	public static double floorGearD = 0.0;

	//Variables
	//Drive
	public static double driveForwardOffset = 0.25;
	public static double driveTurnOffset = 0.25;
	public static double driveCorrection = -0.2;
	public static double drivePegForward = 0.6;
	public static double drivePegCorrection = 0.6;
	public static double drivePegDefault = 0.6;
	public static double drivePegOffset = 8;
	public static double pegDistance = 10;
	
	//Gear
	public static double gearTwoRev = 100;
	public static double gearOffset = 0.1;
	public static double gearTimeout = 1.0;
	public static double gearRest = 0.5;
	public static double floorGearCollectSpeed = 0.5;

	//Image resoulution constants
	public static final int IMG_WIDTH = 320;
	public static final int IMG_HEIGHT = 240;
	//Turret Potentiometer Limits
	public static double turretLower = 0.499;
	public static double turretUpper = 0.640;
	//GearFloor Setpoints
	public static double ground;
	public static double hold;
	
}

//


