package kabasuji.entities;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

/** 
 * Main board object that represents a board of maximum size 12x12 and all the tiles and pieces it contains.
 * @author Michael
 * @author Ian Jacoway as of @since 4/24/16
 *
 */

public class Board implements Serializable{

	private int rows[], cols[];
	private Tile boardArray[][]; //needs to be initialized
	private ArrayList<Piece> placedPieces;
	
	public Board() {
		this.rows = new int[12];
		this.cols = new int[12];
		this.placedPieces = new ArrayList<Piece>();
		this.boardArray = new Tile[12][12];
		initializeBoardArray();
		
	}
	
	void initializeBoardArray(){
		int i,j = 0;
		for(i = 0;i<12;i++){
			for(j = 0;j<12;j++){
				UnplayableTile tile = new UnplayableTile(i, j);
				boardArray[i][j] = tile;
			}
		}
	}
	/**
	 * createBoardTile at the given row and col of the specified type.
	 * 
	 * @param row
	 * @param col
	 * @param type
	 */
	//creates a tile that can be played on at the given grid location in the 12x12
	public void createBoardTile(int row, int col, String type){
		if(type.equals("puzzle")){
			boardArray[row][col] = new PuzzleBoardTile(row, col);
		}else if(type.equals("lightning")){
			boardArray[row][col] = new LightningBoardTile(row, col);
		}else{
			boardArray[row][col] = new ReleaseBoardTile(row, col);
		}
	}
	/**
	 * Places piece at the specified grid location.
	 * 
	 * Only takes on piece with 0,0 starting point needs to be adapted.
	 * 
	 * @param row
	 * @param col
	 * @param piece
	 * @return True if placing the piece succeeds.
	 */
	public boolean place(int row, int col, Piece piece) {
		//need to check if place is covered both the release points and where pieces tiles move to after that
		//probably piece.tiles[0].row + row and piece.tiles[0].col + col.... where .row and .col have been updated to reflect the release point
		//if extension of the piece is ever out of bounds return widget and throw exception, but if lightning just mark tiles in bounds
		
		boolean pieceCovering = true;
		
		try {
			pieceCovering = pieceCovering(row,col,piece);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		if(!pieceCovering){
			//add piece to list of placed pieces
			placedPieces.add(piece);
			//covers the place 
			coverPieceArea(row, col, piece);
			//use row and col to tell piece where it is located on the board
			
			
			return true;
		}else{
			//throw? or boolean like now that says place failed
			return false;
		}
	}
	

	/**
	 * Checks whether the piece is covering an already covered area.
	 * 
	 * @return true if piece is covering a place that's covered
	 */
	public boolean pieceCovering(int row, int col, Piece piece) throws Exception{
		//adjust for pieces when piece doesnt start in 0,0 
		int rowAdjust = piece.tiles[0].row;
		int colAdjust = piece.tiles[0].col;
		
		for(int i = 0; i<piece.numTilesInPiece(); i++){
			
			int rowCord = row + (piece.tiles[i].row - rowAdjust);
			int colCord = col + (piece.tiles[i].col - colAdjust);
			
			if((rowCord < 0)||(colCord < 0)){
				throw new RuntimeException("Out of Bounds");
			}
			
			if(boardArray[rowCord][colCord].isCovered()){
				return true;
			}
		}
		return false;
	}
	public void coverPieceArea(int row, int col, Piece piece){
		int rowAdjust = piece.tiles[0].row;
		int colAdjust = piece.tiles[0].col;
		
		for(int i = 0; i<piece.numTilesInPiece(); i++){
			
			int rowCord = row + (piece.tiles[i].row - rowAdjust);
			int colCord = col + (piece.tiles[i].col - colAdjust);
			
			boardArray[rowCord][colCord].cover();
			//if its a lightningboard we should mark it
			LightningBoardTile lTile = new LightningBoardTile(0, 0);
			if(boardArray[rowCord][colCord].getClass() == lTile.getClass()){
				((LightningBoardTile) boardArray[rowCord][colCord]).mark();
			}
		}
	}
	public void uncoverPieceArea(int row, int col, Piece piece){
		int rowAdjust = piece.tiles[0].row;
		int colAdjust = piece.tiles[0].col;
		
		for(int i = 0; i<piece.numTilesInPiece(); i++){
			
			int rowCord = row + (piece.tiles[i].row - rowAdjust);
			int colCord = col + (piece.tiles[i].col - colAdjust);
			
			boardArray[rowCord][colCord].uncover();
			//if its a lightningboard we should mark it
			LightningBoardTile lTile = new LightningBoardTile(0, 0);
			if(boardArray[rowCord][colCord].getClass() == lTile.getClass()){
				((LightningBoardTile) boardArray[rowCord][colCord]).unmark();
			}
		}
	}
	public ArrayList<Piece> getPlacedPieces(){
		return this.placedPieces;
	}
	public Tile[][] getBoardArray(){
		return boardArray;
	}
	/**
	 * General progress percentage return.
	 * 
	 * @param x represents game type.
	 * @return returns the percentage of completion for the given level.
	 */
	public int getProgress(String x){
		if(x == "puzzle"){
			return getPuzzleProgress();
			
		}else if(x == "lightning"){
			return getLightningProgress();
		}else{
			return getReleaseProgress();
		}
	}
	/**
	 * Determine how much progress player has made on puzzle.
	 *  
	 * @return integer value of between 0 and 100 for completion
	 */
	public int getPuzzleProgress(){
		int i,j,count = 0;
		//iterate over board array
		for(i = 0;i<12;i++){
			for(j = 0;j<12;j++){
				UnplayableTile tile = new UnplayableTile(i, j);
				
				//if this doesn't work use instancOf
				//if its a board tile
				//old code was to check is spot was not an unplayable tile then count
				if(!(boardArray[i][j].getClass() == tile.getClass()) ){
					count++;
				}
			}
		}
		int value = ((placedPieces.size() * 6)/count) * 100;
		return value;
	}
	public int getLightningProgress(){
		return 0;
	}
	public int getReleaseProgress(){
		return 0;
	}
	
	/**
	 * Converts an UnplayableTile to a PieceTile given a Point on the Board.
	 * @param Point p
	 */
	public void selectTile(Point p, String levType) {
		int rowNum = (int) p.getY()/32; 
		int colNum = (int) p.getX()/32; 
		int x = (int)p.getX()%32;
		int y = (int)p.getY()%32;
		
		if(x == 0)
			colNum -= 1;
		if(y == 0)
			rowNum -= 1;
		
		switch(levType){
		case "puzzle" :
			boardArray[rowNum][colNum] = new PuzzleBoardTile(rowNum,colNum); break;
		case "lightning" :
			boardArray[rowNum][colNum] = new LightningBoardTile(rowNum,colNum); break;
		case "release" :
			boardArray[rowNum][colNum] = new ReleaseBoardTile(rowNum,colNum); break;
		default:
			System.err.println("Type not found.");
		}
		
	}
	
	/**
	 * Converts an PieceTile to a UnplayableTile given a Point on the Board.
	 * @param Point p
	 */
	public void deselectTile(Point p) {
		int rowNum = (int) p.getY()/32; 
		int colNum = (int) p.getX()/32;
		int x = (int)p.getX()%32;
		int y = (int)p.getY()%32;
		
		if(x == 0)
			colNum -= 1;
		if(y == 0)
			rowNum -= 1;
		
		boardArray[rowNum][colNum] = new UnplayableTile(rowNum, colNum);
	}
}
