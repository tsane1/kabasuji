package kabasuji.entities;

/**
 * 
 * @author Chase St. Laurent
 *
 */

public class Progress {
	Board board;

	public Progress(Board board) {
		this.board = board;
	}

	public int updateProgressPuzzle() {
		int value = 0;

		//getPuzzleProgress = (numberTilesCovered/numberTotalTiles)*100
		value = board.getPuzzleProgress();
		

		return value;
	}

	public int updateProgressLightning() {
		int value = 0;

		//getLightningProgress = numberTilesCovered/numberTotalTile)*100
		value = board.getLightningProgress();
		
		return value;
	}

	public int updateProgressRelease() {
		int value = 0;

		// getReleaseProgress = numberReleaseTilesCovered/numberTotalReleaseTiles)*100
		value = board.getReleaseProgress();
		
		
		return value;
	}
}
