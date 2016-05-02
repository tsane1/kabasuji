package kabasuji.supers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

/**
 * View class deploys application frame and all associated views with each screen.
 * 
 * <p>
 * Application class (extends {@code JFrame}) that deploys all view elements. Screen is
 * passed into constructor and displayed on the frame. Application handles window size and 
 * on-close handling.
 * </p>
 * 
 * @author Tanuj Sane
 * @since 4/9/2016
 * @see Screen
 *
 */
public class Application extends JFrame {
	/** current screen for the application. */
	private Screen currScreen;
	
	/**
	 * Application constructor
	 * @param Screen scr
	 */
	public Application(Screen scr) {
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(950, 800);
		
		setCurrScreen(scr);
	}
	
	/**
	 * Overridden swing method.
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(950, 800);
	}
	
	/**
	 * Handshake to introduce screens.
	 * @param Screen scr
	 */
	private void handshake(Screen scr) {
		scr.handshake(this);
	}
	
	/**
	 * Gets the current screen
	 * @return Screen
	 */
	public Screen getCurrScreen() {
		return this.currScreen;
	}
	
	/**
	 * Sets the current Screen.
	 * @param newScr
	 */
	public void setCurrScreen(Screen newScr) {
		this.currScreen = newScr;
		setContentPane(this.currScreen);
		handshake(this.currScreen);
		pack();
		revalidate();
		currScreen.populate();
		currScreen.installControllers();
	}
}
