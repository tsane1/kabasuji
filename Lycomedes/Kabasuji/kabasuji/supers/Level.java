package kabasuji.supers;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import kabasuji.entities.Board;
import kabasuji.entities.Bullpen;
import kabasuji.entities.Palette;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.Progress;

/**
 * Level superclass containing all elements common to the different level types.
 * 
 * @author Tanuj Sane
 * @author Derek McMaster
 * @author Chase St. Laurent
 */
public abstract class Level implements Serializable {
	/**
	 * Eclipse said so.
	 */
	private static final long serialVersionUID = 1L;

	/** List of all 35 possible hexominoes. */
	List<Piece> allPieces = new ArrayList<Piece>(35);
	/** Grid of all possible piecetiles that make up pieces. */
	List<PieceTile> pieceGrid = new ArrayList<PieceTile>(36);
	/** A map of piece colors used for drawing the pieces. */
	Map<Piece, Color> colorMap = new HashMap<Piece, Color>(35);

	/** Stack keeping track of the moves done for undoing. */
	Stack<Move> undoStack = new Stack<Move>();
	/** stack for redoable moves when moves are undone. */
	Stack<Move> redoStack = new Stack<Move>();

	/**
	 * The name of the level and the type of the level. Type includes puzzle,
	 * lightning, or release.
	 */
	String name, type;
	
	/**
	 * Boolean variable indicating whether or not the level is locked or
	 * unlocked to the player.
	 */
	boolean locked;
	/** The board associated with the current level. */
	Board theBoard;
	/** The bullpen associated with the current level. */
	Bullpen theBullpen;
	/** Palette for building */
	Palette thePalette;
	
	/**
	 * The number of "stars" or achievements the player has accrued for the
	 * level. Can be (min of) 0, 1, 2, or (max of) 3.
	 */
	int numStars;

	/**
	 * Arraylist of pieces previously in the bullpen and now played on the
	 * board.
	 */
	ArrayList<Piece> piecesOnBoard = new ArrayList<Piece>();
	/** Arraylist of pieces left in the bullpen. */
	ArrayList<Piece> piecesInBullpen = new ArrayList<Piece>();

	/** Keeps track of the current selected piece. */
	Piece selectedPiece = null;
	/** Keeps track of a piece that has been selected but is not yet played. */
	Piece activePiece;
	/** Keeps track of a played piece that is being moved/repositioned. */
	Piece draggingPiece;

	/**
	 * Constructor for creating a new level. Achievement set to new, Board is
	 * 12x12 unplayable tiles, and bullpen contains all 35.
	 * 
	 * @param String
	 *            name
	 * @param String
	 *            type
	 */
	public Level(String name, String type) {
		this.name = name;
		this.type = type;
		locked = false;
		this.theBoard = new Board();
		this.theBullpen = new Bullpen();
		this.thePalette = new Palette();
		this.numStars = 0;
		setupPieces();
		//theBullpen.addPieces(allPieces);
		thePalette.addPieces(allPieces);
		for (int i = 0; i < 36; i++) {
			pieceGrid.add(new PieceTile(i / 6, i % 6));
		}
	}

	/**
	 * Constructor for loading a level.
	 * 
	 * @param String
	 *            name
	 * @param String
	 *            type
	 * @param Board
	 *            b
	 * @param Bullpen
	 *            bp
	 * @param int
	 *            numStars
	 */
	public Level(String name, String type, Board b, Bullpen bp, int numStars) {
		this.name = name;
		this.type = type;
		this.theBoard = b;
		this.theBullpen = bp;
		this.numStars = numStars;
	}

	/**
	 * Generic constructor for testing purposes.
	 */
	public Level() {
		this("level", "test");
	}

