package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.entities.LevelBuilderModel;
import kabasuji.supers.Model;
import kabasuji.views.LevelEdit;


public class FlipXController implements ActionListener {

	Model model;
	LevelEdit screen;
	
	public FlipXController(LevelEdit bs, Model lbm) {
		this.screen = bs;
		this.model = lbm;
	}
	
	public boolean doFlipX(){
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
			doFlipX();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : FlipXController");
			ex.printStackTrace();
		}
	}
}


