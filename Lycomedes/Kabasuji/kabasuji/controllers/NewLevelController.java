package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.views.NewLevelTypeSelectView;



public class NewLevelController implements ActionListener {

	SuperModel model;
	Application app;
	
	public NewLevelController(Application a, SuperModel m) {
		this.model = m;
		this.app = a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		app.setCurrScreen(new NewLevelTypeSelectView(this.model));
	}
}
