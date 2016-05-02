package kabasuji.controllers;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import kabasuji.moves.ChangeReleaseNumColorMove;
import kabasuji.moves.IncrementReleaseTileMove;
import kabasuji.moves.SelectTileMove;
import kabasuji.moves.UpdateHintLocationMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;
import kabasuji.views.BoardView;

/**
 * A controller to select tiles as active on a Board with one <+/+/+SUPPOSE TO BE: "LEFT click"+/+/+> click, 
 * up to the following 6 clicks it then increment a number to appear on the tile (for release).
 * @author Ian Jacoway
 * @author Michael
 */

public class TileSelectController extends MouseAdapter{
	/** Application being run. */
	private Application app;
	/** board view for the controller. */
	BoardView boardView;
	/** Level instance for the controller. */
	Level level;
	
	/**
	 * Constructor for the controller.
	 * @param app
	 * @param model
	 */
	public TileSelectController(Application app, SuperModel model){
		this.app = app;
		this.boardView = app.getCurrScreen().getBoardView();
		this.level = model.getActiveLevel();
	}
	
	/** 
	 * Selects a tile as part of the board.
	 * @param Point p
	 * @return boolean
	 */
	public boolean selectTile(Point p){
		Move m = new SelectTileMove(level, p);

		if(m.execute()){ 
			level.trackMove(m);
			boardView.refresh();
			return true;
		}
		return false;
	}

	/** 
	 * Increments value of a release tile.
	 * @param Point p
	 * @return boolean
	 */
	public boolean incrementRelease(Point p){
		Move m = new IncrementReleaseTileMove(level, p);

		if(m.execute()){ 
			//level.trackMove(m);
			boardView.refresh();
			return true;
		}
		return false;
	}

	/** 
	 * Changes the color of a release tile.
	 * @param Point p
	 * @return boolean
	 */
	public boolean changeNumColor(Point p){
		Move m = new ChangeReleaseNumColorMove(level, p);

		if(m.execute()){ 
			//level.trackMove(m);
			boardView.refresh();
			return true;
		}
		return false;
	}
	
	/**
	 * Add a row and column to the hint piece.
	 * @param Point p
	 * @return boolean
	 */
	public boolean addToHint(Point p){
		int rowNum = (int) p.getY()/32; 
		int colNum = (int) p.getX()/32;
		int x = (int)p.getX()%32;
		int y = (int)p.getY()%32;
		
		if(x == 0)
			colNum -= 1;
		if(y == 0)
			rowNum -= 1;
		
		Move m = new UpdateHintLocationMove(rowNum, colNum, level);
		
		if(m.execute()){ 
			level.trackMove(m);
			boardView.refresh();
			return true;
		}
		return false;
		
	}
	
	/**
	 * Listener for when the mouse is clicked on the boardview.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		
		Point clicked = e.getPoint();
		int numClicks = e.getClickCount();
		
		if(SwingUtilities.isRightMouseButton(e)){

			incrementRelease(clicked);

		} 
		else if(SwingUtilities.isLeftMouseButton(e)){
			if (numClicks == 1){ // will be helpful for incrementing release
				selectTile(clicked); 
			}
			else if(numClicks == 2){
				addToHint(clicked);
			}
			else{
				System.out.println("No action for more than 2 clicks");
			}
		}
		else{
			System.err.println("Button not supported on tile select.");
		}
		app.getCurrScreen().refresh();
	}
}


