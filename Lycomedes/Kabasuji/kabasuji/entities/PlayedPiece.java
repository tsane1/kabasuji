package kabasuji.entities;

/**
 * Helper class to keep track of pieces played on the board.
 * @author Derek McMaster
 */
public class PlayedPiece {

	/** the current piece being manipulated */
	Piece currPiece;
	/** row and column attribute of the specified piece */
	int row, col;
	
	/**
	 * Constructor for the playedpiece object.
	 * @param Piece currPiece
	 * @param int row
	 * @param int column
	 */
	public PlayedPiece(Piece piece, int row, int col) {
		this.currPiece = piece;
		this.row = row;
		this.col = col;
	}
	
	/**
	 * getter for the piece being manipulated.
	 * @return Piece thePiece
	 */
	public Piece getPiece(){
		return currPiece;
	}
	
	/**
	 * getter for the row of the piece being manipulated.
	 * @return int row
	 */
	public int getRow(){
		return row;
	}
	
	/**
	 * getter for the column of the piece being manipulated.
	 * @return int column
	 */
	public int getCol(){
		return col;
	}
}
