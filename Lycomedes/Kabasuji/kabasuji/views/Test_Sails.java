package kabasuji.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kabasuji.controllers.FlipXController;
import kabasuji.controllers.PaletteSelectController;
import kabasuji.controllers.PlacePieceController;
import kabasuji.controllers.RotateRightController;
import kabasuji.controllers.SelectPieceController;
import kabasuji.controllers.UndoController;
import kabasuji.entities.Board;
import kabasuji.entities.Bullpen;
import kabasuji.entities.Palette;
import kabasuji.entities.PuzzleLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class Test_Sails extends JFrame {

	/**
	 * Do some weard serial nonsense.
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
		Bullpen bp = level.getBullpen();
		Board b = level.getBoard();
		Palette pal = level.getPalette();
//		Application a = new Application(new PuzzleLevelEditView("Title", sm));
		sm.setActiveLevel(level);
	
		// create board like MIke'n Ikes
		int size = 12;
		for(int i = 0; i<size; i++){
			for(int j = 0; j<size; j++){
				b.createBoardTile(i, j, "puzzle");
			}
		}
		
		BoardView bView = new BoardView(sm);
		BullpenView bpView = new BullpenView(sm);
		PaletteView pView = new PaletteView(sm);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBounds(100, 100, 384, 384);
		boardPanel.add(bView);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(pView);
		
		JScrollPane boardPane = new JScrollPane();
		boardPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		boardPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton undoButton = new JButton("undo");
		undoButton.addActionListener(new UndoController(a, sm));
		
		JButton flipxbtn = new JButton("flip x");
		flipxbtn.addActionListener(new FlipXController(a, sm.getActiveLevel()));
		
		JButton rotaterightbtn = new JButton("rotate right ");
		rotaterightbtn.addActionListener(new RotateRightController(a, sm.getActiveLevel()));
//		boardPane.setViewportView(bv);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(flipxbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(undoButton, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
					.addGap(55)
					.addComponent(rotaterightbtn, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addComponent(boardPane, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(46, Short.MAX_VALUE)
							.addComponent(boardPane, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
							.addGap(29))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addComponent(undoButton, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(rotaterightbtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(flipxbtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
							.addGap(161)))
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		SelectPieceController psc = new SelectPieceController(sm.getActiveLevel(), bpView);
		bpView.addMouseListener(psc);
		
		//PlacePieceController ppc = new PlacePieceController(sm,bv);
		//bv.addMouseListener(ppc);
		//bv.addMouseMotionListener(ppc);
		
		
		PlacePieceController placeCrtl = new PlacePieceController(sm, bView);
		bView.addMouseListener(placeCrtl);
		bView.addMouseMotionListener(placeCrtl);
		
//		TileSelectController tsc = new TileSelectController(sm, bView);
//		bView.addMouseListener(tsc);
//		bView.addMouseMotionListener(tsc);
		
		PaletteSelectController pc = new PaletteSelectController(sm, pView);
		pView.addMouseListener(pc);
	}
}
