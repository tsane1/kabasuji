package kabasuji.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.JPanel;

import kabasuji.entities.Piece;
import kabasuji.entities.PieceDrawer;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;

public class PaletteView extends JPanel{

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;
	
	/** containersize global, equal to 6xtilesize or 6x32. */	
	public static final int containerSize = 192;
	/** buffer to separate pieces when drawing. */
	public static final int pieceBuffer = 8;
	
	/** Image object to create the piece images with. */
	Image offScreenImage = null;
	/** Graphics object to paint the images of the pieces. */
	Graphics offScreenGraphics = null;
	
	Level level;
	
	/** drawing object that knows how to draw pieces. */
	PieceDrawer drawer = new PieceDrawer();
	
	/**
	 * Constructor for the paletteview. Passed the model and a specific bullpen. 
	 * @param Model model
	 */
	public PaletteView(SuperModel m) {
		super();
		this.level = m.getActiveLevel();
		//this.setBackground(Color.white);
		//this.setBounds(667, 100, 253, 362);
	}
	
	
	public List<Piece> getPiecesInPalette() {
		return level.getPalette().getPieces();
	}
	/**
	 * Overridden painting function for getting the minimum size.
	 * Minimum size is one piece tall and wide with a buffer on all sides.
	 * @return Dimension
	 */
	@Override
	public Dimension getMinimumSize(){
		int height = containerSize + (2*pieceBuffer);
		int width = containerSize + (2*pieceBuffer);
		
		return new Dimension(width, height);
	}
	
	/**
	 * Overridden painting function for getting the preferred size.
	 * Preffered size is one piece tall and three pieces wide wide with a buffer on all sides.
	 * @return Dimension
	 */
	@Override
	public Dimension getPreferredSize() {
		int width = containerSize + (2*pieceBuffer);
		int height = pieceBuffer + (35*(pieceBuffer+containerSize));

		return new Dimension (width, height);
	}
	
	/**
	 * Override method to paint the pieces.
	 * @param Graphics g
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		if(offScreenImage == null) {	
			redraw();
		}
		if(offScreenImage == null) {
			System.err.println("Paint component method: bullpenview class");
			return;
		}
		g.drawImage(offScreenImage, 0, 0, this);
	}
	
	/**
	 * redraw method to refresh the images on the screen before repainting.
	 * @return void
	 */
	public void redraw() {
		int x = pieceBuffer;
		int y = pieceBuffer;
		Dimension dim = getPreferredSize();
		
		if (offScreenImage != null) {
			offScreenImage.flush();
		}
		if (offScreenGraphics != null) {
			offScreenGraphics.dispose();
		}

		offScreenImage = this.createImage(dim.width, dim.height);

		if (offScreenImage == null) { 
			System.err.println("Unable to create new Image.... HELP");
			return; 
		}

		offScreenGraphics = offScreenImage.getGraphics();

		for (Piece p : level.getPalette().getPieces()) {
			if(p == level.getSelected()){
				drawer.drawPalettePiece(offScreenGraphics, p, x, y, Color.orange.brighter());
			}
			else {
				drawer.drawPalettePiece(offScreenGraphics, p, x, y, level.getPieceColor(p.getPieceID()));
			}
			y+= containerSize+pieceBuffer;

		}
		//drawer.drawPiece(offScreenGraphics, p, x, y, level.getPieceColor(p));
		//y+= containerSize+pieceBuffer;	

	}

	/**
	 * Helper method that calls redraw then repaint to continually refresh the screen.
	 * 
	 * @return void
	 */
	public void refresh(){
		redraw();
		repaint();
	}

}
