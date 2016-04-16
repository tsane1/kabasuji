package model;

/**
 * Tile Subclass which will make up the Release Level Boards
 */
public class ReleaseBoardTile extends Tile{

	int row, col;
	
	public ReleaseBoardTile(int row, int column) {
		super(row, column);
		
		this.row = row;
		this.col = column;
		
	}

}
