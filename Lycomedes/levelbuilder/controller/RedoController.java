package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilderModel;
import view.LevelEdit;

public class RedoController implements ActionListener {

	LevelBuilderModel model;
	LevelEdit screen;
	
	public RedoController(LevelEdit bs, LevelBuilderModel lbm) {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// "doRedo" should prolly be implemented here
		try{
			doRedo();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : RedoController");
			ex.printStackTrace();
		}
		
	}
}
