package kabasuji.moves;

import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.supers.Level;
import kabasuji.supers.Move;

public class PaletteToBullpenMove extends Move {

	Level level;
	Piece currPiece;
	PieceTile[] arr;
	int id;
	Piece newPiece;
	
	public PaletteToBullpenMove(Level l, Piece p){
		this.level = l;
		this.currPiece = p;
		arr = new PieceTile[6];
		id = 0;
	}
	
	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		int idx = 0;
		for(PieceTile pt : currPiece.getTileLocations())
		{
			arr[idx] = new PieceTile(pt.getRow(), pt.getColumn());
			idx++;
		}
		this.id = currPiece.getPieceID();
		newPiece = new Piece(id, arr);
		level.getBullpen().addPiece(newPiece);
		return true;
	}

	@Override
	public boolean undo() {
		level.getBullpen().removePiece(newPiece);
		return true;
	}

	@Override
	public boolean valid() {
		if(currPiece == null) { return false; }
		return true;
	}

}
