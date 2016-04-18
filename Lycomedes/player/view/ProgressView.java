package view;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

import model.Progress;

public class ProgressView extends JPanel {
	private Progress progress;
	
	
	public ProgressView(Progress progress){
		super();
		this.progress = progress;
		setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(100);
		progressBar.setBounds(0, 0, 20, 300);//x,y,w,h
		add(progressBar);
		this.setBounds(600, 100, 20, 300);//x,y,w,h
		
	}
}
