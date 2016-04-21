package kabasuji.entities;

/**
 * 
 * @author Chase St. Laurent
 * 
 */

public class Achievement {
	Progress progress; // Change progress to ProgressBar java class?

	public Achievement(Progress progress) {
		super();
		this.progress = progress;
	}
	public boolean earnedAchievement() {
		boolean isEarned = false;
		
		if(isEarnedOneStar(progress)|| isEarnedTwoStar(progress)||isEarnedThreeStar(progress)){
			isEarned = true;
		}
		return isEarned;
	}

	public boolean isEarnedOneStar(Progress progress) {
		boolean isEarned = false;

		if ((progress.updateProgressPuzzle() == 50) || progress.updateProgressLightning() == 50
				|| progress.updateProgressRelease() == 32) {
			isEarned = true;
		}
		return isEarned;
	}
	public boolean isEarnedTwoStar(Progress progress) {
		boolean isEarned = false;

		if ((progress.updateProgressPuzzle() == 75) || progress.updateProgressLightning() == 75
				|| progress.updateProgressRelease() == 66) {
			isEarned = true;
		}
		return isEarned;
	}
	public boolean isEarnedThreeStar(Progress progress) {
		boolean isEarned = false;

		if ((progress.updateProgressPuzzle() == 100) || progress.updateProgressLightning() == 100
				|| progress.updateProgressRelease() == 100) {
			isEarned = true;
		}
		return isEarned;
	}
	
}
