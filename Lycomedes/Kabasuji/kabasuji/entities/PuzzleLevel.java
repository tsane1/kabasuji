package kabasuji.entities;

import kabasuji.supers.Level;

public class PuzzleLevel extends Level {
	private int movesLeft;
	
	public PuzzleLevel(String name) {
		super(name, "Puzzle");
	}
	
	public int getMovesLeft() {
		return this.movesLeft;
	}
	
	public void setMovesLeft(int setMoves) {
		this.movesLeft = setMoves;
	}

}
