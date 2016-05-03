package kabasuji.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import kabasuji.controllers.DeleteLevelController;
import kabasuji.controllers.LevelEditController;
import kabasuji.controllers.LevelPlayController;
import kabasuji.controllers.NavigateLevelSelectController;
import kabasuji.controllers.NewLevelController;
import kabasuji.supers.SuperModel;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Screen;

/**
 * <b>VIEW</b> class that provides interface for choosing levels to play.
 * <p>
 * LevelPlaySelectView (extends {@code Screen}) displays buttons for selection
 * of which level to play, as well as the names of the levels. Navigation is done
 * via "Next" and "Previous" controllers attached to buttons. This class displays
 * both default and user-created levels.
 * </p>
 * @author Tanuj Sane
 * @since 4/21/2016
 *
 */
public class LevelPlaySelectView extends Screen {
	/** list of buttons for the level. */
	private ArrayList<JButton> levelButtons = new ArrayList<JButton>();
	/** List of labels for the level. */
	private ArrayList<JLabel> levelNames = new ArrayList<JLabel>();
	/** List of labels for the levels. */
	private ArrayList<JLabel> levelStars = new ArrayList<JLabel>();
	/** next page button. */
	private JButton btnNext = new JButton("Next");
	/** previous page button. */
	private JButton btnPrev = new JButton("Previous");
	
	/**
	 * Constructor for selecting a level to play.
	 * @param Supermodel m
	 */
	public LevelPlaySelectView(SuperModel m) {
		super("Play a Level", m);
	}
	
	/**
	 * Overriden populate method from screen class.
	 */
	@Override
	public void populate() {
		btnNext.setActionCommand("Next");
		btnNext.setBackground(SystemColor.text);
		btnNext.setForeground(SystemColor.textHighlight);
		btnNext.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnNext.setBounds(765, 683, 155, 57);
		this.add(btnNext);
		
		btnPrev.setActionCommand("Previous");
		btnPrev.setBackground(SystemColor.text);
		btnPrev.setForeground(SystemColor.textHighlight);
		btnPrev.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnPrev.setBounds(13, 683, 155, 57);
		this.add(btnPrev);
		
		for(int idx = 0; idx < 15; idx++) {
			levelNames.add(new JLabel());
			levelNames.get(idx).setText(model.getDefaultLevelNameByIndex(idx));
			levelNames.get(idx).setHorizontalAlignment(SwingConstants.CENTER);
			levelNames.get(idx).setForeground(SystemColor.textHighlight);
			levelNames.get(idx).setFont(new Font("Kristen ITC", Font.BOLD, 18));
			levelNames.get(idx).setSize(128,50);
						
			levelButtons.add(new JButton());
			levelButtons.get(idx).setActionCommand(model.getDefaultLevelNameByIndex(idx));
			
			
			Level level = model.loadLevel(model.getDefaultLevelDir(), model.getDefaultLevelNameByIndex(idx));
			levelStars.add(new JLabel());
			levelStars.get(idx).setSize(128, 42);
			levelStars.get(idx).setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/stars" + level.getMaxAchievement() + "_smol.png")));
			
			switch(model.loadLevel(model.getDefaultLevelDir(), model.getDefaultLevelNameByIndex(idx)+".lev").getLevelType()) {
			case "Puzzle":
				levelButtons.get(idx).setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/puzzle_icon_smol.png")));
				break;
			case "Lightning":
				levelButtons.get(idx).setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/lightning_icon_smol.png")));
				break;
			case "Release":
				levelButtons.get(idx).setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/release_icon_smol.png")));
				break;
			}
			levelButtons.get(idx).setDisabledIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/locked_icon.png")));
			levelButtons.get(idx).setBackground(SystemColor.text);
			levelButtons.get(idx).setSize(128, 128);
			levelButtons.get(idx).setEnabled(!model.loadLevel(model.getDefaultLevelDir(), model.getDefaultLevelNameByIndex(idx)+".lev").isLocked());
		}	
		
		for(int idx = 0; idx < this.model.getNumUserLevels(); idx++) {
			levelNames.add(new JLabel());
			levelNames.get(idx + 15).setText(model.getUserLevelNameByIndex(idx));
			levelNames.get(idx + 15).setHorizontalAlignment(SwingConstants.CENTER);
			levelNames.get(idx + 15).setForeground(SystemColor.textHighlight);
			levelNames.get(idx + 15).setFont(new Font("Kristen ITC", Font.BOLD, 18));
			levelNames.get(idx + 15).setSize(128,50);

			levelButtons.add(new JButton());
			levelButtons.get(idx + 15).setActionCommand(model.getUserLevelNameByIndex(idx));

			levelStars.add(new JLabel());
			levelStars.get(idx).setSize(128, 42);
			levelStars.get(idx).setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/stars" + model.getActiveLevel().getMaxAchievement() + "_smol.png")));
			
			switch(model.loadLevel(model.getUserLevelDir(), model.getUserLevelNameByIndex(idx)+".lev").getLevelType()) {
			case "Puzzle":
				levelButtons.get(idx + 15).setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/puzzle_icon_smol.png")));
				break;
			case "Lightning":
				levelButtons.get(idx + 15).setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/lightning_icon_smol.png")));
				break;
			case "Release":
				levelButtons.get(idx + 15).setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/release_icon_smol.png")));
				break;
			}
			levelButtons.get(idx + 15).setDisabledIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/locked_icon.png")));
			levelButtons.get(idx + 15).setBackground(SystemColor.text);
			levelButtons.get(idx + 15).setSize(128, 128);
			levelButtons.get(idx + 15).setEnabled(!model.loadLevel(model.getUserLevelDir(), model.getUserLevelNameByIndex(idx)+".lev").isLocked());
		}		
			
		refresh();
	}

