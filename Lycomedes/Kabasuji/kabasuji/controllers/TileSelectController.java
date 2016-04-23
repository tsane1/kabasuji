package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.w3c.dom.events.MouseEvent;

import kabasuji.entities.Board;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

/**
 * A controller to select tiles as active on a Board.
 * @author Ian Jacoway
 */

public class TileSelectController extends Board{
	Application app;
	Level level;
	
	public TileSelectController(Application a, Level l){
		this.level = l;
		this.app = a;
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
		if (rightClick.getX() == board.getX()){
			//increment color of number 
		}
		
		app.getCurrScreen().getBoardView().refresh();
		
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


