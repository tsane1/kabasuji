package kabasuji.moves;

import kabasuji.entities.Piece;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

public class PaletteToBullpenMove extends Move {

	Level level;
	Piece currPiece;
	
	public PaletteToBullpenMove(Level l){
		this.level = l;
		this.currPiece = level.getSelected();
	}
	
	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		level.getBullpen().addPiece(currPiece);
		return true;
	}

	@Override
	public boolean undo() {
		level.getBullpen().removePiece(currPiece);
		return true;
	}

	@Override
	public boolean valid() {
		if(currPiece == null) { return false; }
		return true;
	}

}
