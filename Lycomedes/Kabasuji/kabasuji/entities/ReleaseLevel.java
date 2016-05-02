package kabasuji.entities;

import java.util.ArrayList;
import kabasuji.supers.Level;

/**
 * Level sublcass for the puzzle level entity.
 * 
 * @author Derek McMaster
 * @author Tanuj Sane
 * @author Chase St. Laurent
 */
public class ReleaseLevel extends Level {
	
	/** Arraylist for the red number tiles collected in the level. */
	private ArrayList<Integer> redsCollected = new ArrayList<Integer>(6);
	/** Arraylist for the green number tiles collected in the level. */
	private ArrayList<Integer> greensCollected = new ArrayList<Integer>(6);
	/** Arraylist for the yellow number tiles collected in the level. */
	private ArrayList<Integer> yellowsCollected = new ArrayList<Integer>(6);
	/** A bullpen instance to check the ending or completeing of the level.*/
	Bullpen bullpen;
	/**
	 * serial id.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Public constructor for the release level entity.
	 * @param String name
	 */
	public ReleaseLevel(String name) {
		super(name, "Release");
	}
	
	/**
	 * Returns the number tiles collected for each color.
	 * @param color
	 * @return List
	 */
	public ArrayList<Integer> getNumsCollectedByColor(String color) {
		switch(color) {
		case "red":
			return this.redsCollected;
		case "yellow":
			return this.yellowsCollected;
		case "green":
			return this.greensCollected;
		}
		return null;
	}
	
	/**
	 * Method to add a number tile as collected in a level. 
	 * @param String color
	 * @param int num
	 */
	public void collect(String color, int num) {
		switch(color) {
		case "red":
			this.redsCollected.add(num);
			break;
		case "yellow":
			this.yellowsCollected.add(num);
			break;
		case "green":
			this.greensCollected.add(num);
			break;
		
		}
	}

	/**
	 * Determines the number of stars for achievements based on the numbers collected.
	 */
	@Override
	public void setNumStars() {
		byte r =(byte)((this.redsCollected.size() == 6)? 1:0);
		byte y =(byte)((this.yellowsCollected.size() == 6)? 1:0);
		byte g =(byte)((this.greensCollected.size() == 6)? 1:0);
		this.numStars = ((r&g | r&y | g&y) << 1) + (r^g^y);
	}

	/**
	 * Determines whether or not the level has ended based on the progress.
	 */
	@Override
	public boolean hasEnded() {
		return bullpen.isEmpty();
	}

	/**
	 * Determines if the player has gotten the highest achievement on the level. 
	 */
	@Override
	public boolean hasWon() {
		updateAchievement();
		return (hasEnded() && progress.updateProgressRelease() >= 32) || progress.updateProgressRelease() == 100;
	}
}
