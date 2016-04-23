package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

/**
 * A controller to Flip Pieces across the Y axis.
 * @author Ian Jacoway
 */

public class FlipYController implements ActionListener {
	Application app;
	Level level;
	
	public FlipYController(Application a, Level l) {
		this.app = a;
		this.level = l;
	}
	
	public void doFlipY(){
		if(level.getSelected() == null){
			return;
		}
		
		level.getSelected().flipY();
		//casting is messed up cuz the screens are all in other packages
		if(app.getCurrScreen().getName() != "LevelPlay")
			; //should push onto undo stack
		app.getCurrScreen().getBullpenView().refresh();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	// THIS IS A REQUIREMENT OF THE ACTIONLISTENER CLASS THE "doUndo" should prolly go here
		try{
			doFlipY();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : FlipYController");
			ex.printStackTrace();
		}
	}
}


