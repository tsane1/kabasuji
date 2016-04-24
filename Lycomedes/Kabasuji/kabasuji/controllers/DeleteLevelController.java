package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelEditSelectView;

public class DeleteLevelController implements ActionListener {
	private Application app;
	private SuperModel model;

	public DeleteLevelController(Application app, SuperModel model) {
		this.app = app;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		this.model.deleteLevel(e.getActionCommand());
		app.setCurrScreen(new LevelEditSelectView(model));
	}
}
