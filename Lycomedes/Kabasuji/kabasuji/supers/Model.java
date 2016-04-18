package kabasuji.supers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import kabasuji.controllers.Move;
import kabasuji.entities.Level;
import kabasuji.entities.LevelBuilderFactory;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.PlayedPiece;

public class Model {

	Stack<Move> undoStack = new Stack<Move>();
	Stack<Move> redoStack = new Stack<Move>();

	Piece selectedPiece = null;

	List<PlayedPiece> playedPieces = new ArrayList<PlayedPiece>();
	PlayedPiece activePiece, draggingPiece;

	public Model() {
		setUpPieces();
	}

	List<Piece> allPieces = new ArrayList<Piece>(35);
	/**
	 * The 35 possible hexominoes
	 */
	Piece p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
	p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
	p21, p22, p23, p24, p25, p26, p27, p28, p29, p30,
	p31, p32, p33, p34, p35;
	/**
	 * The 36 possible grid locations for a piece in 6x6 array
	 */
	PieceTile pt1,pt2, pt3, pt4, pt5, pt6, pt7, pt8, pt9, pt10,
	pt11, pt12, pt13, pt14, pt15, pt16, pt17, pt18, pt19, pt20,
	pt21, pt22, pt23, pt24, pt25, pt26, pt27, pt28, pt29, pt30,
	pt31, pt32, pt33, pt34, pt35, pt36;

