package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

/**
 * Undo controller for undoing moves.
 * 
 * @author Derek McMaster
 * @author Tanuj Sane
 */
public class UndoController implements ActionListener {
	/** Level where moves are executed. */
	Level level;
	/** Application being run. */
	Application app;
	
	/**
	 * Constructor for the undo controller.
	 * @param app
	 * @param model
	 */
	public UndoController(Application app, SuperModel model) {
		this.app = app;
		this.level = model.getActiveLevel();
	}
	
	/**
	 * Method for when the undo button is acted upon.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			doUndo();
		}
		catch(Exception x) {
			System.err.println("EXCEPTION CAUGHT : UndoController");
			x.printStackTrace();
		}
	}
	
	/**
	 * Undo method called by the controller which creates the move and tries to execute it.
	 * @return boolean
	 * @throws Exception
	 */
	public boolean doUndo() throws Exception {
		Move m = level.getLastMove();
		if(m == null){
			return false;
		}		
		if(m.undo()){
			level.addRedoableMove(m);
		}
		
		app.getCurrScreen().getBoardView().refresh();
		app.getCurrScreen().getBullpenView().refresh();
		app.getCurrScreen().getPaletteView().refresh();
		app.getCurrScreen().refresh();
		return true;
	}
}


