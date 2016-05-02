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
	/** Level being updated. */
	Level currLevel;
	/** point extracting the row, col from. */
	Point p;
	
	/**
	 * Constructor for selecting tile move.
	 * @param Level l
	 * @param Point p
	 */
	public SelectTileMove(Level l, Point p) {
		this.currLevel = l;
		this.p = p;
	}
	
	/**
	 * Handles the execution of the move.
	 */
	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		currLevel.getBoard().selectTile(p, currLevel.getLevelType());
		return true;
	}

	/**
	 * Handles undoing the move if requested.
	 */
	@Override
	public boolean undo() {
		currLevel.getBoard().deselectTile(p);
		return true;
	}

	/**
	 * Determines whether or not the move is valid.
	 */
	@Override
	public boolean valid() {
		if(currLevel.getBoard() == null)
			return false;
		return true;
	}
}
