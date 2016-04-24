package kabasuji.supers;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import kabasuji.controllers.BackController;
import kabasuji.views.BullpenView;

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
	private JButton btnBack;
	protected SuperModel model;
	protected Application app;
	private JLabel lblTitle;
	
	public Screen(String title, SuperModel m) {
		this.model = m;
		initScreen(title);
	}
	
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
	
	protected void setTitle(String newTitle) {
		lblTitle.setText(newTitle);
	}
	
	public void handshake(Application a) {
		this.app = a;
		// install supercontroller right after app and screen are bound.
		btnBack.addActionListener(new BackController(this.app, this.model));
	}
	
	public abstract void populate(); // initialize view
	public abstract void installControllers(); // initialize controllers
	public abstract void refresh(); // refresh view to show updated state
	public abstract String getName(); // get screen name

	public BullpenView getBullpenView() {
		// TODO Auto-generated method stub
		return null;
	}
}
