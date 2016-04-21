package kabasuji.entities;

/**
 * Tile Subclass which will make up the Puzzle Level Boards.
 * 
 * @author Derek McMaster
 */
public class PuzzleBoardTile extends Tile{

	/**
	 * serial Id for puzzleboardtile.
	 */
	private static final long serialVersionUID = 1731217237418160460L;
	/** row and column attributes for a tile object. */
	int row, col;
	/** attribute for whether or not a tile is covered. */
	private boolean covered;
	
	/**
	 * Constructor for the  puzzleboardtile object.
	 * @param int row
	 * @param int col
	 */
	public PuzzleBoardTile(int row, int column) {
		super(row, column);
		
		this.row = row;
		this.col = column;
		covered = false;
	}
	
	/**
	 * Method to change a tile to covered state.
	 * @return void
	 */
	public void cover() {
		covered = true;
	}
	
	/**
	 * Method to change a tile to uncovered state.
	 * @return void
	 */
	public void uncover(){
		covered = false;
	}
	
	/**
	 * Method to determine a tile's covered state.
	 * @return boolean
	 */
	public boolean isCovered() {
		return covered;
	}
}
