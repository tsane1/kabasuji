package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelPlayView;
import kabasuji.views.LightningLevelEditView;
import kabasuji.views.PuzzleLevelEditView;
import kabasuji.views.ReleaseLevelEditView;


public class LevelEditController implements ActionListener {
	private SuperModel model;
	private Application app;

	public LevelEditController(Application a, SuperModel m) {
		this.app = a;
		this.model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Level level;
		if(model.loadLevel(model.getUserLevelDir(), e.getActionCommand()+".lev") == null) 
			level = model.loadLevel(model.getDefaultLevelDir(), e.getActionCommand()+".lev");
		else level = model.loadLevel(model.getUserLevelDir(), e.getActionCommand()+".lev");
		model.setActiveLevel(level);
		
		switch(model.getActiveLevel().getLevelType()) {
		case "Puzzle":
			this.app.setCurrScreen(new PuzzleLevelEditView(model.getActiveLevel().getLevelName(), this.model));
			break;
		case "Lightning":
			this.app.setCurrScreen(new LightningLevelEditView(model.getActiveLevel().getLevelName(), this.model));
			break;
		case "Release": 
			this.app.setCurrScreen(new ReleaseLevelEditView(model.getActiveLevel().getLevelName(), this.model));
			break;
		}
	}	
}
