package kabasuji.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.Piece;
import kabasuji.supers.SuperModel;
import kabasuji.views.BullpenView;


public class SelectPieceController extends MouseAdapter{
	
	SuperModel model;
	BullpenView view;
	
	public SelectPieceController(SuperModel model, BullpenView view){
		this.model = model;
		this.view = view;
	}
	
	public void mousePressed(MouseEvent me) {
		int idx = 0;
		for(Piece p : view.getPiecesInBullpen())
		{
			int xpos = me.getX();
			int pieceIndex = xpos%(view.containerSize+view.pieceBuffer);
			//if(model.)
		}
	}
	
	
	
}

