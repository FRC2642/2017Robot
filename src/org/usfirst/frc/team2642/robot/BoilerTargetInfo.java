package org.usfirst.frc.team2642.robot;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;

import java.util.ArrayList;

public class BoilerTargetInfo {
	private static int numTargets = 0;
	private static ArrayList<MatOfPoint> filterContours;
	private static Rect boilerRec1;
	private static final Object boilerImgLock = new Object();
	private static double boilerCenterX = Double.MAX_VALUE;
	private static double boilerCenterY = Double.MAX_VALUE;
	private static double boilerCenterTargetArea = Double.MAX_VALUE;

	public static void setFilterContours(ArrayList<MatOfPoint> matOfPoints) {
		synchronized (boilerImgLock) {
			filterContours = matOfPoints;
			if (filterContours.size() >= 1) {
				numTargets = 1;
				boilerCenterX = 2 * boilerRec1.x + boilerRec1.width - (RobotMap.IMG_WIDTH / 2);
				boilerCenterY = 2 * boilerRec1.y + boilerRec1.height - (RobotMap.IMG_HEIGHT / 2);
				boilerCenterTargetArea = boilerRec1.area();
			} else {
				numTargets = 0;
				boilerCenterX = Double.MAX_VALUE;
				boilerCenterY = Double.MAX_VALUE;
				boilerCenterTargetArea = Double.MAX_VALUE;
			}
		}
	}

	public static double getBoilerCenterX() {
		return boilerCenterX;
	}

	public static double getBoilerCenterY() {
		return boilerCenterY;
	}

	public static double getBoilerCenterTargetArea() {
		return boilerCenterTargetArea;
	}

	public static int getNumTargets() {
		return numTargets;
	}
}
