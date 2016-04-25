package kabasuji.supers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;
import kabasuji.entities.Board;
import kabasuji.entities.Bullpen;
import kabasuji.entities.Piece;

/**
 * Level superclass containing all elements common to the different level types.
 * @author Tanuj Sane
 * @author Derek McMaster
 */
public abstract class Level implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Stack<Move> undoStack = new Stack<Move>();
	Stack<Move> redoStack = new Stack<Move>();

	/** The name of the level and the type of the level. Type includes Puzzle, Lightning, or Release. */
	String name, type;
	/** Boolean variable indicating whether or not the level is locked or unlocked to the player. */
	boolean locked;
	/** The board associated with the current level. */
	Board theBoard;
	/** The bullpen associated with the current level. */
	Bullpen theBullpen;
	/** The number of "stars" or achievements the player has accrued for the level. Can be (min of) 0, 1, 2, or (max of) 3. */
	int numStars;
	
	/** Arraylist of pieces previously in the bullpen and now played on the board. */
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
	 * Constructor for creating a new level.
	 * @param String name 
	 * @param String type
	 */
	public Level(String name, String type) {
		this(name, type, new Board(), new Bullpen(), 0);
		this.name = name;
		this.type = type;
		locked = false;
		this.theBoard = new Board();
		this.theBullpen = new Bullpen();
		this.numStars = 0;
		setupPieces();
		theBullpen.addPieces(allPieces);
		for(int i = 0; i < 36; i++) {
			pieceGrid.add(new PieceTile(i/6, i%6));
		}
	}
	
	/**
	 * Constructor for loading a level.
	 * @param String name
	 * @param String type
	 * @param Board b
	 * @param Bullpen bp
	 * @param int numStars
	 */
	public Level(String name, String type, Board b, Bullpen bp, int numStars){
		this.name = name;
		this.type = type;
		this.theBoard = b;
		this.theBullpen = bp;
		this.numStars = numStars;
	}
	/**
	 * Achievement
	 */
	public void updateAchievement(){
		
	}
	
	/**
	 * Getters and setters for level attributes
	 */
	
	public String getLevelName() {
		return name;
	}

	public void setLevelName(String name){
		this.name = name;
	}
	
	public String getLevelType() {
		return type;
	}
	
	public void setLevelType(String type){
		this.type = type;
	}
	
	public Board getBoard() {
		return this.theBoard;
	}
	
	public Bullpen getBullpen() {
		return this.theBullpen;
	}
	
	public Piece getActivePiece(){
		return activePiece;
	}
	
	public void setActivePiece(Piece p) {
		activePiece = p;
	}

	public Piece getDraggingPiece() {
		return activePiece;
	}

	public void setDraggingPiece(Piece p) {
		activePiece = p;
	}

	public Piece getSelected() {
		return selectedPiece;
	}

	public void setSelected(Piece p) {
		this.selectedPiece = p;
	}
	
	/**
	 * Piece motion handling
	 */
	
	public void addPieceToBoard(Piece p) {
		piecesOnBoard.add(p);
	}
	
	/**
	 * Level locked and unlocked handling
	 */
	
	public void lock() {
		this.locked = true;
	}
	
	public void unlock() {
		this.locked = false;
	}

	public boolean isLocked() {
		return this.locked;
	}
	
	/**
	 * Undo and redo handlers
	 */
	
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
}
