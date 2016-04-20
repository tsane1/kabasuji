package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;
import kabasuji.views.LightningLevelEditView;
import kabasuji.views.NewLevelTypeSelectView;
import kabasuji.views.PuzzleLevelEditView;
import kabasuji.views.ReleaseLevelEditView;



public class NewLevelController implements ActionListener {

	SuperModel model;
	Application app;
	
	public NewLevelController(Application a, SuperModel m) {
		this.model = m;
		this.app = a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "New Level":
			this.app.setCurrScreen(new NewLevelTypeSelectView(this.model));
			break;
		case "Lightning":
			this.app.setCurrScreen(new LightningLevelEditView(null, this.model));
			break;
		case "Release":
			this.app.setCurrScreen(new ReleaseLevelEditView(null, this.model));
			break;
		case "Puzzle": 
			this.app.setCurrScreen(new PuzzleLevelEditView(null, this.model));
			break;
		default:
			System.out.println("Error 30586: Bad NewLevelController installation.");
			break;
		}
	}
}
