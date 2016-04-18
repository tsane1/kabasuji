package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LevelBuilderModel;
import view.LevelEdit;

public class FlipYController implements ActionListener {

	LevelBuilderModel model;
	LevelEdit screen;
	
	public FlipYController(LevelEdit bs, LevelBuilderModel lbm) {
		this.screen = bs;
		this.model = lbm;
	}
	
	public boolean doFlipY(){
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
			doFlipY();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : FlipYController");
			ex.printStackTrace();
		}
	}
}


