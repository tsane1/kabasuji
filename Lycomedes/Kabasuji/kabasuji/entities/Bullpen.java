package kabasuji.entities;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * IMPORTANT QUESTIONS
 * should allow duplicates?
 * should set max capacity?
 */
public class Bullpen implements Serializable{
	
	/** arraylist of pieces in the bullpen for the level. */
	private ArrayList<Piece> pieces;
	/** arraylist of pieces that were previously in the bullpen and are now on the board. */
	private ArrayList<Piece> playedPieces;
	/** selected piece */
	Piece selectedPiece = null;
	
	/**
	 * generic constructor which creates a new, empty piece list.
	 */
	public Bullpen() {
		pieces = new ArrayList<Piece>();
		playedPieces = new ArrayList<Piece>();		
	}
	
	/**
	 * overloaded constructor that you can passed already
	 * made lists of pieces into.
	 * @param pieces
	 */
	public Bullpen(ArrayList<Piece> pieces) {
		this.pieces = pieces;
		playedPieces = new ArrayList<Piece>();
	}
	
	/**
	 * Add method for a bullpen object's piece list.
	 * @param piece
	 */
	public boolean addPiece(Piece piece) {
		 return this.pieces.add(piece);
	}
	
	/**
	 * Remove method for bullpen object's piece list.
	 * @param piece
	 */
	public boolean removePiece(Piece piece){
		return this.pieces.remove(piece);
	}
	
	/**
	 * getter method to get all of the pieces in the bullpen.
	 * @return Arraylist of pieces
	 */
	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
	
	/**
	 * Returns the currently selected piece.
	 * @return a piece
	 */
	public Piece getSelected() {
		return selectedPiece;
	}

	/**
	 * Sets the selected piece to the passed piece.
	 * @param Piece p
	 */
	public void setSelectedPiece(Piece p) {
		this.selectedPiece = p;
	}
	
	/**
	 * Gets the list of played pieces that are on the board.
	 * @return Arraylist of pieces that were previously in the bullpen and are now on the board.
	 */
	public ArrayList<Piece> getPlayedPieces(){
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
}

