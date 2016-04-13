package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import supers.IApplication;
import supers.Model;

public class LevelSelectView extends JFrame implements IApplication {

	// delete later, testing only
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
	
	public JButton btnLevel1, btnLevel2, btnLevel3, btnLevel4, btnLevel5,
									btnLevel6, btnLevel7, btnLevel8, btnLevel9, btnLevel10,
									btnLevel11, btnLevel12, btnLevel13, btnLevel14, btnLevel15;
	private JButton btnUserLevels = new JButton("User Levels");

	private ArrayList<JButton> buttons = new ArrayList<JButton> ();
	
	public LevelSelectView() {
		btnLevel1 = new JButton("1");
		buttons.add(btnLevel1);
		btnLevel2 = new JButton("2");
		buttons.add(btnLevel2);
		btnLevel3 = new JButton("3");
		buttons.add(btnLevel3);
		btnLevel4 = new JButton("4");
		buttons.add(btnLevel4);
		btnLevel5 = new JButton("5");
		buttons.add(btnLevel5);
		btnLevel6 = new JButton("6");
		buttons.add(btnLevel6);
		btnLevel7 = new JButton("7");
		buttons.add(btnLevel7);
		btnLevel8 = new JButton("8");
		buttons.add(btnLevel8);
		btnLevel9 = new JButton("9");
		buttons.add(btnLevel9);
		btnLevel10 = new JButton("10");
		buttons.add(btnLevel10);
		btnLevel11 = new JButton("11");
		buttons.add(btnLevel11);
		btnLevel12 = new JButton("12");
		buttons.add(btnLevel12);
		btnLevel13 = new JButton("13");
		buttons.add(btnLevel13);
		btnLevel14 = new JButton("14");
		buttons.add(btnLevel14);
		btnLevel15 = new JButton("15");
		buttons.add(btnLevel15);
		
	}
	
	public void populate(JPanel contentPane) {
		btnUserLevels.setBackground(SystemColor.text);
		btnUserLevels.setForeground(SystemColor.textHighlight);
		btnUserLevels.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnUserLevels.setBounds(765, 683, 155, 57);
		contentPane.add(btnUserLevels);
		
		btnLevel8.setBackground(SystemColor.text);
		btnLevel8.setForeground(SystemColor.textHighlight);
		btnLevel8.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel8.setBounds(427, 350, 95, 80);
		contentPane.add(btnLevel8);
		
		btnLevel12.setBackground(SystemColor.text);
		btnLevel12.setForeground(SystemColor.textHighlight);
		btnLevel12.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel12.setBounds(322, 500, 95, 80);
		contentPane.add(btnLevel12);
		
		btnLevel13.setBackground(SystemColor.text);
		btnLevel13.setForeground(SystemColor.textHighlight);
		btnLevel13.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel13.setBounds(427, 500, 95, 80);
		contentPane.add(btnLevel13);
		
		btnLevel14.setBackground(SystemColor.text);
		btnLevel14.setForeground(SystemColor.textHighlight);
		btnLevel14.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel14.setBounds(532, 500, 95, 80);
		contentPane.add(btnLevel14);
		
		btnLevel15.setBackground(SystemColor.text);
		btnLevel15.setForeground(SystemColor.textHighlight);
		btnLevel15.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel15.setBounds(637, 500, 95, 80);
		contentPane.add(btnLevel15);
		
		btnLevel11.setBackground(SystemColor.text);
		btnLevel11.setForeground(SystemColor.textHighlight);
		btnLevel11.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel11.setBounds(217, 500, 95, 80);
		contentPane.add(btnLevel11);
		
		btnLevel6.setBackground(SystemColor.text);
		btnLevel6.setForeground(SystemColor.textHighlight);
		btnLevel6.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel6.setBounds(217, 350, 95, 80);
		contentPane.add(btnLevel6);

		btnLevel7.setBackground(SystemColor.text);
		btnLevel7.setForeground(SystemColor.textHighlight);
		btnLevel7.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel7.setBounds(322, 350, 95, 80);
		contentPane.add(btnLevel7);
		
		btnLevel9.setBackground(SystemColor.text);
		btnLevel9.setForeground(SystemColor.textHighlight);
		btnLevel9.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel9.setBounds(532, 350, 95, 80);
		contentPane.add(btnLevel9);
		
		btnLevel10.setBackground(SystemColor.text);
		btnLevel10.setForeground(SystemColor.textHighlight);
		btnLevel10.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel10.setBounds(637, 350, 95, 80);
		contentPane.add(btnLevel10);
		
		btnLevel5.setBackground(SystemColor.text);
		btnLevel5.setForeground(SystemColor.textHighlight);
		btnLevel5.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel5.setBounds(637, 200, 95, 80);
		contentPane.add(btnLevel5);
		
		btnLevel4.setBackground(SystemColor.text);
		btnLevel4.setForeground(SystemColor.textHighlight);
		btnLevel4.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel4.setBounds(532, 200, 95, 80);
		contentPane.add(btnLevel4);
		
		btnLevel3.setBackground(SystemColor.text);
		btnLevel3.setForeground(SystemColor.textHighlight);
		btnLevel3.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel3.setBounds(427, 200, 95, 80);
		contentPane.add(btnLevel3);
		
		btnLevel2.setBackground(SystemColor.text);
		btnLevel2.setForeground(SystemColor.textHighlight);
		btnLevel2.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel2.setBounds(322, 200, 95, 80);
		contentPane.add(btnLevel2);
		
		btnLevel1.setBackground(SystemColor.text);
		btnLevel1.setForeground(SystemColor.textHighlight);
		btnLevel1.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel1.setBounds(217, 200, 95, 80);
		contentPane.add(btnLevel1);
		
		for(int i = 0; i<= (buttons.size()-1); i++){
			String name = buttons.get(i).getName();
			buttons.get(i).setActionCommand(name);
			
		}
	}

	@Override
	public void installControllers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initModel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	
	public String getName() {
		return "Select a Level";
	}
}
