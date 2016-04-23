package kabasuji.views;

import javax.swing.JPanel;

import kabasuji.entities.Board;
import kabasuji.supers.SuperModel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class BoardView extends JPanel {
	private Board board;
	
	public BoardView(SuperModel model) {
		super();
		this.board = model.getActiveLevel().getBoard();
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BoardView.class.getResource("/imgs/12x12gridedit.jpg")));
		label.setBounds(0, 0, 384, 384);
		add(label);
		this.setBounds(283, 110, 384, 384);
	}
}
