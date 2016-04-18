package model;

/**
 * Tile Subclass which will make up the Lightning Level Boards
 */
public class LightningBoardTile extends Tile{

	int row, col;
	private boolean covered;
	
	public LightningBoardTile(int row, int column) {
		super(row, column);
		
		this.row = row;
		this.col = column;
		covered = false;
	}
	//need to override both isCovered and cover
	public void cover() {
		covered = true;
	}
	
	public void uncover(){
		covered = false;
	}
	
	public boolean isCovered() {
		return covered;
	}
}
