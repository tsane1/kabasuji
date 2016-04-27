package kabasuji.entities;

import java.io.Serializable;

import kabasuji.views.BullpenView;

/**
 * Entity class for the hexomino piece object. 
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
		try {
			if(arr.length == 6) {
				this.tiles = new PieceTile[6];
				for (int i = 0; i < 6; i++) {
					tiles[i] = new PieceTile(arr[i]);
				}
			}
		}
		catch(Exception e) {
			System.err.println("PIECE CONSTRUCTOR: PIECE NEEDS SIX TILES");
			e.printStackTrace();
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
	public void rotateLeft(){
//		int i = 0;
//		while (i < 6){
//			this.tiles[i].setRow(5-this.tiles[i].getColumn());
//			this.tiles[i].setColumn(5-this.tiles[i].getRow());
//			i++;
//		}
		for(PieceTile pt : this.getTileLocations()){
			pt.setRow(5-pt.getColumn());
			pt.setColumn(5-pt.getRow());
		}
		
	}	

	/**
	 * method for rotating a piece 90 degrees counter-clockwise.
	 * @return void
	 */
	public void rotateRight(){
//		int i = 0;
//		while (i < 6){
//			this.tiles[i].setRow(5-this.tiles[i].getRow());
//			this.tiles[i].setColumn(5-this.tiles[i].getColumn());
//			i++;
//		}
		PieceTile temp;
		for(PieceTile pt : this.getTileLocations()){
			//temp = pt;
			pt.setColumn(5-pt.getRow());
			pt.setRow(5-pt.getColumn());
		}
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
	 * Method to determine which piece has been selected.  Called in select piece controller.
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
}
