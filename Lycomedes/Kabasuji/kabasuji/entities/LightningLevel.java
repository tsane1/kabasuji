package kabasuji.entities;

import kabasuji.supers.Level;

public class LightningLevel extends Level {
	private int timeLeft;
	
	public LightningLevel(String name) {
		super(name, "Lightning");
	}
	
	public int getTimeLeft() {
		return this.timeLeft;
	}
	
	public void setTimeLeft(int setTime) {
		this.timeLeft = setTime;
	}

	@Override
	public void setNumStars() {
		
	}
}
