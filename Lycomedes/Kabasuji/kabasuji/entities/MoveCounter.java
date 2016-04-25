package kabasuji.entities;

import kabasuji.supers.Level;

/** 
 * 
 * @author Chase St. Laurent
 *
 */

public class MoveCounter {
	Piece pieces;
	Level level;
	
	public MoveCounter(Level level) {
		super();
		this.level = level; 
	}
	 
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
	
	public boolean isPuzzle(Level level){
		boolean isPuzzle = false;
		//TODO: Makes sure game mode is Puzzle
		if(level.getLevelName() == "Puzzle"){
			isPuzzle = true;
		}
		return isPuzzle;
	}
}
