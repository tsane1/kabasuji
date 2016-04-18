package model;

import java.util.Arrays;
import java.util.Iterator;

public class Piece implements Iterable<PieceTile>{
	
	private String pieceID;
	private int pieceIDnum;
	PieceTile[] tiles;
	
	/**
	 * Constructor for a piece. Pass a number and 6 tile locations.
	 * Name given to the piece with its ID num.  If given less than 6 tiles
	 * the constructor will throw an exception
	 * @param idNum
	 * @param arr
	 */
	public Piece(int idNum, PieceTile[] arr){
		this.pieceIDnum = idNum;
		this.pieceID = "Piece " + idNum;;
		try {
			if(arr.length == 6) {

				this.tiles = arr;
			}
		}
		catch(Exception e) {
			System.err.println("PIECE CONSTRUCTOR: PIECE NEEDS SIX TILES");
			e.printStackTrace();
		}
	}

	/**
	 * Overrides the iterator method.  Gives back the tiles array as a list
	 */
	@Override
	public Iterator<PieceTile> iterator() {
		return Arrays.asList(tiles).iterator();
	}
	
	/**
	 * Gets the piece's "name"
	 */
	public String getPieceName(){
		return this.pieceID;
	}
	
	/**
	 * Gets the piece's ID number
	 */
	public int getPieceID() {
		return this.pieceIDnum;
	}
	
	/**
	 * Quick helper method used in computations. Should return 6.
	 */
	public int numTilesInPiece() {
		return tiles.length;
	}
}
