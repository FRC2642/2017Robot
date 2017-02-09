package org.usfirst.frc.team2642.robot;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;

/**
 * Created by Christian on 2/8/2017.
 */
public class GearTargetInfo {
	private static double gearCenterY = Double.MAX_VALUE;
	private static int numTargets = 0;
	private static ArrayList<MatOfPoint> filterContours;
	private static Rect gearRec1;
	private static Rect gearRec2;
	public static final Object gearImgLock = new Object();
	private static double gearCenterX1 = Double.MAX_VALUE;
	private static double gearCenterY1 = Double.MAX_VALUE;
	private static double gearTargetArea1 = Double.MAX_VALUE;
	private static double gearCenterX2 = Double.MAX_VALUE;
	private static double gearCenterY2 = Double.MAX_VALUE;
	private static double gearTargetArea2 = Double.MAX_VALUE;
	private static double gearCenterX = Double.MAX_VALUE;

	public static double getGearCenterX1() {
		return gearCenterX1;
	}

	public static double getGearCenterY1() {
		return gearCenterY1;
	}

	public static double getGearTargetArea1() {
		return gearTargetArea1;
	}

	public static double getGearCenterX2() {
		return gearCenterX2;
	}

	public static double getGearCenterY2() {
		return gearCenterY2;
	}

	public static double getGearTargetArea2() {
		return gearTargetArea2;
	}

	public static double getGearCenterX() {
		return gearCenterX;
	}

	public static double getGearCenterY() {
		return gearCenterY;
	}

	public void setFilterContours(ArrayList<MatOfPoint> matOfPoints) {
		synchronized (gearImgLock) {
			filterContours = matOfPoints;
			if (filterContours.size() >= 2) {
				numTargets = 2;
				gearRec1 = Imgproc.boundingRect(matOfPoints.get(0));
				gearRec2 = Imgproc.boundingRect(matOfPoints.get(1));
				//Finds the center and area of each rectangle
				setTarget1(gearRec1, true);
				setTarget2(gearRec2, true);
				//Finds the center between both rectangles
				setTargetCenter(true);

			} else if (filterContours.size() >= 1) {
				numTargets = 1;
				gearRec1 = Imgproc.boundingRect(matOfPoints.get(0));
				//Finds the center and area of each rectangle
				setTarget1(gearRec1, true);
				setTarget2(gearRec2, false);
				//Finds the center between both rectangles
				setTargetCenter(false);
			} else {
				numTargets = 0;
				setTarget1(gearRec1, false);
				setTarget2(gearRec2, false);
				setTargetCenter(false);
			}
		}
	}

	private static void setTarget1(Rect gearRec1, Boolean visible) {
		if(visible) {
			gearCenterX1 = 2 * gearRec1.x + gearRec1.width - (RobotMap.IMG_WIDTH / 2);
			gearCenterY1 = 2 * gearRec1.y + gearRec1.height - (RobotMap.IMG_HEIGHT / 2);
			gearTargetArea1 = gearRec1.area();
		} else {
			gearCenterX1 = Double.MAX_VALUE;
			gearCenterY1 = Double.MAX_VALUE;
			gearTargetArea1 = Double.MAX_VALUE;
		}
	}

	private static void setTarget2(Rect gearRec2, Boolean visible) {
		if(visible) {
			gearCenterX2 = 2 * gearRec2.x + gearRec2.width - (RobotMap.IMG_WIDTH / 2);
			gearCenterY2 = 2 * gearRec2.y + gearRec2.height - (RobotMap.IMG_HEIGHT / 2);
			gearTargetArea2 = gearRec2.area();
		} else {
			gearCenterX2 = Double.MAX_VALUE;
			gearCenterY2 = Double.MAX_VALUE;
			gearTargetArea2 = Double.MAX_VALUE;
		}
	}

	private static void setTargetCenter(Boolean visible) {
		if(visible) {
			gearCenterX = gearCenterX1 + gearCenterX2;
			gearCenterY = gearCenterY1 + gearCenterY2;
		} else {
			gearCenterX = Double.MAX_VALUE;
			gearCenterY = Double.MAX_VALUE;
		}
	}

	public static int getNumTargets() {
		return numTargets;
	}
}
