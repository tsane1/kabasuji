package kabasuji.entities;

import kabasuji.supers.Level;

/** 
 * Move counter entity to keep track of moves on levels.
 * @author Chase St. Laurent
 *
 */

public class MoveCounter {
	/** piece involved in the move. */
	Piece pieces;
	/** current level being played */
	Level level;
	
	/**
	 * Constructor for move counter.
	 * @param Level level
	 */
	public MoveCounter(Level level) {
		super();
		this.level = level; 
	}
	 

	/**
	 * Keeps track of the number of moves done.
	 * @return int num moves
	 */
	public int moveCount(){
		int count = 0;//Temporary
//		int count = getMoveCount();
		//look at undo stack - need it to say a move has been done.
		while(count > 0){
			if(isPuzzle(level)){
				count--;
			}
		}
		return count;
	}
	
	/**
	 * Determines if the current level is a puzzle level.
	 * @param level
	 * @return boolean
	 */
	public boolean isPuzzle(Level level){
		boolean isPuzzle = false;
		//TODO: Makes sure game mode is Puzzle
		if(level.getLevelName() == "Puzzle"){
			isPuzzle = true;
		}
		return isPuzzle;
	}
}
