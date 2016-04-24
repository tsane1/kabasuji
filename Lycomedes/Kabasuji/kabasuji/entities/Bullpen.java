package kabasuji.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * IMPORTANT QUESTIONS
 * should allow duplicates?
 * should set max capacity?
 */
public class Bullpen implements Serializable{
	
	/** arraylist of pieces in the bullpen for the level. */
	List<Piece> pieces;
	/** arraylist of pieces that were previously in the bullpen and are now on the board. */
	List<Piece> playedPieces;
	/** ArrayList of original pieces in the bullpen to use in the view */
	List<Piece> originalSet;

	
	/**
	 * generic constructor which creates a new, empty piece list.
	 */
	public Bullpen() {
		pieces = new ArrayList<Piece>();
		originalSet = new ArrayList<Piece>();
		playedPieces = new ArrayList<Piece>();		
	}
	
	/**
	 * overloaded constructor that you can passed already
	 * made lists of pieces into.
	 * @param pieces
	 */
	public Bullpen(List<Piece> pieces) {
		this.pieces = new ArrayList<Piece>();
		this.pieces.addAll(pieces);
		originalSet = new ArrayList<Piece>();
		playedPieces = new ArrayList<Piece>();
	}
	
	/**
	 * Add method for a bullpen object's piece list.
	 * @param piece
	 */
	public boolean addPiece(Piece piece) {
		 return this.pieces.add(piece) && this.originalSet.add(piece);
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
		return this.pieces.remove(piece) && this.originalSet.remove(piece);
	}
	
	/**
	 * getter method to get all of the pieces in the bullpen.
	 * @return Arraylist of pieces
	 */
	public List<Piece> getPieces(){
		return this.pieces;
	}
	
	/**
	 * Gets the list of played pieces that are on the board.
	 * @return Arraylist of pieces that were previously in the bullpen and are now on the board.
	 */
	public List<Piece> getPlayedPieces(){
		return playedPieces;
	}
	
	/**
	 * Once piece is put on board you take it out of the bullpen and add it to the board array.
	 * @param Piece p
	 * @return boolean success of adding and removing the piece to respective arrays
	 */
	public boolean setPieceAsPlayed(Piece p) {
		return pieces.remove(p) && playedPieces.add(p);
	}
	
	/**
	 * Returns the piece back to the bullpen if the move was invalid or user changes mind.
	 * @param Piece p
	 * @return boolean success of adding or removing piece
	 */
	public boolean addPieceBackToBullpen(Piece p) {
		return pieces.add(p) && playedPieces.remove(p);
	}
	
	/**
	 * Method to get overall collection of pieces that were in bullpen at start.
	 * @return List of pieces
	 */
	public List<Piece> getOriginalSet(){
		return originalSet;
	}
	
	/**
	 * helper method that returns whether or not a bullpen is empty.
	 * @return boolean
	 */
	public boolean isEmpty(){
		return this.pieces.isEmpty();
	}
}