	/**
	 * initializing method for setting up pieces.
	 */
	public void setupPieces() {
		/**
		 * The 35 possible hexominoes
		 */
		Piece p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23,
				p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35;
		/**
		 * The 36 possible grid locations for a piece in 6x6 array
		 */
		PieceTile pt1, pt2, pt3, pt7, pt8, pt9, pt13, pt14, pt15, pt19, pt20, pt25, pt31;

		/**
		 * Pieces tiles defined counting horizontally of 6x6 array
		 * Visualization: col: 0 1 2 3 4 5 --------------------- row:0 | 1 2 3 4
		 * 5 6 1 | 7 8 9 10 11 12 2 | 13 14 15 16 17 18 3 | 19 20 21 22 23 24 4
		 * | 25 26 27 28 29 30 5 | 31 32 33 34 35 36
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
		 * Populate pieceGrid with all possible piece tiles
		 */
		for(int i = 0; i < 36; i++) {
			pieceGrid.add(new PieceTile(i/6, i%6));
		}

		/**
		 * To know which pieces are which. Look at the Wikipedia picture of
		 * hexominoes, the pieces are numbered horizontally 1-7, 8-14, 15-21,
		 * 22-28,29-35
		 */
		p1 = new Piece(1, new PieceTile[] { pt1, pt7, pt13, pt19, pt25, pt31 });
		p2 = new Piece(2, new PieceTile[] { pt1, pt2, pt7, pt13, pt19, pt25 });
		p3 = new Piece(3, new PieceTile[] { pt1, pt7, pt8, pt13, pt19, pt25 });
		p4 = new Piece(4, new PieceTile[] { pt1, pt7, pt13, pt14, pt19, pt25 });
		p5 = new Piece(5, new PieceTile[] { pt2, pt7, pt8, pt13, pt19, pt25 });
		p6 = new Piece(6, new PieceTile[] { pt1, pt2, pt7, pt8, pt13, pt19 });
		p7 = new Piece(7, new PieceTile[] { pt1, pt2, pt7, pt13, pt14, pt19 });
		p8 = new Piece(8, new PieceTile[] { pt1, pt2, pt7, pt13, pt19, pt20 });
		p9 = new Piece(9, new PieceTile[] { pt1, pt7, pt8, pt13, pt14, pt19 });
		p10 = new Piece(10, new PieceTile[] { pt1, pt2, pt3, pt7, pt13, pt19 });
		p11 = new Piece(11, new PieceTile[] { pt1, pt7, pt8, pt9, pt13, pt19 });
		p12 = new Piece(12, new PieceTile[] { pt1, pt2, pt3, pt8, pt14, pt20 });
		p13 = new Piece(13, new PieceTile[] { pt2, pt3, pt7, pt8, pt14, pt20 });
		p14 = new Piece(14, new PieceTile[] { pt2, pt3, pt8, pt13, pt14, pt20 });
		p15 = new Piece(15, new PieceTile[] { pt2, pt3, pt8, pt14, pt19, pt20 });
		p16 = new Piece(16, new PieceTile[] { pt2, pt8, pt9, pt13, pt14, pt20 });
		p17 = new Piece(17, new PieceTile[] { pt2, pt7, pt8, pt9, pt14, pt20 });
		p18 = new Piece(18, new PieceTile[] { pt2, pt7, pt8, pt9, pt13, pt19 });
		p19 = new Piece(19, new PieceTile[] { pt2, pt7, pt8, pt13, pt19, pt20 });
		p20 = new Piece(20, new PieceTile[] { pt2, pt8, pt13, pt14, pt19, pt25 });
		p21 = new Piece(21, new PieceTile[] { pt2, pt7, pt8, pt13, pt14, pt19 });
		p22 = new Piece(22, new PieceTile[] { pt1, pt2, pt7, pt8, pt13, pt14 });
		p23 = new Piece(23, new PieceTile[] { pt3, pt7, pt8, pt9, pt14, pt20 });
		p24 = new Piece(24, new PieceTile[] { pt1, pt2, pt3, pt8, pt9, pt14 });
		p25 = new Piece(25, new PieceTile[] { pt3, pt8, pt9, pt13, pt14, pt20 });
		p26 = new Piece(26, new PieceTile[] { pt3, pt7, pt8, pt9, pt13, pt19 });
		p27 = new Piece(27, new PieceTile[] { pt2, pt3, pt7, pt8, pt13, pt19 });
		p28 = new Piece(28, new PieceTile[] { pt1, pt2, pt3, pt7, pt9, pt13 });
		p29 = new Piece(29, new PieceTile[] { pt1, pt3, pt7, pt8, pt9, pt13 });
		p30 = new Piece(30, new PieceTile[] { pt1, pt3, pt7, pt8, pt9, pt14 });
		p31 = new Piece(31, new PieceTile[] { pt2, pt3, pt8, pt13, pt14, pt19 });
		p32 = new Piece(32, new PieceTile[] { pt1, pt7, pt8, pt13, pt14, pt15 });
		p33 = new Piece(33, new PieceTile[] { pt2, pt7, pt8, pt9, pt13, pt14 });
		p34 = new Piece(34, new PieceTile[] { pt3, pt7, pt8, pt9, pt13, pt14 });
		p35 = new Piece(35, new PieceTile[] { pt3, pt8, pt9, pt13, pt14, pt19 });

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
		
		/** Random color generator for pieces */
		Random r = new Random();
		for(Piece p: allPieces){
			Color random = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
			colorMap.put(p, random);
		}
	}
	
	/**
	 * Achievement
	 */
	
	public void updateAchievement(Progress progress) {
		int achievedStars = 0;
		
		if ((progress.updateProgressPuzzle() == 100) 
				|| progress.updateProgressLightning() == 100
				|| progress.updateProgressRelease() == 100) {
			achievedStars = 3;
		}else if ((progress.updateProgressPuzzle() >= 75 && progress.updateProgressPuzzle() < 100)
				|| (progress.updateProgressLightning() >= 75 && progress.updateProgressLightning() < 100)
				|| progress.updateProgressRelease() >= 66 && progress.updateProgressRelease() < 100) {
			achievedStars = 2;
		}else if ((progress.updateProgressPuzzle() >= 50 && progress.updateProgressPuzzle() < 75)
				|| (progress.updateProgressLightning() >= 50 && progress.updateProgressLightning() < 75)
				|| (progress.updateProgressRelease() >= 32 && progress.updateProgressRelease() < 66)) {
			achievedStars = 1;
		}
		else {
			achievedStars = 0;
		}
		//If numStars previously is less than that achieved 
		//in this game, update them to equal the new highest. 
		if(numStars<achievedStars){
			numStars = achievedStars;
		}
	}

