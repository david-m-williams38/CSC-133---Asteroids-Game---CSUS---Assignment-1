package com.mycompany.a1;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class SpaceStation extends FixedGameObject{

	// ugh, more variables
	private int BlinkRt;
	private int lightOn;
	private static final int BLINKRT_MAX = 4;
	private Random rand = new Random();
	
	// Default constructors
	public SpaceStation() {
		lightOn = 1;
		BlinkRt = rand.nextInt(BLINKRT_MAX + 1);
		this.setColor(ColorUtil.MAGENTA);
	}
	
	// toggles the light of the space station, because we needed a lighthouse in space
	public void toggleLight(){
		if(lightOn == 0) {
			lightOn = 1;
		}
		else if(lightOn == 1) {
			lightOn = 0;
		}
	}
	
	// We need to know where the lightho-- I mean space station's light is pointi- I mean its status
	public int getLightStatus() {
		return lightOn;
	}
	
	// Returns the lightho- I mean SpaceStations blinking rate...
	public int getBlinkRt() {
		return BlinkRt;
	}
	
	// ANOTHER SPECIAL toString() METHOD YIPEE
	public String toString() {
		String superS = super.toString();
		String regularS = "";
		regularS += "BlinkRt: " + this.getBlinkRt() + "\n";
		if(lightOn == 1)
		{
			regularS += "Light: On\n";
		}
		else if(lightOn == 0)
		{
			regularS += "Light: Off\n";
		}
		return superS + regularS;
	}

	
}
