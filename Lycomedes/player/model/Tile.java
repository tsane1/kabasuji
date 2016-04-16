package model;

public abstract class Tile {
	
	int row, col;
	
	public static final int width = 32;
	public static final int length = 32;
	
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
