package kabasuji.entities;

/**
 * Abstract super class for tiles.  Will be subclassed to iclude types of tiles in all 3 different kinds of boards
 * as well as the tiles that make up pieces and unplayable tiles for the builder. 
 */
public abstract class Tile {
	
	int row, col;
	private boolean covered;
	
	public static final int width = 32;
	public static final int length = 32;
	
	public Tile(int row, int col) {
		this.row = row;
		this.col = col;
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
