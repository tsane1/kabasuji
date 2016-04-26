package kabasuji.controllers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.*;
import kabasuji.moves.BullpenToBoardMove;
import kabasuji.supers.*;
import kabasuji.views.BoardView;


public class PlacePieceController  extends MouseAdapter{
	SuperModel model;
	BoardView view;
	Level lvl;
	PieceDrawer drawer = new PieceDrawer();
	Piece draggingPiece;
	int xDragging;
	int yDragging;
	
	public PlacePieceController(SuperModel model, BoardView view) {
		this.model = model;
		this.view = view;
		lvl = model.getActiveLevel();
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		int x = me.getPoint().x;
		int y = me.getPoint().y;
		
		int row = y/32;
		int col = x/32;
//		if(draggingPiece == null){
//			System.err.println("Nothing being dragged");
//			return;
//		}
		
		if(!(lvl.getBoard().place(row, col, draggingPiece))){
			System.out.print("piece not able to be placed");
			lvl.setActivePiece(null);
			lvl.setSelected(null);
			draggingPiece = null;
			view.refresh();
			return;
		}
		System.out.println("placed");
		BullpenToBoardMove move = new BullpenToBoardMove(model, row, col);
		
		lvl.addMoveToUndo(move);
		lvl.setActivePiece(null);
		lvl.setSelected(null);
		draggingPiece = null;
		
		view.refresh();
	}
	@Override
	public void mouseMoved(MouseEvent me){
		//need getSelected()
		Piece selected = lvl.getSelected();
//		if (selected == null) { System.err.println("null selected"); return; }

		int x = me.getPoint().x;
		int y = me.getPoint().y;
		
		xDragging = x;
		yDragging = y;
		lvl.setActivePiece(selected);
		draggingPiece = selected;
		//sets activePiece point and color
		view.drawActivePiece(x, y, lvl.getPieceColor(selected));
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
		//draggingPiece = lvl.getActivePiece();
//		if(draggingPiece == null){
//			System.out.println("Not Dragging Anything");
//			return;
//		}
		int diffX = me.getPoint().x;
		int diffY = me.getPoint().y;
		
		view.drawActivePiece(diffX, diffY, lvl.getPieceColor(draggingPiece));//fix color stuff later
		view.refresh();
		
	}
}
