package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.moves.FlipXMove;
import kabasuji.moves.RotateRightMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;

/**
 * A controller to Flip Pieces across the X axis.
 * @author Ian Jacoway
 */

public class FlipXController implements ActionListener {
	/** Application being run. */
	Application app;
	/** Level containing the pieces. */
	Level level;
		
	/**
	 * Constructor for the flip x controller.
	 * @param App a
	 * @param Level l
	 */
	public FlipXController(Application a, Level l) {
		this.app= a;
		this.level = l;
	}
	
	/**
	 * Handles the flipping of the piece.
	 * @return boolean
	 */
	public boolean doFlipX(){
		boolean status = false;
		Move m = new FlipXMove(level);
		if(m.execute()){
			if(!app.getCurrScreen().getName().equals("LevelPlay")) {
				level.trackMove(m);
			}
			
			status = true;
		}

		app.getCurrScreen().getBullpenView().refresh();
		app.getCurrScreen().refresh();
		return status;
	}

	/**
	 * Handles the request for flipping a piece.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			doFlipX();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : FlipXController");
			ex.printStackTrace();
		}
	}
}