	public void setUpPieces(){
		/**
		 * Pieces tiles defined counting horizontally of 6x6 array
		 * Visualization:
		 *   col:  0  1  2  3  4  5
		 *    ---------------------
		 * row:0 | 1  2  3  4  5  6
		 * 	   1 | 7  8  9  10 11 12
		 * 	   2 | 13 14 15 16 17 18
		 * 	   3 | 19 20 21 22 23 24
		 *     4 | 25 26 27 28 29 30
		 *     5 | 31 32 33 34 35 36
		 */
		pt1 = new PieceTile(0,0);
		pt2 = new PieceTile(0,1);
		pt3 = new PieceTile(0,2);
		pt4 = new PieceTile(0,3);
		pt5 = new PieceTile(0,4);
		pt6 = new PieceTile(0,5);
		pt7 = new PieceTile(1,0);
		pt8 = new PieceTile(1,1);
		pt9 = new PieceTile(1,2);
		pt10 = new PieceTile(1,3);
		pt11 = new PieceTile(1,4);
		pt12 = new PieceTile(1,5);
		pt13 = new PieceTile(2,0);
		pt14 = new PieceTile(2,1);
		pt15 = new PieceTile(2,2);
		pt16 = new PieceTile(2,3);
		pt17 = new PieceTile(2,4);
		pt18 = new PieceTile(2,5);
		pt19 = new PieceTile(3,0);
		pt20 = new PieceTile(3,1);
		pt21 = new PieceTile(3,2);
		pt22 = new PieceTile(3,3);
		pt23 = new PieceTile(3,4);
		pt24 = new PieceTile(3,5);
		pt25 = new PieceTile(4,0);
		pt26 = new PieceTile(4,1);
		pt27 = new PieceTile(4,2);
		pt28 = new PieceTile(4,3);
		pt29 = new PieceTile(4,4);
		pt30 = new PieceTile(4,5);
		pt31 = new PieceTile(5,0);
		pt32 = new PieceTile(5,1);
		pt33 = new PieceTile(5,2);
		pt34 = new PieceTile(5,3);
		pt35 = new PieceTile(5,4);
		pt36 = new PieceTile(5,5);

		/**
		 * To know which pieces are which.
		 * Look at the Wikipedia picture of hexominoes,
		 * the pieces are numbered horizontally 1-7, 8-14, 15-21, 22-28,29-35
		 */
		p1 = new Piece(1,new PieceTile[] {pt1, pt7, pt13, pt19, pt25, pt31});
		p2 = new Piece(2,new PieceTile[] {pt1, pt2, pt7, pt13, pt19, pt25});
		p3 = new Piece(3,new PieceTile[] {pt1, pt7, pt8, pt13, pt19, pt25});
		p4 = new Piece(4,new PieceTile[] {pt1, pt7, pt13, pt14, pt19, pt25});
		p5 = new Piece(5,new PieceTile[] {pt2, pt7, pt8, pt13, pt19, pt25});
		p6 = new Piece(6,new PieceTile[] {pt1, pt2, pt7, pt8, pt13, pt19});
		p7 = new Piece(7,new PieceTile[] {pt1, pt2, pt7, pt13, pt14, pt19});
		p8 = new Piece(8,new PieceTile[] {pt1, pt2, pt7, pt13, pt19, pt20});
		p9 = new Piece(9,new PieceTile[] {pt1, pt7, pt8, pt13, pt14, pt19});
		p10 = new Piece(10,new PieceTile[] {pt1, pt2, pt3, pt7, pt13, pt19});
		p11 = new Piece(11,new PieceTile[] {pt1, pt7, pt8, pt9, pt13, pt19});
		p12 = new Piece(12,new PieceTile[] {pt1, pt2, pt3, pt8, pt14, pt20});
		p13 = new Piece(13,new PieceTile[] {pt2, pt3, pt7, pt8, pt14, pt20});
		p14 = new Piece(14,new PieceTile[] {pt2, pt3, pt8, pt13, pt14, pt20});
		p15 = new Piece(15,new PieceTile[] {pt2, pt3, pt8, pt14, pt19, pt20});
		p16 = new Piece(16,new PieceTile[] {pt2, pt8, pt9, pt13, pt14, pt20});
		p17 = new Piece(17,new PieceTile[] {pt2, pt7, pt8, pt9, pt14, pt20});
		p18 = new Piece(18,new PieceTile[] {pt2, pt7, pt8, pt9, pt13, pt19});
		p19 = new Piece(19,new PieceTile[] {pt2, pt7, pt8, pt13, pt19, pt20});
		p20 = new Piece(20,new PieceTile[] {pt2, pt8, pt13, pt14, pt19, pt25});
		p21 = new Piece(21,new PieceTile[] {pt2, pt7, pt8, pt13, pt14, pt19});
		p22 = new Piece(22,new PieceTile[] {pt1, pt2, pt7, pt8, pt13, pt14});
		p23 = new Piece(23,new PieceTile[] {pt3, pt7, pt8, pt9, pt14, pt20});
		p24 = new Piece(24,new PieceTile[] {pt1, pt2, pt3, pt8, pt9, pt14});
		p25 = new Piece(25,new PieceTile[] {pt3, pt8, pt9, pt13, pt14, pt20});
		p26 = new Piece(26,new PieceTile[] {pt3, pt7, pt8, pt9, pt13, pt19});
		p27 = new Piece(27,new PieceTile[] {pt2, pt3, pt7, pt8, pt13, pt19});
		p28 = new Piece(28,new PieceTile[] {pt1, pt2, pt3, pt7, pt9, pt13});
		p29 = new Piece(29,new PieceTile[] {pt1, pt3, pt7, pt8, pt9, pt13});
		p30 = new Piece(30,new PieceTile[] {pt1, pt3, pt7, pt8, pt9, pt14});
		p31 = new Piece(31,new PieceTile[] {pt2, pt3, pt8, pt13, pt14, pt19});
		p32 = new Piece(32,new PieceTile[] {pt1, pt7, pt8, pt13, pt14, pt15});
		p33 = new Piece(33,new PieceTile[] {pt2, pt7, pt8, pt9, pt13, pt14});
		p34 = new Piece(34,new PieceTile[] {pt3, pt7, pt8, pt9, pt13, pt14});
		p35 = new Piece(35,new PieceTile[] {pt3, pt8, pt9, pt13, pt14, pt19});

		/*
		 * add them to the array list
		 */
		allPieces.add(p1);
		allPieces.add(p2);
		allPieces.add(p3);
		allPieces.add(p4);
		allPieces.add(p5);
		allPieces.add(p6);
		allPieces.add(p7);
		allPieces.add(p8);
		allPieces.add(p9);
		allPieces.add(p10);
		allPieces.add(p11);
		allPieces.add(p12);
		allPieces.add(p13);
		allPieces.add(p14);
		allPieces.add(p15);
		allPieces.add(p16);
		allPieces.add(p17);
		allPieces.add(p18);
		allPieces.add(p19);
		allPieces.add(p20);
		allPieces.add(p21);
		allPieces.add(p22);
		allPieces.add(p23);
		allPieces.add(p24);
		allPieces.add(p25);
		allPieces.add(p26);
		allPieces.add(p27);
		allPieces.add(p28);
		allPieces.add(p29);
		allPieces.add(p30);
		allPieces.add(p31);
		allPieces.add(p32);
		allPieces.add(p33);
		allPieces.add(p34);
		allPieces.add(p35);	
	}

	public void trackMoves(Move m){
		undoStack.add(m);
		redoStack.clear();
	}

	/*
	 * get/set undo moves
	 */
	public Move getLastMove(){
		if(undoStack.isEmpty()) {
			return null;
		}
		return undoStack.pop();
	}

	public void addMoveToUndo(Move m){
		undoStack.push(m);
	}

	/*
	 * get/set redo moves
	 */
	public void addRedoableMove(Move m){
		redoStack.push(m);
	}

	public Move getredoMove(){
		if(redoStack.isEmpty()){
			return null;
		}
		return redoStack.pop();
	}

	public Piece getSelected() {
		return selectedPiece;
	}

	public void setSelectedPiece(Piece p) {
		this.selectedPiece = p;
	}

	public List<Piece> getAllPieces(){
		return allPieces;
	}

	public List<PlayedPiece> getPlayedPieces(){
		return playedPieces;
	}

	public void setActivePiece(PlayedPiece p) {
		activePiece = p;
	}

	public PlayedPiece getActivePiece(){
		return activePiece;
	}

	public PlayedPiece getDraggingPiece() {
		return activePiece;
	}


	public void setDraggingPiece(PlayedPiece p) {
		activePiece = p;
	}


	public void addPiece(PlayedPiece p) {
		playedPieces.add(p);
	}


}
