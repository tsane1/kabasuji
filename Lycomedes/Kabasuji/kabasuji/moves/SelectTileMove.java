package kabasuji.moves;

import java.awt.Point;

import kabasuji.supers.Level;
import kabasuji.supers.Move;

/**
 * Set the selected Tile on the Board to active,
 * if Tile in selected again increment a number to appear (release only).
 * @author Ian Jacoway
 *
 */
public class SelectTileMove extends Move {
	Level currLevel;
	
	public SelectTileMove(Level l) {
		this.currLevel = l;
	}
	
	@Override
	public boolean execute(Point p) {
		if(!valid()) { return false; }
		currLevel.getBoard().selectTile(p, currLevel.getLevelType());
		return true;
	}

	@Override
	public boolean undo(Point p) {
		currLevel.getBoard().deselectTile(p);
		return true;
	}

	@Override
	public boolean valid() {
		if(currLevel.getBoard() == null)
			return false;
		return true;
	}

	@Override //Not use as we need to pass it a point
	public boolean execute() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override // not the one to use as we need ot pass it a point
	public boolean undo() {
		// TODO Auto-generated method stub
		return false;
	}
}
