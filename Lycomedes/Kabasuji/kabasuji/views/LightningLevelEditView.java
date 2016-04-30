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
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import kabasuji.controllers.AddToBullpenController;
import kabasuji.controllers.DeleteLevelController;
import kabasuji.controllers.FlipXController;
import kabasuji.controllers.FlipYController;
import kabasuji.controllers.LevelNameChangeController;
import kabasuji.controllers.PaletteSelectController;
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
	private PaletteView paletteView;
	private JScrollPane bullpenViewScroll;
	private JScrollPane paletteViewScroll;
	
	private JButton btnUndo = new JButton("Undo");
	private JButton btnRedo = new JButton("Redo");
	private JButton btnSave = new JButton("Save");
	private JButton btnDelete = new JButton("Delete");
	
	private JSpinner mins = new JSpinner();
	private JSpinner secs = new JSpinner();
	private JTextField setLevelName = new JTextField();
	
	public LightningLevelEditView(String levelName, SuperModel m) {
		super(levelName, m);
		this.level = (LightningLevel)this.model.loadLevel(m.getUserLevelDir(), levelName+".lev");
		
		if(this.level == null) { // create new level
			this.level = new LightningLevel("Level " + (this.model.getTotalNumLevels()+1));
			this.setTitle("New Lightning Level: " + "Level " + (this.model.getTotalNumLevels() + 1));
		}
		else this.setTitle(level.getLevelName() + ": " + level.getLevelType() + " [EDIT]");
		
		model.setActiveLevel(level);
		this.boardView = new BoardView(this.model);
		this.bullpenView = new BullpenView(this.model);
		this.paletteView = new PaletteView(this.model);
	}
	
	@Override
	public void populate() {
		
		this.add(boardView);
		boardView.validate();
		boardView.repaint();
		
		JLabel lblPalette = new JLabel("Piece Palette");
		lblPalette.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalette.setForeground(SystemColor.textHighlight);
		lblPalette.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		lblPalette.setBounds(697, 100, 192, 25);
		this.add(lblPalette);
		
		paletteViewScroll = new JScrollPane();
		paletteViewScroll.setBounds(697, 125, 192, 337);
		paletteViewScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		paletteViewScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		paletteViewScroll.setViewportView(paletteView);
		this.add(paletteViewScroll);
		
		btnSave.setActionCommand(level.getLevelName());
		btnSave.setBackground(SystemColor.text);
		btnSave.setForeground(SystemColor.textHighlight);
		btnSave.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnSave.setBounds(34, 459, 100, 25);
		this.add(btnSave);
		
		btnDelete.setActionCommand(level.getLevelName());
		btnDelete.setBackground(SystemColor.text);
		btnDelete.setForeground(SystemColor.textHighlight);
		btnDelete.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnDelete.setBounds(139, 459, 100, 25);
		this.add(btnDelete);
		
		btnUndo.setBackground(SystemColor.text);
		btnUndo.setForeground(SystemColor.textHighlight);
		btnUndo.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnUndo.setBounds(34, 409, 100, 25);
		this.add(btnUndo);
		
		btnRedo.setBackground(SystemColor.text);
		btnRedo.setForeground(SystemColor.textHighlight);
		btnRedo.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnRedo.setBounds(139, 409, 100, 25);
		this.add(btnRedo);
		
		this.add(boardView);
		
		bullpenViewScroll = new JScrollPane();
		bullpenViewScroll.setBounds(13, 512, 904, 228);
		bullpenViewScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		bullpenViewScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		bullpenViewScroll.setViewportView(bullpenView);
		this.add(bullpenViewScroll);
		
		JLabel lblMins = new JLabel("Minutes (0-5)");
		lblMins.setHorizontalAlignment(SwingConstants.CENTER);
		lblMins.setForeground(SystemColor.textHighlight);
		lblMins.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		lblMins.setBounds(79, 200, 115, 25);
		this.add(lblMins);
		
		JLabel lblSecs = new JLabel("Seconds (0-59)");
		lblSecs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecs.setForeground(SystemColor.textHighlight);
		lblSecs.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		lblSecs.setBounds(79, 277, 115, 25);
		this.add(lblSecs);
		
		mins.setModel(new SpinnerNumberModel(level.getMinsLeft(), 0, 5, 1));
		mins.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		((JSpinner.DefaultEditor)mins.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor)mins.getEditor()).getTextField().setName("mins");
		mins.setBounds(79, 225, 115, 42);
		this.add(mins);
		
		secs.setModel(new SpinnerNumberModel(level.getSecsLeft(), 0, 59, 1));
		secs.setName("secs");
		secs.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		((JSpinner.DefaultEditor)secs.getEditor()).getTextField().setEditable(false);
		((JSpinner.DefaultEditor)secs.getEditor()).getTextField().setName("secs");
		secs.setBounds(79, 302, 115, 42);
		this.add(secs);
		
		JLabel lblSetLevelName = new JLabel("Level Name:");
		lblSetLevelName.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetLevelName.setForeground(SystemColor.textHighlight);
		lblSetLevelName.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		lblSetLevelName.setBounds(35, 100, 200, 25);
		this.add(lblSetLevelName);
		
		setLevelName.setHorizontalAlignment(SwingConstants.CENTER);
		setLevelName.setBackground(SystemColor.text);
		setLevelName.setForeground(SystemColor.textHighlight);
		setLevelName.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		setLevelName.setBounds(35, 125, 200, 50);
		this.add(setLevelName);
		
		this.validate();
		this.repaint();
	}
	
	@Override
	public void installControllers() {
		btnUndo.addActionListener(new UndoController(this.app, this.model));
		btnRedo.addActionListener(new RedoController(this.app, this.model));
		btnSave.addActionListener(new SaveLevelController(this.app, this.model));
		btnDelete.addActionListener(new DeleteLevelController(this.app, this.model));
		
		bullpenView.addMouseListener(new AddToBullpenController(this.app, this.model));
		
		JSpinner.DefaultEditor minsEditor = (JSpinner.DefaultEditor)mins.getEditor();
		JSpinner.DefaultEditor secsEditor = (JSpinner.DefaultEditor)secs.getEditor();
		minsEditor.getTextField().addFocusListener(new SpinnerValueController(this.app, this.model));
		secsEditor.getTextField().addFocusListener(new SpinnerValueController(this.app, this.model));
		
		setLevelName.addFocusListener(new LevelNameChangeController(this.app, this.model));
		
		paletteView.addMouseListener(new PaletteSelectController(this.app, this.model));
		
		refresh();
	}

	@Override
	public void refresh() {
		btnUndo.setEnabled(!(model.getActiveLevel().peekLastMove() == null));
		btnRedo.setEnabled(!(model.getActiveLevel().peekRedoMove() == null));
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
	
	@Override
	public PaletteView getPaletteView() {
		return this.paletteView;
	}
}
