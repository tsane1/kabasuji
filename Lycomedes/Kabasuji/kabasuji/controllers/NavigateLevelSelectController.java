package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;

/**
 * Controller for navigating the levels pages.
 */
public class NavigateLevelSelectController implements ActionListener {
	/** Model instance being updated. */
	SuperModel model;
	/** Application being run. */
	Application app;
	
	/**
	 * Constructor for the navigating page controller.
	 * @param app
	 * @param model
	 */
	public NavigateLevelSelectController(Application app, SuperModel model) {
		this.model = model;
		this.app = app;
	}

	/**
	 * Handles the navigating of pages.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Next": 
			this.model.nextPage();
			break;
		case "Previous": 
			this.model.prevPage();
			break;
		default: 
			System.err.println("Error 64169198: NavigateLevelSelectController installed on wrong button!"); 
			break;
		}
		this.app.getCurrScreen().refresh();
	}
}
