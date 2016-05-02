package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;

/**
 * Controller for saving a level.
 */
public class SaveLevelController implements ActionListener {
	/** Application being run. */
	private Application app;
	/** Model being updated. */
	private SuperModel model;

	/**
	 * Constructor for the save level controller.
	 * @param app
	 * @param model
	 */
	public SaveLevelController(Application app, SuperModel model) {
		this.app = app;
		this.model = model;
	}

	/**
	 * Method for handling the saving of the level.
	 */
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
