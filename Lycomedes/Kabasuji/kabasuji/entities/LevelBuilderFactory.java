package kabasuji.entities;

public class LevelBuilderFactory {

	public LevelBuilder createLevel(String levelType){
		
		LevelBuilder newLevel = null;
		
		if(levelType.equals("puzzle"))
		{
			newLevel = new PuzzleLevelBuilder();
		}
		else if(levelType.equals("lightning"))
		{
			newLevel =  new LightningLevelBuilder();
		}
		else if(levelType.equals("release"))
		{
			newLevel =  new ReleaseLevelBuilder();
		}
		else { ; }//nothing 
		
		return newLevel;
	}

}
