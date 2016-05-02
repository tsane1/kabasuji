package kabasuji.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.Piece;
import kabasuji.moves.PaletteToBullpenMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;
import kabasuji.views.BullpenView;

/**
 * Controller for adding pieces from the palette to bullpen.
 * @author Derek McMaster
 *
 */
public class AddToBullpenController extends MouseAdapter {
	/** Level instance being created. */
	Level currLevel;
	/** Bullpenview being updated. */
	BullpenView bullpenView;
	/** Application being run. */
	Application app;
	
	/**
	 * Constructor for adding a piece to the bullpen.
	 * @param app
	 * @param model
	 */
	public AddToBullpenController(Application app, SuperModel model){
		this.currLevel = model.getActiveLevel();
		this.bullpenView = app.getCurrScreen().getBullpenView();
		this.app = app;
	}
	
	/**
	 * Testing constructor
	 * @param Level l
	 * @param Bullpenview bp
	 */
	public AddToBullpenController(Level l, BullpenView bp) {
		this.currLevel = l;
		this.bullpenView = bp;
	}
	
	/**
	 * Handles the click on the bullpen.
	 */
	@Override
	public void mouseClicked(MouseEvent me){
		if(currLevel.getSelected() == null) { return; }

		if(me.getClickCount() == 2){
			System.out.println("Made it...You double clicked");
			Move m = new PaletteToBullpenMove(currLevel, currLevel.getSelected());
			if(m.execute()) currLevel.trackMove(m);
		}

		bullpenView.refresh();
		app.getCurrScreen().getPaletteView().refresh();
		if(app.getCurrScreen().getName().contains("Edit")) app.getCurrScreen().getPaletteView().refresh();
		app.getCurrScreen().refresh();
		if(currLevel.getBullpen().isEmpty()){
			System.out.println("Bullpen empty");
		}
		else {
			for(Piece p: currLevel.getBullpen().getPieces()){
				System.out.println("Size of Bullpen:" + currLevel.getBullpen().numPiecesInBullpen());
			}
		}
	}
}
