package org.usfirst.frc.team2642.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2642.robot.commands.*;
import org.usfirst.frc.team2642.robot.commands.gear.SetCameraGearVision;
import org.usfirst.frc.team2642.robot.commands.shooter.SetCameraBoilerVision;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//Xbox Controller on USB port 0
	private static XboxController xBox = new XboxController(0);
	Button xBoxA = new JoystickButton(xBox, 1);	//A Button
	Button xBoxB = new JoystickButton(xBox, 2);	//B Button
	
	public static XboxController getxBox(){
		return xBox;
	}
		
	public OI(){
		//Changes the vision mode
		xBoxA.whenPressed(new SetCameraBoilerVision(true));
		xBoxA.whenReleased(new SetCameraBoilerVision(false));
		xBoxB.whenPressed(new SetCameraGearVision(true));
		xBoxB.whenReleased(new SetCameraGearVision(false));
	}
	
}