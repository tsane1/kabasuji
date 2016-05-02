package kabasuji.moves;

import java.awt.Color;

import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.supers.Level;
import kabasuji.supers.Move;

/**
 * Move class for adding a piece from the palette to the bullpen.
 * @author Derek McMaster
 *
 */
public class PaletteToBullpenMove extends Move {
	/** Level being updated. */
	Level level;
	/** Piece being moved. */
	Piece currPiece;
	/** Array to copy tiles into. */
	PieceTile[] arr;
	/** int to copy id into. */
	int id;
	/** new piece from copy constructor format. */
	Piece newPiece;
	
	/**
	 * Constructor for Palette to Bullpen move.
	 * @param Level l
	 * @param Piece p
	 */
	public PaletteToBullpenMove(Level l, Piece p){
		this.level = l;
		this.currPiece = p;
		arr = new PieceTile[6];
		id = 0;
	}
	
	/**
	 * Handles the execution of the move.
	 */
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
		System.out.println(currPiece.getPieceID());
		Color c = level.getColorMap().get(currPiece.getPieceID());
		level.getColorMap().put(newPiece.getPieceID(), c);
		
		//deselect the piece for next move
		//level.setSelected(null);
		
		return true;
	}

	/**
	 * Handles undoing the move if requested.
	 */
	@Override
	public boolean undo() {
		level.getBullpen().removePiece(newPiece);
		return true;
	}

	/**
	 * Determines whether or not the move is valid.
	 */
	@Override
	public boolean valid() {
		if(currPiece == null) { return false; }
		return true;
	}

}
