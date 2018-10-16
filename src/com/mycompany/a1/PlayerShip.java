package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class PlayerShip extends Ship implements ISteerable {
	
	// YIPEE MORE VARIABLES
	private int missileCount;
	private PlayerMissileLauncher ml;
	private static final int MISSILE_MAX = 10;
	private static final int DEGREE_MAX = 359;
	private final Point2D INITIALSPAWN = new Point2D(512, 384);
	
	// Default constructor
	public PlayerShip() {
		this.setLoc(INITIALSPAWN);
		this.setColor(ColorUtil.rgb(250, 150, 77));
		this.setSpeed(0);
		this.setDir(0);
		ml = new PlayerMissileLauncher(this.getX(), this.getY(),this.getSpeed());
		missileCount = MISSILE_MAX;
	}
	
	// PML GML METHOD **Decoding.... DECODED >>> Method for PS to find its lost missile launcher**
	public PlayerMissileLauncher getMissileLauncher() {
		return ml;
	}
	
	// Returns the missile left
	public int getMissileCount() {
		return missileCount;
	}
	
	// GET THEM MISSILES BACK
	public void restockMissiles() {
		missileCount = MISSILE_MAX;
	}
	
	// Turns the ship in some ingenious manner, thank you, thank you...
	public void turn(int degrees) {
		int newDirection = this.getDir() + degrees;
		if(newDirection > DEGREE_MAX) {
			newDirection -= 360;
		}
		else if(newDirection < 0) {
			newDirection += 360;
		}
		if(newDirection >= 0 && newDirection <= DEGREE_MAX) {
			this.setDir(newDirection);
		}
		else {
			System.out.println("Could not successfully rotate PS");
		}
	}
	
	// Turns the missile launcher that was previously lost
	public void turnMissileLauncher(int degrees) {
		ml.turn(degrees);
	}
	
	// Fires a missile... I wish it was a nuke instead....
	public Missile fire() {
		missileCount -= 1;
		return ml.fire(this.getSpeed());
	}
	
	// GREAT ANOTHER TOSTRING() METHOD
	public String toString() {
		String superS = super.toString();
		String regularS = "";
		regularS += "Player ship stats: \n";
		regularS += "Missile Count: " + this.getMissileCount() + "\n";
		
		return regularS + superS + ml.toString();
	}
	
}
