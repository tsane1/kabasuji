package kabasuji.entities;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

/**
 * Palette entity used in the level builder.
 * 
 * @author Derek McMaster
 */
public class Palette implements Serializable {

	/** List of pieces in the palette */
	List<Piece> pieces;
	
	/**
	 * Generic constructor for the palette.
	 */
	public Palette() {
		pieces = new ArrayList(35);
	}

	/**
	 * Add method to add a list of pieces to the Bullpen. Used for setting up new levels.
	 * @param List of pieces
	 * @boolean
	 */
	public boolean addPieces(List<Piece> allPieces){
		return this.pieces.addAll(allPieces);
	}
	
	/**
	 * Remove method for bullpen object's piece list.
	 * @param piece
	 */
	public boolean removePiece(Piece piece){
		return this.pieces.remove(piece);
	}
	
	/**
	 * getter method to get all of the pieces left in the bullpen.
	 * @return Arraylist of pieces
	 */
	public List<Piece> getPieces(){
		return this.pieces;
	}
}
