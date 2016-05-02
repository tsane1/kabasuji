package kabasuji.moves;

import java.awt.Point;

import kabasuji.supers.Level;
import kabasuji.supers.Move;

/**
 * Increment the selected ReleaseBoardTile on the Board,
 * if Tile's value passes 6 it loops back around to zero.
 * @author Ian Jacoway
 *
 */
public class IncrementReleaseTileMove extends Move {
	/** Level being updated. */
	Level currLevel;
	/** Point to get row, col from. */
	Point p;
	
	/**
	 * Constructor for incrementing the release tile value.
	 * @param Level l
	 * @param Point p
	 */
	public IncrementReleaseTileMove(Level l, Point p) {
		this.currLevel = l;
		this.p = p;
	}
	
	/**
	 * Handles undoing the move if requested.
	 */
	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		currLevel.getBoard().incrementReleaseTile(p);
		return true;
	}

	/**
	 * Determines whether or not the move is valid.
	 */
	@Override
	public boolean undo() {
		// There's no reason to undo such a move as the increment loops back around
		// after 6 and eventually returns to 0 printing a blank tile again
		return false;
	}

	/**
	 * Determines whether or not the move is valid.
	 */
	@Override
	public boolean valid() {
		return currLevel.getLevelType().equals("Release");
	}
}
