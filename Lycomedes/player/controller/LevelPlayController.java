package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import supers.Application;
import supers.Model;
import supers.Screen;
import view.LevelPlaySelectView;
import view.LevelPlay;

public class LevelPlayController implements ActionListener {
	private Model model;
	private Application app;
		
	public LevelPlayController(Application a, Model m) {
		this.app = a;
		this.model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String levelName = "Level " + e.getActionCommand();
		app.setCurrScreen(new LevelPlay(new Level(levelName, "Puzzle")));
	}
	
}
