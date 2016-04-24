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
 * @author Ian Jacoway 
 * @since 4/23/16
 *
 */
public class LevelPlayView extends Screen {
	
	private Level level;
	private BoardView boardView;
	private BullpenView bullpenView;
	private ProgressView progress;
	private AchievementView achievement;


	public LevelPlayView(String levelName, SuperModel m) {
		super(levelName, m);
		
		this.level = m.getActiveLevel();
		this.setTitle(level.getLevelName() + ": " + level.getLevelType());
		this.boardView = new BoardView(m);
		this.bullpenView = new BullpenView(m);
	}
	
	public Level getLevel() {
		return this.level;
	}
			
	@Override
	public void populate() {
	
		//populate by adding the views
		this.add(boardView);
		boardView.validate();
		boardView.repaint();
		this.add(bullpenView);
		bullpenView.validate();
		bullpenView.repaint();
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
	
	@Override
	public BullpenView getBullpenView(){
		return this.bullpenView;
	}
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application(new LevelPlayView("hi", new SuperModel()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
