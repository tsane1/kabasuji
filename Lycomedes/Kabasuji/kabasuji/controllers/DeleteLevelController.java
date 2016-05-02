package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelEditSelectView;

/**
 * Controller for deleting a level.
 */
public class DeleteLevelController implements ActionListener {
	/** Application being run. */
	private Application app;
	/** Model being updated. */
	private SuperModel model;

	/**
	 * Constructor for the delete level controller.
	 * @param app
	 * @param model
	 */
	public DeleteLevelController(Application app, SuperModel model) {
		this.app = app;
		this.model = model;
	}

	/**
	 * Handles the request for deleting a level.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		this.model.deleteLevel(model.getUserLevelDir(), e.getActionCommand()+".lev");
		app.setCurrScreen(new LevelEditSelectView(model));
	}
}
