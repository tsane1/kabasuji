package kabasuji.moves;

import kabasuji.entities.Piece;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

public class BullpenToBoardMove extends Move {

	Level level;
	Piece currPiece;
	
	public BullpenToBoardMove(SuperModel m) {
		this.level = m.getActiveLevel();
		this.currPiece = level.getSelected();
	}

	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		return level.getBullpen().setPieceAsPlayed(currPiece);
		
	}

	@Override
	public boolean undo() {
		//int x = level.getBullpen().getPlayedPieces().size();
		//Piece p = level.getBullpen().getPlayedPieces().
		return level.getBullpen().addPieceBackToBullpen(currPiece);
	}

	@Override
	public boolean valid() {
		if(currPiece == null) { return false; } 
		return true;
	}

}
