package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Model;
import kabasuji.views.LevelEdit;

public class Rot90RightController implements ActionListener {

	Model model;
	LevelEdit screen;
	
	public Rot90RightController(LevelEdit bs, Model lbm) {
		this.screen = bs;
		this.model = lbm;
	}
	
	public boolean doRot90Right(){
		Move m = model.getLastMove();
		
		if(m == null){
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
	// THIS IS A REQUIREMENT OF THE ACTIONLISTENER CLASS THE "doUndo" should prolly go here
		try{
			doRot90Right();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : Rot90RightController");
			ex.printStackTrace();
		}
	}
}


