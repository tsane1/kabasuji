package kabasuji.entities;

import java.awt.Point;
import java.io.Serializable;

import kabasuji.views.BullpenView;

/**
 * Entity class for the hexomino piece objects. 
 * 
 * @author Derek McMaster
 * @author Ian Jacoway
 *
 */
public class Piece implements Serializable {
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1256113328790056873L;
	/** Name of the piece. Structured Piece X where 1<= X <= 35. */
	String pieceID;
	/** Number Id for the piece. Corresponds with the piece's name.*/
	int pieceIDnum;
	/** Array of 6 locations for the piece tiles.*/
	PieceTile[] tiles;

	private Point piecePosition;
	/**
	 * Constructor for a piece. Pass a number and 6 tile locations.
	 * Name given to the piece with its ID num.  If given less than 6 tiles
	 * the constructor will throw an exception.
	 * @param int idNum
	 * @param piecetile[] arr
	 */
	public Piece(int idNum, PieceTile[] arr){
		this.pieceIDnum = idNum;
		this.pieceID = "Piece " + idNum;;
		if(arr.length == 6) {
			this.tiles = new PieceTile[6];
			for (int i = 0; i < 6; i++) {
				tiles[i] = new PieceTile(arr[i]);
			}
		}
	
	}

	/**
	 * getter for the name of the piece.
	 * @return String name
	 */
	public String getPieceName(){
		return this.pieceID;
	}

	/**
	 * getter for the piece id number.
	 * @return integer Id number
	 */
	public int getPieceID() {
		return this.pieceIDnum;
	}

	/**
	 * helper method used for painting and iteration.
	 * @return int number of piecetiles in piece
	 */
	public int numTilesInPiece() {
		return tiles.length;
	}

	/**
	 * method for flipping a piece across the x-axis.
	 * @return void
	 */
	public void flipX(){
		for(PieceTile pt : this.getTileLocations()){
			pt.setRow(5-pt.getRow());
		}
	}

	/**
	 * method for flipping a piece across the y-axis.
	 * @return void
	 */
	public void flipY(){
		for(PieceTile pt : this.getTileLocations()){
			pt.setColumn(5-pt.getColumn());
		}
	}

	/**
	 * method for rotating a piece 90 degrees clockwise.
	 * @return void
	 */
	public void rotateRight(){
		for(PieceTile pt : this.getTileLocations()){
			int row = pt.getRow();
			int col = pt.getColumn();
			pt.setRow(col);
			pt.setColumn(5-row);
		}
	}	

	/**
	 * method for rotating a piece 90 degrees counter-clockwise.
	 * @return void
	 */
	public void rotateLeft() {
		for(PieceTile pt : this.getTileLocations()){
			int row = pt.getRow();
			int col = pt.getColumn();
			pt.setRow(5-col);
			pt.setColumn(row);
		}
	}

	/**
	 * Sets the piece on the board at given row and col.
	 * @param int col
	 * @param int row
	 */
	public void setPiecePosition(int col, int row){
		piecePosition = new Point(col,row);
	}
	
	/**
	 * Gets the position of the piece on the board.
	 * @return Point
	 */
	public Point getPiecePosition(){
		return piecePosition;
	}
	
	/**
	 * method for returning the locations of the tiles in the piece.
	 * @return piecetile[] of 6 locations
	 */
	public PieceTile[] getTileLocations() {
		return tiles;
	}
	
	/**
	 * Overridden equality method for pieces.
	 * @param Piece p
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj){
		if(obj == null) { return false; }
		if(obj instanceof Piece) {
			Piece p = (Piece) obj;
			return this.pieceIDnum == p.pieceIDnum;
		}
		return false;
	}
	
	/**
	 * Overridden hascode method to add piece to a hashmap.
	 * @return int
	 */
	@Override
	public int hashCode() {
		return this.pieceIDnum;
	}

	/**
	 * Method to determine which piece has been selected based on x-coordinates.  Called in select piece controller.
	 * @param int x coordinate
	 * @param index
	 * @return boolean
	 */
	public boolean contains(int x, int index) {
		
		int xpos = x;
		System.out.println("X Coordinate Clicked: " + xpos);
		
		int pieceIndex = xpos/(BullpenView.containerSize+BullpenView.pieceBuffer);
		System.out.println("Piece index from point: " + pieceIndex);
		
		return pieceIndex == index;
	}

	/**
	 * Determines the index of the piece based on y-coordinates.
	 * @param int y
	 * @param int index
	 * @return boolean
	 */
	public boolean containsy(int y, int index) {
		int ypos = y;
		System.out.println("Y Coordinate Clicked: " + ypos);
		
		int pieceIndex = ypos/(BullpenView.containerSize+BullpenView.pieceBuffer);
		System.out.println("Piece index from point: " + pieceIndex);
		
		return pieceIndex == index;
	}
}
