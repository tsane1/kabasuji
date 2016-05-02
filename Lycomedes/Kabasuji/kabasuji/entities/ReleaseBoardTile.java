package kabasuji.entities;

/**
 * Tile Subclass which will make up the Release Level Boards.
 * 
 * @author Derek McMaster
 * @author Michael
 * @author Ian Jacoway
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
	

	/** value of the tile, a number that will be translated into a color later */
	int value, numColor;
	
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
		numColor = 0;
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
	 * Increments release number supports up to six then resets to zero.
	 */
	public void updateReleaseNum(){
		if(value<18){

			value++;
		}
		else {
			value = 0;
			updateReleaseColor();
		}
	}

	/**
	 * Increments release number's color supports up to three,
	 * each number corresponds to a color, default color is black at value zero.
	 */
	public void updateReleaseColor(){
		if(numColor < 2){
			numColor++;
		}else{
			numColor= 0;
		}
		
	}

	/**	
	 * Gets the value or number on the tile.
	 * @return int
	 */
	public int getValue(){
		return value;
	}

	/**	
	 * Gets the value or number on the tile.
	 * @return int
	 */
	public int getNumColor(){
		return numColor;
	}

}
