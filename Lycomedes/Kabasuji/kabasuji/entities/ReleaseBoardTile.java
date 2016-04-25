package kabasuji.entities;

/**
 * Tile Subclass which will make up the Release Level Boards.
 * 
 * @author Derek McMaster
 * @author Michael
 */
public class ReleaseBoardTile extends Tile{

	/**
	 * serial Id for releaseboardtile.
	 */
	private static final long serialVersionUID = -2218330060081200831L;
	/** row and column attributes for a tile object. */
	int row, col;
	/** attribute for whether or not a tile is covered. */
	private boolean covered;
	
	int value;
	
	/**
	 * Constructor for the releaseboardtile object.
	 * @param int row
	 * @param int col
	 */
	public ReleaseBoardTile(int row, int column) {
		super(row, column);
		
		
		this.row = row;
		this.col = column;
		value = 0;
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
	/**
	 * increments release number up to six
	 */
	public void updateReleaseNum(){
		if(value<6){
			value++;
		}else{
			value = 0;
		}
		
	}

	public int getValue(){
		return value;
	}
	
	
}
