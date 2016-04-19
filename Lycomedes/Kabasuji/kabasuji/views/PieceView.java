package kabasuji.views;

import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;

public class PieceView {

	Piece currPiece;
	
	public PieceView(Piece p) {
		this.currPiece = p;
		
		for(PieceTile pt : p.getTileLocations())
		{
			TileView tv = new TileView();
		}
	}

}
