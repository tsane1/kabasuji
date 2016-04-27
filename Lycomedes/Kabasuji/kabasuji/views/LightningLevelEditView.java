package kabasuji.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import kabasuji.controllers.DeleteLevelController;
import kabasuji.controllers.FlipXController;
import kabasuji.controllers.FlipYController;
import kabasuji.controllers.SpinnerValueController;
import kabasuji.controllers.PlacePieceController;
import kabasuji.controllers.RedoController;
import kabasuji.controllers.RotateLeftController;
import kabasuji.controllers.RotateRightController;
import kabasuji.controllers.SaveLevelController;
import kabasuji.controllers.SelectPieceController;
import kabasuji.controllers.UndoController;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.PuzzleLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.supers.Screen;

/**
 * 
 * @author Tanuj Sane
 * @since 4/23/16
 *
 */

public class LightningLevelEditView extends Screen { 
	private LightningLevel level;
	private BoardView boardView;
	private BullpenView bullpenView;
	private JScrollPane pieceScroll = new JScrollPane();
	
	private JButton btnUndo = new JButton("Undo");
	private JButton btnRedo = new JButton("Redo");
	private JButton btnSave = new JButton("Save");
	private JButton btnDelete = new JButton("Delete");
	
	private JButton btnClockwise = new JButton();
	private JButton btnCounterClockwise = new JButton();
	private JButton btnFlipX = new JButton();
	private JButton btnFlipY = new JButton();
	
	private JSpinner mins = new JSpinner();
	private JSpinner secs = new JSpinner();
	
	public LightningLevelEditView(String levelName, SuperModel m) {
		super(levelName, m);
		this.level = (LightningLevel)this.model.loadLevel(m.getUserLevelDir(), levelName+".lev");
		
		if(this.level == null) { // create new level
			this.level = new LightningLevel("Level " + (this.model.getTotalNumLevels()+1));
			this.setTitle("New Lightning Level: " + "Level " + (this.model.getTotalNumLevels() + 1));
		}
		else if(!this.level.getLevelType().equals("Lightning")) {
			this.level = new LightningLevel(levelName);
			this.setTitle("New Lightning Level: " + levelName);
		}
		else this.setTitle(level.getLevelName() + ": " + level.getLevelType() + " [EDIT]");
		
		model.setActiveLevel(level);
		this.boardView = new BoardView(this.model);
		this.bullpenView = new BullpenView(this.model);
	}
	
	@Override
	public void populate() {

		this.add(boardView);
		boardView.validate();
		boardView.repaint();
		
		btnSave.setActionCommand(level.getLevelName());
		btnSave.setBackground(SystemColor.text);
		btnSave.setForeground(SystemColor.textHighlight);
		btnSave.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnSave.setBounds(726, 370, 155, 57);
		this.add(btnSave);
		
		btnDelete.setActionCommand(level.getLevelName());
		btnDelete.setBackground(SystemColor.text);
		btnDelete.setForeground(SystemColor.textHighlight);
		btnDelete.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnDelete.setBounds(726, 437, 155, 57);
		this.add(btnDelete);
		
		btnUndo.setBackground(SystemColor.text);
		btnUndo.setForeground(SystemColor.textHighlight);
		btnUndo.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnUndo.setBounds(726, 110, 155, 57);
		this.add(btnUndo);
		
		btnRedo.setBackground(SystemColor.text);
		btnRedo.setForeground(SystemColor.textHighlight);
		btnRedo.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnRedo.setBounds(726, 177, 155, 57);
		this.add(btnRedo);
		
		this.add(boardView);
		
		pieceScroll = new JScrollPane();
		pieceScroll.setBounds(13, 512, 904, 228);
		pieceScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		pieceScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pieceScroll.setViewportView(bullpenView);
		this.add(pieceScroll);
		
		btnClockwise.setBounds(53, 472, 40, 40);
		btnClockwise.setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/clockwise.png")));
		this.add(btnClockwise);
		
		btnCounterClockwise.setBounds(13, 472, 40, 40);
		btnCounterClockwise.setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/counter_clockwise.png")));
		this.add(btnCounterClockwise);
		
		btnFlipX.setBounds(103, 472, 40, 40);
		btnFlipX.setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/flipX.png")));
		this.add(btnFlipX);
		
		btnFlipY.setBounds(143, 472, 40, 40);
		btnFlipY.setIcon(new ImageIcon(LevelPlaySelectView.class.getResource("/imgs/flipY.png")));
		this.add(btnFlipY);
		
		JLabel lblMins = new JLabel("Minutes (0-5)");
		lblMins.setHorizontalAlignment(SwingConstants.CENTER);
		lblMins.setForeground(SystemColor.textHighlight);
		lblMins.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		lblMins.setBounds(79, 100, 115, 25);
		this.add(lblMins);
		
		JLabel lblSecs = new JLabel("Seconds (0-59)");
		lblSecs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecs.setForeground(SystemColor.textHighlight);
		lblSecs.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		lblSecs.setBounds(79, 177, 115, 25);
		this.add(lblSecs);
		
		mins.setModel(new SpinnerNumberModel(level.getMinsLeft(), 0, 5, 1));
		mins.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		((JSpinner.DefaultEditor)mins.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor)mins.getEditor()).getTextField().setName("mins");
		mins.setBounds(79, 125, 115, 42);
		this.add(mins);
		
		secs.setModel(new SpinnerNumberModel(level.getSecsLeft(), 0, 59, 1));
		secs.setName("secs");
		secs.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		((JSpinner.DefaultEditor)secs.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor)secs.getEditor()).getTextField().setName("secs");
		secs.setBounds(79, 202, 115, 42);
		this.add(secs);
		
		this.validate();
		this.repaint();
	}
	
	@Override
	public void installControllers() {
		btnUndo.addActionListener(new UndoController(this.app, this.model));
		btnRedo.addActionListener(new RedoController(this.app, this.model));
		btnSave.addActionListener(new SaveLevelController(this.app, this.model));
		btnDelete.addActionListener(new DeleteLevelController(this.app, this.model));
		
		bullpenView.addMouseListener(new SelectPieceController(level, bullpenView));
		
		PlacePieceController ppc = new PlacePieceController(model, boardView);
		boardView.addMouseListener(ppc);
		boardView.addMouseMotionListener(ppc);
		
		btnClockwise.addActionListener(new RotateRightController(this.app, this.model.getActiveLevel()));
		btnCounterClockwise.addActionListener(new RotateLeftController(this.app, this.model.getActiveLevel()));
		btnFlipX.addActionListener(new FlipXController(this.app, this.model.getActiveLevel()));
		btnFlipY.addActionListener(new FlipYController(this.app, this.model.getActiveLevel()));
		
		JSpinner.DefaultEditor minsEditor = (JSpinner.DefaultEditor)mins.getEditor();
		JSpinner.DefaultEditor secsEditor = (JSpinner.DefaultEditor)secs.getEditor();
		minsEditor.getTextField().addFocusListener(new SpinnerValueController(this.app, this.model));
		secsEditor.getTextField().addFocusListener(new SpinnerValueController(this.app, this.model));
	}

	@Override
	public void refresh() {

	}

	@Override
	public String getName() {
		return this.level.getLevelType() + "LevelEditView";
	}
	
	@Override
	public BullpenView getBullpenView(){
		return this.bullpenView;
	}

	@Override
	public BoardView getBoardView(){
		return this.boardView;
	}
	
	@Override
	public Level getLevel() {
		return this.level;
	}
}
