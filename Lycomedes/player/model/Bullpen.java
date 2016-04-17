package model;

import java.awt.List;
import java.util.ArrayList;

/**
 * IMPORTANT QUESTIONS
 * should allow duplicates?
 * should set max capacity?
 */
public class Bullpen {
	
	private ArrayList<Piece> pieces;
	
	/**
	 * generic constructor which creates a new, empty piece list
	 */
	public Bullpen() {
		pieces = new ArrayList<Piece>();
	}
	
	/**
	 * overloaded constructor that you can passed already
	 * made lists of pieces into
	 * @param pieces
	 */
	public Bullpen(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}
	
	/**
	 * Add method for a bullpen object's piece list
	 * @param piece
	 */
	public boolean addPiece(Piece piece) {
		 return this.pieces.add(piece);
	}
	
	/**
	 * Remove method for bullpen object's piece list
	 * @param piece
	 */
	public boolean removePiece(Piece piece){
		return this.pieces.remove(piece);
	}
	
	public ArrayList<Piece> getPieces(){
		return this.pieces;
	}
}

