package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import supers.Application;
import supers.Model;
import supers.Screen;
import view.LevelPlaySelectView;
import view.LevelEditSelectView;
import view.LevelPlay;

public class BackController implements ActionListener {
	private Screen screen;
	private Model model;
	private Application app;
		
	public BackController(Application a, Screen s, Model m) {
		this.app = a;
		this.screen = s;
		this.model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(app.getCurrScreen().getName()) {
		case "LevelPlaySelect": case "LevelEditSelect": 
			app.dispose();
			break;
		case "LevelPlay":
			app.setCurrScreen(new LevelPlaySelectView(new Model()));
			break;
		case "LevelEdit":
			app.setCurrScreen(new LevelEditSelectView(new Model()));
			break;
		}
	}
}
