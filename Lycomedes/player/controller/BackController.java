package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import supers.Application;
import supers.Model;
import supers.Screen;
import view.LevelSelectView;
import view.LevelView;

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
		if(app.getCurrScreen().getName().contains(":")) {
			app.setCurrScreen(new LevelSelectView(new Model()));
		}
	}
}
