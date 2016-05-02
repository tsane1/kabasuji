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

/**
 * Controller for handling editing of levels.
 */
public class LevelEditController implements ActionListener {
	/** Model instance being updated. */
	private SuperModel model;
	/** Application being run. */
	private Application app;

	/**
	 * Constructor for level edit controller.
	 * @param App a
	 * @param SuperModel m
	 */
	public LevelEditController(Application a, SuperModel m) {
		this.app = a;
		this.model = m;
	}
	
	/**
	 * Handles requesting to edit a level.
	 */
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
