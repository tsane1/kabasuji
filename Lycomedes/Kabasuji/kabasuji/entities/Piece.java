package kabasuji.entities;


public class Piece implements java.io.Serializable {
	
	private String pieceID;
	private int pieceIDnum;
	PieceTile[] tiles;
	
	/**
	 * Constructor for a piece. Pass a number and 6 tile locations.
	 * Name given to the piece with its ID num.  If given less than 6 tiles
	 * the constructor will throw an exception
	 * @param idNum
	 * @param arr
	 */
	public Piece(int idNum, PieceTile[] arr){
		this.pieceIDnum = idNum;
		this.pieceID = "Piece " + idNum;;
		try {
			if(arr.length == 6) {

				this.tiles = arr;
			}
		}
		catch(Exception e) {
			System.err.println("PIECE CONSTRUCTOR: PIECE NEEDS SIX TILES");
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the piece's "name"
	 */
	public String getPieceName(){
		return this.pieceID;
	}
	
	/**
	 * Gets the piece's ID number
	 */
	public int getPieceID() {
		return this.pieceIDnum;
	}
	
	/**
	 * Quick helper method used in computations. Should return 6.
	 */
	public int numTilesInPiece() {
		return tiles.length;
	}
	
	/**
	 * Flip piece with respect to the X axis
	 */
	public void flipX(){
		int i = 0;
		while (i < 6){
			this.tiles[i].setRow(5-this.tiles[i].getRow());
			i++;
		}
	}
	
	/**
	 * Flipping piece with respect to the Y axis
	 */
	public void flipY(){
		int i = 0;
		while (i < 6){
			this.tiles[i].setColumn(5-this.tiles[i].getColumn());
			i++;
		}
	}
	
	/**
	 * Rotate piece 90 left
	 */
	public void rotateLeft(){
		int i = 0;
		while (i < 6){
			this.tiles[i].setRow(5-this.tiles[i].getColumn());
			this.tiles[i].setColumn(5-this.tiles[i].getRow());
			i++;
		}
	}	
	
	/**
	 * Rotate piece 90 right 
	 */
	public void rotateRight(){
		int i = 0;
		while (i < 6){
			this.tiles[i].setRow(5-this.tiles[i].getRow());
			this.tiles[i].setColumn(5-this.tiles[i].getColumn());
			i++;
		}
	}
}
