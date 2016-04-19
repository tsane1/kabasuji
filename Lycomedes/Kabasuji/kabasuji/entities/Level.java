package kabasuji.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import kabasuji.supers.Model;

public class Level extends Model implements Serializable{
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
	
	public Level loadLevel(File file) {
		
		Level loadedLevel = null;
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			loadedLevel = (Level) input.readObject();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loadedLevel;
	}
	
	public void saveLevel(File file){
		try{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
			output.writeObject(this);
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
}
