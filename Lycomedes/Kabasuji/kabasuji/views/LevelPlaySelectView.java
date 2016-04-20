package kabasuji.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kabasuji.controllers.LevelPlayController;
import kabasuji.supers.SuperModel;
import kabasuji.supers.Application;
import kabasuji.supers.Screen;

public class LevelPlaySelectView extends Screen {
	private ArrayList<JButton> defaultLevelButtons = new ArrayList<JButton>(15);
	private JButton btnUserLevels = new JButton("User Levels");

	public LevelPlaySelectView(SuperModel m) {
		super("Select a Level", m);
	}		
	@Override
	public void populate() {
		
		// ditch this get a scroll thing implemented
		btnUserLevels.setName("User Levels");
		btnUserLevels.setBackground(SystemColor.text);
		btnUserLevels.setForeground(SystemColor.textHighlight);
		btnUserLevels.setFont(new Font("Kristen ITC", Font.BOLD, 12));
		btnUserLevels.setBounds(765, 683, 155, 57);
		this.add(btnUserLevels);
		
		int idx; String name;
		for(idx = 0; idx < 15; idx++) {
			name = "Level " + (idx + 1);
			defaultLevelButtons.add(new JButton(this.model.getLevel(name).getLevelName()));
			defaultLevelButtons.get(idx).setActionCommand(this.model.getLevel(name).getLevelName());
			defaultLevelButtons.get(idx).setBackground(SystemColor.text);
			defaultLevelButtons.get(idx).setForeground(SystemColor.textHighlight);
			defaultLevelButtons.get(idx).setFont(new Font("Kristen ITC", Font.BOLD, 20));
			if(idx < 5) defaultLevelButtons.get(idx).setBounds(217+(105*(idx)), 180, 80, 95);
			else if(idx < 10) defaultLevelButtons.get(idx).setBounds(217+(105*(idx-5)), 330, 80, 95);
			else if(idx < 15) defaultLevelButtons.get(idx).setBounds(217+(105*(idx-10)), 480, 80, 95);
			this.add(defaultLevelButtons.get(idx));
		}
	}


	@Override
	public void installControllers() {
		int idx;
		for(idx = 0; idx < 15; idx++) {
			defaultLevelButtons.get(idx).addActionListener(new LevelPlayController(this.app, this.model));
		}
	}
	
	@Override
	public void refresh() {
		
	}
	
	@Override
	public String getName() {
		return "LevelPlaySelect";
	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application(new LevelPlaySelectView(new SuperModel()));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
