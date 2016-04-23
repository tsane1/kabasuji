package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;

/**
 * Undo controller
 * 
 * @author Derek McMaster
 * @author Tanuj Sane
 */
public class UndoController implements ActionListener {
	Level level;
	Application app;
	
	public UndoController(Application app, Level l) {
		this.app = app;
		this.level = l;
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
		Move m = level.getLastMove();
		if(m == null){
			return false;
		}		
		if(m.undo()){
			level.addRedoableMove(m);
		}
		
		/*
		 * Need to add a redraw method
		 */
		app.repaint();
		return true;
	}
}


