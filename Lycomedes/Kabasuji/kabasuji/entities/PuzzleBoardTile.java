package kabasuji.entities;

/**
 * Tile Subclass which will make up the Puzzle Level Boards
 */
public class PuzzleBoardTile extends Tile{

	int row, col;
	private boolean covered;
	
	public PuzzleBoardTile(int row, int column) {
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
