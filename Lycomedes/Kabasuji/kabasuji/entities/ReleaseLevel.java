package kabasuji.entities;

import java.util.ArrayList;
import kabasuji.supers.Level;

/**
 * Level sublcass for the puzzle level entity.
 * 
 * @author Derek McMaster
 * @author Tanuj Sane
 */
public class ReleaseLevel extends Level {
	private ArrayList<Integer> redsCollected = new ArrayList<Integer>(6);
	private ArrayList<Integer> greensCollected = new ArrayList<Integer>(6);
	private ArrayList<Integer> yellowsCollected = new ArrayList<Integer>(6);

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

	@Override
	public void setNumStars() {
		byte r =(byte)((this.redsCollected.size() == 6)? 1:0);
		byte y =(byte)((this.yellowsCollected.size() == 6)? 1:0);
		byte g =(byte)((this.greensCollected.size() == 6)? 1:0);
		
		this.numStars = ((r&g | r&y | g&y) << 1) + (r^g^y);
	}
}
