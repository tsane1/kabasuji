package kabasuji.supers;

import java.io.Serializable;
import java.util.ArrayList;
import kabasuji.entities.Board;
import kabasuji.entities.Bullpen;
import kabasuji.entities.Piece;

/**
 * Level superclass containing all elements common to the different level types.
 * @author Tanuj Sane
 */
public abstract class Level implements Serializable {
	/**
	 * Eclipse said so
	 */
	private static final long serialVersionUID = 1L;

	String name, type;
	
	Board theBoard;
	Bullpen theBullpen;
	
	ArrayList<Piece> piecesOnBoard = new ArrayList<Piece>();
	ArrayList<Piece> piecesInBullpen = new ArrayList<Piece>();
	
	Piece selectedPiece = null;
	Piece activePiece, draggingPiece;
	
	public Level(String name, String type) {
		this.name = name;
		this.type = type;
		this.theBoard = new Board();
		this.theBullpen = new Bullpen();
	}
	
	public Level(){
		this("test", "level");
	}
	
	public String getLevelName() {
		return name;
	}

	public String getLevelType() {
		return type;
	}
	
	public void setLevelName(String name){
		this.name = name;
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
	
	public void quit() {
		// TODO: Put actual quit logic here...windowlistener?
		System.out.println("Saving state and exiting.");		
	}

	public void setActivePiece(Piece p) {
		activePiece = p;
	}

	public Piece getActivePiece(){
		return activePiece;
	}

	public Piece getDraggingPiece() {
		return activePiece;
	}

	public void setDraggingPiece(Piece p) {
		activePiece = p;
	}

	public void addPiece(Piece p) {
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
	 * Sets the selected piece to the passed piece.
	 * @param Piece p
	 */
	public void setSelectedPiece(Piece p) {
		this.selectedPiece = p;
	}

}
