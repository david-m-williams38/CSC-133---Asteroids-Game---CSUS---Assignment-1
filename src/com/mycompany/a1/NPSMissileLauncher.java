package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class NPSMissileLauncher extends MoveableGameObject{

	// THE AWESOMEST CONSTRUCTOR
	public NPSMissileLauncher(int dir, double x, double y) {
		this.setDir(dir);
		this.setColor(ColorUtil.CYAN);
		this.setX(x);
		this.setY(y);
	}
	
	// FIRE THAT MISSILE
	public Missile fire(int speed)
	{
		// 1 is this NPS's identifier number, separate from the real ID, not to be confused with CA Real ID...
		return new Missile(this.getX(), this.getY(), speed, this.getDir(), 1);
	}
	
	// A pathetic toString() method, couldn't look any better
	public String toString(){
		String superS = super.toString();
		String regularS = "NPS missile launcher stats: \n";
		return regularS + superS;
	}
	
}
