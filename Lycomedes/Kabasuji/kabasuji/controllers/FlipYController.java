package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.SuperModel;
import kabasuji.views.LevelEdit;


public class FlipYController implements ActionListener {

	SuperModel model;
	LevelEdit screen;
	
	public FlipYController(LevelEdit bs, SuperModel lbm) {
		this.screen = bs;
		this.model = lbm;
	}
	
	public boolean doFlipY(){
		if(model.getSelected() == null){
			return false;
		}
		
		model.getSelected().flipY();
		
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


