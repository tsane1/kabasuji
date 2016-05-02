package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.moves.RotateLeftMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;

/**
 * A controller to Pieces 90 degrees to the left.
 * @author Ian Jacoway
 */

public class RotateLeftController implements ActionListener {
	/** Level where moves are executed. */
	Level level;
	/** Application being run. */
	Application app;
	
	/**
	 * Controller for rotate left controller.
	 * @param App a
	 * @param Level l
	 */
	public RotateLeftController(Application a, Level l) {
		this.app = a;
		this.level = l;
	}
	
	/**
	 * Method for handling the rotation of the piece.
	 * @return boolean
	 */
	public boolean doRotateLeft(){
		boolean status = false;
		Move m = new RotateLeftMove(level);
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
	 * Method for handling an action when request to rotate left.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			doRotateLeft();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : RotateLeftController");
			ex.printStackTrace();
		}
	}
}
