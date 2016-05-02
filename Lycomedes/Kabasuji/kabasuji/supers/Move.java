package kabasuji.supers;

import java.awt.Point;
import java.io.Serializable;

/**
 * <b>SUPER - Controllers</b> Superclass built to handle move events
 * <p>
 * Move class that controller
 * </p>
 * @author Tanuj Sane
 *
 */
public abstract class Move implements Serializable {
	/**
	 * Generic constructor for the move parent.
	 */
	public Move() {
		
	}
	
	/**
	 * Method for executing the move.
	 * @return boolean
	 */
	public abstract boolean execute();
	
	/**
	 * Method for undoing a move.
	 * @return boolean
	 */
	public abstract boolean undo();
	
	/**
	 * Method for validating a move. 
	 * @return boolean
	 */
	public abstract boolean valid();
}
