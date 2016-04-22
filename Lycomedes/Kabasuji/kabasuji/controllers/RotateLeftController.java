package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;

public class RotateLeftController implements ActionListener {

	SuperModel model;
	Level level;
	
	public RotateLeftController(Level l, SuperModel sm) {
		this.level = l;
		this.model = sm;
	}
	
	public void doRotateLeft(){
		if(level.getSelected() == null){
			return;
		}
		
		level.getSelected().rotateLeft();
		
		//screen.redraw();
		//screen.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	// THIS IS A REQUIREMENT OF THE ACTIONLISTENER CLASS THE "doUndo" should prolly go here
		try{
			doRotateLeft();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : RotateLeftController");
			ex.printStackTrace();
		}
	}
}


