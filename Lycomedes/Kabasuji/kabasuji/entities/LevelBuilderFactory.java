package kabasuji.entities;

import kabasuji.supers.Level;

public class LevelBuilderFactory {

	public Level createLevel(String levelType){
		Level newLevel = null;
		if(levelType.equals("Puzzle")) newLevel = new PuzzleLevel("");
		else if(levelType.equals("Lightning")) newLevel =  new LightningLevel("");
		else if(levelType.equals("Release")) newLevel =  new ReleaseLevel("");
		else;		
		return newLevel;
	}
}
