package kabasuji.controllers;

import java.awt.Polygon;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.Piece;
import kabasuji.entities.PlayedPiece;
import kabasuji.supers.Model;
import kabasuji.views.BoardView;


public class PlacePieceController  extends MouseAdapter{
	Model model;
	BoardView view;
	
	PlacePieceController(Model model, BoardView view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		
	}
	@Override
	public void mouseMoved(MouseEvent me){
		Piece selected = model.getSelected();
		if (selected == null) { return; }

		//Polygon p = computeActivePolygon(me.getPoint(), model.getSelected());
		//PlacedPiece pp = new PlacedPiece(model.getSelected(), p);
		//model.setActive(pp);
		//puzzleView.repaint();
	}
	@Override
	public void mouseEntered(MouseEvent me){
		
	}
}
