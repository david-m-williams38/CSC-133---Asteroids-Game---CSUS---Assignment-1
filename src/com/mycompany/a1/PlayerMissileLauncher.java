package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class PlayerMissileLauncher extends MoveableGameObject implements ISteerable {

	// VARIABLES!
	private static final int DEGREE_MAX = 359;
	private static final int CENTER_X = 512;
	private static final int CENTER_Y = 384;
	
	// Default constructor
	public PlayerMissileLauncher() {
		this.setDir(0); // North
		// Starts in center of world
		this.setX(CENTER_X);
		this.setY(CENTER_Y);
		this.setColor(ColorUtil.GREEN);
	}
	
	// LOADED CONSTRUCTOR (Not to be confused with loaded nachos at a construction site...)
	public PlayerMissileLauncher(double x, double y,int speed) {
		this.setX(x);
		this.setY(y);
		this.setSpeed(speed);
		this.setDir(0);
		this.setColor(ColorUtil.GREEN);
	}
	
	// Turns the MissileLauncher for the PS
	public void turn(int degrees)
	{
		int newDirection = this.getDir() + degrees;
		if(newDirection > DEGREE_MAX) {
			newDirection -= 360;
		}
		else if(newDirection < 0) {
			newDirection += 360;
		}
		if(newDirection >= 0 && newDirection <= DEGREE_MAX) {
			this.setDir(newDirection);
		} else {
			System.out.println("PS.ML.Rotation ERROR!\n");
		}
	}
	
	// IMA FIRING MY missile?
	public Missile fire(int speed) {
		// 0 means the PS, zero the hero
		return new Missile(this.getX(), this.getY(), speed, this.getDir(), 0);
	}
	
	// SURPRISE IT ISN'T, oh, it is a toString()
	public String toString() {
		String superS = super.toString();
		String regularS = "PS missile launcher stats = \n";
		return regularS + superS;
	}
	
}
