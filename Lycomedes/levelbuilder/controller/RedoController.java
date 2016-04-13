package controller;

import model.LevelBuilderModel;
import view.BuilderScreen;

public class RedoController {

	LevelBuilderModel model;
	BuilderScreen screen;
	
	public RedoController(BuilderScreen bs, LevelBuilderModel lbm) {
		this.screen = bs;
		this.model = lbm;
	}

	public boolean doRedo(){
		Move m = model.getredoMove();
		
		if(m == null) {
			return false;
		}
		
		if(m.execute()) {
			model.addMoveToUndo(m);
		}
		
		//screen.redraw();
		//screen.repaint();
		return true;
	}
}
