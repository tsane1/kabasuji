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
public class ChangeReleaseNumColorMove extends Move {
	/** Level being updated. */
	Level currLevel;
	/** Point for getting the row, col from. */
	Point p;
	
	/**
	 * Constructor for change release color move.
	 * @param Level l
	 * @param Point p
	 */
	public ChangeReleaseNumColorMove(Level l, Point p) {
		this.currLevel = l;
		this.p = p;
	}
	
	/**
	 * Handles the execution of the move.
	 */
	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		currLevel.getBoard().changeReleaseNumColor(p);
		return true;
	}

	/**
	 * Handles undoing the move if requested.
	 */
	@Override
	public boolean undo() {
		// There's no reason to undo such a move as the colors loop back around
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
