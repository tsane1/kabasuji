package kabasuji.entities;

import java.io.Serializable;

/**
 * Abstract super class for tiles.  Will be subclassed to iclude types of tiles in all 3 different kinds of boards
 * as well as the tiles that make up pieces and unplayable tiles for the builder. 
 * 
 * @author Derek McMaster
 */
public abstract class Tile implements Serializable{
	
	/**
	 * serial id.
	 */
	private static final long serialVersionUID = 1L;
	
	/** row and column attributes for a tile object. */
	int row, col;
	/** attribute for whether or not a tile is covered. */
	boolean covered;
	
	/** global for the width of a tile which is 32 pixels. */
	public static final int width = 32;
	/** global for the height of a tile which is 32 pixels. */
	public static final int height = 32;
	
	/**
	 * Constructor for the abstract tile object.
	 * @param int row
	 * @param int col
	 */
	public Tile(int row, int col) {
		this.row = row;
		this.col = col;
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
