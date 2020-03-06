import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * SERPENTINE - a robot by (your name here)
 */
public class SERPENTINE extends AdvancedRobot
{
	/**
	 * run: SERPENTINE's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
			// Replace the next 4 lines with any behavior you would like'
		setAdjustRadarForRobotTurn(true);
		setAdjustGunForRobotTurn(false);
		while(true) {
			doScan(360);
		}
	}
	
	public void doScan(double bearing) {
		ahead(50);
		if (bearing > 0) {
			turnRadarRight(bearing);
		} else {
			turnRadarLeft(-bearing);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		double bearing = e.getBearing();
		
		if (bearing > 0) {
			setTurnRightDegrees(bearing);
			//turnGunRight(gunBearing);
		} else {
			setTurnLeftDegrees(-bearing);
			//turnGunLeft(-gunBearing);
		}

		fire(3);
		ahead(150);
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		
	}	
}
