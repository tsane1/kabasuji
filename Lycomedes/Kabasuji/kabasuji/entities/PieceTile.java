package kabasuji.entities;

import java.io.Serializable;

/**
 * Tile Subclass which will make up the pieces.
 * 
 * @author Derek McMaster
 */
public class PieceTile extends Tile implements Serializable{

	/**
	 * serial number.
	 */
	private static final long serialVersionUID = 2772653943506364180L;
	
	/** Row location of the tile.*/
	int row;
	/** Column location of the tile. */
	int col;
	
	/**
	 * Constructor for the piecetile. 
	 * @param int row 
	 * @param int column
	 */
	public PieceTile(int row, int column) {
		super(row, column);
		
		this.row = row;
		this.col = column;
	}

	/**
	 * setter for the row attribute of a piecetile.
	 * @param int row
	 * @return void
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	 * getter for the row attribute of a piecetile.
	 * @return row int 
	 */
	public int getRow(){
		return row;
	}
	
	/**
	 * setter for the column attribute of a piecetile.
	 * @param int column
	 * @return void
	 */
	public void setColumn(int col){
		this.col = col;
	}
	
	/**
	 * getter for the column attribute of a piecetile.
	 * @return column int
	 */
	public int getColumn(){
		return col;
	}
}
