package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.moves.RotateRightMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;

/**
 * A controller to rotate Pieces 90 degrees to the right.
 * @author Ian Jacoway
 */

public class RotateRightController implements ActionListener {
	/** Level where moves are executed. */
	Level level;
	/** Application being run. */
	Application app;
	
	/**
	 * Constructor for rotating right controller.
	 * @param App a
	 * @param Level l
	 */
	public RotateRightController(Application a, Level l) {
		this.app = a;
		this.level = l;
	}
	
	/**
	 * Method for handling the rotation of the piece.
	 * @return boolean
	 */
	public boolean doRotateRight(){
		boolean status = false;
		Move m = new RotateRightMove(level);
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
	 * Method for handling an action when request to rotate right.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			doRotateRight();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : RotateRightController");
			ex.printStackTrace();
		}
	}
}


