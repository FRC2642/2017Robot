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
	
	// USB
	public static int cameraBoiler = 0;
	public static int cameraGear = 1;
}
