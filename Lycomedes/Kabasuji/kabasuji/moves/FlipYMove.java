package kabasuji.moves;

import kabasuji.supers.Level;
import kabasuji.supers.Move;

/**
 * A Move done on a Piece, that will mirror the Piece over the Y-Axis.
 * @author Ian Jacoway
 *
 */

public class FlipYMove extends Move {
	/** Level being updated. */
	Level currLevel;
	
	/**
	 * Constructor for flip y move.
	 * @param Level l
	 */
	public FlipYMove(Level l) {
		this.currLevel = l;
	}

	/**
	 * Handles the execution of the move.
	 */
	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		currLevel.getSelected().flipY();
		return true;
	}

	/**
	 * Handles undoing the move if requested.
	 */
	@Override
	public boolean undo() {
		currLevel.getSelected().flipY();
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
