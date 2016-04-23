package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

/**
 * A controller to Flip Pieces across the Y axis.
 * @author Ian Jacoway
 */

public class FlipYController implements ActionListener {
	Application app;
	Level level;
	SuperModel model;
		
	public FlipYController(Application a, Level l, SuperModel mod) {
		this.app = a;
		this.level = l;
		this.model = mod;
	}
	
	public boolean doFlipY(){
		Move m = model.getLastMove();
		if(m == null){
			return false;
		}		
		if(level.getSelected() == null){
			return false;
		}
		
		level.getSelected().flipY();
		//casting is messed up cuz the screens are all in other packages
		if(app.getCurrScreen().getName() != "LevelPlay")
			; //should push onto undo stack
		app.getCurrScreen().getBullpenView().refresh();
		
		if(m.execute()) {
			model.addMoveToUndo(m);
		}
		return true;
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

