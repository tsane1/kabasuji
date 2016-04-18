package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Model;
import kabasuji.views.LevelEdit;

public class UndoController implements ActionListener {

	Model model;
	LevelEdit screen;
	
	public UndoController(LevelEdit bs, Model lbm) {
		this.screen = bs;
		this.model = lbm;
	}
	
	public boolean doUndo(){
		Move m = model.getLastMove();
		
		if(m == null){
			return false;
		}
		
		if(m.undo()){
			model.addRedoableMove(m);
		}
		
		//screen.redraw();
		//screen.repaint();
		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	// THIS IS A REQUIREMENT OF THE ACTIONLISTENER CLASS THE "doUndo" should prolly go here
		try{
			doUndo();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : UndoController");
			ex.printStackTrace();
		}
	}
}


