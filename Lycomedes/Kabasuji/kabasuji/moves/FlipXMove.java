package kabasuji.moves;

import kabasuji.supers.Level;
import kabasuji.supers.Move;

/**
 * A Move done on a Piece, that will mirror the Piece over the X-Axis.
 * @author Ian Jacoway
 *
 */

public class FlipXMove extends Move {
	/** Level being updated. */
	Level currLevel;
	
	/**
	 * Constructor for flip x move.
	 * @param Level l
	 */
	public FlipXMove(Level l) {
		this.currLevel = l;
	}

	/**
	 * Handles the execution of the move.
	 */
	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		currLevel.getSelected().flipX();
		return true;
	}

	/**
	 * Handles undoing the move if requested.
	 */
	@Override
	public boolean undo() {
		currLevel.getSelected().flipX();
		return true;
	}

	/**
	 * Determines whether or not the move is valid.
	 */
	@Override
	public boolean valid() {
		if(currLevel.getSelected() == null)
			return false;
		return true;
	}
}
