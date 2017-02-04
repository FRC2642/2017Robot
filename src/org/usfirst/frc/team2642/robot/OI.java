package org.usfirst.frc.team2642.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2642.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private static XboxController xBox = new XboxController(0);
	Button xBoxA = new JoystickButton(xBox, 1);
	Button xBoxB = new JoystickButton(xBox, 2);
	
	public static XboxController getxBox(){
		return xBox;
	}
		
	public OI(){
		xBoxA.whenPressed(new SetCameraBoilerVision(true));
		xBoxA.whenReleased(new SetCameraBoilerVision(false));
		xBoxB.whenPressed(new SetCameraGearVision(true));
		xBoxB.whenReleased(new SetCameraGearVision(false));
	}
	
}
	