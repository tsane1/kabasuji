package kabasuji.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;

import kabasuji.controllers.DeleteLevelController;
import kabasuji.controllers.RedoController;
import kabasuji.controllers.SaveLevelController;
import kabasuji.controllers.UndoController;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.supers.Screen;

/**
 * 
 * @author lots of someones
 * @since 4/23/16
 *
 */

public class ReleaseLevelEditView extends Screen {
	private Level level;
	private BoardView boardView;
	private BullpenView bullpenView;
	
	private JButton btnUndo = new JButton("Undo");
	private JButton btnRedo = new JButton("Redo");
	private JButton btnSave = new JButton("Save");
	private JButton btnDelete = new JButton("Delete");
	
	public ReleaseLevelEditView(String levelName, SuperModel m) {
		super(levelName, m);
		this.level = this.model.getLevel(levelName);
		
		if(this.level == null) { // create new level
			this.level = new PuzzleLevel("Level " + this.model.totalLevels());
			this.setTitle("New Release Level: " + "Level " + (this.model.totalLevels() + 1));
		}
		else if(!this.level.getLevelType().equals("Release")) {
			this.level = new PuzzleLevel(levelName);
			this.setTitle("New Release Level: " + levelName);
		}
		else this.setTitle(level.getLevelName() + ": " + level.getLevelType() + " [EDIT]");
		
		this.boardView = new BoardView(this.model);
		this.bullpenView = new BullpenView(this.model);
	}
	
	@Override
	public void populate() {
		btnSave.setBackground(SystemColor.text);
		btnSave.setForeground(SystemColor.textHighlight);
		btnSave.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnSave.setBounds(726, 370, 155, 57);
		this.add(btnSave);
		
		btnDelete.setBackground(SystemColor.text);
		btnDelete.setForeground(SystemColor.textHighlight);
		btnDelete.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnDelete.setBounds(726, 437, 155, 57);
		this.add(btnDelete);
		
		btnUndo.setBackground(SystemColor.text);
		btnUndo.setForeground(SystemColor.textHighlight);
		btnUndo.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnUndo.setBounds(726, 110, 155, 57);
		this.add(btnUndo);
		
		btnRedo.setBackground(SystemColor.text);
		btnRedo.setForeground(SystemColor.textHighlight);
		btnRedo.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnRedo.setBounds(726, 177, 155, 57);
		this.add(btnRedo);
		
		this.add(boardView);
		this.add(bullpenView);
	}
	
	@Override
	public void installControllers() {
		btnUndo.addActionListener(new UndoController(this.app, this.model));
		btnRedo.addActionListener(new RedoController(this.app, this.model));
		btnSave.addActionListener(new SaveLevelController(this.app, this.model));
		btnDelete.addActionListener(new DeleteLevelController(this.app, this.model));
	}

	@Override
	public void refresh() {

	}

	@Override
	public String getName() {
		return this.level.getLevelType() + "LevelEditView";
	}

