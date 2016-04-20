package kabasuji.supers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import kabasuji.entities.Board;
import kabasuji.entities.Bullpen;
import kabasuji.entities.Piece;
import kabasuji.entities.PlayedPiece;

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
	
	Piece[] placedPieces;
	Piece selectedPiece = null;
	PlayedPiece activePiece, draggingPiece;
	ArrayList<PlayedPiece> playedPieces = new ArrayList<PlayedPiece>();
	
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
		// TODO: Put actual quit logic here
		System.out.println("Saving state and exiting.");		
	}
	

	public Piece getSelected() {
		return selectedPiece;
	}

	public void setSelectedPiece(Piece p) {
		this.selectedPiece = p;
	}

	public ArrayList<PlayedPiece> getPlayedPieces(){
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
