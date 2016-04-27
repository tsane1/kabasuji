package kabasuji.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.Piece;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.views.BullpenView;


public class SelectPieceController extends MouseAdapter{
	
	Level currLevel;
	BullpenView bullpenView;
	
	public SelectPieceController(Level l, BullpenView view){
		this.currLevel = l;
		this.bullpenView = view;
	}
	
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
					if(currLevel.getBullpen().getPlayedPieces().contains(temp)){
						currLevel.setSelected(null);
						System.out.println("Selected Piece: " + temp.getPieceName());
						return;
					}
					currLevel.setSelected(temp);
					System.out.println("Selected Piece: " + temp.getPieceName());
				}
				
				bullpenView.refresh();
				return;
			}
			idx++;
		}
	}
	
	
	
}

