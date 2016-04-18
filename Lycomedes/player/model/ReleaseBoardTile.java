package model;

/**
 * Tile Subclass which will make up the Release Level Boards
 */
public class ReleaseBoardTile extends Tile{

	int row, col;
	private boolean covered;
	
	public ReleaseBoardTile(int row, int column) {
		super(row, column);
		
		this.row = row;
		this.col = column;
		covered = false;
		
	}

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
