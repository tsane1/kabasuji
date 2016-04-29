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
	Level currLevel;
	
	public IncrementReleaseTileMove(Level l) {
		this.currLevel = l;
	}
	
	@Override
	public boolean execute(Point p) {
		if(!valid()) { return false; }
		System.err.println("Shhh im here");
		currLevel.getBoard().incrementReleaseTile(p);
		return true;
	}

	@Override
	public boolean undo(Point p) {
		// There's no reason to undo such a move as the increment loops back around
		// after 6 and eventually returns to 0 printing a blank tile again
		return false;
	}

	@Override
	public boolean valid() {
		if((currLevel.getBoard() == null))
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