	/**
	 * Overriden installation of controllers form screen class.
	 */
	@Override
	public void installControllers() {
		for(int idx = 0; idx < 15 + this.model.getNumUserLevels(); idx++) {
			levelButtons.get(idx).addActionListener(new LevelPlayController(this.app, this.model));
		}
		btnNext.addActionListener(new NavigateLevelSelectController(this.app, this.model));
		btnPrev.addActionListener(new NavigateLevelSelectController(this.app, this.model));
	}
	
	/**
	 * Getter for the level name.
	 * @return String
	 */
	@Override
	public String getName() {
		return "LevelEditSelect";
	}

	/**
	 * Overridden refresh method from Screen class.
	 */
	@Override
	public void refresh() {
		for(int idx = 0; idx < 15 + this.model.getNumUserLevels(); idx++) {
			this.remove(levelButtons.get(idx));
			this.remove(levelNames.get(idx));
			this.remove(levelStars.get(idx));
		}		
		this.validate();
		this.repaint();
		
		btnNext.setEnabled(model.getPage() < (model.getNumUserLevels() + 14) / 10);
		btnPrev.setEnabled(model.getPage() > 0);
		btnNext.validate();
		btnNext.repaint();
		btnPrev.validate();
		btnPrev.repaint();		
		
		for(int idx = 0; idx < 10; idx++) {
			int btnIndex = (10*model.getPage()) + idx;
			if(btnIndex >= model.getTotalNumLevels());
			else {
				levelNames.get(btnIndex).setLocation(125+(138*(idx%5)), 150+(218*(idx/5)));
				this.add(levelNames.get(btnIndex));
				levelNames.get(btnIndex).validate();
				levelNames.get(btnIndex).repaint();
				
				levelButtons.get(btnIndex).setLocation(125+(138*(idx%5)), 200+(218*(idx/5)));
				this.add(levelButtons.get(btnIndex));
				levelButtons.get(btnIndex).validate();
				levelButtons.get(btnIndex).repaint();
				
				levelStars.get(btnIndex).setLocation(125+(138*(idx%5)), 328+(218*(idx/5)));
				this.add(levelStars.get(btnIndex));
				levelStars.get(btnIndex).validate();
				levelStars.get(btnIndex).repaint();
			}
		}
	}
	
	/**
	 * Test Main class.
	 * @param args
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application(new LevelPlaySelectView(new SuperModel()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
