package kabasuji.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import kabasuji.controllers.FlipXController;
import kabasuji.controllers.FlipYController;
import kabasuji.controllers.PlacePieceController;
import kabasuji.controllers.RotateLeftController;
import kabasuji.controllers.RotateRightController;
import kabasuji.controllers.SelectPieceController;
import kabasuji.controllers.TimerController;
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
 * @author Michael
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
	private JLabel starsDisplay = new JLabel();
	private Timer t;
	
	private JButton btnClockwise = new JButton();
	private JButton btnCounterClockwise = new JButton();
	private JButton btnFlipX = new JButton();
	private JButton btnFlipY = new JButton();


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
		
		btnClockwise.setBounds(787, 472, 40, 40);
		btnClockwise.setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/clockwise.png")));
		this.add(btnClockwise);
		
		btnCounterClockwise.setBounds(747, 472, 40, 40);
		btnCounterClockwise.setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/counter_clockwise.png")));
		this.add(btnCounterClockwise);
		
		btnFlipX.setBounds(837, 472, 40, 40);
		btnFlipX.setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/flipX.png")));
		this.add(btnFlipX);
		
		btnFlipY.setBounds(877, 472, 40, 40);
		btnFlipY.setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/flipY.png")));
		this.add(btnFlipY);
		
		levelParamTitle.setHorizontalAlignment(SwingConstants.CENTER);
		levelParamTitle.setForeground(SystemColor.textHighlight);
		levelParamTitle.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		levelParamTitle.setBounds(0, 100, 273, 25);
		
		levelParamDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		levelParamDisplay.setForeground(SystemColor.textHighlight);
		levelParamDisplay.setFont(new Font("Kristen ITC", Font.BOLD, 72));
		levelParamDisplay.setBounds(0, 125, 273, 200);
		
		starsDisplay.setBounds(697, 100, 192, 64);
		
		refresh();
	}
	
	@Override
	public void installControllers() {
		bullpenView.addMouseListener(new SelectPieceController(this.app, this.model));
		
		PlacePieceController ppc = new PlacePieceController(this.app, this.model);
		boardView.addMouseListener(ppc);
		boardView.addMouseMotionListener(ppc);
		
		btnClockwise.addActionListener(new RotateRightController(this.app, this.model.getActiveLevel()));
		btnCounterClockwise.addActionListener(new RotateLeftController(this.app, this.model.getActiveLevel()));
		btnFlipX.addActionListener(new FlipXController(this.app, this.model.getActiveLevel()));
		btnFlipY.addActionListener(new FlipYController(this.app, this.model.getActiveLevel()));
		
		if(model.getActiveLevel().getLevelType().equals("Lightning")) {
			t = new Timer(1000, new TimerController(this.app, this.model));
			t.start();
		}
	}	

	@Override
	public void refresh() {
		this.remove(levelParamDisplay);
		this.remove(starsDisplay);
		
		switch(level.getLevelType()) { // add level-specific elements
		case "Puzzle":
			levelParamTitle.setText("Moves Left:");
			levelParamDisplay.setText("" + pl.getMovesLeft());
			if(pl.getMovesLeft() < 10) levelParamDisplay.setForeground(Color.RED);
			pl.setNumStars();
			starsDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars" + pl.getNumStars() + ".png")));
			break;
		case "Lightning":
			levelParamTitle.setText("Time Left:");
			levelParamDisplay.setText("" + ll.getMinsLeft() + ":" + String.format("%02d", ll.getSecsLeft()));
			if(ll.getSecsLeft() < 10 && ll.getMinsLeft() == 0) levelParamDisplay.setForeground(Color.RED);
			if(ll.getSecsLeft() + ll.getMinsLeft() == 0) t.stop();
			starsDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars" + ll.getNumStars() + ".png")));
			break;
		case "Release":
			levelParamTitle.setText("Number Left:");
			rl.setNumStars();
			starsDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars" + rl.getNumStars() + ".png")));
			break;
		default:
			System.err.println("This level type is not yet supported."); 
			return;			
		}
		this.add(levelParamTitle);
		this.add(starsDisplay);
		this.add(levelParamDisplay);
		
		this.validate();
		this.repaint();
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
