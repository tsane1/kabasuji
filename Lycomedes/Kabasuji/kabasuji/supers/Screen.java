package kabasuji.supers;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import kabasuji.controllers.BackController;
import kabasuji.views.BoardView;
import kabasuji.views.BullpenView;
import kabasuji.views.PaletteView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;

/**
 * Abstract view class containing necessary elements of all screens.
 * 
 * <p>
 * Screen class (extends {@code JPanel}) is a super that is used as the content pane for
 * an instance of {@code Application}. This class contains common view elements for any given
 * screen in the game.
 * </p>
 * 
 * @author Tanuj Sane
 * @author Ian Jacoway 4/23/2016
 * @since 4/12/2016
 * @see Application
 */

public abstract class Screen extends JPanel {
	/** back button installed on all screens. */
	private JButton btnBack;
	/** model instance for the application. */
	protected SuperModel model;
	/** application being run. */
	protected Application app;
	/** title label for screens. */
	private JLabel lblTitle;
	
	/**
	 * Screen entity constructor.
	 * @param String title
	 * @param SuperModel m
	 */
	public Screen(String title, SuperModel m) {
		this.model = m;
		initScreen(title);
	}
	
	/**
	 * Initialize method for all screens.  Sets defualt colors, buttons, setups, etc.
	 * @param title
	 */
	private void initScreen(String title) {
		this.setBackground(Color.WHITE);
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setLayout(null);
		
		lblTitle = new JLabel();
		setTitle(title);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(SystemColor.textHighlight);
		lblTitle.setFont(new Font("Kristen ITC", Font.BOLD, 32));
		lblTitle.setBounds(0,13,930,75);
		this.add(lblTitle);
			
		btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnBack.setForeground(SystemColor.textHighlight);
		btnBack.setBounds(12, 13, 97, 25);
		this.add(btnBack);
	}
	
	/**
	 * Setter for the screen title.
	 * @param newTitle
	 */
	public void setTitle(String newTitle) {
		lblTitle.setText(newTitle);
	}
	
	/** 
	 * Gets the name of the current screen.
	 * @return String.
	 */
	public String getTitle() {
		return lblTitle.getText();
	}
	
	/**
	 * Handshake method for screens.
	 * @param App a
	 */
	public void handshake(Application a) {
		this.app = a;
		// install supercontroller right after app and screen are bound.
		btnBack.addActionListener(new BackController(this.app, this.model));
	}
	
	/**
	 * Populates the screen and initializes any views.
	 */
	public abstract void populate(); // initialize view
	
	/**
	 * Installs controllers for each screen.
	 */
	public abstract void installControllers(); // initialize controllers
	
	/**
	 * Generic refresh that handles views. 
	 */
	public abstract void refresh();// refresh view to show updated state
	
	/**
	 * Gets the name of the screen, Not title.
	 */
	public abstract String getName(); // get screen name

	/**
	 * Bullpenview getter.
	 * @return Bullpenview
	 */
	public BullpenView getBullpenView() {
		return null;
	}

	/**
	 * BoardView Getter.
	 * @return Boardview
	 */
	public BoardView getBoardView() {
		return null;
	}
	
	/**
	 * Level getter for the screen.
	 * @return Level
	 */
	public Level getLevel() {
		return null;
	}
	
	/**
	 * Paletteview getter for the screen.
	 * @return PaletteView
	 */
	public PaletteView getPaletteView() {
		return null;
	}
}
