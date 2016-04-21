package kabasuji.entities;

public class LevelBuilderFactory {

	public LevelBuilder createLevel(String levelType){
		LevelBuilder newLevel = null;
		if(levelType.equals("Puzzle")) newLevel = new PuzzleLevelBuilder();
		else if(levelType.equals("Lightning")) newLevel =  new LightningLevelBuilder();
		else if(levelType.equals("Release")) newLevel =  new ReleaseLevelBuilder();
		else;		
		return newLevel;
	}
}
