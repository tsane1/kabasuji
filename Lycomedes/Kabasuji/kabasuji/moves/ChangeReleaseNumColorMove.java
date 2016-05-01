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
	Level currLevel;
	Point p;
	
	public ChangeReleaseNumColorMove(Level l, Point p) {
		this.currLevel = l;
		this.p = p;
	}
	
	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		currLevel.getBoard().changeReleaseNumColor(p);
		return true;
	}

	@Override
	public boolean undo() {
		// There's no reason to undo such a move as the colors loop back around
		// after 6 and eventually returns to 0 printing a blank tile again
		return false;
	}

	@Override
	public boolean valid() {
		if((currLevel.getBoard() == null)||(currLevel.getLevelType() != "ReleaseLevelEditView"))
			return false;
		return true;
	}
}
