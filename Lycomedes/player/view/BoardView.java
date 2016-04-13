package view;

import javax.swing.JPanel;
import model.Board;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class BoardView extends JPanel {
	private Board board;
	
	public BoardView(Board board) {
		super();
		this.board = board;
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BoardView.class.getResource("/imgs/12x12gridedit.jpg")));
		label.setBounds(0, 0, 384, 384);
		add(label);
		this.setBounds(283, 110, 384, 384);
	}
}
