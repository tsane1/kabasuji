package kabasuji.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.Piece;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.views.BullpenView;


public class SelectPieceController extends MouseAdapter{
	
	Level currLevel;
	BullpenView view;
	
	public SelectPieceController(Level l, BullpenView view){
		this.currLevel = l;
		this.view = view;
	}
	
	public void mousePressed(MouseEvent me) {
		int idx = 0;
		for(Piece p : view.getPiecesInBullpen())
		{
			int xpos = me.getX();
			int pieceIndex = xpos%(view.containerSize+view.pieceBuffer);
			
			Piece temp = currLevel.getBullpen().getPieces().get(idx);
		}
	}
	
	
	
}

