package kabasuji.views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

import kabasuji.entities.Bullpen;
import kabasuji.entities.Piece;
import kabasuji.supers.SuperModel;

/**
 * View class for the bullpen which displays the pieces.
 * 
 * @author Derek McMaster
 */

public class BullpenView extends JPanel {
	
	/**
	 * serial version id from eclipse.
	 */
	private static final long serialVersionUID = -4329058249074751161L;
	
	/** specific bullpen instance associated with the view. */
	Bullpen bullpen;
	
	private final int containerSize = 192; //tilesize*6
	private final int pieceBuffer = 8;
	
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;
	
	public BullpenView(Bullpen bullpen) {
		super();
		this.bullpen = bullpen;
	}

	
	@Override
	public Dimension getMinimumSize(){
		int height = containerSize + (2*pieceBuffer);
		int width = containerSize + (2*pieceBuffer);
		
		return new Dimension(width, height);
	}
	
	@Override
	public Dimension getPreferredSize() {
		int height = containerSize + (2*pieceBuffer);
		int width = pieceBuffer + (3*(pieceBuffer+containerSize));

		return new Dimension (width, height);
	}
	/**
	 * Override method to paint the pieces
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(offScreenImage == null) {
			redraw();
		}
		if(offScreenImage == null) {
			System.err.println("Paint component method: bullpenview class");
		}
		g.drawImage(offScreenImage, 0, 0, this);
	}
	
	public void redraw() {
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
		
		// HERE
		
		// 1. draw each piece at proper location
		// 2. offset after each one is drawn
		for (Piece p : bullpen.getPieces()) {
			
		}
		
	}
	
	public void refresh(){
		redraw();
		repaint();
	}
}
