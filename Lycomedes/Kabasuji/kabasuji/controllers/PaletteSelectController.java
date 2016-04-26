package kabasuji.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.Piece;
import kabasuji.supers.Level;
import kabasuji.views.PaletteView;

public class PaletteSelectController extends MouseAdapter{

	Level currLevel;
	PaletteView pview;
	
	public PaletteSelectController(Level l, PaletteView view){
		this.currLevel = l;
		this.pview = view;
	}
	
	public void mousePressed(MouseEvent me) {
		int idx = 0;
		for(Piece p : pview.getPiecesInPalette())
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
				pview.refresh();
				return;
			}
			idx++;
		}
	}
	
}
