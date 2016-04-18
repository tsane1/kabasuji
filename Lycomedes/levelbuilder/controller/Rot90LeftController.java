package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilderModel;
import view.LevelEdit;

public class Rot90LeftController implements ActionListener {

	LevelBuilderModel model;
	LevelEdit screen;
	
	public Rot90LeftController(LevelEdit bs, LevelBuilderModel lbm) {
		this.screen = bs;
		this.model = lbm;
	}
	
	public boolean doRot90Left(){
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
			doRot90Left();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : Rot90LeftController");
			ex.printStackTrace();
		}
	}
}


