package kabasuji.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kabasuji.controllers.FlipXController;
import kabasuji.controllers.FlipYController;
import kabasuji.controllers.PaletteSelectController;
import kabasuji.controllers.PlacePieceController;
import kabasuji.controllers.RotateLeftController;
import kabasuji.controllers.RotateRightController;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test_Sails extends JFrame {

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
					Test_Sails frame = new Test_Sails();
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
	public Test_Sails() {
		
		SuperModel sm = new SuperModel("test");
		Level level = new PuzzleLevel("no name");
		sm.setActiveLevel(level);
		Bullpen bp = level.getBullpen();
		Board board = level.getBoard();
		Palette pal = level.getPalette();
		Application a = new Application(new PuzzleLevelEditView("Title", sm));			//<=================kill these for window builder
		
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
		boardPanel.add(bView);			//<=================kill these for window builder
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(bpView);			//<=================kill these for window builder
		
		JScrollPane palettePane = new JScrollPane();
		palettePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		palettePane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton btnFlipx = new JButton("flipx");
		btnFlipx.addActionListener(new FlipXController(a, sm.getActiveLevel()));
		
		JButton btnFlippy = new JButton("flippy");
		btnFlipx.addActionListener(new FlipYController(a, sm.getActiveLevel()));
		
		JButton btnRotL = new JButton("rotate ->");
		btnFlipx.addActionListener(new RotateLeftController(a, sm.getActiveLevel()));
		
		JButton btnRotR = new JButton("<- rotate");
		btnFlipx.addActionListener(new RotateRightController(a, sm.getActiveLevel()));
		
		palettePane.setViewportView(pview);			//<=================kill these for window builder
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(palettePane, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(boardPanel, GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
							.addGap(7))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addComponent(btnFlipx)
							.addGap(29)
							.addComponent(btnFlippy)
							.addGap(22)
							.addComponent(btnRotR, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(btnRotL)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(palettePane, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(66)
									.addComponent(btnFlipx))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(66)
									.addComponent(btnFlippy))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(67)
									.addComponent(btnRotR))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(67)
									.addComponent(btnRotL)))))
					.addContainerGap(236, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		SelectPieceController psc = new SelectPieceController(sm.getActiveLevel(), bpView);
		bpView.addMouseListener(psc);
		
		PlacePieceController placeCrtl = new PlacePieceController(sm, bView);
		bView.addMouseListener(placeCrtl);
		bView.addMouseMotionListener(placeCrtl);
		
//		TileSelectController tsc = new TileSelectController(sm, bView);
//		bView.addMouseListener(tsc);
//		bView.addMouseMotionListener(tsc);
		
		PaletteSelectController pc = new PaletteSelectController(sm, pview);
		pview.addMouseListener(pc);
	}
}
