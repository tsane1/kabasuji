package model;

import java.util.ArrayList;

public class Bullpen {
	private ArrayList<Piece> pieces;
	
	public Bullpen() {
		
	}
	public Bullpen(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}
	
	public void addPiece(Piece p) {
		this.pieces.add(p);
	}
}

