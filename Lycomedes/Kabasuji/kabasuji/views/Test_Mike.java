package kabasuji.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kabasuji.controllers.PaletteSelectController;
import kabasuji.controllers.PlacePieceController;
import kabasuji.controllers.SelectPieceController;
import kabasuji.controllers.TileSelectController;
import kabasuji.entities.Board;
import kabasuji.entities.Bullpen;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.Palette;
import kabasuji.entities.Piece;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseBoardTile;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Test_Mike extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test_Mike frame = new Test_Mike();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test_Mike() {
		
		SuperModel sm = new SuperModel("test");
		Level level = new PuzzleLevel("no name");
		Bullpen bp = level.getBullpen();
		Board board = level.getBoard();
		Palette pal = level.getPalette();
		sm.setActiveLevel(level);
		
		//bp.addPieces(level.getAllPieces());
		//creates a square of size x size
		int size = 12;
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size; j++){
				board.createBoardTile(i, j, "release");
				((ReleaseBoardTile)board.getBoardArray()[i][j]).updateReleaseNum();
			}
		}
		
		BoardView bView = new BoardView(sm);
		BullpenView bpView = new BullpenView(sm);
		PaletteView pview = new PaletteView(sm);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBounds(100, 100, 384, 384);
		boardPanel.add(bView);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(bpView);
		
		JScrollPane palettePane = new JScrollPane();
		palettePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		palettePane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		palettePane.setViewportView(pview);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 938, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(palettePane, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
							.addGap(73)
							.addComponent(boardPanel, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
						.addComponent(palettePane, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		SelectPieceController psc = new SelectPieceController(sm.getActiveLevel(), bpView);
		bpView.addMouseListener(psc);
		
//		PlacePieceController placeCrtl = new PlacePieceController(sm, bView);
//		bView.addMouseListener(placeCrtl);
//		bView.addMouseMotionListener(placeCrtl);
		
//		TileSelectController tsc = new TileSelectController(sm, bView);
//		bView.addMouseListener(tsc);
//		bView.addMouseMotionListener(tsc);
		
		PaletteSelectController pc = new PaletteSelectController(sm, pview);
		pview.addMouseListener(pc);
	}
}
