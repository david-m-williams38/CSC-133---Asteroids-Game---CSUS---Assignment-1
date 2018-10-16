package com.mycompany.a1;

import java.util.Vector;
import java.util.Random;

public class GameWorld {

	// Set the variables
	Random rand = new Random();
	private Vector<GameObject> gameObjects = new Vector<GameObject>();
	private int lives;
	private final int TURN_AMOUNT = 5;
	// FIXED THIS HORRIBLE MIXUP AGAIN
	private static final double GAME_HEIGHT = 768.0;
	private static final double GAME_WIDTH = 1024.0;
	private int score;
	private int gameTicks = 0;
	Boolean doesPSExist;

	
	// initialization method
	public void init() {
		lives = 3;
		score = 0;
		gameTicks = 0;
	}
	
	// Create a new NPS in the game
	public void addNPS() {
		NonPlayerShip nps = new NonPlayerShip();
		gameObjects.add(nps);
		System.out.println("An NPS has been created.");
		System.out.println(nps);
	}

	
	// Create a new PS in the game
	// This also has redundant checks within this method/function
	public void addPS() {
		Boolean psBool = false;
		for (int i = 0; i < gameObjects.size() && !psBool ;i++) {
			if (gameObjects.elementAt(i) instanceof PlayerShip)
				psBool = true;
		}
		if (!psBool) {
			PlayerShip ps = new PlayerShip();
			gameObjects.add(ps);
			System.out.println("A new PS has been created.");
		}
		else
			System.out.println("Error: PS already exists.");
	}
	
	// Return how many ticket have passed in the game
	public int getGameTicks() {
		return gameTicks;
	}
	
	// Add one more tick to the game, increasing the time in the game
	// Ticks are the main function of time tracking within the game
	// This will be critical later....
	public void incrementGameTicks() {
		gameTicks++;
	}
	
	// Checks to see if the item is a PS
	public Boolean isPS(int index) {
		Boolean isAPS = false;
		if(gameObjects.elementAt(index) instanceof PlayerShip)
			isAPS = true;
		return isAPS;
	}
	
	// Returns if it is anananaonymous NPS
	public Boolean isNonPlayerShip(int index) {
		Boolean isANPS = false;
		if(gameObjects.elementAt(index) instanceof NonPlayerShip)
			isANPS = true;
		return isANPS;
	}
	
	// ERROR METHOD
	public void PrintNoPS() {
		System.out.println("Error: PS doesn't exist! Did you create one?");
	}
	
	// ERROR METHOD
	public void PrintNoNPS() {
		System.out.println("Error: NPS doesn't exist! Did you create one?");
	}
	
	// RETURNS THE PLAYER LIVES
	public int getPlayLives() {
		return lives;
	}
	
	// Gets the player score, IT BETTER BE A HIGH SCORE
	public int getPlayScore() {
		return score;
	}
	
	// Sets the player score, pathetic little bitty points
	public void setPlayScore(int x) {
		score = x;
	}
	
	// Sets the player lives
	public void setPlayLives(int x) {
		lives = x;
	}
	
	// adds a new asteroid, they still haven't weaponized themselves yet...
	public void addAsteroid() {
		Asteroid asteroid = new Asteroid();
		gameObjects.add(asteroid);
		System.out.println("A new ASTEROID has been created.");
	}
	
	// Adds a space station, this should really be there, they can't live without their lighthouse
	public void addStation() {
		SpaceStation ss = new SpaceStation();
		gameObjects.add(ss);
		System.out.println("A new SS has been created.");
	}
	
