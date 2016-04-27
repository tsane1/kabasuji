package kabasuji.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.Piece;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.views.PaletteView;

public class PaletteSelectController extends MouseAdapter{

	Level currLevel;
	PaletteView pview;
	
	public PaletteSelectController(Application app, SuperModel model){
		this.currLevel = model.getActiveLevel();
		this.pview = app.getCurrScreen().getPaletteView();
	}
	
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
