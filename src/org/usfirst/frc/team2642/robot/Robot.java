
package org.usfirst.frc.team2642.robot;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.usfirst.frc.team2642.robot.commands.auto.*;
import org.usfirst.frc.team2642.robot.commands.drive.InchesDrive;
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
	public static final Intake intake = new Intake();
	public static final GearEjector gearEjector = new GearEjector();
	public static final Shooter shooter = new Shooter();
	public static final Turret turret = new Turret();
	public static final Hood hood = new Hood();
	public static final GearIntake gearIntake = new GearIntake();
	public static final GearFloor gearFloor = new GearFloor();
	public static OI oi;

	//Cameras
	public static UsbCamera cameraBoiler;
	public static UsbCamera cameraGear;
	public static MjpegServer cameraFront;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
		
	
	boolean isBlue;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		SmartDashboard.putString("Code Version", "0.1.0");
		oi = new OI();

		//Camera instances
		cameraBoiler = CameraServer.getInstance().startAutomaticCapture("Boiler", RobotMap.cameraBoiler);
		cameraGear = CameraServer.getInstance().startAutomaticCapture("Gear", RobotMap.cameraGear);
		cameraFront = new MjpegServer("Front", 0);
			//Camera resolutions
		cameraBoiler.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
		cameraGear.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);

		//Camera FPS
		cameraBoiler.setFPS(10);
		cameraGear.setFPS(10);
		
		//Turns off vision by default
		setCameraBoilerVision(false);
		setCameraGearVision(true);

		//Vision Thread for gear vision tracking
		VisionThread gearVisionThread = new VisionThread(cameraGear, new GearPipeline(), gearpipeline -> {
			GearTargetInfo.setFilterContours(gearpipeline.filterContoursOutput());
		});
		gearVisionThread.start();


		//Vision thread for Boiler vision tracking
		VisionThread boilerVisionThread = new VisionThread(cameraBoiler, new BoilerPipeline(), boilerPipeline -> {
			BoilerTargetInfo.setFilterContours(boilerPipeline.filterContoursOutput());
		});
		boilerVisionThread.start();
	}

	//Changes camera mode for the boiler camera
	public static void setCameraBoilerVision(boolean enabled) {
		if (enabled) {    //Vision Mode
			cameraBoiler.setBrightness(0);
			cameraBoiler.setExposureManual(0);
		} else {        //Driving Mode
			cameraBoiler.setBrightness(30);
			cameraBoiler.setExposureManual(35);
		}
	}

	//Changes camera mode for the gear camera
	public static void setCameraGearVision(boolean enabled) {
		if (enabled) {    //Vision Mode
			cameraGear.setBrightness(30);
			cameraGear.setExposureManual(0);
		} else {        //Drive Mode
			cameraGear.setBrightness(0);
			cameraGear.setExposureManual(20);
		}
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

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
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		cameraGear.setFPS(10);
		DriverStation.Alliance color = DriverStation.getInstance().getAlliance();
		if(color == DriverStation.Alliance.Blue){
			isBlue = true;
		}else{
			isBlue = false;
		}

		driveTrain.resetGyro();
		
		setCameraGearVision(true);
		
		if(isBlue){
			if(oi.dial1.get()){
				autonomousCommand = new BlueGearBoiler();
			}else if(oi.dial2.get()){
				autonomousCommand = new BlueMiddleGear();
			}else if(oi.dial3.get()){
				autonomousCommand = new BlueFeederGear();
			}else if(oi.dial4.get()){
				autonomousCommand = new InchesDrive(96.0);
			}else{
				autonomousCommand = null;
			}
		}
		if(!isBlue){
			if(oi.dial1.get()){
				autonomousCommand = new RedGearBoiler();
			}else if(oi.dial2.get()){
				autonomousCommand = new RedMiddleGear();
			}else if(oi.dial3.get()){
				autonomousCommand = new RedFeederGear();
			}else if(oi.dial4.get()){
				autonomousCommand = new InchesDrive(96.0);
			}else{
				autonomousCommand = null;
			}
		}
		
		
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
		SmartDashboard.putNumber("Gyro", driveTrain.getGyro());
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		setCameraBoilerVision(false);
		setCameraGearVision(false);
		driveTrain.resetGyro();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		//Sends general vision information to the Smart Dashboard
		SmartDashboard.putNumber("Boiler Center X", BoilerTargetInfo.getBoilerCenterX());
		SmartDashboard.putNumber("Boiler Center Y", BoilerTargetInfo.getBoilerCenterY());
		SmartDashboard.putNumber("Gear Center X", GearTargetInfo.getGearCenterX());
		SmartDashboard.putNumber("Gear Center Y", GearTargetInfo.getGearCenterY());
		SmartDashboard.putNumber("Number of Gear Targets", GearTargetInfo.getNumTargets());
		SmartDashboard.putNumber("Potentiometer", Turret.getPot());
		SmartDashboard.putNumber("Ultrasonic Inches", gearEjector.getUltraInches());
		SmartDashboard.putNumber("Gyro", driveTrain.getGyro());
		System.out.println(gearIntake.gearLimit.get());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
