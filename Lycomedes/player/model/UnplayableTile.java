package model;

/**
 * Type of tile in builder for when the builder doesn't want the tile to be part of the board
 */
public class UnplayableTile extends Tile{

	int row;
	int column;
	boolean covered;
	
	public UnplayableTile(int row, int col) {
		super(row, col);
		
		this.row = row;
		this.column = col;
		covered = true;
	}

	public boolean isCovered() {
		return true;
	}
}
