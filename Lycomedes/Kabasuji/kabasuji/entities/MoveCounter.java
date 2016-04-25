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
		int count = 0;
		if(isPuzzle(level)){
			//waiting on this function
			//count = getMoveCount();//OR infinity?
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
