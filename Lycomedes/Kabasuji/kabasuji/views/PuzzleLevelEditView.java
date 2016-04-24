package kabasuji.views;

import java.awt.EventQueue;

import kabasuji.controllers.RedoController;
import kabasuji.controllers.UndoController;
import kabasuji.entities.PuzzleLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.supers.Screen;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
/**
 * 
 * @author lots of someones
 * @since 4/23/16
 *
 */
public class PuzzleLevelEditView extends Screen {
	private Level level;
	private BoardView boardView;
	private BullpenView bullpenView;
	
	private JButton btnUndo = new JButton("Undo");
	private JButton btnRedo = new JButton("Redo");
	private JButton btnSave = new JButton("Save");
	private JButton btnDelete = new JButton("Delete");
	
	public PuzzleLevelEditView(String levelName, SuperModel m) {
		super(levelName, m);
		this.level = this.model.getLevel(levelName);
		
		if(this.level == null) { // create new level
			this.level = new PuzzleLevel("Level " + this.model.totalLevels());
			this.setTitle("New Puzzle Level: " + "Level " + (this.model.totalLevels() + 1));
		}
		else if(!this.level.getLevelType().equals("Puzzle")) {
			this.level = new PuzzleLevel(levelName);
			this.setTitle("New Puzzle Level: " + levelName);
		}
		else this.setTitle(level.getLevelName() + ": " + level.getLevelType() + " [EDIT]");
		
		this.boardView = new BoardView(this.level.getBoard());
		this.bullpenView = new BullpenView(level);
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
	}

	@Override
	public void refresh() {

	}
	
	@Override
	public BullpenView getBullpenView(){
		return this.bullpenView;
	}

	@Override
	public BoardView getBoardView(){
		return this.boardView;
	}
	
	@Override
	public String getName() {
		return this.level.getLevelType() + "LevelEditView";
	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application(new PuzzleLevelEditView("Test Level", new SuperModel()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private JPanel contentPane;
//	private JTextField numMovesTextField;
//	int numMoves;
//
//	/**
//	 * Launch the application.
//	 */
//	
//	public static void main(String[] args) {
//
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PuzzleLevelEditView frame = new PuzzleLevelEditView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
//
//	/**
//	 * Create the frame.
//	 */
//	public PuzzleLevelEditView() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 950, 800);
//		contentPane = new JPanel();
//		contentPane.setBackground(Color.WHITE);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		
//		JLabel titleLabel = new JLabel("New Puzzle Level");
//		titleLabel.setForeground(new Color(30, 144, 255));
//		titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 24));
//		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		
//		JButton backBtn = new JButton("");
//		backBtn.setBackground(Color.WHITE);
//		backBtn.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/back arrow.JPG")));
//		getContentPane().add(backBtn);
//		
//		JButton undoBtn = new JButton("");
//		undoBtn.setBackground(Color.WHITE);
//		undoBtn.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/Undo.png")));
//		getContentPane().add(undoBtn);
//		
//		JButton saveBtn = new JButton("");
//		saveBtn.setBackground(Color.WHITE);
//		saveBtn.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/Save.png")));
//		getContentPane().add(saveBtn);
//		
//		JButton redoBtn = new JButton("");
//		redoBtn.setBackground(Color.WHITE);
//		redoBtn.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/Redo.png")));
//		getContentPane().add(redoBtn);
//		
//		JLabel numMovesLabel = new JLabel("Enter a number of allowed moves : ");
//		numMovesLabel.setForeground(new Color(30, 144, 255));
//		numMovesLabel.setFont(new Font("Kristen ITC", Font.BOLD, 16));
//		numMovesLabel.setBackground(Color.WHITE);
//		numMovesLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		
//		numMovesTextField = new JTextField();
//		numMovesTextField.setColumns(10);
//		//numMovesTextField.addFocusListener((FocusListener) this);
//		
//		
//		GroupLayout gl_contentPane = new GroupLayout(contentPane);
//		gl_contentPane.setHorizontalGroup(
//			gl_contentPane.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addContainerGap()
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
//							.addGroup(gl_contentPane.createSequentialGroup()
//								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//									.addComponent(undoBtn, 0, 0, Short.MAX_VALUE)
//									.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
//								.addPreferredGap(ComponentPlacement.UNRELATED)
//								.addComponent(redoBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
//								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
//									.addGroup(gl_contentPane.createSequentialGroup()
//										.addGap(111)
//										.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
//										.addContainerGap(340, Short.MAX_VALUE))
//									.addGroup(gl_contentPane.createSequentialGroup()
//										.addPreferredGap(ComponentPlacement.RELATED)
//										.addComponent(numMovesLabel)
//										.addContainerGap())))
//							.addGroup(gl_contentPane.createSequentialGroup()
//								.addComponent(saveBtn)
//								.addContainerGap()))
//						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
//							.addComponent(numMovesTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//							.addGap(109))))
//		);
//		gl_contentPane.setVerticalGroup(
//			gl_contentPane.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addContainerGap()
//							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//								.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
//								.addGroup(gl_contentPane.createSequentialGroup()
//									.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
//									.addGap(8)
//									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//										.addComponent(redoBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
//										.addComponent(undoBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))))
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addGap(92)
//							.addComponent(numMovesLabel)))
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addComponent(numMovesTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED, 525, Short.MAX_VALUE)
//					.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
//					.addContainerGap())
//		);
//		contentPane.setLayout(gl_contentPane);
//	}
//	
//	public void focusGained(FocusEvent e){
//		;; //do nothing
//	}
//	
//	public void focusLost(FocusEvent e) {
//		String temp = numMovesTextField.getText();
//		numMoves = Integer.parseInt(temp);
//	}

}
