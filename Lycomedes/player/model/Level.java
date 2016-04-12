package model;

public class Level extends supers.Model {
	private String name, type;
	private Piece[] placedPieces;
	private Board theBoard;
	private Bullpen theBullpen;
	
	public Level(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getLevelName() {
		return name + ": " + type;
	}

	public String getLevelType() {
		return type;
	}
}
