package model;

import java.util.Stack;
import controller.Move;
import supers.Model;

public class LevelBuilderModel extends Model{

	Level currentLevel;
	Stack<Move> undoStack = new Stack<Move>();
	Stack<Move> redoStack = new Stack<Move>();
	LevelBuilderFactory levelFactory;
	
	Piece selectedPiece;
	
	public LevelBuilderModel(){
	 	//default constructor
	}
	
	public Level getLevel(){
		return currentLevel;
	}
	
	public void setLevel(Level L){
		this.currentLevel = L;
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
	
}
