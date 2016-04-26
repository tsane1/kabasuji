package kabasuji.entities;

import java.util.HashMap;

import kabasuji.supers.Level;

public class ReleaseLevel extends Level {
	private HashMap<String, Integer> numsCollected = new HashMap<String, Integer>();
	
	public ReleaseLevel(String name) {
		super(name, "Release");
	}
	
	public HashMap<String, Integer> getNumsCollected() {
		return this.numsCollected;
	}

	public void collect(String color, int num) {
		this.numsCollected.put(color, num);
	}
	
	
}
