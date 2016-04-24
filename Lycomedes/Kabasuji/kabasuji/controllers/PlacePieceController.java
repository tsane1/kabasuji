package kabasuji.controllers;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.*;
import kabasuji.moves.newmovetemp;
import kabasuji.supers.*;
import kabasuji.views.BoardView;


public class PlacePieceController  extends MouseAdapter{
	Level model;
	BoardView view;
	PieceDrawer drawer = new PieceDrawer();
	int xDragging;
	int yDragging;
	
	PlacePieceController(Level model, BoardView view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		
	}
	@Override
	public void mouseMoved(MouseEvent me){
		//need getSelected()
		Piece selected = model.getSelected();
		if (selected == null) { return; }

		int x = me.getPoint().x;
		int y = me.getPoint().y;
		Graphics g = view.getGraphics();
		drawer.drawPiece(g, selected, x, y);
		xDragging = x;
		yDragging = y;
		model.setActivePiece(selected);
		view.repaint();
		//Polygon p = computeActivePolygon(me.getPoint(), model.getSelected());
		//PlacedPiece pp = new PlacedPiece(model.getSelected(), p);
		//model.setActive(pp);
		//puzzleView.repaint();
	}
	@Override
	public void mouseEntered(MouseEvent me){
		
	}
	@Override
	public void mouseDragged(MouseEvent me){
		Piece draggingPiece = model.getActivePiece();
		if(draggingPiece == null){
			System.out.println("Not Dragging Anything");
			return;
		}
		
		int diffX = me.getPoint().x - xDragging;
		int diffY = me.getPoint().y - yDragging;
		xDragging = me.getPoint().x;
		yDragging = me.getPoint().y;
		//hit CODE WALL need to figure out how to destroy after images without polygon or use polygon
		//drawer.
		
	}
}
