import robocode.*;
import java.awt.Color;

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
	    setColors(Color.red, Color.blue, Color.blue);
        setAdjustGunForRobotTurn(true);
        setAdjustRadarForGunTurn(false);
		
		while(true) {
			turnGunLeft(160);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		double bearing = e.getBearing();
		double range = e.getDistance();
    	
		if (range < 200) {
			fire(2);
		} else if (range < 100) {
			fire(3);
		}
		
		
		setTurnRightDegrees(bearing + 30);
		if (range < 150) {
			setTurnRightDegrees(bearing + 180);
		}
		
        setTurnGunRight(getHeading() + bearing - getRadarHeading());
        setAhead(500);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {

	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		setTurnRight(160);
	}
	public void onHitRobot(HitRobotEvent e) {
		// Replace the next line with any behavior you would like
		setTurnRight(160);
	}
}
