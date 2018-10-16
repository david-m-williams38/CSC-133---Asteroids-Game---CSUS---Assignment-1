package com.mycompany.a1;

public abstract class Ship extends MoveableGameObject{
	
	// ALL MOVEABLE OBJECTS NEED MISSILES, SPECIFICALLY SHIPS. Asteroids haven't weaponized themselves yet
	int missileCount;
	
	// Sets the missiles appropriately
	public void setMissileCount(int missiles) {
		this.missileCount = missiles;
	}
	
	// Returns the missiles that were just now counted by our 12 year old kid, we needed to hire for diversity
	public int getMissileCount() {
		return missileCount;
	}
	
	// Method that sets the missile count, which is currently ten, because that was all they could afford
	public void setFixedMissileCount() {
		this.missileCount = 10;
	}
	
	// similar method, but it sounds cooler, although this one doesn't need any funds, it just required the kid
	public int getMaxFixedMissileCount() {
		return 10;
	}
	
	// TOSTRING() :O
	public String toString() {
		String returnStr = "";
		returnStr += super.toString();
		returnStr += "Missile Count: "+this.getMissileCount()+"\n";
		return returnStr;
	}
	
}
