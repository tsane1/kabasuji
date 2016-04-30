package kabasuji.entities;

import kabasuji.supers.Level;

/**
 * 
 * @author Chase St. Laurent
 * 
 */

public class Achievement {
	Progress progress; // Change progress to ProgressBar java class?
	Level level;
	public Achievement(Progress progress) {
		super();
		this.progress = progress; 
	}
	
	public int updateAchievement() {
		int achievedStars = 0;
		
		if ((progress.updateProgressPuzzle() == 100) 
				|| progress.updateProgressLightning() == 100
				|| progress.updateProgressRelease() == 100) {
			achievedStars = 3;
		}else if ((progress.updateProgressPuzzle() >= 75 && progress.updateProgressPuzzle() < 100)
				|| (progress.updateProgressLightning() >= 75 && progress.updateProgressLightning() < 100)
				|| progress.updateProgressRelease() >= 66 && progress.updateProgressRelease() < 100) {
			achievedStars = 2;
		}else if ((progress.updateProgressPuzzle() >= 50 && progress.updateProgressPuzzle() < 75)
				|| (progress.updateProgressLightning() >= 50 && progress.updateProgressLightning() < 75)
				|| (progress.updateProgressRelease() >= 32 && progress.updateProgressRelease() < 66)) {
			achievedStars = 1;
		}
		else {
			achievedStars = 0;
		}
		System.out.println("achieved" + achievedStars);
		//If numStars previously is less than that achieved 
		//in this game, update them to equal the new highest. 
		//if(numStars<achievedStars){
	//		level.numStars = achievedStars; 
		//}
		return achievedStars;
	}
}
