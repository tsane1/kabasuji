package controller;

import model.LevelBuilderModel;
import view.BuilderScreen;

public class UndoController {

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

}
