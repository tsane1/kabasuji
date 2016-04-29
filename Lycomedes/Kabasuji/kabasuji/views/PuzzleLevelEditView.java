package kabasuji.views;

import java.awt.EventQueue;

import kabasuji.controllers.AddToBullpenController;
import kabasuji.controllers.DeleteLevelController;
import kabasuji.controllers.FlipXController;
import kabasuji.controllers.FlipYController;
import kabasuji.controllers.LevelNameChangeController;
import kabasuji.controllers.PaletteSelectController;
import kabasuji.controllers.PlacePieceController;
import kabasuji.controllers.RedoController;
import kabasuji.controllers.RotateLeftController;
import kabasuji.controllers.RotateRightController;
import kabasuji.controllers.SaveLevelController;
import kabasuji.controllers.SelectPieceController;
import kabasuji.controllers.SpinnerValueController;
import kabasuji.controllers.UndoController;
import kabasuji.entities.PuzzleLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.supers.Screen;

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
/**
 * 
 * @author Tanuj Sane
 * @since 4/23/16
 *
 */
public class PuzzleLevelEditView extends Screen {
	private PuzzleLevel level;
	private BoardView boardView;
	private BullpenView bullpenView;
	private PaletteView paletteView;
	private JScrollPane bullpenViewScroll;
	private JScrollPane paletteViewScroll;
	
	private JButton btnUndo = new JButton("Undo");
	private JButton btnRedo = new JButton("Redo");
	private JButton btnSave = new JButton("Save");
	private JButton btnDelete = new JButton("Delete");
	
	private JSpinner setMoves = new JSpinner();
	private JTextField setLevelName = new JTextField();
	
	public PuzzleLevelEditView(String levelName, SuperModel m) {
		super(levelName, m);
		this.level = (PuzzleLevel)this.model.loadLevel(m.getUserLevelDir(), levelName+".lev");
		
		if(this.level == null) { // create new level
			this.level = new PuzzleLevel("Level " + (this.model.getTotalNumLevels() + 1));
			this.setTitle("New Puzzle Level: " + "Level " + (this.model.getTotalNumLevels() + 1));
		}
		else if(!this.level.getLevelType().equals("Puzzle")) {
			this.level = new PuzzleLevel(levelName);
			this.setTitle("New Puzzle Level: " + levelName);
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
		
		JLabel lblMoves = new JLabel("Moves");
		lblMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoves.setForeground(SystemColor.textHighlight);
		lblMoves.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		lblMoves.setBounds(79, 200, 115, 25);
		this.add(lblMoves);
		
		setMoves.setModel(new SpinnerNumberModel(level.getMovesLeft(), 0, null, 1));
		setMoves.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
		((JSpinner.DefaultEditor)setMoves.getEditor()).getTextField().setEditable(false);
		setMoves.setBounds(79, 225, 115, 42);
		this.add(setMoves);
		
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
		
		JSpinner.DefaultEditor setMovesEditor = (JSpinner.DefaultEditor)setMoves.getEditor();
		setMovesEditor.getTextField().addFocusListener(new SpinnerValueController(this.app, this.model));
		
		setLevelName.addFocusListener(new LevelNameChangeController(this.app, this.model));
		
		paletteView.addMouseListener(new PaletteSelectController(this.app, this.model));
	}

	@Override
	public void refresh() {

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
	public String getName() {
		return this.level.getLevelType() + "LevelEditView";
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
