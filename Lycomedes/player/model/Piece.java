package model;

import java.util.Arrays;
import java.util.Iterator;

public class Piece implements Iterable<PieceTile>{
	
	private String pieceID;
	private int pieceIDnum;
	PieceTile[] tiles;
		
	public Piece(int idNum, PieceTile[] arr) {
		this.pieceIDnum = idNum;
		this.pieceID = "Piece " + idNum;;
		if(arr.length == 6) {
			this.tiles = arr;
		}
		else {
			System.err.println("PIECE CONSTRUCTOR : Need 6 tiles to make a piece!");
		}
	}

	@Override
	public Iterator<PieceTile> iterator() {
		return Arrays.asList(tiles).iterator();
	}
	
	public String getPieceName(){
		return this.pieceID;
	}
}
