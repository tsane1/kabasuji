package kabasuji.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kabasuji.supers.Application;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;

public class NewLevelTypeSelectView extends Screen {
	private SuperModel model;
	private JButton btnLightning = new JButton("Lightning");
	private JButton btnPuzzle = new JButton("Puzzle");
	private JButton btnRelease = new JButton("Release");
	
	public NewLevelTypeSelectView(SuperModel model) {
		super("Select Level Type", model);
	}

	@Override
	public void populate() {
		btnLightning.setName("Lightning");
		btnLightning.setBackground(SystemColor.text);
		btnLightning.setForeground(SystemColor.textHighlight);
		btnLightning.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnLightning.setBounds(386, 284, 155, 57);
		this.add(btnLightning);
		
		btnPuzzle.setName("Puzzle");
		btnPuzzle.setBackground(SystemColor.text);
		btnPuzzle.setForeground(SystemColor.textHighlight);
		btnPuzzle.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnPuzzle.setBounds(386, 354, 155, 57);
		this.add(btnPuzzle);
		
		btnRelease.setName("Release");
		btnRelease.setBackground(SystemColor.text);
		btnRelease.setForeground(SystemColor.textHighlight);
		btnRelease.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnRelease.setBounds(386, 421, 155, 57);
		this.add(btnRelease);
	}

	@Override
	public void installControllers() {
		
	}

	@Override
	public void refresh() {
		
	}

	@Override
	public String getName() {
		return "NewLevelTypeSelectView";
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application(new NewLevelTypeSelectView(new SuperModel()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//
//	/**
//	 * Create the frame.
//	 */
//	public NewLevelTypeSelectView() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 550, 600);
//		contentPane = new JPanel();
//		contentPane.setBackground(Color.WHITE);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		
//		JLabel titleLabel = new JLabel("Choose A Level Type");
//		titleLabel.setForeground(new Color(30, 144, 255));
//		titleLabel.setFont(new Font("Kristen ITC", Font.BOLD, 24));
//		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		
//		JButton NewPuzzleLevelBtn = new JButton("Puzzle Level");
//		NewPuzzleLevelBtn.setBackground(new Color(245, 245, 245));
//		NewPuzzleLevelBtn.setForeground(new Color(30, 144, 255));
//		NewPuzzleLevelBtn.setFont(new Font("Kristen ITC", Font.BOLD, 16));
//		
//		JButton NewLightningLevelBtn = new JButton("Lightning Level");
//		NewLightningLevelBtn.setForeground(new Color(30, 144, 255));
//		NewLightningLevelBtn.setFont(new Font("Kristen ITC", Font.BOLD, 16));
//		NewLightningLevelBtn.setBackground(new Color(245, 245, 245));
//		
//		JButton NewreleaseLevelBtn = new JButton("Release Level");
//		NewreleaseLevelBtn.setForeground(new Color(30, 144, 255));
//		NewreleaseLevelBtn.setFont(new Font("Kristen ITC", Font.BOLD, 16));
//		NewreleaseLevelBtn.setBackground(new Color(245, 245, 245));
//		GroupLayout gl_contentPane = new GroupLayout(contentPane);
//		gl_contentPane.setHorizontalGroup(
//			gl_contentPane.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addContainerGap(127, Short.MAX_VALUE)
//					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
//					.addGap(123))
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addGap(171)
//					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//						.addComponent(NewreleaseLevelBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
//						.addComponent(NewLightningLevelBtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
//						.addComponent(NewPuzzleLevelBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//					.addGap(182))
//		);
//		gl_contentPane.setVerticalGroup(
//			gl_contentPane.createParallelGroup(Alignment.LEADING)
//				.addGroup(gl_contentPane.createSequentialGroup()
//					.addContainerGap()
//					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
//					.addGap(47)
//					.addComponent(NewPuzzleLevelBtn)
//					.addGap(32)
//					.addComponent(NewLightningLevelBtn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
//					.addGap(34)
//					.addComponent(NewreleaseLevelBtn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
//					.addContainerGap(254, Short.MAX_VALUE))
//		);
//		contentPane.setLayout(gl_contentPane);
//	}
//
//	public void setPreviousFrame(Screen screen) {
//		prevScreen = screen;
//	}
//
//	public LevelEditSelectView getPreviousFrame() {
//		return (LevelEditSelectView)prevScreen;
//	}
}
