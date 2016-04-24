package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.w3c.dom.events.MouseEvent;

import kabasuji.entities.Board;
import kabasuji.moves.SelectTileMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

/**
 * A controller to select tiles as active on a Board.
 * @author Ian Jacoway
 */

public class TileSelectController implements ActionListener{
	Application app;
	Level level;
	
	public TileSelectController(Application a, Level l){
		this.app = a;
		this.level = l;
	}
	
// This is mostly psuedo code as of now
	public boolean selectTile(){
		Move m = new SelectTileMove(level);
		
		if(m.execute()){
			// If appropriate screen then update view
			switch (app.getCurrScreen().getName()){
				case "LevelPlay":
					app.getCurrScreen().getBoardView().refresh();
				case "PuzzleLevelEditView":
					app.getCurrScreen().getBoardView().refresh();
				case "LightningLevelEditView":
					app.getCurrScreen().getBoardView().refresh();
				case "ReleaseLevelEditView":
					app.getCurrScreen().getBoardView().refresh();
				default:
					level.trackMove(m);
					;//do nothing/push to undo stack?
			}
		}
//		if(level.getSelected() == null){
//			return false;
//		}
//		if (leftClick.getX() == board.getX()) && ()
//			//turn tile on & if release 
//			if(level.getLevelType() == "Release"){
//				//do increment number on tile
//			}
//		
//		level.get();
//		if (rightClick.getX() == board.getX()){
//			//increment color of number 
//		}
//		
//		app.getCurrScreen().getBoardView().refresh();
		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	// THIS IS A REQUIREMENT OF THE ACTIONLISTENER CLASS
		try{
			selectTile();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : TileSelectController");
			ex.printStackTrace();
		}
	}
}


