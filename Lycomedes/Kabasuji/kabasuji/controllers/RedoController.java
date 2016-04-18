package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Model;
import kabasuji.views.LevelEdit;


public class RedoController implements ActionListener {

	Model model;
	LevelEdit screen;
	
	public RedoController(LevelEdit bs, Model lbm) {
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
