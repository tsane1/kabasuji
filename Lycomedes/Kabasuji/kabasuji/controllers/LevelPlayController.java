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
 * Controller for loading and playing a level.
 */
public class LevelPlayController implements ActionListener {
	/** Model instance being updated. */
	private SuperModel model;
	/** Application being run. */
	private Application app;
		
	/**
	 * Constructor for level play controller.
	 * @param App a
	 * @param Supermodel m
	 */
	public LevelPlayController(Application a, SuperModel m) {
		this.app = a;
		this.model = m;
	}
	
	/**
	 * Handles the loading and playing of the level.
	 */
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
