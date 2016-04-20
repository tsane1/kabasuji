package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.SuperModel;
import kabasuji.views.LevelEdit;

public class RotateRightController implements ActionListener {

	SuperModel model;
	LevelEdit screen;
	
	public RotateRightController(LevelEdit bs, SuperModel lbm) {
		this.screen = bs;
		this.model = lbm;
	}
	
	public boolean doRotateRight(){
		if(model.getSelected() == null){
			return false;
		}
		
		model.getSelected().rotateRight();
		
		//screen.redraw();
		//screen.repaint();
		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	// THIS IS A REQUIREMENT OF THE ACTIONLISTENER CLASS THE "doUndo" should prolly go here
		try{
			doRotateRight();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : RotateRightController");
			ex.printStackTrace();
		}
	}
}


