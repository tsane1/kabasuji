package kabasuji.views;

import java.awt.EventQueue;

import kabasuji.controllers.NewLevelController;
import kabasuji.supers.Application;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * View for choosing a new level type after requesting to make a new level.
 */
public class NewLevelTypeSelectView extends Screen {
	/** Button to choose a lightning level. */
	private JButton btnLightning = new JButton("Lightning");
	/** Button to choose a puzzle level. */
	private JButton btnPuzzle = new JButton("Puzzle");
	/** Button to choose a release level. */
	private JButton btnRelease = new JButton("Release");
	
	/**
	 * Constructor for making a new level.
	 * @param SuperModel m
	 */
	public NewLevelTypeSelectView(SuperModel m) {
		super("Select Level Type", m);
	}

	/**
	 * Overriden populate method from screen class.
	 */
	@Override
	public void populate() {
		JLabel lblLightning = new JLabel("Lightning");
		lblLightning.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning.setForeground(SystemColor.textHighlight);
		lblLightning.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		lblLightning.setBounds(71,175,256,50);
		this.add(lblLightning);
		
		btnLightning.setName("Lightning");
		btnLightning.setActionCommand("Lightning");
		btnLightning.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/lightning_icon.png")));
		btnLightning.setBounds(71, 215, 256, 256);
		this.add(btnLightning);
		
		JLabel lblPuzzle = new JLabel("Puzzle");
		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setForeground(SystemColor.textHighlight);
		lblPuzzle.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		lblPuzzle.setBounds(337,175,256,50);
		this.add(lblPuzzle);
		
		btnPuzzle.setName("Puzzle");
		btnPuzzle.setActionCommand("Puzzle");
		btnPuzzle.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/puzzle_icon.png")));
		btnPuzzle.setBounds(337, 215, 256, 256);
		this.add(btnPuzzle);
		
		JLabel lblRelease = new JLabel("Release");
		lblRelease.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease.setForeground(SystemColor.textHighlight);
		lblRelease.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		lblRelease.setBounds(603,175,256,50);
		this.add(lblRelease);
		
		btnRelease.setName("Release");
		btnRelease.setActionCommand("Release");
		btnRelease.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/release_icon.png")));
		btnRelease.setBounds(603, 215, 256, 256);
		this.add(btnRelease);
	}

	/**
	 * Overriden installation of controllers form screen class.
	 */
	@Override
	public void installControllers() {
		btnLightning.addActionListener(new NewLevelController(this.app, this.model));
		btnRelease.addActionListener(new NewLevelController(this.app, this.model));
		btnPuzzle.addActionListener(new NewLevelController(this.app, this.model));
	}

	/**
	 * Overridden refresh method from Screen class.
	 */
	@Override
	public void refresh() {
		
	}

	/**
	 * Getter for the level name.
	 * @return String
	 */
	@Override
	public String getName() {
		return "NewLevelTypeSelectView";
	}
	
	/**
	 * Test Main class.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application(new NewLevelTypeSelectView(new SuperModel()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
