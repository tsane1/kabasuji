package kabasuji.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSlider;

public class PuzzleLevelEditView extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuzzleLevelEditView frame = new PuzzleLevelEditView();
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
	public PuzzleLevelEditView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel titleLabel = new JLabel("New Puzzle Level");
		titleLabel.setForeground(new Color(30, 144, 255));
		titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 24));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton backBtn = new JButton("");
		backBtn.setBackground(Color.WHITE);
		backBtn.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/back arrow.JPG")));
		getContentPane().add(backBtn);
		
		JButton undoBtn = new JButton("");
		undoBtn.setBackground(Color.WHITE);
		undoBtn.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/Undo.png")));
		getContentPane().add(undoBtn);
		
		JButton saveBtn = new JButton("");
		saveBtn.setBackground(Color.WHITE);
		saveBtn.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/Save.png")));
		getContentPane().add(saveBtn);
		
		JButton redoBtn = new JButton("");
		redoBtn.setBackground(Color.WHITE);
		redoBtn.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/Redo.png")));
		getContentPane().add(redoBtn);
		
		JLabel numMovesLabel = new JLabel("Select a number of allowed moves : ");
		numMovesLabel.setForeground(new Color(30, 144, 255));
		numMovesLabel.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		numMovesLabel.setBackground(Color.WHITE);
		numMovesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider numMovesSlider = new JSlider();
		numMovesSlider.setValue(0);
		numMovesSlider.setMinorTickSpacing(1);
		numMovesSlider.setMajorTickSpacing(10);
		numMovesSlider.setPaintLabels(true);
		numMovesSlider.setSnapToTicks(true);
		numMovesSlider.setPaintTicks(true);
		numMovesSlider.setForeground(new Color(30, 144, 255));
		numMovesSlider.setBackground(Color.WHITE);
		numMovesSlider.setMinimum(0);
		numMovesSlider.setMaximum(50);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(undoBtn, 0, 0, Short.MAX_VALUE)
								.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(redoBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(111)
									.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(340, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(numMovesSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(numMovesLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addContainerGap())))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(saveBtn)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(8)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(redoBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
										.addComponent(undoBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(92)
							.addComponent(numMovesLabel)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numMovesSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 507, Short.MAX_VALUE)
					.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	/*
	public int getNumMoves(){
		return numMovesSlider.getValue();
	}
	*/
}
