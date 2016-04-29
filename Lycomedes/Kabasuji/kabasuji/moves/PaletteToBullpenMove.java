package kabasuji.moves;

import java.awt.Color;

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
		
		//copy over the piece tiles to a new array
		int idx = 0;
		for(PieceTile pt : currPiece.getTileLocations())
		{
			arr[idx] = new PieceTile(pt.getRow(), pt.getColumn());
			idx++;
		}
		
		//get the size of the array
		//no need to add +1 because 0 indexed means adding one more will be the "size-th" element
		this.id = level.getAllPieces().size();
		//create the new piece
		newPiece = new Piece(id, arr);
		//add it to all piece to increase the size for next time
		level.addPieceToAllPieces(newPiece);
		//add it to the bullpen
		level.getBullpen().addPiece(newPiece);
		
		//to keep color consistent get color from original piece and put in color map with new id
		Color c = level.getColorMap().get(currPiece);
		level.getColorMap().put(newPiece.getPieceID(), c);
		
		//deselect the piece for next move
		level.setSelected(null);
		
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
