package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.moves.RotateLeftMove;
import kabasuji.moves.RotateRightMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;

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
	
	public boolean doRotateRight(){
		Move m = new RotateRightMove(level);
	
		if(m.execute()){
			// If appropriate screen then update view
			switch (app.getCurrScreen().getName()){
				case "LevelPlay": case "PuzzleLevelEditView": case "LightningLevelEditView": case "ReleaseLevelEditView":
					app.getCurrScreen().getBullpenView().refresh();
				default:
					level.trackMove(m);
					;//do nothing/push to undo stack?
			}
		}
		return true;
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


