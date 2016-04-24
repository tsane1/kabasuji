package kabasuji.moves;

import kabasuji.supers.Level;
import kabasuji.supers.Move;

/**
 * Set the selected Tile on the Board to active,
 * if Tile in selected again increment a number to appear (release only).
 * @author Ian Jacoway
 *
 */
public class SelectTileMove extends Move {
	Level currLevel;
	
	public SelectTileMove(Level l) {
		this.currLevel = l;
	}

	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		currLevel.getBoard().selectTile();
		return true;
	}

	@Override
	public boolean undo() {
		currLevel.getBoard().deselectTile();
		return true;
	}

	@Override
	public boolean valid() {
		if(currLevel.getBoard() == null)
			return false;
		return true;
	}
}
