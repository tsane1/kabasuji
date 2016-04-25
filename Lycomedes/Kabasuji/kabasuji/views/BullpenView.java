package kabasuji.views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import kabasuji.entities.Bullpen;
import kabasuji.entities.Piece;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.entities.PieceDrawer;
import kabasuji.entities.PieceTile;

/**
 * View class for the bullpen which displays the pieces.
 * 
 * @author Derek McMaster
 * @author Tanuj Sane
 */

public class BullpenView extends JPanel {
	
	/**
	 * serial version id for bullpenview from eclipse.
	 */
	private static final long serialVersionUID = -4329058249074751161L;
	
	/** drawing object that knows how to draw pieces. */
	PieceDrawer drawer = new PieceDrawer();
	
	Level level;
	
/** containersize global, equal to 6xtilesize or 6x32. */	
	public static final int containerSize = 192;
	/** buffer to separate pieces when drawing. */
	public static final int pieceBuffer = 8;
	
	/** Image object to create the piece images with. */
	Image offScreenImage = null;
	/** Graphics object to paint the images of the pieces. */
	Graphics offScreenGraphics = null;
	
	/**
	 * Constructor for the bullpenview. Passed the model and a specific bullpen. 
	 * @param Model model
	 * @param Bullpen bullpen
	 */
	public BullpenView(SuperModel m) {
		super();
		this.level = m.getActiveLevel();
		//this.setBounds(13, 522, 908, 218);
	}
	

	/**
	 * get played pieces method.
	 * @return
	 */
	public List<Piece> getPlayedPieces(){
		return level.getBullpen().getPlayedPieces();
	}
	
	public List<Piece> getPiecesInBullpen() {
		return level.getBullpen().getPieces();
	}
	
	public List<Piece> getAllPieces() {
		return level.getBullpen().getOriginalSet();
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
		int height = containerSize + (2*pieceBuffer);
		int width = pieceBuffer + (level.getBullpen().numPiecesInBullpen()*(pieceBuffer+containerSize));

		return new Dimension (width, height);
	}
	/**
	 * Override method to paint the pieces.
	 * @param Graphics g
	 */
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
		if (level == null) { return; }
		if (level.getBullpen() == null) { return; }
		
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

		if (offScreenImage == null) { return; }

		offScreenGraphics = offScreenImage.getGraphics();

		for (Piece p : level.getBullpen().getOriginalSet()) {
			if(p == level.getSelected()){
				offScreenGraphics.setColor(Color.MAGENTA);
			}
			else{
				boolean played = false;
				for(Piece p2 : level.getBullpen().getPlayedPieces()){
					if(p2.equals(p)){
						played = true;
						break;
					}			
				}
				if(played) {
					offScreenGraphics.setColor(Color.GRAY);
				}
				else {
					offScreenGraphics.setColor(Color.GREEN);
				}
			}
			drawer.drawPiece(offScreenGraphics, p, x, y, level.getPieceColor(p));
			x+= containerSize+pieceBuffer;	
		}
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
