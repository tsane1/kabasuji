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

import model.Board;
import model.Bullpen;
import model.Level;
import supers.Model;

public class LevelView extends JFrame implements supers.IApplication {
	private Level level;
//	private BoardView board;
//	private BullpenView bullpen;
//	private AchievementView stars;
	
	// for testing only
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelView frame = new LevelView(new Level("Level x", "type"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LevelView(Level level) {
		this.level = level;
	}

	@Override
	public void populate(JPanel contentPane) {
		BoardView bv = new BoardView(new Board());
		BullpenView vb = new BullpenView(new Bullpen());
		
		contentPane.add(bv);
		contentPane.add(vb);
	}

	@Override
	public void installControllers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initModel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	
	public String getName() {
		return this.level.getLevelName();
	}
}
