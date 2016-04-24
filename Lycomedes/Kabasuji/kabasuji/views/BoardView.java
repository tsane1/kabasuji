package kabasuji.views;

import javax.swing.JPanel;


import kabasuji.entities.*;
import kabasuji.supers.Level;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * 
 * @author Michael
 * @author Heineman
 *
 */
public class BoardView extends JPanel {
	
	/**
	 *  serial id for BoardView
	 */
	private static final long serialVersionUID = -8800914211105754331L;
	
	private Level currLevel;
	//not sure if needed since we are using a square
	int offset = 32;
	//size of puzzle if 12x12 with squares being 32 pixels long
	private final int size = 384;
	
	PieceDrawer drawer = new PieceDrawer();
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;
	
	//in order open in window builder apparently
	BoardView(){
		
	}
	
	public BoardView(Level currLevel) {
		super();
		this.currLevel = currLevel;
		
		
//		setLayout(null);
//		
//		JLabel label = new JLabel("");
//		label.setIcon(new ImageIcon(BoardView.class.getResource("/imgs/12x12gridedit.jpg")));
//		label.setBounds(0, 0, 384, 384);
//		add(label);
//		this.setBounds(283, 110, 384, 384);
	}
	
	@Override
	public Dimension getMinimumSize() {
		int width = 2*size + 2*offset;
		int height = 2*size + 2*offset;

		return new Dimension (width, height);
	}
	@Override
	public Dimension getPreferredSize() {
		int width = 2*size + 2*offset;
		int height = 2*size + 2*offset;
		
		return new Dimension (width, height);
	}
	/**
	 * Draws the background puzzle image and the unplayable tiles
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if (offScreenImage == null) {
			// create on demand
			Dimension s = getPreferredSize();
			offScreenImage = this.createImage(s.width, s.height);
			offScreenGraphics = offScreenImage.getGraphics();

			redraw();
		}
		// if no offscreenImage, then Swing hasn't fully initialized; leave now
		if (offScreenImage == null) {
			System.err.println("Swing not ready for drawing.");
			return;
		}
		
		g.drawImage(offScreenImage, 0, 0, this);
		//in case no model like for window builder
		if(currLevel == null){return;}
		
		//draw active piece???
//		Piece active = currLevel.getActivePiece();
//		if(active != null){
//			Color c = new Color(Color.GREEN);
//			g.setColor(c);
//			drawer.drawPiece(offScreenGraphics, active, 0, 0);
//		}
		
	}
	public void redraw(){
		//set buffer
		int x = offset;
		int y = offset;
		
		Dimension dim = getPreferredSize();
		offScreenGraphics.clearRect(0, 0, dim.width, dim.height);
		
		Board board = currLevel.getBoard();
		Tile[][] boardArray = board.getBoardArray();
		UnplayableTile tile = new UnplayableTile(0, 0);
		//Just incase separate drawing color needed for them
		PuzzleBoardTile pTile = new PuzzleBoardTile(0, 0);
		LightningBoardTile lTile = new LightningBoardTile(0, 0);
		ReleaseBoardTile rTile = new ReleaseBoardTile(0, 0);
		//draws out the board
		//MIGHT NEED TO CHANGE IF WE PLACE TRANSPARENT ON TOP?? or not
		int i,j = 0;
		for(i = 0;i<12;i++){
			for(j = 0;j<12;j++){
				//unplayable tile then make a black tile there
				if(boardArray[i][j].getClass() == tile.getClass()){
					offScreenGraphics.setColor(Color.BLACK);
					//the tile start is i*width and goes to that plus width
					offScreenGraphics.fillRect(i*tile.width, j*tile.height,(i*tile.width + tile.width), (j*tile.height + tile.height));
				}else if(boardArray[i][j].isCovered()){ //this is for pieces because if a tile is covered then it colored like the pieces
					offScreenGraphics.setColor(Color.RED);
					offScreenGraphics.fillRect(i*tile.width, j*tile.height,(i*tile.width + tile.width), (j*tile.height + tile.height));
				}else if((boardArray[i][j].getClass() == lTile.getClass())){
					if(((LightningBoardTile) boardArray[i][j]).isMarked()){
						offScreenGraphics.setColor(Color.GREEN);
						offScreenGraphics.fillRect(i*tile.width, j*tile.height,(i*tile.width + tile.width), (j*tile.height + tile.height));
					}
				}
				else {
					offScreenGraphics.setColor(Color.LIGHT_GRAY); //regular board tiles are just light gray still need to figure out the release tile number stuff
					offScreenGraphics.fillRect(i*tile.width, j*tile.height,(i*tile.width + tile.width), (j*tile.height + tile.height));
				}
			}
		}
		
		
		
	}
	public void refresh(){
		redraw();
		repaint();
	}
	//returns the graphics for this view???
	
	public Graphics getGraphics(){
		return offScreenGraphics;
	}
}