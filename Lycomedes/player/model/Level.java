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
	
	public Level(){
		this("test", "level");
	}
	
	public String getLevelName() {
		return name + ": " + type;
	}

	public String getLevelType() {
		return type;
	}
	
	public void setLevelName(String name){
		this.name = name;
	}
	
	public void setLevelType(String type){
		this.type = type;
	}
	
	public Board getBoard() {
		return this.theBoard;
	}
	
	public Bullpen getBullpen() {
		return this.theBullpen;
	}
	
	public void quit() {
		System.out.println("Saving state and exiting.");
	}
}