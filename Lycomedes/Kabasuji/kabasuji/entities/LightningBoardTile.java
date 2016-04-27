package kabasuji.entities;

/**
 * Tile Subclass which will make up the Lightning Level Boards.
 * 
 * @author Derek McMaster
 * @author Michael Pickett
 */
public class LightningBoardTile extends Tile{

	/**
	 * serial Id for lightningboardtile.
	 */
	private static final long serialVersionUID = -8103462939793486285L;
	/** row and column attributes for a tile object. */
	int row, col;
	/** attribute for whether or not a tile is covered. */
	private boolean covered;
	/** attribute to determine if a tile is covered for lightning levels. */
	private boolean marked;
	
	/**
	 * Constructor for the lightningboardtile object.
	 * @param int row
	 * @param int col
	 */
	public LightningBoardTile(int row, int column) {
		super(row, column);
		
		this.row = row;
		this.col = column;
		covered = false;
		marked = false;
	}
	
	/**
	 * Method to change a tile to covered state.
	 * @return void
	 */
	public void cover() {
		covered = false;
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
	
	/**
	 * Marks a lightning tile.
	 */
	public void mark(){
		marked = true;
	}
	
	/**
	 * Unmarks a tile.
	 */
	public void unmark(){
		marked = false;
	}
	
	/**
	 * Gets the marked boolean.
	 * @return true is tile is marked
	 */
	public boolean isMarked(){
		return marked;
	}
}
