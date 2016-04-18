package kabasuji.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kabasuji.entities.Level;
import kabasuji.supers.Screen;

public class LevelPlay extends Screen {
	
	private Level level;
	private BoardView board;
	private BullpenView bullpen;

	public LevelPlay(Level l) {
		super(l.getLevelName(), l);
		this.level = l;
	}
	
	@Override
	public void populate() {
//		board = new BoardView(level.getBoard());
//		bullpen = new BullpenView(level.getBullpen());
//		this.add(board);
//		this.add(bullpen);
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
		return this.level;
	}
	
	@Override
	public String getName() {
		return "LevelPlay";
	}
}
