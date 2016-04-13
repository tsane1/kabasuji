package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.DeleteLevelController;
import controller.LevelEditController;
import controller.LevelPlayController;
import controller.NewLevelController;
import mockups.Derek_Sandbox;
import model.LevelBuilderModel;
import supers.Model;
import supers.Screen;

import javax.swing.ScrollPaneConstants;

public class LevelEditSelectView extends Screen {
	private ArrayList<JButton> userLevelButtons = new ArrayList<JButton>(15);
	private JButton btnNewLevel = new JButton("New Level");
	private JButton btnDeleteLevel = new JButton("Delete Level");
	
	public LevelEditSelectView(Model m) {
		super("Edit a Level", m);
	}
	
	@Override
	public void populate() {
		
		// ditch this get a scroll thing implemented
		btnNewLevel.setName("New Level");
		btnNewLevel.setBackground(SystemColor.text);
		btnNewLevel.setForeground(SystemColor.textHighlight);
		btnNewLevel.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnNewLevel.setBounds(13, 683, 155, 57);
		this.add(btnNewLevel);
		
		btnDeleteLevel.setName("Delete Level");
		btnDeleteLevel.setBackground(SystemColor.text);
		btnDeleteLevel.setForeground(SystemColor.textHighlight);
		btnDeleteLevel.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnDeleteLevel.setBounds(765, 683, 155, 57);
		this.add(btnDeleteLevel);
		
		int idx; String name;
		for(idx = 0; idx < 15; idx++) {
			name = Integer.toString(idx+1);
			userLevelButtons.add(new JButton(name));
			userLevelButtons.get(idx).setName(name);
			userLevelButtons.get(idx).setActionCommand(name);
			userLevelButtons.get(idx).setBackground(SystemColor.text);
			userLevelButtons.get(idx).setForeground(SystemColor.textHighlight);
			userLevelButtons.get(idx).setFont(new Font("Kristen ITC", Font.BOLD, 20));
			if(idx < 5) userLevelButtons.get(idx).setBounds(217+(105*(idx)), 200, 95, 80);
			else if(idx < 10) userLevelButtons.get(idx).setBounds(217+(105*(idx-5)), 350, 95, 80);
			else if(idx < 15) userLevelButtons.get(idx).setBounds(217+(105*(idx-10)), 500, 95, 80);
			this.add(userLevelButtons.get(idx));
		}
	}


	@Override
	public void installControllers() {
		int idx;
		for(idx = 0; idx < 15; idx++) {
			userLevelButtons.get(idx).addActionListener(new LevelEditController(this.app, this.model));
		}
		btnNewLevel.addActionListener(new NewLevelController(this.app, this.model));
	}

	@Override
	public void initModel() {
	
	}	
	
	@Override
	public String getName() {
		return "LevelEditSelect";
	}
}
