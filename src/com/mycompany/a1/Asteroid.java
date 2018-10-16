package com.mycompany.a1;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public class Asteroid extends MoveableGameObject{

	// Set all variables
	private Random rand = new Random();
	private int size = rand.nextInt(24) + 6;
	private final int GAME_HEIGHT = 768;
	private final int GAME_WIDTH = 1024;
	
	// Default constructor
	public Asteroid() {
		this.setColor(ColorUtil.LTGRAY);
		this.setX(rand.nextInt(GAME_WIDTH));
		this.setY(rand.nextInt(GAME_HEIGHT));
		this.setSpeed(rand.nextInt(10));
		this.setDir(rand.nextInt(359));
	}
	
	// Method to set the randomized size
	public void setSize(int mySize) {
		this.size = mySize;
	}
	
	// Method to get what the randomized size currently is
	public int getSize() {
		return size;
	}
	
	// toString() method
	public String toString() {
		return "Asteroid " + super.toString() + "size= " + size;
	}
	
}
