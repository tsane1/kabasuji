package supers;

import java.util.Stack;
import controller.Move;

public class Model {
	
	Stack<Move> undoStack = new Stack<Move>();
	Stack<Move> redoStack = new Stack<Move>();
	
	public Model() {
		
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
