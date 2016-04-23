package kabasuji.moves;

import kabasuji.supers.Level;
import kabasuji.supers.Move;

public class RotateLeftMove extends Move {

	Level currLevel;
	
	public RotateLeftMove(Level l) {
		this.currLevel = l;
	}

	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		currLevel.getSelected().rotateLeft();
		return true;
	}

	@Override
	public boolean undo() {
		currLevel.getSelected().rotateRight();
		return true;
	}

	@Override
	public boolean valid() {
		if(currLevel.getSelected() == null)
			return false;
		return true;
	}

}