	// FASTER SPEED
	public void increasePSS() {
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.elementAt(i) instanceof PlayerShip) {
				PlayerShip myShip = (PlayerShip) gameObjects.elementAt(i);
				myShip.setSpeed(myShip.getSpeed() + 1);
				System.out.println("Increased PS speed");
			}
		}
	}
	
	// CLOSER TO TORTOISE SPEED
	public void decreasePSS() {
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.elementAt(i) instanceof PlayerShip) {
				PlayerShip myShip = (PlayerShip) gameObjects.elementAt(i);
				myShip.setSpeed(myShip.getSpeed() - 1);
				System.out.println("Decreased PS speed");
			}
		}
	}

	// CHA CHA SLIDE TO THE LEFT
	public void turnLeft() {
		Boolean playerBool = false; 
		for(int i = 0; i <gameObjects.size() && !playerBool;i++) {
			if (gameObjects.elementAt(i) instanceof ISteerable) {
				playerBool = isPS(i);
				if(playerBool) {
					PlayerShip ps = (PlayerShip) gameObjects.elementAt(i);
					if (ps.getDir() == 0)
						ps.setDir(360 - TURN_AMOUNT);
					else
						ps.setDir(ps.getDir() - TURN_AMOUNT);
					System.out.println("PS turned " + TURN_AMOUNT + " degrees counter-clockwise. dir = " + ps.getDir());
				}
			}
		}
		if(!playerBool)
			PrintNoPS();
	}
	
	// CHA CHA SLIDE TO THE RIGHT
	public void turnRight() {
		Boolean playerBool = false;
		for(int i = 0; i <gameObjects.size() && !playerBool;i++) {
			if(gameObjects.elementAt(i) instanceof ISteerable) {
				playerBool = isPS(i);
				if(playerBool) {
					PlayerShip ps = (PlayerShip) gameObjects.elementAt(i);
					if ((ps.getDir() + TURN_AMOUNT) == 360)
						ps.setDir(0);
					else
						ps.setDir(ps.getDir() + TURN_AMOUNT);
					System.out.println("PS turned " + TURN_AMOUNT + " degrees clockwise. dir = " + ps.getDir());
				}
			}
		}
		if(!playerBool)
			PrintNoPS();
	}
	
	// UNDO YOUR CHA CHA SLDE BY MOVING THE MISSILE LAUNCHER
	public void turnPSML() {
		Boolean playerBool = false;
		for(int i = 0; i <gameObjects.size() && !playerBool;i++) {
			if(gameObjects.elementAt(i) instanceof ISteerable) {
				playerBool = isPS(i);
				if(playerBool) {
					PlayerShip ps = (PlayerShip) gameObjects.elementAt(i);
					if (ps.getMissileLauncher().getDir() == 0)
						ps.getMissileLauncher().setDir(360 - TURN_AMOUNT);
					else
						ps.getMissileLauncher().setDir(ps.getMissileLauncher().getDir() - TURN_AMOUNT);
					System.out.println("MISSILELAUNCHER turned " + TURN_AMOUNT + " degrees counter-clockwise. dir = " + ps.getMissileLauncher().getDir());
				}
			}
		}
		if(!playerBool)
			PrintNoPS();
	}

	// FIRING MY LA- MISSILE
	public void firePSMissile() {
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.elementAt(i) instanceof PlayerShip) {
				PlayerShip myShip = (PlayerShip) gameObjects.elementAt(i);
				if(myShip.getMissileCount() > 0) {
					Missile newMissile = myShip.fire();
					gameObjects.add(newMissile);
				}
				else {
					System.out.println("You shot all of your missiles already, get your resupply at the Space Station");
				}
			}
		}
	}

	// Fire an NPS missile
	public void fireNPSMissile() {
		for(int i = 0; i < gameObjects.size(); i++) {
			if(gameObjects.elementAt(i) instanceof NonPlayerShip) {
				NonPlayerShip aShip = (NonPlayerShip) gameObjects.elementAt(i);
				if(aShip.getMissileCount() > 0) {
					Missile newMissile = aShip.fire();
					gameObjects.add(newMissile);
				}
				else
					System.out.println("NPS is out of missiles");
			}
		}
	}
	
	// STAR TREK JUMP TO THE, same dimension?
	public void jump() {
		Boolean playerBool = false; 
		Boolean psBool = false; 
		for(int i = 0; i <gameObjects.size();i++) {
			playerBool = isPS(i);
			if(playerBool) {
				psBool = true;
				PlayerShip ps = (PlayerShip) gameObjects.elementAt(i);
				ps.setX(GAME_WIDTH/2);
				ps.setY(GAME_HEIGHT/2);
				System.out.println("PS jumped through hyperspace!");
			}
		}
		if (!psBool)
			PrintNoPS();
	}

	// SUPPLY UP
	public void newSupply() {
		Boolean playerBool = false; 
		Boolean psBool = false; 
		for(int i = 0; i <gameObjects.size();i++) {
			playerBool = isPS(i);
			if(playerBool) {
				psBool = true;
				PlayerShip ps = (PlayerShip) gameObjects.elementAt(i);
				ps.setMissileCount(ps.getMaxFixedMissileCount());
				System.out.println("PS has successfully resupplied! You now have the maximum number of missiles again!");
			}
		}
		if (!psBool)
			PrintNoPS();
	}

	// Destroyed
	public void removeMissileAsteroid() {
		Boolean asteroidBool = false;
		Boolean missileBool = false;
		Missile ms = null;
		Asteroid ast = null;
		for(int i =0; i < gameObjects.size() && (!asteroidBool || !missileBool); i++) {
			if ((gameObjects.elementAt(i) instanceof Asteroid) && !asteroidBool) {
				ast = (Asteroid) gameObjects.elementAt(i);
				asteroidBool = true;	
			}
			if ((gameObjects.elementAt(i) instanceof Missile) && !missileBool) {
				ms = (Missile) gameObjects.elementAt(i);
				if (ms.getIsPlayerMissile() == true) {
					missileBool = true;
				}
			}			
		}
		if(asteroidBool && missileBool) {
			gameObjects.remove(ast); 
			gameObjects.remove(ms);
			this.setPlayScore(this.getPlayScore() + 10);
			System.out.println("PS missile destroyed an asteroid! Your score increased by 10.");
		}
		else
			System.out.println("Error: Either an asteroid or PS missile doesn't exist");
	}
	

	// Destroyed
	public void removeMissileNPS() {
		Boolean npsBool = false;
		Boolean missileBool = false;
		Missile ms = null;
		NonPlayerShip nps = null;
		for(int i =0; i < gameObjects.size() && (!npsBool || !missileBool); i++) {
			if ((gameObjects.elementAt(i) instanceof NonPlayerShip) && !npsBool) {
				nps = (NonPlayerShip) gameObjects.elementAt(i);
				npsBool = true;	
			}
			if ((gameObjects.elementAt(i) instanceof Missile) && !missileBool) {
				ms = (Missile) gameObjects.elementAt(i);
				if (ms.getIsPlayerMissile() == true) {
					missileBool = true;
				}
			}			
		}
		if(npsBool && missileBool) {
			gameObjects.remove(nps);
			gameObjects.remove(ms);
			this.setPlayScore(this.getPlayScore() + 50);
			System.out.println("PS missile destroyed a NPS! Player score increased by 50");
		}
		else
			System.out.println("Error: Either NPS or PS Missile doesn't exist");
	}

	// Destroyed
	public void removeMissilePS() {
		Boolean psExists = false;
		Boolean missileBool = false;
		Missile ms = null;
		PlayerShip ps = null;
		for(int i =0; i < gameObjects.size() && (!psExists || !missileBool); i++) {
			if ((gameObjects.elementAt(i) instanceof PlayerShip) && !psExists) {
				ps = (PlayerShip) gameObjects.elementAt(i);
				psExists = true;	
			}
			if ((gameObjects.elementAt(i) instanceof Missile) && !missileBool) {
				ms = (Missile) gameObjects.elementAt(i);
				if (ms.getIsPlayerMissile() == false) {
					missileBool = true;
				}
			}
		}
		if(psExists && missileBool) {
			gameObjects.remove(ps);
			gameObjects.remove(ms);
			if (this.getPlayLives() != 0) {
				this.setPlayLives(this.getPlayLives() - 1); 
				System.out.println("NPS missile destroyed a PS! You lost a life!");
			}
		} else
			System.out.println("Error: Either PS or NPS missile doesn't exist");
	}

	// Destroyed
	public void removePSAsteroid() {
		Boolean psExists = false;
		Boolean asteroidBool = false;
		PlayerShip ps = null;
		Asteroid ast = null;
		for(int i =0; i < gameObjects.size() && (!psExists || !asteroidBool); i++) {
			if ((gameObjects.elementAt(i) instanceof PlayerShip) && !psExists) {
				ps = (PlayerShip) gameObjects.elementAt(i);
				psExists = true;	
			}
			if ((gameObjects.elementAt(i) instanceof Asteroid) && !asteroidBool) {
				ast = (Asteroid) gameObjects.elementAt(i);
				asteroidBool = true;
			}
		}
		if(psExists && asteroidBool) {
			gameObjects.remove(ps);
			gameObjects.remove(ast);
			if (this.getPlayLives() != 0) {
				this.setPlayLives(this.getPlayLives() - 1); 
				System.out.println("PS crashed into an asteroid! You lost a life!");
			}
		}
		else
			System.out.println("Error: Either PS or an asteroid doesn't exist");
	}
	
	// Destroyed
	public void removeNpsPs() {
		Boolean psExists = false;
		Boolean npsBool = false;
		PlayerShip ps = null;
		NonPlayerShip nps = null;
		for(int i =0; i < gameObjects.size() && (!psExists || !npsBool); i++) {
			if ((gameObjects.elementAt(i) instanceof PlayerShip) && !psExists) {
				ps = (PlayerShip) gameObjects.elementAt(i);
				psExists = true;	
			}
			if ((gameObjects.elementAt(i) instanceof NonPlayerShip) && !npsBool) {
				nps = (NonPlayerShip) gameObjects.elementAt(i);
				npsBool = true;
			}
		}
		if(psExists && npsBool) {
			gameObjects.remove(ps);
			gameObjects.remove(nps);
			if (this.getPlayLives() != 0) {
				this.setPlayLives(this.getPlayLives() - 1); 
				System.out.println("PS crashed into an NPS! You lost a life!");
			}	
		}
		else
			System.out.println("Error: Either PS or NPS doesn't exist");
	}
	
	// Destroyed
	public void removeTwoAsteroids() {
		Boolean asteroid1Exists = false;
		Boolean asteroid2Exists = false;
		Asteroid ast1 = null;
		Asteroid ast2 = null;
		int ast1index = -1;
		
		for(int i =0; i < gameObjects.size() && (!asteroid1Exists || !asteroid2Exists); i++) {
			if ((gameObjects.elementAt(i) instanceof Asteroid) && !asteroid1Exists) {
				ast1 = (Asteroid) gameObjects.elementAt(i);
				ast1index = i;	
				asteroid1Exists= true;	
			}
			if ((gameObjects.elementAt(i) instanceof Asteroid) && !asteroid2Exists && !(ast1index == i )) {
				ast2 = (Asteroid) gameObjects.elementAt(i);
				asteroid2Exists = true;
			}
		}
		if(asteroid1Exists && asteroid2Exists) {
			gameObjects.remove(ast1);
			gameObjects.remove(ast2);
			System.out.println("Two asteroids collided with each other and were destroyed!");
		}
		else
			System.out.println("Error: A minimum of 2 Asteroids must exist");
	}
	
	// Destroyed
	public void removeAsteroidNPS() {
		Boolean astExists = false;
		Boolean npsBool = false;
		Asteroid ast = null;
		NonPlayerShip nps = null;
		for(int i =0; i < gameObjects.size() && (!astExists || !npsBool); i++) {
			if ((gameObjects.elementAt(i) instanceof Asteroid) && !astExists) {
				ast = (Asteroid) gameObjects.elementAt(i);
				astExists = true;	
			}
			if ((gameObjects.elementAt(i) instanceof NonPlayerShip) && !npsBool) {
				nps = (NonPlayerShip) gameObjects.elementAt(i);
				npsBool = true;
			}
		}
		if(astExists && npsBool) {
			gameObjects.remove(ast);
			gameObjects.remove(nps);
			System.out.println("An asteroid collided with an NPS! Both were destroyed horribly!");
		}
		else
			System.out.println("Error: Either an asteroid or an NPS doesn't exist");
	}
	
	// GAME TIME TRACKER, TICK TICK BOOM
	public void tick() {
		incrementGameTicks();
		System.out.println("Game ticks have been incremented by one. Time is now: " + gameTicks);
		
		for(int i =0; i < gameObjects.size(); i++) {
			if ((gameObjects.elementAt(i) instanceof IMoveable)) {
				IMoveable mObj = (IMoveable) gameObjects.elementAt(i);
				mObj.move();
				double shift;
				MoveableGameObject mv = (MoveableGameObject) mObj;
				if (mv.getX() > GAME_WIDTH) {
					shift =  mv.getX() - GAME_WIDTH;
					mv.setX(shift); 
				}
				else if (mv.getX() < 0) {
					shift = GAME_WIDTH - Math.abs(mv.getX()); 
					mv.setX(shift);
				}
				if (mv.getY() > GAME_HEIGHT) {
					shift = mv.getY() - GAME_HEIGHT;
					mv.setY(shift); 
				}
				else if (mv.getY() < 0) {
					shift = GAME_HEIGHT - Math.abs(mv.getY());
					mv.setY(shift);
				}
				if (gameObjects.elementAt(i) instanceof PlayerShip) {
					PlayerShip ps = (PlayerShip) gameObjects.elementAt(i);
					ps.getMissileLauncher().setLoc(ps.getLoc()); 
					ps.getMissileLauncher().setSpeed(ps.getSpeed()); 
				}
				if (gameObjects.elementAt(i) instanceof NonPlayerShip) {
					NonPlayerShip nps = (NonPlayerShip) gameObjects.elementAt(i);
					nps.getMissileLauncher().setLoc(nps.getLoc()); 
					nps.getMissileLauncher().setSpeed(nps.getSpeed()); 
				}
			}
			else if ((gameObjects.elementAt(i) instanceof SpaceStation)) {
				SpaceStation station = (SpaceStation) gameObjects.elementAt(i);
				if(gameTicks % station.getBlinkRt() == 0) {
					station.toggleLight();
				}
			}
		}
		for (int i = 0; i < gameObjects.size(); i++) {
			if (gameObjects.elementAt(i) instanceof Missile) {
				Missile ms = (Missile) gameObjects.elementAt(i);
				ms.setFuelLevel(ms.getFuelLevel() - 1);
				if (ms.getFuelLevel() == 0) {
					gameObjects.remove(i);
					i--; 
				}
			}
		}
	}
	
	// Display Printer
	public void printDisplay() {
		PlayerShip ps = null;
		Boolean psBool = false;
		for (int i = 0; i < gameObjects.size() && !psBool; i++) {
			if (gameObjects.elementAt(i) instanceof PlayerShip) {
				ps = (PlayerShip) gameObjects.elementAt(i);
				psBool = true;
			}
		}
		System.out.println("Current Score: " + this.getPlayScore() + " points");
		if (ps == null)
			this.PrintNoPS();
		else
			System.out.println("Missile count: " + ps.getMissileCount() + " missiles"); 
		System.out.println("Current elasped time: " + this.getGameTicks());
	}
	
	// Map Printer
	public void printMap() {
		if (gameObjects.size() > 0)
			for (int i =0; i<gameObjects.size(); i++) {
				System.out.println((gameObjects.elementAt(i)));
			}
		else
			System.out.println("No GameObjects exist currently.");
	}
}
