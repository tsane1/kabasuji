package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;

public class SaveLevelController implements ActionListener {
	private Application app;
	private SuperModel model;

	public SaveLevelController(Application app, SuperModel model) {
		this.app = app;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Level newLevel = app.getCurrScreen().getLevel();
		if(newLevel == null);
		else {
			newLevel.setSelected(null);
			newLevel.saveLevel(model.getUserLevelDir());
			model.updateUserLevelNames();
		}
	}
}
