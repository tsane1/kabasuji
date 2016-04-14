package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import model.Level;
import supers.Screen;

@SuppressWarnings("serial")
public class PuzzleLevelEdit extends Screen{

	private Level thisLevel;
	private Screen prevScreen;
	private BoardView board;
	private BullpenView bullpen;
	
	public PuzzleLevelEdit(Level L) {
		super(L.getLevelName(), L);
		this.thisLevel = L;
	}

	@Override
	public void populate() {
		board = new BoardView(thisLevel.getBoard());
		bullpen = new BullpenView(thisLevel.getBullpen());
		this.add(board);
		this.add(bullpen);

		JButton saveBtn = new JButton("");
		saveBtn.setIcon(new ImageIcon(LevelEdit.class.getResource("/imgs/Save.png")));
		saveBtn.setBounds(102, 26, 50, 54);
		this.add(saveBtn);
		saveBtn.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		
		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon(LevelEdit.class.getResource("/imgs/back arrow.JPG")));
		backBtn.setBounds(22, 38, 80, 37);
		this.add(backBtn);
		
		JButton undoBtn = new JButton("");
		undoBtn.setIcon(new ImageIcon(LevelEdit.class.getResource("/imgs/Undo.png")));
		undoBtn.setBounds(102, 92, 53, 37);
		this.add(undoBtn);
		
		JButton redoBtn = new JButton("");
		redoBtn.setIcon(new ImageIcon(LevelEdit.class.getResource("/imgs/Redo.png")));
		redoBtn.setBounds(32, 87, 53, 37);
		this.add(redoBtn);
	}
	
	@Override
	public void installControllers() {
		super.installControllers();
	}
	

	@Override
	public void initModel() {
		// Method intentionally unimplemented, must be overridden to use
	}

	@Override
	public void refresh() {
		// Method intentionally unimplemented, must be overridden to use
	}
	
	public Level getLevel() {
		return this.thisLevel;
	}
	
	public void setPreviousFrame(Screen screen) {
		prevScreen = screen;
	}

	public LevelEditSelectView getPreviousFrame() {
		return (LevelEditSelectView)prevScreen;
	}
}
