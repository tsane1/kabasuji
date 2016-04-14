package model;

public abstract class Tile {
	private int row, col;
	private static final int sideLength = 32;
	private boolean covered;
	
	public Tile(int row, int col) {
		this.row = row;
		this.col = col;
		covered = false;
	}
	
	public void cover() {
		covered = true;
	}
}
