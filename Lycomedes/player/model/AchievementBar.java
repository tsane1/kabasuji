package model;

import javax.swing.JProgressBar;
import javax.swing.JWindow;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class AchievementBar extends JWindow{
	private static JProgressBar progressBar = new JProgressBar();
	
	public AchievementBar() {

		getContentPane().setLayout(null);

		Container container = getContentPane();
		container.setLayout(null);
		progressBar.setMaximum(50);
		progressBar.setBounds(150, 670, 600, 15);
		container.add(progressBar);
	}
}
