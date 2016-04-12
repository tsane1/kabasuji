package model;

import java.util.Stack;
import controller.Move;

public class LevelBuilderModel {

	Level currentLevel;
	Stack<Move> undoStack = new Stack<Move>();
	Stack<Move> redoStack = new Stack<Move>();
	
	Piece selectedPiece;
	
	public LevelBuilderModel(Level L) {
		this.currentLevel = L;
	}
	
	public LevelBuilderModel(){
		this(new Level());
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
}
