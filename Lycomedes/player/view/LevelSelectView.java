package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.LevelSelectController;
import supers.IScreen;
import supers.Model;
import supers.Screen;

public class LevelSelectView extends Screen {
	private JButton btnLevel1, btnLevel2, btnLevel3, btnLevel4, btnLevel5,
									btnLevel6, btnLevel7, btnLevel8, btnLevel9, btnLevel10,
									btnLevel11, btnLevel12, btnLevel13, btnLevel14, btnLevel15;
	private JButton btnUserLevels = new JButton("User Levels");
	private Model model;

	public LevelSelectView(Model m) {
		super("Select a Level", m);
		this.model = m;
	}		
	@Override
	public void populate() {
		btnUserLevels.setName("User Levels");
		btnUserLevels.setBackground(SystemColor.text);
		btnUserLevels.setForeground(SystemColor.textHighlight);
		btnUserLevels.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnUserLevels.setBounds(765, 683, 155, 57);
		this.add(btnUserLevels);
		
		btnLevel15 = new JButton("15");
		btnLevel15.setName("15");
		btnLevel15.setBackground(SystemColor.text);
		btnLevel15.setForeground(SystemColor.textHighlight);
		btnLevel15.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel15.setBounds(637, 500, 95, 80);
		this.add(btnLevel15);
		
		btnLevel14 = new JButton("14");
		btnLevel14.setName("14");
		btnLevel14.setBackground(SystemColor.text);
		btnLevel14.setForeground(SystemColor.textHighlight);
		btnLevel14.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel14.setBounds(532, 500, 95, 80);
		this.add(btnLevel14);

		btnLevel13 = new JButton("13");
		btnLevel13.setName("13");
		btnLevel13.setBackground(SystemColor.text);
		btnLevel13.setForeground(SystemColor.textHighlight);
		btnLevel13.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel13.setBounds(427, 500, 95, 80);
		this.add(btnLevel13);
		
		btnLevel12 = new JButton("12");
		btnLevel12.setName("12");
		btnLevel12.setBackground(SystemColor.text);
		btnLevel12.setForeground(SystemColor.textHighlight);
		btnLevel12.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel12.setBounds(322, 500, 95, 80);
		this.add(btnLevel12);
		
		btnLevel11 = new JButton("11");
		btnLevel11.setName("11");
		btnLevel11.setBackground(SystemColor.text);
		btnLevel11.setForeground(SystemColor.textHighlight);
		btnLevel11.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel11.setBounds(217, 500, 95, 80);
		this.add(btnLevel11);
		
		btnLevel10 = new JButton("10");
		btnLevel10.setName("10");
		btnLevel10.setBackground(SystemColor.text);
		btnLevel10.setForeground(SystemColor.textHighlight);
		btnLevel10.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel10.setBounds(637, 350, 95, 80);
		this.add(btnLevel10);
		
		btnLevel9 = new JButton("9");
		btnLevel9.setName("9");
		btnLevel9.setBackground(SystemColor.text);
		btnLevel9.setForeground(SystemColor.textHighlight);
		btnLevel9.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel9.setBounds(532, 350, 95, 80);
		this.add(btnLevel9);
		
		btnLevel8 = new JButton("8");
		btnLevel8.setName("8");
		btnLevel8.setBackground(SystemColor.text);
		btnLevel8.setForeground(SystemColor.textHighlight);
		btnLevel8.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel8.setBounds(427, 350, 95, 80);
		this.add(btnLevel8);
		
		btnLevel7 = new JButton("7");
		btnLevel7.setName("7");
		btnLevel7.setBackground(SystemColor.text);
		btnLevel7.setForeground(SystemColor.textHighlight);
		btnLevel7.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel7.setBounds(322, 350, 95, 80);
		this.add(btnLevel7);
		
		btnLevel6 = new JButton("6");
		btnLevel6.setName("6");
		btnLevel6.setBackground(SystemColor.text);
		btnLevel6.setForeground(SystemColor.textHighlight);
		btnLevel6.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel6.setBounds(217, 350, 95, 80);
		this.add(btnLevel6);
		
		btnLevel5 = new JButton("5");
		btnLevel5.setName("5");
		btnLevel5.setBackground(SystemColor.text);
		btnLevel5.setForeground(SystemColor.textHighlight);
		btnLevel5.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel5.setBounds(637, 200, 95, 80);
		this.add(btnLevel5);
		
		btnLevel4 = new JButton("4");
		btnLevel4.setName("4");
		btnLevel4.setBackground(SystemColor.text);
		btnLevel4.setForeground(SystemColor.textHighlight);
		btnLevel4.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel4.setBounds(532, 200, 95, 80);
		this.add(btnLevel4);
		
		btnLevel3 = new JButton("3");
		btnLevel3.setName("3");
		btnLevel3.setBackground(SystemColor.text);
		btnLevel3.setForeground(SystemColor.textHighlight);
		btnLevel3.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel3.setBounds(427, 200, 95, 80);
		this.add(btnLevel3);
		
		btnLevel2 = new JButton("2");
		btnLevel2.setName("2");
		btnLevel2.setBackground(SystemColor.text);
		btnLevel2.setForeground(SystemColor.textHighlight);
		btnLevel2.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel2.setBounds(322, 200, 95, 80);
		this.add(btnLevel2);
		
		btnLevel1 = new JButton("1");
		btnLevel1.setName("1");
		btnLevel1.setBackground(SystemColor.text);
		btnLevel1.setForeground(SystemColor.textHighlight);
		btnLevel1.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		btnLevel1.setBounds(217, 200, 95, 80);
<<<<<<< HEAD
		this.add(btnLevel1);
		
=======
		contentPane.add(btnLevel1);
		
		for(int i = 0; i<= (buttons.size()-1); i++){
			String name = buttons.get(i).getName();
			buttons.get(i).setActionCommand(name);
			
		}
>>>>>>> branch 'master' of https://github.com/tsane1/lycomedes.git
	}


	@Override
	public void installControllers() {
		btnLevel1.addActionListener(new LevelSelectController(this, model));
		btnLevel2.addActionListener(new LevelSelectController(this, model));
		btnLevel3.addActionListener(new LevelSelectController(this, model));
		btnLevel4.addActionListener(new LevelSelectController(this, model));
		btnLevel5.addActionListener(new LevelSelectController(this, model));
		btnLevel6.addActionListener(new LevelSelectController(this, model));
		btnLevel7.addActionListener(new LevelSelectController(this, model));
		btnLevel8.addActionListener(new LevelSelectController(this, model));
		btnLevel9.addActionListener(new LevelSelectController(this, model));
		btnLevel10.addActionListener(new LevelSelectController(this, model));
		btnLevel11.addActionListener(new LevelSelectController(this, model));
		btnLevel12.addActionListener(new LevelSelectController(this, model));
		btnLevel13.addActionListener(new LevelSelectController(this, model));
		btnLevel14.addActionListener(new LevelSelectController(this, model));
		btnLevel15.addActionListener(new LevelSelectController(this, model));
	}

	@Override
	public void initModel() {
	
	}
}
