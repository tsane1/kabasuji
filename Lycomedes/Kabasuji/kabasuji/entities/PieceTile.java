package kabasuji.entities;

import java.io.Serializable;

/**
 * Tile Subclass which will make up the pieces.
 * 
 * @author Derek McMaster
 */
public class PieceTile extends Tile implements Serializable {

	/**
	 * serial number.
	 */
	private static final long serialVersionUID = 2772653943506364180L;
	
	/**
	 * Constructor for the piecetile. 
	 * @param int row 
	 * @param int column
	 */
	public PieceTile(int row, int column) {
		super(row, column);
	}

	/**
	 * Overloaded constructor for the piecetile. 
	 * @param Piecetile other
	 */
	public PieceTile(PieceTile other) {
		super(other.row, other.col);
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

	/**
	 * Method to change a tile to covered state.
	 * @return void
	 */
	@Override
	public void cover() {
		//nothing
	}

	/**
	 * Method to change a tile to uncovered state.
	 * @return void
	 */
	@Override
	public void uncover() {
		//nothing
	}

	/**
	 * Method to determine a tile's covered state.
	 * @return boolean
	 */
	@Override
	public boolean isCovered() {
		return true;
	}
}
