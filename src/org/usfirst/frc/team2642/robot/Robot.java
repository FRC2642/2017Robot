
package org.usfirst.frc.team2642.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2642.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//Subsystems
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final Climber climber = new Climber();
	public static final Intake intake = new Intake();
	public static final GearEjector gearEjector = new GearEjector();
	public static OI oi;
	
	//Cameras
	public static UsbCamera cameraBoiler;
	public static UsbCamera cameraGear;
	public static final int IMG_WIDTH = 320;
	public static final int IMG_HEIGHT = 240;
	
	//Default Gear Settings
	private VisionThread gearVisionThread;
	private GearTargetInfo gearTargetInfo = new GearTargetInfo();

	//Default Boiler Settings
	private VisionThread boilerVisionThread;
	public static final Object boilerImgLock = new Object();
	public static double boilerCenterX = 0.0;
	public static double boilerCenterY = 0.0;
	public static double boilerCenterTargetArea = 0.0;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		
		//Camera instances
		cameraBoiler = CameraServer.getInstance().startAutomaticCapture("Boiler", RobotMap.cameraBoiler);
		cameraGear = CameraServer.getInstance().startAutomaticCapture("Gear", RobotMap.cameraGear);
		//Camera resolutions
		cameraBoiler.setResolution(IMG_WIDTH, IMG_HEIGHT);
		cameraGear.setResolution(IMG_WIDTH, IMG_HEIGHT);
		//Camera FPS
		cameraBoiler.setFPS(10);
		cameraGear.setFPS(10);
		//Turns off vision by default
		setCameraBoilerVision(false);
		setCameraGearVision(false);
		
		//Vision Thread for gear vision tracking
		gearVisionThread = new VisionThread(cameraGear, new GearPipeline(),gearpipeline -> {		//Sets the pipeline
			synchronized (GearTargetInfo.gearImgLock) {		//Synchronizes on an abstract static object of the GearTargetInfo class
				gearTargetInfo.setFilterContours(gearpipeline.filterContoursOutput());
			}
		});
		gearVisionThread.start();	//Starts the thread for gear vision tracking
		
		
		//Vision thread for Boiler vision tracking
		boilerVisionThread = new VisionThread(cameraBoiler, new BoilerPipeline(), pipeline -> { //Pipeline for boiler vision
	        if (!pipeline.filterContoursOutput().isEmpty()) {
	        	//Creates a rectangle around all of the contours in the boiler pipeline
	            Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
	            synchronized (boilerImgLock) {		//TODO switch this to an object
	            	//Finds the center of the boiler vision targets
	                boilerCenterX = 2*r.x + r.width - (IMG_WIDTH/2);
	                boilerCenterY = 2*r.y + r.height - (IMG_HEIGHT/2);
	                boilerCenterTargetArea = r.area();
	            }
	        }
	    });
		boilerVisionThread.start();	//Starts the thread for boiler tracking
		
		
		//chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	}
	
	//Changes camera mode for the boiler camera
	public static void setCameraBoilerVision(boolean enabled) {
		if(enabled) {	//Vision Mode
			cameraBoiler.setBrightness(0);
			cameraBoiler.setExposureManual(0);
		} else {		//Driving Mode
			cameraBoiler.setBrightness(30);
			cameraBoiler.setExposureManual(35);
		}
	}

	//Changes camera mode for the gear camera
	public static void setCameraGearVision(boolean enabled) {
		if(enabled) {	//Vision Mode
			cameraGear.setBrightness(30);
			cameraGear.setExposureManual(0);
		} else {		//Drive Mode
			cameraGear.setBrightness(10);
			cameraGear.setExposureManual(20);
		}
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		//Sends general vision information to the Smart Dashboard
		SmartDashboard.putNumber("Boiler Center X", boilerCenterX);
		SmartDashboard.putNumber("Boiler Center Y", boilerCenterY);
		SmartDashboard.putNumber("Gear Center X", GearTargetInfo.getGearCenterX());
		SmartDashboard.putNumber("Gear Center Y", GearTargetInfo.getGearCenterY());
		SmartDashboard.putNumber("Number of Gear Targets", GearTargetInfo.getNumTargets());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
