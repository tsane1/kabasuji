package kabasuji.views;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import kabasuji.controllers.SelectPieceController;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseLevel;
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
	private PuzzleLevel pl;
	private LightningLevel ll;
	private ReleaseLevel rl;
	
	private BoardView boardView;
	private BullpenView bullpenView;
	private ProgressView progress;
	private AchievementView achievement;
	private JScrollPane pieceScroll = new JScrollPane();
	
	private JLabel levelParamTitle = new JLabel();
	private JLabel levelParamDisplay = new JLabel();


	public LevelPlayView(String levelName, SuperModel m) {
		super(levelName, m);
		
		this.level = m.getActiveLevel();
		pl = null; rl = null; ll = null;
		this.setTitle(level.getLevelName() + ": " + level.getLevelType());
		this.boardView = new BoardView(m);
		this.bullpenView = new BullpenView(m);
		
		switch(level.getLevelType()) { // add level-specific elements
		case "Puzzle":
			pl = (PuzzleLevel)level;
			break;
		case "Lightning":
			ll = (LightningLevel)level;
			break;
		case "Release":
			rl = (ReleaseLevel)level;
			break;
		default:
			System.err.println("This level type is not yet supported.");
			break;				
		}
	}
	
	public Level getLevel() {
		return this.level;
	}
			
	@Override
	public void populate() {
	
		this.add(boardView);
		boardView.validate();
		boardView.repaint();

		pieceScroll = new JScrollPane();
		pieceScroll.setBounds(13, 512, 904, 228);
		pieceScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		pieceScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pieceScroll.setViewportView(bullpenView);
		this.add(pieceScroll);
		
		
		levelParamTitle.setHorizontalAlignment(SwingConstants.CENTER);
		levelParamTitle.setForeground(SystemColor.textHighlight);
		levelParamTitle.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		levelParamTitle.setBounds(726, 150, 100, 25);
		
		levelParamDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		levelParamDisplay.setForeground(SystemColor.textHighlight);
		levelParamDisplay.setFont(new Font("Kristen ITC", Font.BOLD, 32));
		levelParamDisplay.setBounds(726, 200, 100, 50);
		
		refresh();
	}
	
	@Override
	public void installControllers() {
		SelectPieceController psc = new SelectPieceController(level, bullpenView);
		bullpenView.addMouseListener(psc);
	}	

	@Override
	public void refresh() {
		switch(level.getLevelType()) { // add level-specific elements
		case "Puzzle":
			levelParamTitle.setText("Moves Left:");
			pl.setMovesLeft(10);
			levelParamDisplay.setText("" + pl.getMovesLeft());
			break;
		case "Lightning":
			levelParamTitle.setText("Time Left:");
			ll.setTimeLeft(10);
			levelParamDisplay.setText("" + ll.getTimeLeft());
			break;
		case "Release":
			levelParamTitle.setText("Number Left:");
			break;
		default:
			System.err.println("This level type is not yet supported."); 
			return;			
		}
		
		this.add(levelParamTitle);
		this.add(levelParamDisplay);
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
}
