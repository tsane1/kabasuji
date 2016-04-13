package supers;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import controller.BackController;

import javax.swing.SwingConstants;

public class Application extends JFrame {
	private Screen currScreen;
	
	public Application(Screen scr) {
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		
		setCurrScreen(scr);
	}
	
	public void handshake(Screen scr) {
		scr.finish(this);
	}
	
	public Screen getCurrScreen() {
		return this.currScreen;
	}
	
	public void setCurrScreen(Screen newScr) {
		this.currScreen = newScr;
		setContentPane(this.currScreen);
		drawScreen();
	}
	
	private void drawScreen() {
		currScreen.populate();
		currScreen.installControllers();
		currScreen.initModel();
	}
}
