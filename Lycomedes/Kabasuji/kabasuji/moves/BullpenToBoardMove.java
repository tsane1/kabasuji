package kabasuji.moves;

import kabasuji.entities.Piece;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

/**
 * Move for adding a piece from the bullpen to the board.
 */
public class BullpenToBoardMove extends Move {
	/** Level being updated. */
	Level level;
	/** Piece being moved. */
	Piece currPiece;
	/** row adding to the board. */
	int row;
	/** column adding to the board. */
	int col;
	
	/**
	 * Constructor for bullpen to board move.
	 * @param Supermodel m
	 * @param int row
	 * @param int col
	 */
	public BullpenToBoardMove(SuperModel m, int row, int col) {
		this.level = m.getActiveLevel();
		this.currPiece = level.getSelected();
		this.row = row;
		this.col = col;
	}

	/**
	 * Handles the execution of the move.
	 */
	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		return level.getBullpen().setPieceAsPlayed(currPiece);
		
	}

	/**
	 * Handles undoing the move if requested.
	 */
	@Override
	public boolean undo() {
		//int x = level.getBullpen().getPlayedPieces().size();
		//Piece p = level.getBullpen().getPlayedPieces().
		level.getBoard().uncoverPieceArea(row, col, currPiece);
		return level.getBullpen().addPieceBackToBullpen(currPiece);
		
	}

	/**
	 * Determines whether or not the move is valid.
	 */
	@Override
	public boolean valid() {
		if(currPiece == null) { return false; } 
		return true;
	}

}
