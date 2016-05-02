package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

/**
 * Redo controller.
 * 
 * @author Derek McMaster
 * @author Tanuj Sane
 */
public class RedoController implements ActionListener {
	/** Level where moves are executed. */
	Level level;
	/** Application being run. */
	Application app;
	
	/**
	 * Constructor for the redo controller.
	 * @param app
	 * @param model
	 */
	public RedoController(Application app, SuperModel model) {
		this.app = app;
		this.level = model.getActiveLevel();
	}
	
	/**
	 * Method for when the redo button is acted upon.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			doRedo();
		}
		catch(Exception ex) {
			System.err.println("EXCEPTION CAUGHT : RedoController");
			ex.printStackTrace();
		}
	}
	
	/**
	 * redo method called by the controller which creates the move and tries to execute it.
	 * @return boolean
	 */
	public boolean doRedo() {
		Move m = level.getRedoMove();
		if(m == null) {
			return false;
		}		
		if(m.execute()) {
			level.addMoveToUndo(m);
		}
		app.getCurrScreen().getBoardView().refresh();
		app.getCurrScreen().getBullpenView().refresh();
		app.getCurrScreen().getPaletteView().refresh();
		app.getCurrScreen().refresh();
		return true;
	}
}
