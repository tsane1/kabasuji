package model;

public class Level {
	private String name;
	private String type;
	
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
