package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;
import kabasuji.supers.Screen;
import kabasuji.views.LevelEditSelectView;
import kabasuji.views.LevelPlaySelectView;
import kabasuji.views.LevelPlayView;

/** 
 * Controller for going back a screen.
 */
public class BackController implements ActionListener {
	/** Model being updated. */
	private SuperModel model;
	/** Application being run. */
	private Application app;
		
	/**
	 * Constructor for the back controller. 
	 * @param App a
	 * @param Model m
	 */
	public BackController(Application a, SuperModel m) {
		this.app = a;
		this.model = m;
	}
	
	/**
	 * Handles the request for going back a screen.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(app.getCurrScreen().getName()) {
		case "LevelPlaySelect": case "LevelEditSelect":
			app.setVisible(false);
			app.dispose();
			break;
		case "LevelPlay": case "LevelEnd":
			app.setCurrScreen(new LevelPlaySelectView(model));
			break;
		case "LightningLevelEditView": case "PuzzleLevelEditView": case "ReleaseLevelEditView": case "NewLevelTypeSelectView": 
			app.setCurrScreen(new LevelEditSelectView(model));
			break;
		default:
				System.out.println("Error 404: Screen not found.");
		}
	}
}
