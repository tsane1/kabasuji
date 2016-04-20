package kabasuji.supers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import kabasuji.entities.LightningLevel;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.PuzzleLevel;

/** 
 * Model class containing all necessary game entities.
 * 
 * <p>
 * This class contains entities related to the player and the builder.
 * Entities that contain entities ({@code Level} contains {@code Board}, etc.) are not double-included.
 * This class also handles undo and redo events during builder use. This functionality
 * is disqualified in player by forcing a typecheck on the current view.
 * </p>
 * 
 * @author Tanuj Sane
 * @since 4/19/2016
 *
 */

public class SuperModel {
	private HashMap<String, Level> defaultLevels = new HashMap<String, Level>(15);
	private HashMap<String, Level> userLevels = new HashMap<String, Level>();
	private HashMap<Integer, Piece> allPieces = new HashMap<Integer, Piece>(35);
	ArrayList<PieceTile> pieceGrid = new ArrayList<PieceTile>(36);
	Stack<Move> undoStack = new Stack<Move>();
	Stack<Move> redoStack = new Stack<Move>();
	

	public SuperModel() {
		setupDefaultLevels();
		for(int i = 0; i < 36; i++) {
			pieceGrid.add(new PieceTile(i/6, i%6));
		}
		setupPieces();
	}

	public void setupPieces(){
		/**
		 * The 35 possible hexominoes
		 */
		Piece p1, p2, p3, p4, p5, p6, p7, 
		p8, p9, p10, p11, p12, p13, p14,
		p15, p16, p17, p18, p19, p20, p21, 
		p22, p23, p24, p25, p26, p27, p28, 
		p29, p30, p31, p32, p33, p34, p35;
		/**
		 * The 36 possible grid locations for a piece in 6x6 array
		 */
		PieceTile pt1,pt2, pt3, pt7,pt8, pt9, pt13, pt14, pt15, pt19, pt20,	pt25, pt31;

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
		pt7 = new PieceTile(1,0);
		pt8 = new PieceTile(1,1);
		pt9 = new PieceTile(1,2);
		pt13 = new PieceTile(2,0);
		pt14 = new PieceTile(2,1);
		pt15 = new PieceTile(2,2);
		pt19 = new PieceTile(3,0);
		pt20 = new PieceTile(3,1);
		pt25 = new PieceTile(4,0);
		pt31 = new PieceTile(5,0);


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
		allPieces.put(p1.getPieceID(), p1);
		allPieces.put(p2.getPieceID(), p2);
		allPieces.put(p3.getPieceID(), p3);
		allPieces.put(p4.getPieceID(), p4);
		allPieces.put(p5.getPieceID(), p5);
		allPieces.put(p6.getPieceID(), p6);
		allPieces.put(p7.getPieceID(), p7);
		allPieces.put(p8.getPieceID(), p8);
		allPieces.put(p9.getPieceID(), p9);
		allPieces.put(p10.getPieceID(), p10);
		allPieces.put(p11.getPieceID(), p11);
		allPieces.put(p12.getPieceID(), p12);
		allPieces.put(p13.getPieceID(), p13);
		allPieces.put(p14.getPieceID(), p14);
		allPieces.put(p15.getPieceID(), p15);
		allPieces.put(p16.getPieceID(), p16);
		allPieces.put(p17.getPieceID(), p17);
		allPieces.put(p18.getPieceID(), p18);
		allPieces.put(p19.getPieceID(), p19);
		allPieces.put(p20.getPieceID(), p20);
		allPieces.put(p21.getPieceID(), p21);
		allPieces.put(p22.getPieceID(), p22);
		allPieces.put(p23.getPieceID(), p23);
		allPieces.put(p24.getPieceID(), p24);
		allPieces.put(p25.getPieceID(), p25);
		allPieces.put(p26.getPieceID(), p26);
		allPieces.put(p27.getPieceID(), p27);
		allPieces.put(p28.getPieceID(), p28);
		allPieces.put(p29.getPieceID(), p29);
		allPieces.put(p30.getPieceID(), p30);
		allPieces.put(p31.getPieceID(), p31);
		allPieces.put(p32.getPieceID(), p32);
		allPieces.put(p33.getPieceID(), p33);
		allPieces.put(p34.getPieceID(), p34);
		allPieces.put(p35.getPieceID(), p35);	
	}

	public void setupDefaultLevels() {
		for(int i = 0; i < 15; i++) {
			String filename = "Level " + (i+1);// + ".lev";
			//defaultLevels.put(filename, loadLevel(filename));
			defaultLevels.put(filename, new LightningLevel(filename));
		}
	}
	
	public Level getLevel(String name) {
		if(name == null) return null;
		if(defaultLevels.containsKey(name)) return defaultLevels.get(name);
		else if(userLevels.containsKey(name)) return userLevels.get(name);
		else return null;
	}
	
	public int totalLevels() {
		return defaultLevels.size() + userLevels.size();
	}
	
	public int numUserLevels() {
		return userLevels.size();
	}

	private Level loadLevel(String filename) {		
		if(!filename.contains(".lev")) return null;
		
		File file = new File(filename);
		Level loadedLevel = null;
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			loadedLevel = (Level)input.readObject();
			input.close();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return loadedLevel;
	}

	public void saveLevel(Level level) {
		File file = new File(level.getLevelName() + ".lev");
		try{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
			output.writeObject(this);
			output.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		userLevels.put(level.getLevelName(), level);
	}
	
	public void trackMove(Move m){
		undoStack.add(m);
		redoStack.clear();
	}

	public Move getLastMove(){
		if(undoStack.isEmpty()) {
			return null;
		}
		return undoStack.pop();
	}

	public void addMoveToUndo(Move m){
		undoStack.push(m);
	}

	public void addRedoableMove(Move m){
		redoStack.push(m);
	}

	public Move getRedoMove(){
		if(redoStack.isEmpty()){
			return null;
		}
		return redoStack.pop();
	}
	
	public static void main(String[] args) {
		SuperModel sm = new SuperModel();
	}
}
