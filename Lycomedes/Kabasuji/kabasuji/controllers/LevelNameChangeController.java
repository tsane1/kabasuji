package kabasuji.controllers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;

/**
 * Constructor for handling the changing of a level's name.
 */
public class LevelNameChangeController implements FocusListener {
	/** Model instance being updated. */
	private SuperModel model;
	/** Application being run. */
	private Application app;

	/**
	 * Constructor for level name change controller.
	 * @param app
	 * @param model
	 */
	public LevelNameChangeController(Application app, SuperModel model) {
		this.app = app;
		this.model = model;
	}
	
	/** 
	 * handles the focus gained on a focus listener.
	 */
	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("focus on" + e.getComponent().toString());
	}

	/**
	 * hnadles losing focus on a focus listener.
	 */
	@Override
	public void focusLost(FocusEvent e) {
		if(((JTextField)e.getComponent()).getText().equals("")) return;
			
		model.deleteLevel(model.getUserLevelDir(), model.getActiveLevel().getLevelName()+".lev");
		String newTitle;
		if(app.getCurrScreen().getTitle().contains("New")) {
			newTitle = "New " + model.getActiveLevel().getLevelType() + " Level: " + ((JTextField)e.getComponent()).getText();
		}
		else {
			newTitle = ((JTextField)e.getComponent()).getText() + ": " + model.getActiveLevel().getLevelType() + " [EDIT]";
		}
		app.getCurrScreen().setTitle(newTitle);
		model.getActiveLevel().setLevelName(((JTextField)e.getComponent()).getText());
	}

}
