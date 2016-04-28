package kabasuji.controllers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import kabasuji.entities.*;
import kabasuji.moves.BullpenToBoardMove;
import kabasuji.supers.*;
import kabasuji.views.BoardView;


public class PlacePieceController  extends MouseAdapter{
	SuperModel model;
	Application app;
	BoardView view;
	Level lvl;
	PieceDrawer drawer = new PieceDrawer();
	Piece draggingPiece;
	int xDragging;
	int yDragging;
	
	public PlacePieceController(Application app, SuperModel model) {
		this.model = model;
		this.app = app;
		this.view = app.getCurrScreen().getBoardView();
		this.lvl = model.getActiveLevel();
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		int x = me.getPoint().x;
		int y = me.getPoint().y;
		
		int row = y/32;
		int col = x/32;

		if(draggingPiece == null){
			System.err.println("Nothing being dragged");
			PuzzleBoardTile pTile = new PuzzleBoardTile(0, 0);
			if(lvl.getBoard().getBoardArray()[col][row].isCovered() && (lvl.getBoard().getBoardArray()[col][row].getClass() == pTile.getClass())){
				
				Piece onBoard = ((PuzzleBoardTile) lvl.getBoard().getBoardArray()[col][row]).getCoveringPiece();
				int idx = ((PuzzleBoardTile) lvl.getBoard().getBoardArray()[col][row]).getPieceTileIdx();
				
				//does reverse of the board's adjust method for covering area on the board to get the starting tiles position
				int rowAdjust = onBoard.getTileLocations()[0].getRow();
				int colAdjust = onBoard.getTileLocations()[0].getColumn();
				int rowCord = row;
				int colCord = col;
				int rowStart = rowCord -(onBoard.getTileLocations()[idx].getRow() - rowAdjust);
				int colStart = colCord - (onBoard.getTileLocations()[idx].getColumn() - colAdjust);
				
				Point pt = new Point(colStart,rowStart);
				HashMap<Point,Piece> map = lvl.getBoard().getPlacedPieces();
				//remove that piece from the place pieces map so it doesnt draw
				map.remove(pt);
				//return to bullpen
				lvl.getBullpen().addPieceBackToBullpen(onBoard);
				//uncovers the area that piece was on
				lvl.getBoard().uncoverPieceArea(rowStart, colStart, onBoard);
				//sets this piece to selected
				lvl.setSelected(onBoard);
				view.refresh();
			}
			
			return;
		}
		
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
		move.execute();
		lvl.addMoveToUndo(move);
		lvl.setActivePiece(null);
		lvl.setSelected(null);
		draggingPiece = null;
		
		view.refresh();
		if(app.getCurrScreen().getName().equals("LevelPlay") && model.getActiveLevel().getLevelType().equals("Puzzle")) {
			int prev = ((PuzzleLevel)model.getActiveLevel()).getMovesLeft();
			((PuzzleLevel)model.getActiveLevel()).setMovesLeft(prev - 1);
			app.getCurrScreen().refresh();
		}
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
