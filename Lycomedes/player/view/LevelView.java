package view;

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

import controller.BackController;
import model.Board;
import model.Bullpen;
import model.Level;
import supers.Application;
import supers.Model;
import supers.Screen;

public class LevelView extends Screen {
	private Level level;
	private BoardView board;
	private BullpenView bullpen;

	public LevelView(Level level) {
		super(level.getLevelName(), level);
		this.level = level;
	}
	
	@Override
	public void populate() {
		board = new BoardView(level.getBoard());
		bullpen = new BullpenView(level.getBullpen());
		this.add(board);
		this.add(bullpen);
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
}
