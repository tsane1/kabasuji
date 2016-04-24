package kabasuji.moves;

import kabasuji.supers.Level;
import kabasuji.supers.Move;

public class FlipXMove extends Move {
	Level currLevel;
	
	public FlipXMove(Level l) {
		this.currLevel = l;
	}

	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		currLevel.getSelected().flipX();
		return true;
	}

	@Override
	public boolean undo() {
		currLevel.getSelected().flipX();
		return true;
	}

	@Override
	public boolean valid() {
		if(currLevel.getSelected() == null)
			return false;
		return true;
	}
}
