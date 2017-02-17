package org.usfirst.frc.team2642.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2642.robot.commands.climber.* ;
import org.usfirst.frc.team2642.robot.commands.gear.*;
import org.usfirst.frc.team2642.robot.commands.intake.*;
import org.usfirst.frc.team2642.robot.commands.shooter.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//Xbox Controller on USB port 0
	private static XboxController xBox = new XboxController(0);
	Button xBoxA = new JoystickButton(xBox, 1);	//A Button
	Button xBoxB = new JoystickButton(xBox, 2);	//B Button
	Button xBoxX = new JoystickButton(xBox, 3);	//X Button
	Button xBoxY = new JoystickButton(xBox, 4);	//Y Button
	Button xBoxLB = new JoystickButton(xBox, 5);	//Left Bumper
	Button xBoxRB = new JoystickButton(xBox, 6);	//Right Bumper
	Button xBoxSelect = new JoystickButton(xBox, 7);	//Select
	Button xBoxStart = new JoystickButton(xBox, 8);	//Start
	Button xBoxL3 = new JoystickButton(xBox, 9);	//Left Stick
	Button xBoxR3 = new JoystickButton(xBox, 10);	//Right Stick
	
	public static XboxController getxBox(){
		return xBox;
	}
	
	private static Joystick auxillary = new Joystick(1);
	Button trigger = new JoystickButton(auxillary, 1);
	Button sideTrigger = new JoystickButton(auxillary, 2);
	Button side7 = new JoystickButton(auxillary, 7);
	Button side9 = new JoystickButton(auxillary, 9);
	Button side11 = new JoystickButton(auxillary, 11);

	
	
	public static Joystick getAux(){
		return auxillary;
	}
		
	public OI(){
		//Changes the vision mode
		xBoxLB.whenPressed(new SetCameraBoilerVision(true));
		xBoxLB.whenReleased(new SetCameraBoilerVision(false));
		xBoxRB.whenPressed(new SetCameraGearVision(true));
		xBoxRB.whenReleased(new SetCameraGearVision(false));
		
		//Climber
		side11.whenReleased(new ClimbStop());
		side9.whileHeld(new GrabRope());
		side9.whenReleased(new ClimbStop());
		side7.whileHeld(new ClimbUp());
		side7.whenReleased(new ClimbStop());
		
		
		//Gear
		xBoxY.whenPressed(new EjectGear());
		
		//Intake
		xBoxA.whenPressed(new IntakeIn());
		xBoxA.whenReleased(new IntakeOff());
		xBoxX.whenPressed(new IntakeOut());
		xBoxX.whenReleased(new IntakeOff());;;
		
		//Shooter
		xBoxB.toggleWhenPressed(new ShooterOff());
		xBoxSelect.whileHeld(new ShooterStuck());
		xBoxY.whileHeld(new Shoot());
		sideTrigger.whileHeld(new ManualTurret());
		sideTrigger.whileHeld(new ManualShootSpeed());
	}
	
}