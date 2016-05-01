package kabasuji.entities;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/** 
 * Main board object that represents a board of maximum size 12x12 and all the tiles and pieces it contains.
 * @author Michael
 * @author Ian Jacoway as of @since 4/24/16
 * @author Derek McMaster - hints
 */

public class Board implements Serializable{

	/**
	 * Serial Id.
	 */
	private static final long serialVersionUID = 1L;
	/** row and column arrays to make the board. */
	private int rows[], cols[];
	/** the array of tiles that make up the board. */
	private Tile boardArray[][]; //needs to be initialized
	/** Map of where the pieces are on the board. */
	private HashMap<Point,Piece> placedPieces;
	/** Array to store the locations of a 'hint' piece. */
	ArrayList<Tile> hintArray;
	
	/**
	 * Constructor for the board class.  Initializes the board and piece map.
	 */
	public Board() {
		this.rows = new int[12];
		this.cols = new int[12];
		this.placedPieces = new HashMap<Point, Piece>();
		this.boardArray = new Tile[12][12];
		hintArray = new ArrayList<Tile>();
		initializeBoardArray();
		
	}
	
	/**
	 * Method to initialize all of the board tiles to unplayable tiles. 
	 * @return void
	 */
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
	 * @param int row
	 * @param int col
	 * @param int type
	 */
	//creates a tile that can be played on at the given grid location in the 12x12
	public void createBoardTile(int row, int col, String type) {
		if(type.equals("Puzzle")){
			boardArray[row][col] = new PuzzleBoardTile(row, col);
		}
		else if(type.equals("Lightning")) {
			boardArray[row][col] = new LightningBoardTile(row, col);
		}
		else {
			boardArray[row][col] = new ReleaseBoardTile(row, col);
		}
	}
	
	/**
	 * Places piece at the specified grid location.
	 * 
	 * Only takes on piece with 0,0 starting point needs to be adapted.
	 * 
	 * @param int row
	 * @param int col
	 * @param Piece piece
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
			//need to adjust for hashmap to know where point is for drawing
//			int rowAdjust = piece.tiles[0].row;
//			int colAdjust = piece.tiles[0].col;
			
//			int rowCord = Math.abs(row - rowAdjust);
//			int colCord = Math.abs(col - colAdjust);
			//add piece to list of placed pieces
			piece.setPiecePosition(col, row);
			Point pt = piece.getPiecePosition();
			placedPieces.put(pt, piece);
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
	 * i and j in the boardArray are as follows: i is the x distance and thus the column and j is the y distance and thus the row
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
			
			if(boardArray[colCord][rowCord].isCovered()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to mark the squares on the board where the piece has just been placed as covered.
	 * @param int row
	 * @param int col
	 * @param int piece
	 */
	public void coverPieceArea(int row, int col, Piece piece){
		int rowAdjust = piece.tiles[0].row;
		int colAdjust = piece.tiles[0].col;
		
		for(int i = 0; i<piece.numTilesInPiece(); i++){
			
			int rowCord = row + (piece.tiles[i].row - rowAdjust);
			int colCord = col + (piece.tiles[i].col - colAdjust);
			
			boardArray[colCord][rowCord].cover();
			
			//tells a puzzle board the piece covering it so removing it from board is easy
			PuzzleBoardTile pTile = new PuzzleBoardTile(0, 0);
			if(boardArray[colCord][rowCord].getClass() == pTile.getClass()){
				((PuzzleBoardTile) boardArray[colCord][rowCord]).coveringPiece(piece,i);
			}
			//if its a lightningboard we should mark it
			LightningBoardTile lTile = new LightningBoardTile(0, 0);
			if(boardArray[colCord][rowCord].getClass() == lTile.getClass()){
				((LightningBoardTile) boardArray[colCord][rowCord]).mark();
			}
		}
	}
	
	/**
	 * Method to unmark pieces on the board if a move is undone or a piece is moved to a different place.
	 * @param int row
	 * @param int col
	 * @param Piece piece
	 */
	public void uncoverPieceArea(int row, int col, Piece piece){
		int rowAdjust = piece.tiles[0].row;
		int colAdjust = piece.tiles[0].col;
		
		for(int i = 0; i<piece.numTilesInPiece(); i++){
			
			int rowCord = row + (piece.tiles[i].row - rowAdjust);
			int colCord = col + (piece.tiles[i].col - colAdjust);
			
			boardArray[colCord][rowCord].uncover();
			//if its a lightningboard we should mark it
			LightningBoardTile lTile = new LightningBoardTile(0, 0);
			if(boardArray[colCord][rowCord].getClass() == lTile.getClass()){
				((LightningBoardTile) boardArray[colCord][rowCord]).unmark();
			}
		}
	}
	
	/**
	 * Getter function to return the map of pieces for searching. 
	 * @return Hashmap
	 */
	public HashMap<Point,Piece> getPlacedPieces(){
		return this.placedPieces;
	}
	