	/**
	 * Gets the level's name.
	 * @return String
	 */
	public String getLevelName() {
		return name;
	}

	/**
	 * Sets the levels name.
	 * @param String name
	 */
	public void setLevelName(String name){
		this.name = name;
	}
	
	/**
	 * Returns the level type as a string.
	 * @return String
	 */
	public String getLevelType() {
		return type;
	}

	/**
	 * Sets the level type.
	 * @param String type
	 */
	public void setLevelType(String type) {
		this.type = type;
	}

	/**
	 * returns the instance of the board for the level.
	 * @return Board
	 */
	public Board getBoard() {
		return this.theBoard;
	}

	/**
	 * returns the instance of the bullpen for the level.
	 * @return Bullpen
	 */
	public Bullpen getBullpen() {
		return this.theBullpen;
	}
	
	public Palette getPalette(){
		return this.thePalette;
	}

	/**
	 * method for quitting a level.
	 */
	public void quit() {
		// TODO: Put actual quit logic here...windowlistener?
		System.out.println("Saving state and exiting.");
	}

	/**
	 * Sets the active piece for the level.
	 * @param Piece p
	 */
	public void setActivePiece(Piece p) {
		activePiece = p;
	}
	
	/**
	 * Returns the active piece.
	 * @return Piece
	 */
	public Piece getActivePiece() {
		return activePiece;
	}

	/**
	 * Returns the dragging piece for the level.
	 * @return Piece
	 */
	public Piece getDraggingPiece() {
		return activePiece;
	}

	/**
	 * Sets the dragging piece.
	 * @param Piece p
	 */
	public void setDraggingPiece(Piece p) {
		activePiece = p;
	}

	/**
	 * Adds a piece to the board
	 * @param Piece p
	 */
	public void addPieceToBoard(Piece p) {
		piecesOnBoard.add(p);
	}

	/**
	 * Returns the currently selected piece.
	 * @return a piece
	 */
	public Piece getSelected() {
		return selectedPiece;
	}

	/**
	 * Sets the selected piece.
	 * @param Piece p
	 */
	public void setSelected(Piece p) {
		this.selectedPiece = p;
	}
	
	/**
	 * Sets the selected piece to the passed piece.
	 * 
	 * @param Piece
	 *            p
	 */
	public void setSelectedPiece(Piece p) {
		this.selectedPiece = p;
	}

	/**
	 * Method to return a list of all possible 35 pieces.
	 * @return List of pieces
	 */
	public List<Piece> getAllPieces() {
		return allPieces;
	}

	/**
	 * Locks the level.
	 */
	public void lock() {
		this.locked = true;
	}

	/**
	 * unlocks the level.
	 */
	public void unlock() {
		this.locked = false;
	}

	/**
	 * Checks whether or not the level is unlocked.
	 * @return boolean
	 */
	public boolean isLocked() {
		return this.locked;
	}
	
	/**
	 * Undo and redo handlers.
	 */
	public void trackMove(Move m){
		undoStack.add(m);
		redoStack.clear();
	}

	/**
	 * returns the last move done off the undo stack.
	 * @return
	 */
	public Move getLastMove() {
		if (undoStack.isEmpty()) {
			return null;
		}
		return undoStack.pop();
	}

	/**
	 * Adds a move to the undo stack.
	 * @param m
	 */
	public void addMoveToUndo(Move m) {
		undoStack.push(m);
	}

	/**
	 * Adds a move to be redoable.
	 * @param Move m
	 */
	public void addRedoableMove(Move m) {
		redoStack.push(m);
	}

	/**
	 * Gets the last redone move.
	 * @return Move
	 */
	public Move getRedoMove() {
		if (redoStack.isEmpty()) {
			return null;
		}
		return redoStack.pop();
	}
	
	/**
	 * Save level handling
	 */
	public void saveLevel(String lvlDir) {
		String filepath = lvlDir + this.getLevelName() + ".lev";
		File file = new File(filepath);
		try{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
			output.writeObject(this);
			output.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * Gets the color from the map for the piece.
	 * @param Piece p
	 * @return Color
	 */
	public Color getPieceColor(Piece p) {
		return colorMap.get(p);
	}

	
	/**
	 * Method for generating a random piece for lightning levels.
	 * @return Piece
	 */
	public Piece generateRandomPiece(){
		Random r = new Random();
		int idx = r.nextInt(35);
		return this.allPieces.get(idx);
	}
}
