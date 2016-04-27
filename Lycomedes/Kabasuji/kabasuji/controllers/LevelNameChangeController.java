package kabasuji.controllers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;

public class LevelNameChangeController implements FocusListener {
	
	private SuperModel model;
	private Application app;

	public LevelNameChangeController(Application app, SuperModel model) {
		this.app = app;
		this.model = model;
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("focus on" + e.getComponent().toString());
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(((JTextField)e.getComponent()).getText().equals("")) return;
			
		model.deleteLevel(model.getUserLevelDir(), model.getActiveLevel().getLevelName()+".lev");
		String newTitle;
		if(app.getCurrScreen().getTitle().contains("New")) {
			newTitle = "New " + model.getActiveLevel().getLevelType() + " Level: " + ((JTextField)e.getComponent()).getText();
		}
		else {
			newTitle = ((JTextField)e.getComponent()).getText() + ": " + model.getActiveLevel().getLevelType() + " [EDIT]";
		}
		app.getCurrScreen().setTitle(newTitle);
		model.getActiveLevel().setLevelName(((JTextField)e.getComponent()).getText());
	}

}
