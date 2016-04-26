package kabasuji.views;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
	private JScrollPane pieceScroll = new JScrollPane();
	private JPanel boardPanel;


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
		
		boardPanel = new JPanel();
		boardPanel.setBounds(13, 280, 384, 384);
//		boardPanel.setLayout(null);
		boardPanel.add(boardView);
		boardView.refresh();
		this.add(boardPanel);

		pieceScroll = new JScrollPane();
		pieceScroll.setBounds(13, 512, 904, 228);
		pieceScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		pieceScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pieceScroll.setViewportView(bullpenView);
		this.add(pieceScroll);
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
	
	@Override
	public BoardView getBoardView(){
		return this.boardView;
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
