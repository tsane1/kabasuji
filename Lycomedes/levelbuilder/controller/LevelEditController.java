package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import supers.Application;
import supers.Model;
import supers.Screen;
import view.LevelPlaySelectView;
import view.LevelEdit;
import view.LevelPlay;

public class LevelEditController implements ActionListener {
	private Model model;
	private Application app;
		
	public LevelEditController(Application a, Model m) {
		this.app = a;
		this.model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String levelName = "Level " + e.getActionCommand();
		app.setCurrScreen(new LevelEdit(new Level(levelName, "Puzzle")));
	}	
}
