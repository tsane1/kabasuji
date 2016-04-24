package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.moves.FlipXMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

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
	
	public boolean doFlipX(){
		Move m = new FlipXMove(level);
		
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

