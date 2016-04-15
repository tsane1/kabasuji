package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class LightningLevelEditView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LightningLevelEditView frame = new LightningLevelEditView();
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
	public LightningLevelEditView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel titleLabel = new JLabel("New Lightning Level");
		titleLabel.setForeground(new Color(30, 144, 255));
		titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 24));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton backBtn = new JButton("");
		backBtn.setBackground(Color.WHITE);
		backBtn.setIcon(new ImageIcon(LightningLevelEditView.class.getResource("/imgs/back arrow.JPG")));
		getContentPane().add(backBtn);
		
		JButton undoBtn = new JButton("");
		undoBtn.setBackground(Color.WHITE);
		undoBtn.setIcon(new ImageIcon(LightningLevelEditView.class.getResource("/imgs/Undo.png")));
		getContentPane().add(undoBtn);
		
		JButton saveBtn = new JButton("");
		saveBtn.setBackground(Color.WHITE);
		saveBtn.setIcon(new ImageIcon(LightningLevelEditView.class.getResource("/imgs/Save.png")));
		getContentPane().add(saveBtn);
		
		JButton redoBtn = new JButton("");
		redoBtn.setBackground(Color.WHITE);
		redoBtn.setIcon(new ImageIcon(LightningLevelEditView.class.getResource("/imgs/Redo.png")));
		getContentPane().add(redoBtn);
		
		JLabel timerLabel = new JLabel("Select a number of allowed seconds : ");
		timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timerLabel.setForeground(new Color(30, 144, 255));
		timerLabel.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		timerLabel.setBackground(Color.WHITE);
		
		JSlider timerSlider = new JSlider();
		timerSlider.setValue(0);
		timerSlider.setSnapToTicks(true);
		timerSlider.setPaintTicks(true);
		timerSlider.setPaintLabels(true);
		timerSlider.setMinorTickSpacing(5);
		timerSlider.setMajorTickSpacing(30);
		timerSlider.setMaximum(180);
		timerSlider.setBackground(Color.WHITE);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(undoBtn, 0, 0, Short.MAX_VALUE)
						.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(redoBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addGap(111)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(timerSlider, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
							.addContainerGap())
						.addComponent(timerLabel, Alignment.TRAILING)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(saveBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(redoBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(undoBtn, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(timerLabel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(timerSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(612, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	/*
	public int getNumSeconds(){
		return timerSlider.getValue();
	}
	*/
}
