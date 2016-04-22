package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Model;
import kabasuji.views.LevelEdit;


public class TileSelectController implements MouseAdapter {

	Model model;
	LevelEdit screen;
	
	public TileSelectController(LevelEdit bs, Model lbm) {
		this.screen = bs;
		this.model = lbm;
	}
	@Override
	public void mousePressed(){
		
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

//	@Override
//	public void actionPerformed(ActionEvent e) {
//	// THIS IS A REQUIREMENT OF THE ACTIONLISTENER CLASS THE "doUndo" should prolly go here
//		try{
//			doFlipX();
//		}
//		catch(Exception ex){
//			System.err.println("EXCEPTION CAUGHT : FlipXController");
//			ex.printStackTrace();
//		}
//	}
}


