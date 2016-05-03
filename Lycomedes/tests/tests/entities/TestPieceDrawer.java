package tests.entities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import junit.framework.TestCase;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceDrawer;
import kabasuji.entities.PieceTile;
import kabasuji.entities.Tile;

public class TestPieceDrawer extends TestCase {

	Piece testPiece;
	PieceTile[] arr;
	Graphics offScreenGraphics;
	Image offScreenImage;
	JPanel panel = new JPanel();
	
	protected void setUp() throws Exception {
		super.setUp();
		
		/** set up a test piece */
		arr = new PieceTile[6];
		PieceTile pt1 = new PieceTile(0,0);
		arr[0] = pt1;
		PieceTile pt2 = new PieceTile(1,0);
		arr[1] = pt2;
		PieceTile pt3 = new PieceTile(2,0);
		arr[2] = pt3;
		PieceTile pt4 = new PieceTile(3,0);
		arr[3] = pt4;
		PieceTile pt5 = new PieceTile(4,0);
		arr[4] = pt5;
		PieceTile pt6 = new PieceTile(5,0);
		arr[5] = pt6;
		
		testPiece = new Piece(1, arr);
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 400, 400);
		
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPieceDrawer(){
		PieceDrawer pd = new PieceDrawer();
		if (offScreenImage == null) {
			// create on demand
//			Dimension s = getPreferredSize();
			offScreenImage = panel.createImage(200, 200);
			offScreenGraphics = offScreenImage.getGraphics();
		}
		//pd.drawHintPiece(gr, arr);
		
		pd.drawPalettePiece(offScreenGraphics, testPiece, 0, 0, Color.black);
		
		pd.drawPiece(offScreenGraphics, testPiece, 100, 100, Color.gray);
	}

}
