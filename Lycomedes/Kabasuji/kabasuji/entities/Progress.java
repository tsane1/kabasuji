package kabasuji.entities;

public class Progress {
	Board board;
	Tile boardArray[][];

	public Progress(Board board, Tile[][] boardArray) {
		this.board = board;
		this.boardArray = boardArray;
	}

	public int updateProgressPuzzle() {
		int value = 0;

		// TODO: Puzzle -> Progress = (numberTilesCovered/numberTotalTiles)*100
		//value = board.getPuzzleProgress();
		

		return value;
	}

	public int updateProgressLightning() {
		int value = 0;

		// TODO: Lightning -> Progress = numberTilesCovered/numberTotalTile)*100
		//value = board.getLightningProgress();
		
		return value;
	}

	public int updateProgressRelease() {
		int value = 0;

		// TODO: Release -> Progress =
		// numberReleaseTilesCovered/numberTotalReleaseTiles)*100
		//value = board.getReleaseProgress();
		
		
		return value;
	}
}