	@Override
	public BullpenView getBullpenView(){
		return this.bullpenView;
	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application(new ReleaseLevelEditView("Test Level", new SuperModel()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	
//	
//	
//	
//
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ReleaseLevelEditView frame = new ReleaseLevelEditView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public ReleaseLevelEditView() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 950, 800);
//		contentPane = new JPanel();
//		contentPane.setBackground(Color.WHITE);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		
//		JLabel titleLabel = new JLabel("New Release Level");
//		titleLabel.setForeground(new Color(30, 144, 255));
//		titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 24));
//		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		
//		JButton backBtn = new JButton("");
//		backBtn.setBackground(Color.WHITE);
//		backBtn.setIcon(new ImageIcon(ReleaseLevelEditView.class.getResource("/imgs/back arrow.JPG")));
//		getContentPane().add(backBtn);
//		
//		JButton undoBtn = new JButton("");
//		undoBtn.setBackground(Color.WHITE);
//		undoBtn.setIcon(new ImageIcon(ReleaseLevelEditView.class.getResource("/imgs/Undo.png")));
//		getContentPane().add(undoBtn);
//		
//		JButton saveBtn = new JButton("");
//		saveBtn.setBackground(Color.WHITE);
//		saveBtn.setIcon(new ImageIcon(ReleaseLevelEditView.class.getResource("/imgs/Save.png")));
//		getContentPane().add(saveBtn);
//		
//		JButton redoBtn = new JButton("");
//		redoBtn.setBackground(Color.WHITE);
//		redoBtn.setIcon(new ImageIcon(ReleaseLevelEditView.class.getResource("/imgs/Redo.png")));
//		getContentPane().add(redoBtn);
//		
//		JLabel lblNewLabel = new JLabel("Place at least one set of these numbers : ");
//		lblNewLabel.setFont(new Font("Kristen ITC", Font.BOLD, 16));
//		lblNewLabel.setForeground(new Color(30, 144, 255));
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		
//		JButton oneRed = new JButton("1");
//		oneRed.setForeground(Color.RED);
//		oneRed.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton twoRed = new JButton("2");
//		twoRed.setForeground(Color.RED);
//		twoRed.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton threeRed = new JButton("3");
//		threeRed.setForeground(Color.RED);
//		threeRed.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton fiveRed = new JButton("5");
//		fiveRed.setForeground(Color.RED);
//		fiveRed.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton sixRed = new JButton("6");
//		sixRed.setForeground(Color.RED);
//		sixRed.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton fourRed = new JButton("4");
//		fourRed.setForeground(Color.RED);
//		fourRed.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton oneGreen = new JButton("1");
//		oneGreen.setForeground(new Color(0, 128, 0));
//		oneGreen.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton oneYellow = new JButton("1");
//		oneYellow.setForeground(Color.YELLOW);
//		oneYellow.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton sixGreen = new JButton("6");
//		sixGreen.setForeground(new Color(0, 128, 0));
//		sixGreen.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton twoGreen = new JButton("2");
//		twoGreen.setForeground(new Color(0, 128, 0));
//		twoGreen.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton fiveGreen = new JButton("5");
//		fiveGreen.setForeground(new Color(0, 128, 0));
//		fiveGreen.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton fourGreen = new JButton("4");
//		fourGreen.setForeground(new Color(0, 128, 0));
//		fourGreen.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton threeGreen = new JButton("3");
//		threeGreen.setForeground(new Color(0, 128, 0));
//		threeGreen.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton twoYellow = new JButton("2");
//		twoYellow.setForeground(Color.YELLOW);
//		twoYellow.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton threeYellow = new JButton("3");
//		threeYellow.setForeground(Color.YELLOW);
//		threeYellow.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton fiveYellow = new JButton("5");
//		fiveYellow.setForeground(Color.YELLOW);
//		fiveYellow.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton fourYellow = new JButton("4");
//		fourYellow.setForeground(Color.YELLOW);
//		fourYellow.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		JButton sixYellow = new JButton("6");
//		sixYellow.setForeground(Color.YELLOW);
//		sixYellow.setFont(new Font("Tahoma", Font.BOLD, 13));
//		
//		
//		GroupLayout gl_contentPane = new GroupLayout(contentPane);
//		gl_contentPane.setHorizontalGroup(
//			gl_contentPane.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addContainerGap()
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//								.addComponent(undoBtn, 0, 0, Short.MAX_VALUE)
//								.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
//							.addPreferredGap(ComponentPlacement.UNRELATED)
//							.addComponent(redoBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
//							.addGap(111)
//							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
//								.addGroup(gl_contentPane.createSequentialGroup()
//									.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
//									.addGap(340))
//								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
//								.addComponent(fourYellow, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
//								.addComponent(oneYellow, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
//								.addComponent(fourRed, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
//								.addComponent(oneRed, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
//								.addComponent(oneGreen, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
//								.addComponent(fourGreen, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
//							.addPreferredGap(ComponentPlacement.RELATED)
//							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//								.addGroup(gl_contentPane.createSequentialGroup()
//									.addComponent(twoRed, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
//									.addPreferredGap(ComponentPlacement.RELATED)
//									.addComponent(threeRed, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
//								.addGroup(gl_contentPane.createSequentialGroup()
//									.addComponent(fiveRed, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
//									.addPreferredGap(ComponentPlacement.RELATED)
//									.addComponent(sixRed, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
//								.addGroup(gl_contentPane.createSequentialGroup()
//									.addComponent(twoGreen, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
//									.addPreferredGap(ComponentPlacement.RELATED)
//									.addComponent(threeGreen, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
//								.addGroup(gl_contentPane.createSequentialGroup()
//									.addComponent(fiveGreen, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
//									.addPreferredGap(ComponentPlacement.RELATED)
//									.addComponent(sixGreen, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
//								.addGroup(gl_contentPane.createSequentialGroup()
//									.addComponent(twoYellow, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
//									.addPreferredGap(ComponentPlacement.RELATED)
//									.addComponent(threeYellow, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
//								.addGroup(gl_contentPane.createSequentialGroup()
//									.addComponent(fiveYellow, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
//									.addPreferredGap(ComponentPlacement.RELATED)
//									.addComponent(sixYellow, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
//							.addGap(32))
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
//							.addContainerGap())))
//		);
//		gl_contentPane.setVerticalGroup(
//			gl_contentPane.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addContainerGap()
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
//							.addPreferredGap(ComponentPlacement.RELATED)
//							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
//							.addGap(8)
//							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//								.addComponent(redoBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
//								.addComponent(undoBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//						.addComponent(oneRed)
//						.addComponent(twoRed)
//						.addComponent(threeRed))
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//						.addComponent(fourRed)
//						.addComponent(fiveRed)
//						.addComponent(sixRed))
//					.addGap(28)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//						.addComponent(oneGreen)
//						.addComponent(twoGreen)
//						.addComponent(threeGreen))
//					.addGap(7)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//						.addComponent(fourGreen)
//						.addComponent(fiveGreen)
//						.addComponent(sixGreen))
//					.addGap(26)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//						.addComponent(oneYellow)
//						.addComponent(twoYellow)
//						.addComponent(threeYellow))
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
//						.addComponent(fiveYellow)
//						.addComponent(sixYellow)
//						.addComponent(fourYellow))
//					.addGap(312)
//					.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
//					.addContainerGap())
//		);
//		contentPane.setLayout(gl_contentPane);
//	}


}
