package kabasuji.views;

import java.awt.event.ActionListener;

/**
 * 
 * @author Chase St. Laurent
 * 
 */

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import kabasuji.entities.Progress;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;

public class ProgressView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Progress progress;
	private Level currLevel;
	JProgressBar progressBar = new JProgressBar();

	public ProgressView(SuperModel model) {
		super();
		this.currLevel = model.getActiveLevel();
		this.progress = new Progress(currLevel.getBoard());
		setLayout(null);
		// setBounds(700, 50, 20, 300);

		progressBar.setOrientation(SwingConstants.VERTICAL);
		progressBar.setMaximum(100);
		progressBar.setBounds(0, 0, 25, 384);// x,y,w,h
		add(progressBar);
		this.setBounds(675, 100, 25, 384);// x,y,w,h
		while(progressBar.getValue()<=progress.updateProgressPuzzle()){
			updateProgressBar();
			break;
		}

	}

	public void updateProgressBar() {
	//	while(progressBar.getValue()<=100){
			progressBar.setValue(+1);
			progressBar.setValue(progress.updateProgressPuzzle()+1);
		//	break;
	//}
	}
}
