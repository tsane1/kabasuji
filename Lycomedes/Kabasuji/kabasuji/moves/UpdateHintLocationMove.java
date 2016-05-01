package kabasuji.moves;

import kabasuji.entities.Board;
import kabasuji.entities.LightningBoardTile;
import kabasuji.entities.PuzzleBoardTile;
import kabasuji.entities.ReleaseBoardTile;
import kabasuji.supers.Level;
import kabasuji.supers.Move;

public class UpdateHintLocationMove extends Move {

	int col, row;
	Level lev;
	Board b;
	
	public UpdateHintLocationMove(int row, int col, Level l){
		this.row = row;
		this.col = col;
		this.lev = l;
		this.b = l.getBoard();
	}
	
	@Override
	public boolean execute() {
		if(!valid()) { return false; }
		
		String leveltype = lev.getLevelType();
		switch(leveltype){
		case "Puzzle":
			b.setHintLocation(new PuzzleBoardTile(row, col));
			break;
		case "Lightning":
			b.setHintLocation(new LightningBoardTile(row, col));
			break;
		case "Release":
			b.setHintLocation(new ReleaseBoardTile(row, col));
			break;
		default:
			System.out.println("Tile type not recognized");
		}
		return true;
	}

	@Override
	public boolean undo() {
		if(b.getHintLocations().size() > 0) b.getHintLocations().remove(b.getHintLocations().size()-1);
		else return false;
		return true;
	}

	@Override
	public boolean valid() {
		return !(b.getHintLocations().size() > 6);
	}

}
