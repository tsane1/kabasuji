package model;

/**
 * Tile Subclass which will make up the Puzzle Level Boards
 */
public class PuzzleBoardTile extends Tile{

	int row, col;
	
	public PuzzleBoardTile(int row, int column) {
		super(row, column);
		
		this.row = row;
		this.col = column;
		
	}


}
