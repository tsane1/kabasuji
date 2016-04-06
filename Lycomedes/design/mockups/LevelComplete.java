package mockups;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LevelComplete extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelComplete frame = new LevelComplete();
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
	public LevelComplete() {
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
		
		JLabel lblKabasuji = new JLabel("Level Complete!");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setForeground(SystemColor.textHighlight);
		lblKabasuji.setFont(new Font("Kristen ITC", Font.BOLD, 32));
		lblKabasuji.setBounds(260, 13, 430, 97);
		contentPane.add(lblKabasuji);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnBack.setForeground(SystemColor.textHighlight);
		btnBack.setBackground(SystemColor.textHighlight);
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
		
		JPanel scorePanel = new JPanel();
		scorePanel.setBounds(210, 200, 530, 250);
		contentPane.add(scorePanel);
		
		JButton btnReplayLevel = new JButton("Replay Level");
		btnReplayLevel.setForeground(SystemColor.textHighlight);
		btnReplayLevel.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnReplayLevel.setBackground(SystemColor.textHighlight);
		btnReplayLevel.setBounds(210, 483, 134, 25);
		contentPane.add(btnReplayLevel);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMenu.setForeground(SystemColor.textHighlight);
		btnMenu.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnMenu.setBackground(SystemColor.textHighlight);
		btnMenu.setBounds(440, 483, 97, 25);
		contentPane.add(btnMenu);
		
		JButton btnContinue = new JButton("Continue >");
		btnContinue.setForeground(SystemColor.textHighlight);
		btnContinue.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnContinue.setBackground(SystemColor.textHighlight);
		btnContinue.setBounds(619, 483, 121, 25);
		contentPane.add(btnContinue);
		
	}
	
	private void populate() {
		
	}

}
