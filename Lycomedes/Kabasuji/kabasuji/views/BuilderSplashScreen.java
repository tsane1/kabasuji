package kabasuji.views;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;

import javax.swing.*;
import java.awt.Container;

/**
 * Splash screen for the level builder entity.
 * @author Chase St. Laurent
 */
public class BuilderSplashScreen extends JWindow {

	/** static builder screen variable. */
	static boolean isRegistered;
	/** Progress bar for screen. */
	private static JProgressBar progressBar = new JProgressBar();
	/** Splash Screen instance. */
	private static PlayerSplashScreen execute;
	/** count for the progress bar. */
	private static int count;
	/** timer for the progress bar. */
	private static Timer timer1;

	/**
	 * Constructor for creating builder splash screen.
	 */
	public BuilderSplashScreen() {
		getContentPane().setLayout(null);

		Container container = getContentPane();
		container.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIconTextGap(10);
		lblNewLabel.setIcon(new ImageIcon(PlayerSplashScreen.class.getResource("/imgs/BuilderSplashScreen.png")));
		lblNewLabel.setBounds(0, 0, 900, 700);
		getContentPane().add(lblNewLabel);

		progressBar.setMaximum(50);
		progressBar.setBounds(150, 670, 600, 15);
		container.add(progressBar);
		loadProgressBar();
		setSize(900, 700);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Method for controlling the progress bar.
	 */
	private void loadProgressBar() {
		ActionListener al = new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				count++;
				progressBar.setValue(count);
				if (count == 65) {
					timer1.stop();
				}
			}
		};
		timer1 = new Timer(50, al);
		timer1.start();
	}
}
