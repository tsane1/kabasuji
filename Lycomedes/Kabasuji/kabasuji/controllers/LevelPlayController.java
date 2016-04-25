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

public class LevelPlayController implements ActionListener {
	private SuperModel model;
	private Application app;
		
	public LevelPlayController(Application a, SuperModel m) {
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
		if(!model.getActiveLevel().isLocked()) 
			this.app.setCurrScreen(new LevelPlayView(this.model.getActiveLevel().getLevelName(), this.model));
	}
	
}
