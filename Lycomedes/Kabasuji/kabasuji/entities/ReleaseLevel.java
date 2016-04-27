package kabasuji.entities;

import java.util.HashMap;
import java.util.Map;

import kabasuji.supers.Level;

/**
 * Level sublcass for the puzzle level entity.
 * 
 * @author Derek McMaster
 */

public class ReleaseLevel extends Level {
	/**
	 * serial id.
	 */
	private static final long serialVersionUID = 1L;
	
	/** Hashmap of the number tiles covered */
	private Map<String, Integer> numsCollected = new HashMap<String, Integer>();
	
	/**
	 * Public constructor for the release level entity.
	 * @param String name
	 */
	public ReleaseLevel(String name) {
		super(name, "Release");
	}
	
	/**
	 * Gets the map of collected numbers.
	 * @return
	 */
	public Map<String, Integer> getNumsCollected() {
		return this.numsCollected;
	}

	/**
	 * Set a value as collected.
	 * @param String color
	 * @param int num
	 */
	public void collect(String color, int num) {
		this.numsCollected.put(color, num);
	}
	
}
