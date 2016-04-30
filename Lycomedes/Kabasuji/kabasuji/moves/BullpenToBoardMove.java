package kabasuji.moves;

import kabasuji.entities.Piece;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

public class BullpenToBoardMove extends Move {

	Level level;
	Piece currPiece;
	int row;
	int col;
	
	public BullpenToBoardMove(SuperModel m, int row, int col) {
		this.level = m.getActiveLevel();
		this.currPiece = level.getSelected();
		this.row = row;
		this.col = col;
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
		level.getBoard().uncoverPieceArea(row, col, currPiece);
		return level.getBullpen().addPieceBackToBullpen(currPiece);
		
	}

	@Override
	public boolean valid() {
		if(currPiece == null) { return false; } 
		return true;
	}

}
