package kabasuji.supers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseLevel;

/** 
 * Model class containing and storing all necessary game entities.
 * 
 * <p>
 * This class contains entities related to the player and the builder.
 * For entities that contain entities ({@code Level} contains {@code Board}, etc.) the sub-entities
 * can be accessed through the super-entity that contains them ({@code Board} is accessed through {@code Level}).
 * This class also handles undo and redo events during builder use. This functionality
 * is disqualified in player by forcing a typecheck on the current view in undo and redo controllers.
 * </p>
 * 
 * @author Tanuj Sane
 * @author Derek McMaster
 * @since 4/19/2016
 *
 */

public class SuperModel {
	ArrayList<String> defaultLevelNames = new ArrayList<String>(15);
	ArrayList<String> userLevelNames = new ArrayList<String>();
	Level activeLevel;
	int page;
	private String userLevelsDirectory, defaultLevelsDirectory;	
	
	/**
	 * Constructor for the SuperModel, sets up all necessary game elements in initial state.
	 */
	public SuperModel() {
		userLevelsDirectory = System.getProperty("user.dir") + System.getProperty("file.separator") + "user_levels" + System.getProperty("file.separator");
		defaultLevelsDirectory = System.getProperty("user.dir") + System.getProperty("file.separator") + "default_levels" + System.getProperty("file.separator");
		activeLevel = null;
		page = 0;
		setupDefaultLevelNames();
		updateUserLevelNames();
	}
	
	public SuperModel(String testString){
		//string passed should be test...used to test 
		activeLevel = null;
		page = 0;
	}
	
	private void setupDefaultLevelNames() {
		System.out.println(defaultLevelsDirectory);
		File[] files = new File(defaultLevelsDirectory).listFiles();
		Arrays.sort(files, new Comparator<File>() {
      @Override
      public int compare(File o1, File o2) {
          int n1 = extractNumber(o1.getName());
          int n2 = extractNumber(o2.getName());
          return n1 - n2;
      }

      private int extractNumber(String name) {
          int i = 0;
          try {
              int s = name.indexOf(' ')+1; // TODO: Find a better way to get number out
              int e = name.lastIndexOf('.');
              String number = name.substring(s, e);
              i = Integer.parseInt(number);
          } 
          catch(Exception e) {  
              i = 0; // if filename does not match the format
                     // then default to 0
          }
          return i;
      }
		});
		for(File f : files) {
			defaultLevelNames.add(loadLevel(defaultLevelsDirectory, f.getName()).getLevelName());
		}
	}
	public void updateUserLevelNames() {
		userLevelNames.removeAll(userLevelNames);
		for(File f : new File(userLevelsDirectory).listFiles()) {
			userLevelNames.add(loadLevel(userLevelsDirectory, f.getName()).getLevelName());
		}
	}
	//
	/**
	 * The following three methods track the pagination of the level play and edit
	 * selection views. These methods are used to extract the necessary information
	 * and set it properly via the proper controllers.
	 */
	
	public int getPage() {
		return this.page;
	}
		
	public void nextPage() {
		this.page += 1;
	}
	
	public void prevPage() {
		this.page -= 1;
	}
	
	/**
	 * These methods deal with the active level, which is used when levels are being
	 * manipulated or played.
	 */
	
	public void setActiveLevel(Level level) {
		this.activeLevel = level;
	}
	
	public Level getActiveLevel() {
		return this.activeLevel;
	}
	
	public String getDefaultLevelDir() {
		return defaultLevelsDirectory;
	}
	public String getUserLevelDir() {
		return userLevelsDirectory;
	}
	
	/**
	 * Method to access any level given its name.
	 * @param fileName
	 * @return Instance of requested level, or null if the file does not exist.
	 */
	public Level loadLevel(String dir, String fileName) {
		String filepath = dir + fileName;
			Level loadedLevel = null;
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File(filepath)));
				loadedLevel = (Level)input.readObject();
				input.close();
			}
			catch (ClassNotFoundException e) {
				
			} 
			catch (IOException e) {
				
			}
			return loadedLevel;
	}
	
	/**
	 * 
	 * @param dir Directory to look for files in
	 * @param fileName Name of the file from which to open
	 * @return Integer 0-3 indicating number of stars gotten for that levels
	 */
	public int loadAch(String fileName) {
		String filepath = System.getProperty("user.dir") + System.getProperty("file.separator") + fileName;
			Integer loadedAch = null;
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File(filepath)));
				loadedAch = (Integer)input.readObject();
				input.close();
			}
			catch (ClassNotFoundException e) {
				
			} 
			catch (IOException e) {
				
			}
			System.out.println("loaded ach " + (int)loadedAch);
			return loadedAch;
	}
	
	/**
	 * Method to remove any level given its name
	 * @param fileName
	 */
	public void deleteLevel(String dir, String fileName) {
		String filepath = dir + fileName;
		File file = new File(filepath);
		if(file.delete());
		else System.out.println("Error 38762u386w: Could not delete level, check SuperModel::removeLevel.");
		updateUserLevelNames();
	}
	
	/**
	 * Getters for number of levels
	 */
	public int getTotalNumLevels() {
		return defaultLevelNames.size() + getNumUserLevels();
	}
	
	public int getNumUserLevels() {
		return userLevelNames.size();
	}
	
	/**
	 * Level name getters
	 */
	public String getDefaultLevelNameByIndex(int idx) {
		return defaultLevelNames.get(idx);
	}
	
	public String getUserLevelNameByIndex(int idx) {
		return userLevelNames.get(idx);
	}
	
	private void generateDefaultLevels() {
		for(int i = 0; i < 15; i++) {
			if(i%3 == 0) {
				ReleaseLevel rl = new ReleaseLevel("Level " + (i+1));
				if(i>2)rl.lock();
				rl.saveLevel(this.getDefaultLevelDir());
			}
			else if(i%3 == 1) {
				LightningLevel ll = new LightningLevel("Level " + (i+1));
				if(i>2)ll.lock();
				ll.saveLevel(this.getDefaultLevelDir());
			}
			else if(i%3 == 2) {
				PuzzleLevel pl = new PuzzleLevel("Level " + (i+1));
				if(i>2)pl.lock();
				pl.saveLevel(this.getDefaultLevelDir());
			}
		}
	}
	
	/**
	 * Dummy main for testing purposes
	 * @param args
	 */
	public static void main(String[] args) {
		SuperModel sm = new SuperModel();
		sm.generateDefaultLevels();
	}
}
