package kabasuji.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.supers.Screen;

/**
 * View class that displays a level to play.
 * 
 * <p>
 * LevelPlay class (extends {@code Screen}) that contains all view elements for playing a level.
 * LevelPlay can show the board and update the {@code Level} it contains by updating its model.
 * </p>
 * 
 * @author Tanuj Sane
 *
 */
public class LevelPlay extends Screen {
	private Level level;

	private BoardView boardView;
	private BullpenView bullpenView;
	private ProgressView progress;
	private AchievementView achievement;

	public LevelPlay(String levelName, SuperModel m) {
		super(levelName, m);
		this.level = m.getLevel(levelName);
		this.setTitle(level.getLevelName() + ": " + level.getLevelType());
		this.boardView = new BoardView(level.getBoard());
		this.bullpenView = new BullpenView(level.getBullpen());
	}
	
	public Level getLevel() {
		return this.level;
	}
			
	@Override
	public void populate() {
		board = new BoardView(level.getBoard());
		bullpen = new BullpenView(model, level.getBullpen());
		//progress = new ProgressView();
		//achievement = new AchievementView();
		this.add(board);
		this.add(bullpen);

	}
	
	@Override
	public void installControllers() {
		
	}	

	@Override
	public void refresh() {
		this.app.setCurrScreen(this);
	}
	
	@Override
	public String getName() {
		return "LevelPlay";
	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application(new LevelPlay("hi", new SuperModel()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
