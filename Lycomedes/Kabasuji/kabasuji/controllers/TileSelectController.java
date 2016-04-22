package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.w3c.dom.events.MouseEvent;

import kabasuji.entities.Board;
import kabasuji.supers.Level;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

/**
 * 
 * @author irjacoway
 *
 */


public class TileSelectController extends Board{

	SuperModel supermodel;
	Screen screen;
	Level level;
	
	public TileSelectController(Level level, Screen s, SuperModel sm) {
		this.level = level;
		this.screen = s;
		this.supermodel = sm;
	}
//	@Override
//	public void mousePressed(){
//		
//	}
	
// This is mostly psuedo code as of now
	public boolean selectTile(){
		if(level.getSelected() == null){
			return false;
		}
		if (leftClick.getX() == board.getX()) && ()
			//turn tile on & if release 
			if(level.getLevelType() == "Release"){
				//do increment number on tile
			}
		
		level.get();
		if (rightClick.getX() == board.getX())
			//increment color of number 
		
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


