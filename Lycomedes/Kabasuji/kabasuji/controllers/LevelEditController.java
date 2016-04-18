package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.entities.Level;
import kabasuji.supers.Application;
import kabasuji.supers.Model;
import kabasuji.views.LevelEdit;


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
