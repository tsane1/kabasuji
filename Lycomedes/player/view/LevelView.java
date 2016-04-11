package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Level;

public class LevelView extends ApplicationView {
	private Level level;
	private BoardView board;
	private BullpenView bullpen;
	private AchievementView stars;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelView frame = new LevelView(new Level("Level 1", "Puzzle"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LevelView(Level level) {
		super(level.getLevelName());
		this.level = level;
	}

	private void populate() {
		
	}
}
