package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelEdit;


public class FlipXController implements ActionListener {
	SuperModel model;
	Application app;
	Level level;
	
	public FlipXController(Application a, SuperModel m) {
		this.app = a;
		this.model = m;
	}
	
	public boolean doFlipX(){
		if(model.getSelected() == null){
			return false;
		}
		
		model.getSelected().flipX();
		
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


