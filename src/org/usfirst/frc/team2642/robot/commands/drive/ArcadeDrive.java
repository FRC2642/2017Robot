package org.usfirst.frc.team2642.robot.commands.drive;

import org.usfirst.frc.team2642.robot.Robot;
import org.usfirst.frc.team2642.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.GenericHID.Hand;



public class ArcadeDrive extends Command {

	static boolean flip = false;
	static boolean buttonState = false;
	
    public ArcadeDrive() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {}

    //Sets if the drive orientation is reversed
    public static void setFlip(){
    	flip = !flip;
    }
    
    protected void execute() {
    	//Drives the robot in different orientations based on a driver button input
    	if(flip){
    		//High speed gear in front
    		if(OI.getxBox().getRawAxis(2) > 0.6){
	        	Robot.driveTrain.drive(-OI.getxBox().getY(Hand.kLeft) * 1.1, OI.getxBox().getX(Hand.kLeft) * 0.8);
	    	}else{
	    	//Low speed gear in front
	    		Robot.driveTrain.drive(-OI.getxBox().getY(Hand.kLeft) * 0.6, OI.getxBox().getX(Hand.kLeft) * 0.8);
	    	}
    	}
    	else{
    		//Overdrive
	    	if(OI.getxBox().getRawAxis(3) > 0.6){
	    		Robot.driveTrain.drive(OI.getxBox().getY(Hand.kLeft) * 1.1, OI.getxBox().getX(Hand.kLeft) * 1.1);
	    	//Fast Speed
	    	}else if(OI.getxBox().getRawAxis(2) > 0.6){
	        	Robot.driveTrain.drive(OI.getxBox().getY(Hand.kLeft) * 1.1, OI.getxBox().getX(Hand.kLeft) * 0.8);
	    	}else{
    		//Low speed
	    		Robot.driveTrain.drive(OI.getxBox().getY(Hand.kLeft) * 0.6, OI.getxBox().getX(Hand.kLeft) * 0.8);
	    	}
    	}
    	//Low speed turning is faster because the turning was awful. High speed turning is slower because it was too sensitive
        //#TokyoDrift
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
