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
	private Screen currScreen;
	
	public Application(Screen scr) {
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(950, 800);
		
		setCurrScreen(scr);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(950, 800);
	}
	
	private void handshake(Screen scr) {
		scr.handshake(this);
	}
	
	public Screen getCurrScreen() {
		return this.currScreen;
	}
	
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
