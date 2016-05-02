package kabasuji.entities;
/**
 * Tile subclass that represents an unplayable boundary of the board.
 * @author Michael
 *
 */
public class UnplayableTile extends Tile {
	
	/**
	 * serial Id for puzzleboardtile
	 */
	private static final long serialVersionUID = 684927514430563777L;
	
	/** row and column attributes for a tile object. */
	int row, col;
	/** attribute for whether or not a tile is covered. */
	private boolean covered;
	
	/**
	 * Constructor for the unplayable tile object.
	 * @param int row
	 * @param int col
	 */
	public UnplayableTile(int row, int col) {
		super(row, col);
		
		this.row = row;
		this.col = col;
		covered = true;
	}
	
	/**
	 * Method to change a tile to covered state.
	 * @return void
	 */
	public void cover(){
		covered = true;
	}
	
	/**
	 * Method to change a tile to uncovered state.
	 * @return void
	 */
	public void uncover(){
		covered = true;
	}
	
	/**
	 * Method to determine a tile's covered state.
	 * @return boolean
	 */
	public boolean isCovered(){
		return covered;
	}
}
