package kabasuji.entities;

/**
 * Class for the progress entitiy that tracks achievements.
 * 
 * @author Chase St. Laurent
 */

public class Progress {
	/** board instance used to keep track of the achievements. */
	Board board;

	/**
	 * Constructor for progress.
	 * @param board
	 */
	public Progress(Board board) {
		this.board = board; 
	}

	/**
	 * Returns the puzzle level progress.
	 * @return int
	 */
	public int updateProgressPuzzle() {

		int value = board.getPuzzleProgress();

		return value;
	}

	/**
	 * Returns the lightning level progress.
	 * @return int
	 */
	public int updateProgressLightning() {
		int value = 0;

		value = board.getLightningProgress();
		
		return value;
	}

	/**
	 * Returns the release level progress.
	 * @return int
	 */
	public int updateProgressRelease() {
		int value = 0;

		value = board.getReleaseProgress();
		
		return value;
	}
}
