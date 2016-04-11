package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LevelSelectView extends ApplicationView {

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelectView frame = new LevelSelectView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LevelSelectView() {
		super("Select a Level");
		populate();
	}
	
	private void populate() {
		JButton btnUserLevels = new JButton("User Levels");
		btnUserLevels.setBackground(SystemColor.text);
		btnUserLevels.setForeground(SystemColor.textHighlight);
		btnUserLevels.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnUserLevels.setBounds(765, 683, 155, 57);
		contentPane.add(btnUserLevels);
		
		JButton btnLevel8 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t8");
		btnLevel8.setBackground(SystemColor.text);
		btnLevel8.setForeground(SystemColor.textHighlight);
		btnLevel8.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel8.setBounds(427, 350, 95, 80);
		contentPane.add(btnLevel8);
		
		JButton btnLevel12 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t12");
		btnLevel12.setBackground(SystemColor.text);
		btnLevel12.setForeground(SystemColor.textHighlight);
		btnLevel12.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel12.setBounds(322, 500, 95, 80);
		contentPane.add(btnLevel12);
		
		JButton btnLevel13 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t13");
		btnLevel13.setBackground(SystemColor.text);
		btnLevel13.setForeground(SystemColor.textHighlight);
		btnLevel13.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel13.setBounds(427, 500, 95, 80);
		contentPane.add(btnLevel13);
		
		JButton btnLevel14 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t14");
		btnLevel14.setBackground(SystemColor.text);
		btnLevel14.setForeground(SystemColor.textHighlight);
		btnLevel14.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel14.setBounds(532, 500, 95, 80);
		contentPane.add(btnLevel14);
		
		JButton btnLevel15 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t15");
		btnLevel15.setBackground(SystemColor.text);
		btnLevel15.setForeground(SystemColor.textHighlight);
		btnLevel15.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel15.setBounds(637, 500, 95, 80);
		contentPane.add(btnLevel15);
		
		JButton btnLevel11 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t11");
		btnLevel11.setBackground(SystemColor.text);
		btnLevel11.setForeground(SystemColor.textHighlight);
		btnLevel11.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel11.setBounds(217, 500, 95, 80);
		contentPane.add(btnLevel11);
		
		JButton btnLevel6 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t6");
		btnLevel6.setBackground(SystemColor.text);
		btnLevel6.setForeground(SystemColor.textHighlight);
		btnLevel6.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel6.setBounds(217, 350, 95, 80);
		contentPane.add(btnLevel6);
		
		JButton btnLevel7 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t7");
		btnLevel7.setBackground(SystemColor.text);
		btnLevel7.setForeground(SystemColor.textHighlight);
		btnLevel7.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel7.setBounds(322, 350, 95, 80);
		contentPane.add(btnLevel7);
		
		JButton btnLevel9 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t9");
		btnLevel9.setBackground(SystemColor.text);
		btnLevel9.setForeground(SystemColor.textHighlight);
		btnLevel9.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel9.setBounds(532, 350, 95, 80);
		contentPane.add(btnLevel9);
		
		JButton btnLevel10 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t10");
		btnLevel10.setBackground(SystemColor.text);
		btnLevel10.setForeground(SystemColor.textHighlight);
		btnLevel10.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel10.setBounds(637, 350, 95, 80);
		contentPane.add(btnLevel10);
		
		JButton btnLevel5 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t5");
		btnLevel5.setBackground(SystemColor.text);
		btnLevel5.setForeground(SystemColor.textHighlight);
		btnLevel5.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel5.setBounds(637, 200, 95, 80);
		contentPane.add(btnLevel5);
		
		JButton btnLevel4 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t4");
		btnLevel4.setBackground(SystemColor.text);
		btnLevel4.setForeground(SystemColor.textHighlight);
		btnLevel4.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel4.setBounds(532, 200, 95, 80);
		contentPane.add(btnLevel4);
		
		JButton btnLevel3 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t3");
		btnLevel3.setBackground(SystemColor.text);
		btnLevel3.setForeground(SystemColor.textHighlight);
		btnLevel3.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel3.setBounds(427, 200, 95, 80);
		contentPane.add(btnLevel3);
		
		JButton btnLevel2 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t2");
		btnLevel2.setBackground(SystemColor.text);
		btnLevel2.setForeground(SystemColor.textHighlight);
		btnLevel2.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel2.setBounds(322, 200, 95, 80);
		contentPane.add(btnLevel2);
		
		JButton btnLevel1 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t1");
		btnLevel1.setBackground(SystemColor.text);
		btnLevel1.setForeground(SystemColor.textHighlight);
		btnLevel1.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel1.setBounds(217, 200, 95, 80);
		contentPane.add(btnLevel1);
	}
}
