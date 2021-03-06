package kabasuji.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import kabasuji.controllers.FlipXController;
import kabasuji.controllers.FlipYController;
import kabasuji.controllers.HintController;
import kabasuji.controllers.PlacePieceController;
import kabasuji.controllers.RotateLeftController;
import kabasuji.controllers.RotateRightController;
import kabasuji.controllers.SelectPieceController;
import kabasuji.controllers.TimerController;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.Progress;
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
	/** Level being played. */
	private Level level;
	/** puzzle level instance. */
	private PuzzleLevel pl;
	/** lightning level instance. */
	private LightningLevel ll;
	/** release level instance. */
	private ReleaseLevel rl;
	/** Progress object for the level. */
	private Progress progress;
	/** Boardview for the level. */
	private BoardView boardView;
	/** Bullpenview for the level. */
	private BullpenView bullpenView;
	/** progressview for the level. */
	private ProgressView progressView;
	/** scrollpane for the pieces. */
	private JScrollPane pieceScroll = new JScrollPane();
	/** Label for displaying level params. */
	private JLabel levelParamTitle = new JLabel();
	/** Label for displaying the params. */
	private JLabel levelParamDisplay = new JLabel();
	/** label for displaying three stars. */
	private JLabel threeStarDisplay = new JLabel();
	/** label for displaying two stars. */
	private JLabel twoStarDisplay = new JLabel ();
	/** label for displaying one stars. */
	private JLabel oneStarDisplay = new JLabel ();
	/** Timer for lightning levels. */
	private Timer t;
	/** clockwise rotate button. */
	private JButton btnClockwise = new JButton();
	/** ccw rotate button. */
	private JButton btnCounterClockwise = new JButton();
	/** flip over x axis button. */
	private JButton btnFlipX = new JButton();
	/** flip over y axis button. */
	private JButton btnFlipY = new JButton();
	/** help button. */
	private JButton helpMe = new JButton();
	/** Progress bar for achievements. */
	private JProgressBar progressBar = new JProgressBar();

	/**
	 * Constructor for the level play view.
	 * @param levelName
	 * @param Supermodel m
	 */
	public LevelPlayView(String levelName, SuperModel m) {
		super(levelName, m);
		this.level = m.getActiveLevel();
		pl = null; rl = null; ll = null;
		this.setTitle(level.getLevelName() + ": " + level.getLevelType());
		this.boardView = new BoardView(m);
		this.bullpenView = new BullpenView(m);
		this.progressView = new ProgressView(m);
		
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
	
	/**
	 * Getter for the level instance.
	 * @return Level
	 */
	public Level getLevel() {
		return this.level;
	}
			
	/**
	 * Overriden populate method from Screen class.
	 */
	@Override
	public void populate() {
	
		this.add(boardView);
		boardView.validate();
		boardView.repaint();

		this.add(progressView);

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
		
		threeStarDisplay.setBounds(725, 75, 192, 64);
		twoStarDisplay.setBounds(725, 175, 192, 64);
		oneStarDisplay.setBounds(725, 275, 192, 64);
		
		
		helpMe.setText("Hint?");
		helpMe.setActionCommand("Hint");
		helpMe.setBackground(SystemColor.text);
		helpMe.setForeground(SystemColor.textHighlight);
		helpMe.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		helpMe.setBounds(87, 409, 100, 50);
		this.add(helpMe);
		
		refresh();
	}
	
	/**
	 * Overridden controller installation from Screen class.
	 */
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
		helpMe.addActionListener(new HintController(this.app, this.model));
	}	

	/**
	 * Overriden refresh for the screen from the screen class.
	 */
	@Override
	public void refresh() {
		this.remove(levelParamDisplay);
		if(model.getActiveLevel().hasEnded() || model.getActiveLevel().hasWon()) {
			if(model.getActiveLevel().getLevelType().equals("Lightning") && !(t == null)) t.stop();
			this.app.setCurrScreen(new LevelEndView(this.model));
			return;
		}
		switch(level.getLevelType()) { // add level-specific elements
		case "Puzzle":
			System.out.println(pl.hasEnded());
			while(pl.getMovesLeft()>=0){
				levelParamTitle.setText("Moves Left:");
				levelParamDisplay.setText("" + pl.getMovesLeft());
				if(pl.getMovesLeft() < 10) levelParamDisplay.setForeground(Color.RED);
				break;
			}

			pl.setNumStars();
			threeStarDisplay.setBounds(715, 75, 192, 64);
			twoStarDisplay.setBounds(715, 175, 192, 64);
			oneStarDisplay.setBounds(715, 275, 192, 64);
			if(pl.getNumStars()==3){
				threeStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars3.png")));
				twoStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars2.png")));
				oneStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars1.png")));
			} else if(pl.getNumStars()==2){
				threeStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars3.png")));
				twoStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars2.png")));
				oneStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars1.png")));
			} else if(pl.getNumStars()==1){
				threeStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars3.png")));
				twoStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars2.png")));
				oneStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars1.png")));
			} else if(pl.getNumStars()==0){
				threeStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars3.png")));
				twoStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars2.png")));
				oneStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars1.png")));
			}
			progressView.updateProgressBar("Puzzle");
			break;
		case "Lightning":
			levelParamTitle.setText("Time Left:");
			levelParamDisplay.setText("" + ll.getMinsLeft() + ":" + String.format("%02d", ll.getSecsLeft()));
			if(ll.getSecsLeft() < 10 && ll.getMinsLeft() == 0) levelParamDisplay.setForeground(Color.RED);
			
			threeStarDisplay.setBounds(715, 75, 192, 64);
			twoStarDisplay.setBounds(715, 175, 192, 64);
			oneStarDisplay.setBounds(715, 275, 192, 64);
			
			if(ll.getNumStars()==3){
				threeStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars3.png")));
				twoStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars2.png")));
				oneStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars1.png")));
			} else if(ll.getNumStars()==2){
				threeStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars3.png")));
				twoStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars2.png")));
				oneStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars1.png")));
			} else if(ll.getNumStars()==1){
				threeStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars3.png")));
				twoStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars2.png")));
				oneStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars1.png")));
			} else if(ll.getNumStars()==0){
				threeStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars3.png")));
				twoStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars2.png")));
				oneStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars1.png")));
			}
			progressView.updateProgressBar("Lightning");
			break;
		case "Release":
			levelParamTitle.setText("Number Left:");
			rl.setNumStars();
		
			threeStarDisplay.setBounds(715, 75, 192, 64);
			twoStarDisplay.setBounds(715, 200, 192, 64);
			oneStarDisplay.setBounds(715, 300, 192, 64);
			if(rl.getNumStars()==3){
				threeStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars3.png")));
				twoStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars2.png")));
				oneStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars1.png")));
			} else if(rl.getNumStars()==2){
				threeStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars3.png")));
				twoStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars2.png")));
				oneStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars1.png")));
			} else if(rl.getNumStars()==1){
				threeStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars3.png")));
				twoStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars2.png")));
				oneStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/goldstars1.png")));
			} else if(rl.getNumStars()==0){
				threeStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars3.png")));
				twoStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars2.png")));
				oneStarDisplay.setIcon(new ImageIcon(LevelPlayView.class.getResource("/imgs/stars1.png")));
			}
			progressView.updateProgressBar("Release");
			break;
		default:
			System.err.println("This level type is not yet supported."); 
			return;			
		}
		this.add(levelParamTitle);
		this.add(threeStarDisplay);
		this.add(twoStarDisplay);
		this.add(oneStarDisplay);
		this.add(levelParamDisplay);
		
		this.validate();
		this.repaint();
	}
	
	/**
	 * Overridden getter for the screen name.
	 * @return String
	 */
	@Override
	public String getName() {
		return "LevelPlay";
	}
	
	/**
	 * Overridden getter for the bullpenview.
	 * @return bullpenview
	 */
	@Override
	public BullpenView getBullpenView(){
		return this.bullpenView;
	}
	
	/**
	 * Overridden getter for the boardview.
	 * @return boardview
	 */
	@Override
	public BoardView getBoardView(){
		return this.boardView;
	}
	
	/**
	 * Method for stopping the timer on lightning levels.
	 */
	public void stopTimer() {
		t.stop();
	}
	
	/**
	 * Getter for FlipXBtn.
	 * @return FlipXBtn
	 */
	public JButton getFlipXBtn(){
		return this.btnFlipX;
	}
	
	/**
	 * Getter for FlipYBtn.
	 * @return FlipYBtn
	 */
	public JButton getFlipYBtn(){
		return this.btnFlipY;
	}
	
	/**
	 * Getter for RotateRightBtn.
	 * @return btnClockwise
	 */
	public JButton getRotateRightBtn(){
		return this.btnClockwise;
	}
	
	/**
	 * Getter for RotateLeftBtn.
	 * @return btnCounterClockwise
	 */
	public JButton getRotateLeftBtn(){
		return this.btnCounterClockwise;
	}
}
