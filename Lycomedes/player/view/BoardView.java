package view;

import javax.swing.JPanel;
import model.Board;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class BoardView extends JPanel {
	private Board board;
	
	public BoardView(Board board) {
		this.board = board;
		setLayout(null);
		
		JLabel lblBoard = new JLabel("");
		lblBoard.setIcon(new ImageIcon(BoardView.class.getResource("/imgs/12x12gridedit.jpg")));
		lblBoard.setBounds(0, 0, 384, 384);
		add(lblBoard);
	}
}
