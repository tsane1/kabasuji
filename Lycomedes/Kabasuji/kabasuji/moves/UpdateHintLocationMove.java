package kabasuji.moves;

import kabasuji.entities.Board;
import kabasuji.entities.LightningBoardTile;
import kabasuji.entities.PuzzleBoardTile;
import kabasuji.entities.ReleaseBoardTile;
import kabasuji.supers.Level;
import kabasuji.supers.Move;

/**
 * Move class for adding a board tile to a hint piece.
 */
public class UpdateHintLocationMove extends Move {
	/** column and row of the tile. */
	int col, row;
	/** Level adding the hint to. */
	Level lev;
	/** Board adding the hint to. */
	Board b;
	
	/**
	 * Constructor for updating hint move.
	 * @param int row
	 * @param int col
	 * @param Level l
	 */
	public UpdateHintLocationMove(int row, int col, Level l){
		this.row = row;
		this.col = col;
		this.lev = l;
		this.b = l.getBoard();
	}
	
	/**
	 * Handles the execution of the move.
	 */
	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		
		String leveltype = lev.getLevelType();
		switch(leveltype){
		case "Puzzle":
			b.setHintLocation(new PuzzleBoardTile(row, col));
			break;
		case "Lightning":
			b.setHintLocation(new LightningBoardTile(row, col));
			break;
		case "Release":
			b.setHintLocation(new ReleaseBoardTile(row, col));
			break;
		default:
			System.out.println("Tile type not recognized");
		}
		return true;
	}

	/**
	 * Handles undoing the move if requested.
	 */
	@Override
	public boolean undo() {
		if(b.getHintLocations().size() > 0) b.getHintLocations().remove(b.getHintLocations().size()-1);
		else return false;
		return true;
	}

	/**
	 * Determines whether or not the move is valid.
	 */
	@Override
	public boolean valid() {
		return !(b.getHintLocations().size() > 6);
	}

}
