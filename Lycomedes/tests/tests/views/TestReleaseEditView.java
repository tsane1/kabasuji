package tests.views;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import junit.framework.TestCase;
import kabasuji.controllers.FlipXController;
import kabasuji.controllers.FlipYController;
import kabasuji.controllers.PaletteSelectController;
import kabasuji.controllers.PlacePieceController;
import kabasuji.controllers.RotateLeftController;
import kabasuji.controllers.RotateRightController;
import kabasuji.controllers.SelectPieceController;
import kabasuji.entities.Board;
import kabasuji.entities.Bullpen;
import kabasuji.entities.Palette;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseBoardTile;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.views.BoardView;
import kabasuji.views.BullpenView;
import kabasuji.views.PaletteView;
import kabasuji.views.PuzzleLevelEditView;
import kabasuji.views.ReleaseLevelEditView;

public class TestReleaseEditView extends TestCase {

	private JPanel contentPane;
	
	SuperModel sm = new SuperModel("test");
	Level level = new PuzzleLevel("no name");
	JFrame frame = new JFrame();
	BoardView bView;
	BullpenView bpView;
	Palette pal;
	PaletteView pview;
	
	protected void setUp() throws Exception {
		sm.setActiveLevel(level);
		Bullpen bp = level.getBullpen();
		Board board = level.getBoard();
		Palette pal = level.getPalette();
		Application a = new Application(new ReleaseLevelEditView("Title", sm));
		
		int size = 12;
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size; j++){
				board.createBoardTile(i, j, "Release");
				((ReleaseBoardTile)board.getBoardArray()[i][j]).updateReleaseNum();
			}
		}
		
		bView = new BoardView(sm);
		bpView = new BullpenView(sm);
		pview = new PaletteView(sm);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
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
		
		PlacePieceController placeCrtl = new PlacePieceController(a, sm);
		bView.addMouseListener(placeCrtl);
		bView.addMouseMotionListener(placeCrtl);

//		TileSelectController tsc = new TileSelectController(sm, bView);
//		bView.addMouseListener(tsc);
//		bView.addMouseMotionListener(tsc);
		
		PaletteSelectController pc = new PaletteSelectController(sm, pview);
		pview.addMouseListener(pc);
		
		frame.setVisible(true);
	}


	protected void tearDown() throws Exception {
		frame.setVisible(false);
		frame.dispose();
	}
	public void testBoardView(){
//		bView.refresh();
//		bpView.refresh();
//		pview.refresh();
	}

}
