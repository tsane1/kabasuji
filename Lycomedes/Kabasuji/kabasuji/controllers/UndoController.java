package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

/**
 * Undo controller
 * 
 * @author SOMEBODY ELSE PUT THAT IN
 * @author Tanuj Sane
 */
public class UndoController implements ActionListener {
	SuperModel model;
	Application app;
	
	public UndoController(Application app, SuperModel model) {
		this.app = app;
		this.model = model;
	}
	
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
	public boolean doUndo() throws Exception {
		Move m = model.getLastMove();
		if(m == null){
			return false;
		}		
		if(m.undo()){
			model.addRedoableMove(m);
		}		
		return true;
	}
}


