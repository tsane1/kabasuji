package kabasuji.controllers;


import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import kabasuji.moves.ChangeReleaseNumColorMove;
import kabasuji.moves.IncrementReleaseTileMove;
import kabasuji.moves.SelectTileMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;
import kabasuji.views.BoardView;

/**
 * A controller to select tiles as active on a Board with one <+/+/+SUPPOSE TO BE: "LEFT click"+/+/+> click, 
 * up to the following 6 clicks it then increment a number to appear on the tile (for release).
 * @author Ian Jacoway
 */

public class TileSelectController extends MouseAdapter{
	private Application app;
	BoardView boardView;
	Level level;
	
	public TileSelectController(Application app, SuperModel model){
		this.app = app;
		this.boardView = app.getCurrScreen().getBoardView();
		this.level = model.getActiveLevel();
	}
	
	public boolean selectTile(Point p){
		Move m = new SelectTileMove(level);

		if(m.execute(p)){ 
			level.trackMove(m);
			System.out.println(level.peekLastMove().toString());
			boardView.refresh();
			app.getCurrScreen().refresh();
			return true;
		}
		app.getCurrScreen().refresh();
		return false;
	}

	public boolean incrementRelease(Point p){
		Move m = new IncrementReleaseTileMove(level);

		if(m.execute(p)){ 
			level.trackMove(m);
			boardView.refresh();
			return true;
		}
		return false;
	}

	public boolean changeNumColor(Point p){
		Move m = new ChangeReleaseNumColorMove(level);

		if(m.execute(p)){ 
			level.trackMove(m);
			boardView.refresh();
			return true;
		}
		return false;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		Point clicked = e.getPoint();
		
		if(SwingUtilities.isRightMouseButton(e)){

			if (e.getClickCount() == 1){
				incrementRelease(clicked);
			}
			if (e.getClickCount() == 2){
				changeNumColor(clicked);
			}
		} 
		else if(SwingUtilities.isLeftMouseButton(e)){
			if (e.getClickCount() == 2){ // will be helpful for incrementing release
				selectTile(clicked); 
			}
		}
		else{
			System.err.println("Button not supported on tile select.");
		}
	}
}


