package kabasuji.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.Piece;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.views.PaletteView;

/**
 * Controller for selecting pieces in the palette.
 * @author Derek McMaster
 *
 */
public class PaletteSelectController extends MouseAdapter{

	/** level instance for palette.*/
	Level currLevel;
	/** view associated with the palette. */
	PaletteView pview;
	
	/**
	 * Constructor for palette select.
	 * @param app
	 * @param model
	 */
	public PaletteSelectController(Application app, SuperModel model){
		this.currLevel = model.getActiveLevel();
		this.pview = app.getCurrScreen().getPaletteView();
	}
	
	/**
	 * Testing constructor for palette select.
	 * @param SuperModel sm
	 * @param Paletteview pv
	 */
	public PaletteSelectController(SuperModel sm, PaletteView pv) {
		this.currLevel = sm.getActiveLevel();
		this.pview = pv;
	}
	
	/**
	 * Handles the mouse press in the palette view and selects piece.
	 */
	public void mousePressed(MouseEvent me) {
		int idx = 0;
		for(Piece p : pview.getPiecesInPalette())
		{
			if(p.containsy(me.getY(), idx))
			{
				if (currLevel.getSelected() == currLevel.getPalette().getPieces().get(idx)) {
					currLevel.setSelected(null); // deselect
				}
				else {
					Piece temp = currLevel.getPalette().getPieces().get(idx);
					currLevel.setSelected(temp);
					System.out.println("Selected Piece: " + temp.getPieceName());
				}
				pview.refresh();
				return;
			}
			idx++;
		}
	}
	
}
