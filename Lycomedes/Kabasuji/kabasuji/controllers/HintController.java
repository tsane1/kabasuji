package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;

/**
 * Controller for setting hints in a level/
 * @author Derek McMaster
 */
public class HintController implements ActionListener{
	/** Application being run. */
	Application app;
	/** Model being updated. */
	SuperModel sm;
	
	/**
	 * Constructor for the hint controller
	 * @param App a
	 * @param SuperModel sm
	 */
	public HintController(Application a, SuperModel sm) {
		this.app = a;
		this.sm = sm;
	}
	
	/**
	 * Handles requesting to see the hint.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			showHint();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : HintController");
			ex.printStackTrace();
		}
		app.getCurrScreen().getBoardView().refresh();
	}

	/**
	 * Passes the hint request to the boardview for painting. 
	 */
	private void showHint() {
		app.getCurrScreen().getBoardView().showHint();
	}

}
