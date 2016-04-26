package kabasuji.controllers;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import org.w3c.dom.events.MouseEvent;

import kabasuji.entities.Board;
import kabasuji.moves.IncrementReleaseTileMove;
import kabasuji.moves.SelectTileMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

/**
 * A controller to select tiles as active on a Board with one <+/+/+SUPPOSE TO BE: "LEFT click"+/+/+> click, 
 * up to the following 6 clicks it then increment a number to appear on the tile (for release).
 * @author Ian Jacoway
 */

public class TileSelectController implements MouseListener{
	Application app;
	Level level;
	
	public TileSelectController(Application a, SuperModel model){
		this.app = a;
		this.level = model.getActiveLevel();
	}
	
	public boolean selectTile(Point p){
		Move m = new SelectTileMove(level);
		
		if(m.execute(p)){ 
			if(app.getCurrScreen().getName() != "LevelPlay")
				level.trackMove(m);
			app.getCurrScreen().getBoardView().refresh();
			return true;
		}
		return false;
	}

	public boolean incrementRelease(Point p){
		Move m = new IncrementReleaseTileMove(level);
		
		if(m.execute(p)){ 
			if(app.getCurrScreen().getName() != "LevelPlay")
				level.trackMove(m);
			app.getCurrScreen().getBoardView().refresh();
			return true;
		}
		return false;
	}
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		try{
			// increment a counter in selectTile for every tile being selected that is already selected
			if (e.getSource() == app.getCurrScreen().getBoardView()){
				Point p = e.getPoint(); // returns the X and Y with respect to the source object (board) yeah!!
				if (e.getClickCount() == 1){ // will be helpful for incrementing release
					selectTile(p); 
				}
				if (e.getClickCount() > 1 && app.getCurrScreen().getName() == "ReleaseLevelEditView"){
					incrementRelease(p);
				}
			}
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : TileSelectController");
			ex.printStackTrace();
		}
		
	}
// What's the difference between a click and a press??
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Figure out how this is different..
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// Do nothing
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// Do nothing
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// Do nothing
		
	}
}


