package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;


public class FlipXController implements ActionListener {
	SuperModel model;
	Level level;
	
	public FlipXController(Level l, SuperModel m) {
		this.level = l;
		this.model = m;
	}
	
	public void doFlipX(){
		if(level.getSelected() == null){
			return;
		}
		
		level.getSelected().flipX();
		
		//screen.redraw();
		//screen.repaint();
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


