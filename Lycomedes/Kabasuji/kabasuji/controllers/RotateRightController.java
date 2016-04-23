package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;

/**
 * A controller to rotate Pieces 90 degrees to the right.
 * @author Ian Jacoway
 */

public class RotateRightController implements ActionListener {
	Application app;
	Level level;
	
	public RotateRightController(Application a, Level l) {
		this.app = a;
		this.level = l;
	}
	
	public void doRotateRight(){
		if(level.getSelected() == null){
			return;
		}
		
		level.getSelected().rotateRight();
		//casting is messed up cuz the screens are all in other packages
		if(app.getCurrScreen().getName() != "LevelPlay")
			; //should push onto undo stack
		app.getCurrScreen().getBullpenView().refresh();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	// THIS IS A REQUIREMENT OF THE ACTIONLISTENER CLASS THE "doUndo" should prolly go here
		try{
			doRotateRight();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : RotateRightController");
			ex.printStackTrace();
		}
	}
}


