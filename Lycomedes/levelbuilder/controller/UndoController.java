package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilderModel;
import view.BuilderScreen;

public class UndoController implements ActionListener {

	LevelBuilderModel model;
	BuilderScreen screen;
	
	public UndoController(BuilderScreen bs, LevelBuilderModel lbm) {
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
		// TODO Auto-generated method stub
	// THIS IS A REQUIREMENT OF THE ACTIONLISTENER CLASS THE "doUndo" should prolly go here
	}

}
