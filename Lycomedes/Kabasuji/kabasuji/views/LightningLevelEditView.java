package kabasuji.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import kabasuji.controllers.RedoController;
import kabasuji.controllers.UndoController;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.PuzzleLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.supers.Screen;

public class LightningLevelEditView extends Screen {
	private Level level;
	private BoardView boardView;
	private BullpenView bullpenView;
	
	private JButton btnUndo = new JButton("Undo");
	private JButton btnRedo = new JButton("Redo");
	private JButton btnSave = new JButton("Save");
	private JButton btnDelete = new JButton("Delete");
	
	public LightningLevelEditView(String levelName, SuperModel m) {
		super(levelName, m);
		this.level = this.model.getLevel(levelName);
		
		if(this.level == null) { // create new level
			this.level = new PuzzleLevel("Level " + this.model.totalLevels());
			this.setTitle("New Lightning Level: " + "Level " + (this.model.totalLevels() + 1));
		}
		else if(!this.level.getLevelType().equals("Lightning")) {
			this.level = new PuzzleLevel(levelName);
			this.setTitle("New Lightning Level: " + levelName);
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
	public String getName() {
		return this.level.getLevelType() + "LevelEditView";
	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application(new LightningLevelEditView("Level 1", new SuperModel()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	
//	
//	public void LightningLevelEditVieow() {
//		
//		
//		JLabel titleLabel = new JLabel("New Lightning Level");
//		titleLabel.setForeground(new Color(30, 144, 255));
//		titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 24));
//		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		
//		
//		
//		JLabel timerLabel = new JLabel("Enter a number of allowed seconds: ");
//		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		timerLabel.setForeground(new Color(30, 144, 255));
//		timerLabel.setFont(new Font("Kristen ITC", Font.BOLD, 16));
//		timerLabel.setBackground(Color.WHITE);
//		
//		secondsInput = new JTextField();
//		secondsInput.setColumns(10);
//		//secondsInput.addFocusListener((FocusListener) this);
//		
//		GroupLayout gl_contentPane = new GroupLayout(contentPane);
//		gl_contentPane.setHorizontalGroup(
//			gl_contentPane.createParallelGroup(Alignment.TRAILING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addContainerGap()
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
//							.addGroup(gl_contentPane.createSequentialGroup()
//								.addComponent(saveBtn)
//								.addContainerGap())
//							.addGroup(gl_contentPane.createSequentialGroup()
//								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//									.addComponent(undoBtn, 0, 0, Short.MAX_VALUE)
//									.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
//								.addPreferredGap(ComponentPlacement.UNRELATED)
//								.addComponent(redoBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
//								.addGap(111)
//								.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
//								.addPreferredGap(ComponentPlacement.RELATED)
//								.addComponent(timerLabel)))
//						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
//							.addComponent(secondsInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//							.addGap(121))))
//		);
//		gl_contentPane.setVerticalGroup(
//			gl_contentPane.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addContainerGap()
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
//						.addGroup(gl_contentPane.createSequentialGroup()
//							.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
//							.addGap(8)
//							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//								.addComponent(redoBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
//								.addComponent(undoBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
//								.addComponent(timerLabel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
//					.addPreferredGap(ComponentPlacement.RELATED)
//					.addComponent(secondsInput, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED, 542, Short.MAX_VALUE)
//					.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
//					.addContainerGap())
//		);
//		contentPane.setLayout(gl_contentPane);
//	}
//	
//	public void focusGained(FocusEvent e) {
//		; //do nothing
//	}
//	public void focusLost(FocusEvent e) {
//		inputSeconds = secondsInput.getText();
//	}
//

}
