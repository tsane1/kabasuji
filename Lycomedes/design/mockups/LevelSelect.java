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
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class LevelSelect extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelect frame = new LevelSelect();
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
	public LevelSelect() {
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
		
		JLabel lblKabasuji = new JLabel("Kabasuji - Level Selection");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setForeground(SystemColor.textHighlight);
		lblKabasuji.setFont(new Font("Kristen ITC", Font.BOLD, 32));
		lblKabasuji.setBounds(235, 30, 480, 97);
		contentPane.add(lblKabasuji);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnBack.setForeground(SystemColor.textHighlight);
		btnBack.setBackground(SystemColor.textHighlight);
		btnBack.setBounds(12, 13, 97, 25);
		contentPane.add(btnBack);
	}
	
	public void populate() {
		JButton btnUserLevels = new JButton("User Levels");
		btnUserLevels.setBackground(SystemColor.textHighlight);
		btnUserLevels.setForeground(SystemColor.textHighlight);
		btnUserLevels.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnUserLevels.setBounds(765, 683, 155, 57);
		contentPane.add(btnUserLevels);
			
		JButton btnLevel12 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t12");
		btnLevel12.setBounds(322, 500, 95, 80);
		contentPane.add(btnLevel12);
		
		JButton btnLevel13 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t13");
		btnLevel13.setBounds(427, 500, 95, 80);
		contentPane.add(btnLevel13);
		
		JButton btnLevel14 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t14");
		btnLevel14.setBounds(532, 500, 95, 80);
		contentPane.add(btnLevel14);
		
		JButton btnLevel15 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t15");
		btnLevel15.setBounds(637, 500, 95, 80);
		contentPane.add(btnLevel15);
		
		JButton btnLevel11 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t11");
		btnLevel11.setBounds(217, 500, 95, 80);
		contentPane.add(btnLevel11);
		
		JButton btnLevel6 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t6");
		btnLevel6.setBounds(217, 350, 95, 80);
		contentPane.add(btnLevel6);
		
		JButton btnLevel8 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t8");
		btnLevel8.setBounds(427, 350, 95, 80);
		contentPane.add(btnLevel8);
		
		JButton btnLevel7 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t7");
		btnLevel7.setBounds(322, 350, 95, 80);
		contentPane.add(btnLevel7);
		
		JButton btnLevel9 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t9");
		btnLevel9.setBounds(532, 350, 95, 80);
		contentPane.add(btnLevel9);
		
		JButton btnLevel10 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t10");
		btnLevel10.setBounds(637, 350, 95, 80);
		contentPane.add(btnLevel10);
		
		JButton btnLevel5 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t5");
		btnLevel5.setBounds(637, 200, 95, 80);
		contentPane.add(btnLevel5);
		
		JButton btnLevel4 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t4");
		btnLevel4.setBounds(532, 200, 95, 80);
		contentPane.add(btnLevel4);
		
		JButton btnLevel3 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t3");
		btnLevel3.setBounds(427, 200, 95, 80);
		contentPane.add(btnLevel3);
		
		JButton btnLevel2 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t2");
		btnLevel2.setBounds(322, 200, 95, 80);
		contentPane.add(btnLevel2);
		
		JButton btnLevel1 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t1");
		btnLevel1.setBackground(SystemColor.menu);
		btnLevel1.setBounds(217, 200, 95, 80);
		contentPane.add(btnLevel1);
	}
}
