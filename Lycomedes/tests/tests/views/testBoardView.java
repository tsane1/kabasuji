package tests.views;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.View;

import junit.framework.TestCase;
import kabasuji.controllers.PlacePieceController;
import kabasuji.controllers.SelectPieceController;
import kabasuji.entities.*;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.views.BoardView;
import kabasuji.views.LevelPlayView;
import kabasuji.views.Test_Mike;

//ATTEMPTS TO TEST BOARD VIEW BUT I DONT THINK ITS POSSIBLE CURRENTLY
public class testBoardView extends JFrame{
	
	
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testBoardView frame = new testBoardView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public testBoardView(){
		SuperModel model = new SuperModel("test");
		Level lvl = new PuzzleLevel("test");
		Board board = lvl.getBoard();
		model.setActiveLevel(lvl);
		LevelPlayView lpv = new LevelPlayView("test", model);
		BoardView view = new BoardView(model);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel Pane = new JPanel();
		//Pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//Pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Pane.add(lpv);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Pane, GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Pane, GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		PlacePieceController psc = new PlacePieceController(model, view);
		view.addMouseListener(psc);
	}
	
//	protected void setUp() throws Exception {
//		model = new SuperModel();
//		model.setActiveLevel(new PuzzleLevel("test"));
//		view = new BoardView(model);
//		view.refresh();
//		view.setVisible(true);
//	}
//
//	protected void tearDown() throws Exception {
//		
//	}
//	
//	public void testView(){
//		Board board = model.getActiveLevel().getBoard();
//		Tile[][] boardArray = board.getBoardArray();
//		UnplayableTile tile = new UnplayableTile(0, 0);
//		int i,j,count = 0;
//		for(i = 0; i<12; i++){
//			for(j = 0; j<12; j++){
//				if(boardArray[i][j].getClass() == tile.getClass()){
//					
//				}else{
//					count++;
//				}
//			}
//		}
//		assertEquals(0, count);
//		
//	}

}
