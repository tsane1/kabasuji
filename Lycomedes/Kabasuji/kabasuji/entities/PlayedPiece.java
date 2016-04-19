package kabasuji.entities;

/**
 * Helper class to keep track of pieces played on the board.  Needed to change Pieces to polygons for graphics purposes
 */
public class PlayedPiece {

	Piece currPiece;
	int row, col;
	
	public PlayedPiece(Piece piece, int row, int col) {
		this.currPiece = piece;
		this.row = row;
		this.col = col;
	}
	
	public Piece getPiece(){
		return currPiece;
	}
	
	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
	

}
