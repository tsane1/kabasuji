package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Screen;

/**
 * A controller to Flip Pieces across the X axis.
 * @author Ian Jacoway
 */

public class FlipXController implements ActionListener {
	Application app;
	Level level;
	
	public FlipXController(Application a, Level l) {
		this.app= a;
		this.level = l;
	}
	
	public void doFlipX(){
		if(level.getSelected() == null){
			return;
		}
	
		level.getSelected().flipX();
		//casting is messed up cuz the screens are all in other packages
		if(app.getCurrScreen().getName() != "LevelPlay")
			; //should push onto undo stack
		app.getCurrScreen().getBullpenView().refresh();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	// THIS IS A REQUIREMENT OF THE ACTIONLISTENER CLASS 
		try{
			doFlipX();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : FlipXController");
			ex.printStackTrace();
		}
	}
}

