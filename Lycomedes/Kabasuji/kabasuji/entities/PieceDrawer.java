package kabasuji.entities;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Helper Class that knows how to translate pieces into graphics.
 * 
 * @author Derek McMaster
 */

public class PieceDrawer {

	/**
	 * Default constructor for a piece drawer object to get access to the draw method.
	 */
	public PieceDrawer() {
		//nothing, piece drawer only knows how to draw
	}
	
	/**
	 * Method that knows how to draw pieces.
	 * @param Graphics g
	 * @param Piece p
	 */
	public void drawPiece(Graphics g, Piece p, int x, int y, Color c) {
		int rowAdjust = p.tiles[0].row;
		int colAdjust = p.tiles[0].col;
		
		for(int i = 0; i<p.numTilesInPiece(); i++){
			
			int rowCord = y + ((p.tiles[i].row - rowAdjust)*32);
			int colCord = x + ((p.tiles[i].col - colAdjust)*32);
			g.setColor(c);
			g.fillRect(colCord, rowCord, Tile.width, Tile.height);
			g.setColor(Color.black);
			g.drawRect(colCord, rowCord, Tile.width, Tile.height);
		}
	}
	public void drawPalettePiece(Graphics g, Piece p, int x, int y, Color c){
		for(PieceTile pt: p.getTileLocations()){
			g.setColor(c);
			g.fillRect(x + (pt.getColumn() * Tile.width), y + (pt.getRow() * Tile.height), Tile.width, Tile.height);
			g.setColor(Color.BLACK);
			g.drawRect(x + (pt.getColumn() * Tile.width), y + (pt.getRow() * Tile.height), Tile.width, Tile.height);
		}
	}
	
	public void drawHintPiece(Graphics g, Tile[] locationsOnBoard){
		for(Tile pt : locationsOnBoard){
			g.setColor(Color.green.brighter().brighter());
			g.drawRect((Tile.height*pt.row)+(Tile.width*pt.col), (Tile.width*pt.col)+(Tile.height*pt.row), Tile.width, Tile.height);
		}
	}
}
