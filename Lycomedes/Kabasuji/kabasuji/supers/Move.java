package kabasuji.supers;

import java.awt.Point;

/**
 * <b>SUPER - Controllers</b> Superclass built to handle move events
 * <p>
 * Move class that controller
 * </p>
 * @author Tanuj Sane
 *
 */
public abstract class Move {
	public Move() {
		
	}
	
	public abstract boolean execute();
	
	public abstract boolean undo();
	
	public abstract boolean valid();

	public boolean execute(Point p) {
		// Used to de/select Tiles
		return false;
	}

	public boolean undo(Point p) {
		// Used to de/select Tiles
		return false;
	}
}
