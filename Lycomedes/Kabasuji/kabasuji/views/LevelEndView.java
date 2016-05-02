package kabasuji.views;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import kabasuji.controllers.BackController;
import kabasuji.controllers.LevelPlayController;
import kabasuji.entities.LightningLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

/**
 * View displayed after ending a level. Either won or lost.
 */
public class LevelEndView extends Screen {
	/** Supermodel instance being updated. */
	private SuperModel model;
	/** Button to return to level choosing screen. */
	private JButton btnBackToSelection = new JButton();
	/** Replay button for the level. */
	private JButton btnReplay = new JButton();
	
	/**
	 * Constructor for level end view.
	 * @param Supermodel m
	 */
	public LevelEndView(SuperModel m) {
		super("", m);
		this.model = m;
	}

	/**
	 * Overriden populate method from screen class.
	 */
	@Override
	public void populate() {
		btnBackToSelection.setText("Back to Selection");
		btnBackToSelection.setActionCommand("LevelPlay");
		btnBackToSelection.setBackground(SystemColor.text);
		btnBackToSelection.setForeground(SystemColor.textHighlight);
		btnBackToSelection.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		btnBackToSelection.setBounds(160, 600, 300, 50);
		
		btnReplay.setText("Replay");
		btnReplay.setActionCommand(model.getActiveLevel().getLevelName());
		btnReplay.setBackground(SystemColor.text);
		btnReplay.setForeground(SystemColor.textHighlight);
		btnReplay.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		btnReplay.setBounds(470, 600, 300, 50);
		
		JLabel lblPic = new JLabel();
		lblPic.setBounds(232, 100, 465, 375);
		
		JLabel stars = new JLabel();
		stars.setBounds(369, 500, 192, 64);
		stars.setIcon(new ImageIcon(LevelEndView.class.getResource("/imgs/stars" + model.getActiveLevel().getNumStars() + ".png")));
		
		if(model.getActiveLevel().hasWon()) {
			setTitle(model.getActiveLevel().getLevelName() + " WON!");
			lblPic.setIcon(new ImageIcon(LevelEndView.class.getResource("/imgs/" + model.getActiveLevel().getLevelType() + "Won.png")));
		}
		else if(model.getActiveLevel().hasEnded()) {
			setTitle(model.getActiveLevel().getLevelName() + " LOST!");
			lblPic.setIcon(new ImageIcon(LevelEndView.class.getResource("/imgs/" + model.getActiveLevel().getLevelType() + "Lost.png")));
			
		}
		else {
			System.out.println("no fuck you you're not my real dad");
		}
		
		this.add(btnBackToSelection);
		this.add(btnReplay);
		this.add(lblPic);
		this.add(stars);
		
		
		
		this.validate();
		this.repaint();
	}

	/**
	 * Overriden installation of controllers form screen class.
	 */
	@Override
	public void installControllers() {
		btnReplay.addActionListener(new LevelPlayController(this.app, this.model));
		btnBackToSelection.addActionListener(new BackController(this.app, this.model));
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
		return "LevelEnd";
	}
}