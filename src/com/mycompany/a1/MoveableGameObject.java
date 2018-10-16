package com.mycompany.a1;

import java.util.Random;

public abstract class MoveableGameObject extends GameObject implements IMoveable{
	
	// Setting all of the magnificent variables
	private Random rand = new Random();
	private int speed =  rand.nextInt(10);
	private int dir = rand.nextInt(359);
	
	// BOB THE CONSTRUCTOR
	public MoveableGameObject() {
		this.dir = getDir();
	}
	
	// Method to set the object's speed
	public void setSpeed(int mySpeed) {
		this.speed = mySpeed;
	}
	
	// Method to set the object's dir
	public void setDir(int dir) {
		this.dir = dir;
	}
	
	// Returns the object's speed
	public int getSpeed() {
		return speed;
	}
	
	// Returns the object's dir
	public int getDir() {
		return dir;
	}
	
	// MOVE METHOD, THE BEST OF THEM ALL
	public void move() {
		int angle = 90 - this.getDir();
		double xChange = Math.cos(angle) * speed;
		double yChange = Math.sin(angle) * speed;
		double newX = this.getX() + xChange;
		double newY = this.getY() + yChange;
		setX(newX);
		setY(newY);
	}

	// Just a regular old toString() method here, nothing much to see...
	public String toString() {
		String myStr = "";
		myStr = super.toString() + "speed=" + this.getSpeed() + " dir=" + this.getDir() + " ";
		return myStr;
	}
	
}
