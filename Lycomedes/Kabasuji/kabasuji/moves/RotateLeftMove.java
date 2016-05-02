package kabasuji.moves;

import kabasuji.supers.Level;
import kabasuji.supers.Move;

/**
 * A Move done on a Piece, that will rotate the Piece 90 degrees to the left.
 * @author Ian Jacoway
 *
 */

public class RotateLeftMove extends Move {
	/** Level being updated. */
	Level currLevel;
	
	/**
	 * Constructor for rotate left move.
	 * @param Level l
	 */
	public RotateLeftMove(Level l) {
		this.currLevel = l;
	}

	/**
	 * Handles the execution of the move.
	 */
	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		currLevel.getSelected().rotateLeft();
		return true;
	}

	/**
	 * Handles undoing the move if requested.
	 */
	@Override
	public boolean undo() {
		currLevel.getSelected().rotateRight();
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
