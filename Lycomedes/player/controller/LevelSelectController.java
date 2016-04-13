package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import supers.Application;
import supers.Model;
import supers.Screen;
import view.LevelSelectView;
import view.LevelView;

public class LevelSelectController implements ActionListener {
	private Model model;
	private Application app;
		
	public LevelSelectController(Application a, Model m) {
		this.app = a;
		this.model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String levelName = "Level " + e.getActionCommand();
		app.setCurrScreen(new LevelView(new Level(levelName, "Puzzle")));
	}
	
}
