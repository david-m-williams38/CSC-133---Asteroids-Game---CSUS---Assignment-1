package com.mycompany.a1;

import com.codename1.ui.*;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form{

	// Set all them variables
	private GameWorld gw;
	private boolean didQuit = false;
	
	// Default constructor
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	// This method handles all the commands that will be executed
	// These commands will later be mapped to buttons and other such items
	// 		that will be implemented later, allowing for user control (Later)
	@SuppressWarnings("rawtypes")
	private void play() {
		// Given Code
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				if(didQuit) {
					switch(sCommand.charAt(0)) {
					case 'Y':
					case 'y':
						Display.getInstance().exitApplication();;
						break;
					case 'N':
					case 'n':
						System.out.println("You have selected to not quit, let's keep playing!");
						didQuit = false;
						break;
					default:
						System.out.println("Invalid Input Given! Resuming Game...");
						didQuit = false;
					}
				}
				// This try/catch block exists if the user finds a bug that could occur
				// The main bug involves the interface crashing when the user clicks 
				//			outside of the window after clicking the text box input
				try {
					switch (sCommand.charAt(0)) {
					case 'q':
						didQuit = true;
						System.out.println("Want to quit game? 'Y' or 'N'");
						break;
					case 'a':
						gw.addAsteroid();
						break;
					case 'm':
						gw.printMap();
						break;
					case 'y':
						gw.addNPS();
						break;
					case 'b':
						gw.addStation();
						break;
					case 's':
						gw.addPS();
						break;
					case 'i':
						gw.increasePSS();
						break;
					case 'd':
						gw.decreasePSS();
						break;
					case 'l':
						gw.turnLeft();
						break;
					case 'r':
						gw.turnRight();
						break;
					case '<':
						gw.turnPSML();
						break;
					case 'f':
						gw.firePSMissile();
						break;
					case 'L':
						gw.fireNPSMissile();
						break;
					case 'j':
						gw.jump();
						break;
					case 'n':
						gw.newSupply();
						break;
					case 'k':
						gw.removeMissileAsteroid();
						break;
					case 'e':
						gw.removeMissileNPS();
						break;
					case 'E':
						gw.removeMissilePS();
						break;
					case 'c':
						gw.removePSAsteroid();
						break;
					case 'h':
						gw.removeNpsPs();
						break;
					case 'x':
						gw.removeTwoAsteroids();
						break;
					case 'I':
						gw.removeAsteroidNPS();
						break;
					case 't':
						gw.tick();
						break;
					case 'p':
						gw.printDisplay();
						break;
					default:
						System.out.println("Invalid Input Given!");
					}
				}
				// This catch block will catch ALL errors, preventing the interface from crashing,
				//		Such as a NullPointerException and so on....
				catch(Exception E) {
					System.out.println("The interface has crashed! But don't worry!");
				}
			}
		});
	}
	
}
