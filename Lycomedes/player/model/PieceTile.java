package model;

/**
 * Tile Subclass which will make up the pieces.
 */
public class PieceTile extends Tile{

	int row;
	int col;
	
	public PieceTile(int row, int column) {
		super(row, column);
		
		this.row = row;
		this.col = column;
	}

}
