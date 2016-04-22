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
		if(isLightning(level)){
			count = 0;//OR infinity?
		}
		while(!isLightning(level)){
			//TODO: Need to determine how we determine allowable # of moves	
		}
		return count;
	}
	
	public boolean isLightning(Level level){
		boolean isLightning = false;
		//TODO: Makes sure game mode is not lightning
		if(level.getLevelName() == "Lightning"){
			isLightning = true;
		}
		return isLightning;
	}
}
