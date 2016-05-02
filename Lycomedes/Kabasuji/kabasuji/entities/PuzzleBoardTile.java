package kabasuji.entities;

/**
 * Tile Subclass which will make up the Puzzle Level Boards.
 * 
 * @author Derek McMaster
 * @author Michael Pickett
 */
public class PuzzleBoardTile extends Tile{

	/**
	 * serial Id for puzzleboardtile.
	 */
	private static final long serialVersionUID = 1731217237418160460L;
	/** row and column attributes for a tile object. */
	int row, col;
	/** attribute for whether or not a tile is covered. */
	private boolean covered;
	/** A piece instance to determine which piece is covering a certain location. */
	private Piece pieceCovering;
	/** The piece index when determining pieces on the board. */
	private int pieceIndex;
	
	/**
	 * Constructor for the  puzzleboardtile object.
	 * @param int row
	 * @param int col
	 */
	public PuzzleBoardTile(int row, int column) {
		super(row, column);
		
		this.row = row;
		this.col = column;
		covered = false;
		pieceCovering = null;
	}
	
	/**
	 * Method to change a tile to covered state.
	 * @return void
	 */
	public void cover() {
		covered = true;
		
	}
	
	/**
	 * Sets the covering piece for a board.
	 * @param piece
	 * @param idx
	 */
	public void coveringPiece(Piece piece, int idx){
		pieceCovering = piece;
		pieceIndex = idx;
	}
	
	/**
	 * returns the covering piece
	 * @return Piece
	 */
	public Piece getCoveringPiece(){
		return pieceCovering;
	}
	
	/**
	 * Gets the piece tile index.
	 * @return int
	 */
	public int getPieceTileIdx(){
		return pieceIndex;
	}
	/**
	 * Method to change a tile to uncovered state.
	 * @return void
	 */
	public void uncover(){
		covered = false;
	}
	
	/**
	 * Method to determine a tile's covered state.
	 * @return boolean
	 */
	public boolean isCovered() {
		return covered;
	}
}
