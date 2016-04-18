package kabasuji.entities;

import javax.swing.JProgressBar;
import javax.swing.JWindow;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Achievement {
	Progress progress; // Change progress to ProgressBar java class?

	public Achievement(Progress progress) {
		super();
		this.progress = progress;
	}
	// TODO: Determine 3Star, 2Star, and 1Star criteria

	public void updateAchievement() {
		
		//TODO: what should i do here?
		return;
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