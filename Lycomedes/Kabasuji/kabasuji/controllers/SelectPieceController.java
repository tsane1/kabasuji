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
 * Controller for selecting a piece in the bullpen
 * @author Derek McMaster
 *
 */
public class SelectPieceController extends MouseAdapter{
	/** Level instance where the bullpen is. */
	Level currLevel;
	/** Bullpen view drawing the pieces. */
	BullpenView bullpenView;
	/** application being run. */
	Application app;
	
	/**
	 * Constructor for the controller.
	 * @param app
	 * @param model
	 */
	public SelectPieceController(Application app, SuperModel model){
		this.currLevel = model.getActiveLevel();
		this.bullpenView = app.getCurrScreen().getBullpenView();
		this.app = app;
	}
	
	/**
	 * Testing constructor
	 * @param l
	 * @param bp
	 */
	public SelectPieceController(Level l, BullpenView bp) {
		this.currLevel = l;
		this.bullpenView = bp;
	}
	
	/**
	 * Method for handling a press in the bullpen.
	 */
	public void mousePressed(MouseEvent me) {
		int idx = 0;
		for(Piece p : bullpenView.getPiecesInBullpen())
		{
			if(p.contains(me.getX(), idx))
			{
				if (currLevel.getSelected() == currLevel.getBullpen().getPieces().get(idx)) {
					currLevel.setSelected(null); // deselect
				}
				else {
					Piece temp = currLevel.getBullpen().getPieces().get(idx);
					currLevel.setSelected(temp);
					System.out.println("Selected Piece: " + temp.getPieceName());
				}
				bullpenView.refresh();
				if(app.getCurrScreen().getName().contains("Edit")) app.getCurrScreen().getPaletteView().refresh();
				app.getCurrScreen().refresh();
				return;
			}
			idx++;
		}
	}	
	
}

