package kabasuji.views;

import java.awt.EventQueue;
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
 * @author Chase St. Laurent
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
		this.bullpenView = new BullpenView(level);
	}
	
	public Level getLevel() {
		return this.level;
	}
			
	@Override
	public void populate() {
		BoardView boardView = new BoardView(level.getBoard());
		BullpenView bullpenView = new BullpenView(level);
		ProgressView progress = new ProgressView(null);
		AchievementView achievement = new AchievementView(null);
		
		//populate by adding the views
		this.add(boardView);
		this.add(bullpenView);
		this.add(progress);
		this.add(achievement);

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
