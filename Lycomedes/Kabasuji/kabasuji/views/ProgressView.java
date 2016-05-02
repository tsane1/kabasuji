package kabasuji.views;

import java.awt.event.ActionListener;

/**
 * 
 * @author Chase St. Laurent
 * @author Michael
 */

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import kabasuji.entities.Progress;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
/**
 * View class for the level progress.
 * @author Chase St. Laurent
 */
public class ProgressView extends JPanel {

	/** serial id. */
	private static final long serialVersionUID = 1L;
	/** Progress object for the level. */
	private Progress progress;
	/** current level associated with progress. */
	private Level currLevel;
	/** progressbar to control progress. */
	JProgressBar progressBar = new JProgressBar();

	/**
	 * Constructor for the progress view.
	 * @param model
	 */
	public ProgressView(SuperModel model) {
		super();
		this.currLevel = model.getActiveLevel();
		this.progress = new Progress(currLevel.getBoard());
		setLayout(null);

		progressBar.setOrientation(SwingConstants.VERTICAL);
		progressBar.setMaximum(100);
		progressBar.setBounds(0, 0, 25, 384);// x,y,w,h
		add(progressBar);
		this.setBounds(675, 100, 25, 384);// x,y,w,h

	}

	/**
	 * Updates the level progress depending on type.
	 * @param type
	 */
	public void updateProgressBar(String type) {
		switch (type){
			case "Puzzle":
				progressBar.setValue(progress.updateProgressPuzzle());
				break;
			case "Lightning":
				progressBar.setValue(progress.updateProgressLightning());
				break;
			case "Release":
				progressBar.setValue(progress.updateProgressRelease());
				break;
		}
	}
}
