package kabasuji.entities;

import kabasuji.supers.Level;

/**
 * Level sublcass for the puzzle level entity.
 * 
 * @author Derek McMaster
 * @author Chase St. Laurent
 */
public class PuzzleLevel extends Level {
	/**
	 * serial id.
	 */
	private static final long serialVersionUID = 1L;
	
	/** integer keeping track of the moves left for the level. */
	private int movesLeft;
	
	/**
	 * Public constructor for the puzzle level entity.
	 * @param String name
	 */
	public PuzzleLevel(String name) {
		super(name, "Puzzle");
	}
	
	/**
	 * returns the number of moves left.
	 * @return int
	 */
	public int getMovesLeft() {
		return this.movesLeft;
	}
	
	/**
	 * sets the number of moves left for the level.
	 * @param int setMoves
	 */
	public void setMovesLeft(int setMoves) {
		this.movesLeft = setMoves;
	}

	/**
	 * Determines the number of stars for achievements based on the numbers collected.
	 */
	@Override
	public void setNumStars() {
		//this.numStars = 3 - this.theBullpen.pieces.size();
		//if(this.numStars < 1) this.numStars = 0;
		this.numStars=0;
	}

	/**
	 * Determines whether or not the level has ended based on the progress.
	 */
	@Override
	public boolean hasEnded() {
		return getMovesLeft() == 0;
	}

	/**
	 * Determines if the player has gotten the highest achievement on the level. 
	 */
	@Override
	public boolean hasWon() {
		updateAchievement();
		return (hasEnded() && progress.updateProgressPuzzle() >= 50) || progress.updateProgressPuzzle() == 100;
	}
}
