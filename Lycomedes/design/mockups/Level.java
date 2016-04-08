package mockups;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Level extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Level frame = new Level();
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
	public Level() {
		initWindow();
		populate();
	}
	
	private void initWindow() {
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKabasuji = new JLabel("Level X: LevelType");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setForeground(SystemColor.textHighlight);
		lblKabasuji.setFont(new Font("Kristen ITC", Font.BOLD, 32));
		lblKabasuji.setBounds(300, 13, 349, 97);
		contentPane.add(lblKabasuji);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnBack.setForeground(SystemColor.textHighlight);
		btnBack.setBackground(SystemColor.textHighlight);
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
	}
	
	private void populate() {
	  JPanel board = new JPanel();
		board.setBounds(283, 125, 384, 384);
		contentPane.add(board);
		board.setLayout(null);
		
		JButton btnFuckyou = new JButton("FUCKYOU");
		btnFuckyou.setIcon(new ImageIcon(getClass().getClassLoader().getResource("/imgs/Star.png")));
		btnFuckyou.setBounds(99, 128, 97, 25);
		board.add(btnFuckyou);
		
		JPanel bullpen = new JPanel();
		bullpen.setBounds(12, 522, 908, 218);
		contentPane.add(bullpen);
		
		JLabel lblTimeLeft = new JLabel("Time Left:");
		lblTimeLeft.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		lblTimeLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeLeft.setBounds(760, 123, 97, 16);
		contentPane.add(lblTimeLeft);
		
		JLabel lblMovesLeft = new JLabel("Moves Left:");
		lblMovesLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovesLeft.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		lblMovesLeft.setBounds(760, 226, 97, 16);
		contentPane.add(lblMovesLeft);
		
		JLabel lblLevelProgress = new JLabel("Level Progress:");
		lblLevelProgress.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelProgress.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		lblLevelProgress.setBounds(63, 123, 125, 16);
		contentPane.add(lblLevelProgress);
		
		JPanel panel = new JPanel();
		panel.setBounds(73, 152, 61, 357);
		contentPane.add(panel);
	}
}
