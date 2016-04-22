package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;

public class RotateRightController implements ActionListener {

	SuperModel model;
	Level level;
	
	public RotateRightController(Level l, SuperModel sm) {
		this.level = l;
		this.model = sm;
	}
	
	public void doRotateRight(){
		if(level.getSelected() == null){
			return;
		}
		
		level.getSelected().rotateRight();
		
		//screen.redraw();
		//screen.repaint();
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