	/**
	 * Getter for the board array to manipulate it.
	 * @return Tile[][]
	 */
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
	 * Determine how much progress player has made on a puzzle level.
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
		int placed = placedPieces.size() * 6;
		float div = ((float)placed/count);
		System.out.println(div);
		int value = (int)(div * 100);
		System.out.println(value);
		return value;
	}
	
	/**
	 * Determine how much progress player has made on a lightning level.
	 *  
	 * @return integer value of between 0 and 100 for completion
	 */
	public int getLightningProgress(){
		
		int i,j,count = 0, marked = 0;
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
				LightningBoardTile ltile = new LightningBoardTile(i, j);
				
				//if this doesn't work use instancOf
				//if its a board tile
				//old code was to check is spot was not an unplayable tile then count
				if(boardArray[i][j].getClass() == ltile.getClass()){
					if(((LightningBoardTile) boardArray[i][j]).isMarked()){
						marked++;
					}
				}
			}
		}
		System.out.println(marked);
		System.out.println(count);
		float value = ((float)marked/count);
		int last = (int)(value * 100);
		System.out.println(value);
		return last;
	}
	
	/**
	 * Determine how much progress player has made on a release level.
	 *  
	 * @return 
	 */
	public int getReleaseProgress(){
		int i,j,countGreen = 0, countRed = 0, countYellow = 0, markedGreen = 0, markedRed = 0, markedYellow = 0;
		//iterate over board array
		for(i = 0;i<12;i++){
			for(j = 0;j<12;j++){
				ReleaseBoardTile tile = new ReleaseBoardTile(i, j);
				
				//if this doesn't work use instancOf
				//if its a board tile
				//old code was to check is spot was not an unplayable tile then count
				if((boardArray[i][j].getClass() == tile.getClass()) && (((ReleaseBoardTile)boardArray[i][j]).getValue() > 0)){
					if(((ReleaseBoardTile)boardArray[i][j]).getNumColor() == 0){
						countGreen++;
					}else if(((ReleaseBoardTile) boardArray[i][j]).getNumColor() == 1){
						countRed++;
					}else if(((ReleaseBoardTile) boardArray[i][j]).getNumColor() == 2){
						countYellow++;
					}
				}
				
				//if this doesn't work use instancOf
				//if its a board tile
				//old code was to check is spot was not an unplayable tile then count
				if(boardArray[i][j].getClass() == tile.getClass() && (((ReleaseBoardTile)boardArray[i][j]).getValue() > 0)){
					if(((ReleaseBoardTile) boardArray[i][j]).isCovered()){
						if(((ReleaseBoardTile)boardArray[i][j]).getNumColor() == 0){
							markedGreen++;
						}else if(((ReleaseBoardTile) boardArray[i][j]).getNumColor() == 1){
							markedRed++;
						}else if(((ReleaseBoardTile) boardArray[i][j]).getNumColor() == 2){
							markedYellow++;
						}
					}
				}
			}
		}
		if(countGreen == 0 || countRed == 0 || countYellow == 0){
			System.out.println("Missing release tiles with numbers");
			return 0;
		}
		int value = 0;
		if(markedGreen == countGreen){
			value += 33;
		}
		if(markedRed == countRed){
			value += 33;
		}
		if(markedYellow == countYellow){
			value += 33;
		}
		if(value == 99){
			value++;
		}
		return value;
	}
	
	/**
	 * Converts an UnplayableTile to a active corresponding BoardTile.
	 * @param Point p -Given a piece on the Board. 
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
		case "Puzzle" :
			boardArray[colNum][rowNum] = new PuzzleBoardTile(colNum,rowNum); break;
		case "Lightning" :
			boardArray[colNum][rowNum] = new LightningBoardTile(colNum,rowNum); break;
		case "Release" :
			boardArray[colNum][rowNum] = new ReleaseBoardTile(colNum,rowNum); break;
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
		
		boardArray[colNum][rowNum] = new UnplayableTile(rowNum, colNum);
	}
	
	/**
	 * Increments the number shown on a ReleaseBoardTile.
	 * @param Point p
	 */
	public void incrementReleaseTile(Point p){
		int rowNum = (int) p.getY()/32; 
		int colNum = (int) p.getX()/32;
		int x = (int)p.getX()%32;
		int y = (int)p.getY()%32;
		
		if(x == 0)
			colNum -= 1;
		if(y == 0)
			rowNum -= 1;
		((ReleaseBoardTile) boardArray[colNum][rowNum]).updateReleaseNum();
	}

	/**
	 * Increments the number's color shown on a ReleaseBoardTile.
	 * @param Point p
	 */
	public void changeReleaseNumColor(Point p) {
		int rowNum = (int) p.getY()/32; 
		int colNum = (int) p.getX()/32;
		int x = (int)p.getX()%32;
		int y = (int)p.getY()%32;
		
		if(x == 0)
			colNum -= 1;
		if(y == 0)
			rowNum -= 1;
		
		((ReleaseBoardTile) boardArray[colNum][rowNum]).updateReleaseColor();
	}

	/**
	 * returns the locations of the squares on the board for hints.  Will be board locations not piecetile.
	 * @return Tile[]
	 */
	public List<Tile> getHintLocations() {
		return hintArray;
	}
	
	/**
	 * Method for adding a location to the hint piece array.
	 * @param Tile t
	 */
	public void setHintLocation(Tile t){
		/*
		 * Will length return current length or declared length?
		 */
		System.out.println("setHintLocation");
		if(hintArray.size() < 6)
			System.out.println("add to hintArray");
			hintArray.add(t);
	}

}
