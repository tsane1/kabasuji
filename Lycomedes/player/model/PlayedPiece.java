package model;

import java.awt.Point;
import java.awt.Polygon;

/**
 * Helper class to keep track of pieces played on the board.  Needed to change Pieces to polygons for graphics purposes
 */
public class PlayedPiece {

	Piece currPiece;
	Polygon shape;
	
	public PlayedPiece(Piece piece, Polygon p) {
		this.currPiece = piece;
		this.shape = p;
	}
	
	public boolean contains(Point p) {
		return shape.contains(p);
	}
	
	public Piece getPiece(){
		return currPiece;
	}
	
	public Polygon getPolygon() {
		return shape;
	}

}
