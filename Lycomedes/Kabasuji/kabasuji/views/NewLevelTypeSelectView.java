package kabasuji.views;

import java.awt.EventQueue;

import kabasuji.controllers.NewLevelController;
import kabasuji.supers.Application;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class NewLevelTypeSelectView extends Screen {
	private JButton btnLightning = new JButton("Lightning");
	private JButton btnPuzzle = new JButton("Puzzle");
	private JButton btnRelease = new JButton("Release");
	
	public NewLevelTypeSelectView(SuperModel m) {
		super("Select Level Type", m);
	}

	@Override
	public void populate() {
		JLabel lblLightning = new JLabel("Lightning");
		lblLightning.setHorizontalAlignment(SwingConstants.CENTER);
		lblLightning.setForeground(SystemColor.textHighlight);
		lblLightning.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		lblLightning.setBounds(71,175,256,50);
		this.add(lblLightning);
		
		btnLightning.setName("Lightning");
		btnLightning.setActionCommand("Lightning");
		btnLightning.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/lightning_icon.png")));
		btnLightning.setBounds(71, 215, 256, 256);
		this.add(btnLightning);
		
		JLabel lblPuzzle = new JLabel("Puzzle");
		lblPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuzzle.setForeground(SystemColor.textHighlight);
		lblPuzzle.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		lblPuzzle.setBounds(337,175,256,50);
		this.add(lblPuzzle);
		
		btnPuzzle.setName("Puzzle");
		btnPuzzle.setActionCommand("Puzzle");
		btnPuzzle.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/puzzle_icon.png")));
		btnPuzzle.setBounds(337, 215, 256, 256);
		this.add(btnPuzzle);
		
		JLabel lblRelease = new JLabel("Release");
		lblRelease.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelease.setForeground(SystemColor.textHighlight);
		lblRelease.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		lblRelease.setBounds(603,175,256,50);
		this.add(lblRelease);
		
		btnRelease.setName("Release");
		btnRelease.setActionCommand("Release");
		btnRelease.setIcon(new ImageIcon(PuzzleLevelEditView.class.getResource("/imgs/release_icon.png")));
		btnRelease.setBounds(603, 215, 256, 256);
		this.add(btnRelease);
	}

	@Override
	public void installControllers() {
		btnLightning.addActionListener(new NewLevelController(this.app, this.model));
		btnRelease.addActionListener(new NewLevelController(this.app, this.model));
		btnPuzzle.addActionListener(new NewLevelController(this.app, this.model));
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
