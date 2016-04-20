package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

/**
 * Redo controller
 * 
 * @author SOMEBODY ELSE PUT THAT IN
 * @author Tanuj Sane
 */
public class RedoController implements ActionListener {
	SuperModel model;
	Application app;
	
	public RedoController(Application app, SuperModel model) {
		this.app = app;
		this.model = model;
	}
	
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
	
	public boolean doRedo() {
		Move m = model.getRedoMove();
		if(m == null) {
			return false;
		}		
		if(m.execute()) {
			model.addMoveToUndo(m);
		}
		return true;
	}
}
