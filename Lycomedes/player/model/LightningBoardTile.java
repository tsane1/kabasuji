package model;


/**
 * Tile Subclass which will make up the Lightning Level Boards
 */
public class LightningBoardTile extends Tile{

	int row, col;
	
	public LightningBoardTile(int row, int column) {
		super(row, column);
		
		this.row = row;
		this.col = column;
		
	}
	//need to override both isCovered and cover

}
