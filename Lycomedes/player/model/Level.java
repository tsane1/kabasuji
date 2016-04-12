package model;

public class Level {
	private String name, type;
	private Piece[] placedPieces;
	private Board theBoard;
	private Bullpen theBullpen;
	
	public Level(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public Level(){
		//nothing
	}
	
	public String getLevelName() {
		return name + ": " + type;
	}
	
	public void setLevelName(String name){
		this.name = name;
	}
	
	public String getLevelType() {
		return type;
	}
	
	public void setLevelType(String type){
		this.type = type;
	}
}
