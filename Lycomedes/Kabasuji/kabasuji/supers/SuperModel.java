package kabasuji.supers;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

import kabasuji.entities.LightningLevel;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.PuzzleLevel;

/** 
 * Model class containing all necessary game entities.
 * 
 * <p>
 * This class contains entities related to the player and the builder.
 * Entities that contain entities ({@code Level} contains {@code Board}, etc.) are not double-included.
 * This class also handles undo and redo events during builder use. This functionality
 * is disqualified in player by forcing a typecheck on the current view.
 * </p>
 * 
 * @author Tanuj Sane
 * @author Derek McMaster
 * @since 4/19/2016
 *
 */

public class SuperModel {
	private HashMap<String, Level> defaultLevels = new HashMap<String, Level>(15);
	private HashMap<String, Level> userLevels = new HashMap<String, Level>();
	
	Stack<Move> undoStack = new Stack<Move>();
	Stack<Move> redoStack = new Stack<Move>();
	

	public SuperModel() {
		setupDefaultLevels();
	}

	public void setupDefaultLevels() {
		for(int i = 0; i < 15; i++) {
			String filename = "Level " + (i+1);// + ".lev";
			//defaultLevels.put(filename, loadLevel(filename));
			defaultLevels.put(filename, new LightningLevel(filename));
		}
	}
	
	public Level getLevel(String name) {
		if(name == null) return null;
		if(defaultLevels.containsKey(name)) return defaultLevels.get(name);
		else if(userLevels.containsKey(name)) return userLevels.get(name);
		else return null;
	}
	
	public int totalLevels() {
		return defaultLevels.size() + userLevels.size();
	}
	
	public int numUserLevels() {
		return userLevels.size();
	}

	private Level loadLevel(String filename) {		
		if(!filename.contains(".lev")) return null;
		
		File file = new File(filename);
		Level loadedLevel = null;
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			loadedLevel = (Level)input.readObject();
			input.close();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return loadedLevel;
	}

	public void saveLevel(Level level) {
		File file = new File(level.getLevelName() + ".lev");
		try{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
			output.writeObject(level);
			output.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		userLevels.put(level.getLevelName(), level);
	}

	public boolean deleteLevel(Level lev){
		try{
			String filepath = "/levels/"+lev.getLevelName()+".lev";
			File level = new File(filepath);
			return level.delete();
		}
		catch(Exception e){
			System.err.println("Error deleting level: " + lev.getLevelName());
			e.printStackTrace();
		}
		return false;
	}

	public void trackMove(Move m){
		undoStack.add(m);
		redoStack.clear();
	}

	public Move getLastMove(){
		if(undoStack.isEmpty()) {
			return null;
		}
		return undoStack.pop();
	}

	public void addMoveToUndo(Move m){
		undoStack.push(m);
	}

	public void addRedoableMove(Move m){
		redoStack.push(m);
	}

	public Move getRedoMove(){
		if(redoStack.isEmpty()){
			return null;
		}
		return redoStack.pop();
	}
	
	public static void main(String[] args) {
		SuperModel sm = new SuperModel();
	}
}
