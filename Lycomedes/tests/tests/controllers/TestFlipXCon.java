package tests.controllers;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import junit.framework.TestCase;
import kabasuji.controllers.AddToBullpenController;
import kabasuji.controllers.FlipXController;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseLevel;
import kabasuji.moves.SelectTileMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;
import kabasuji.views.BullpenView;
import kabasuji.views.LightningLevelEditView;
import kabasuji.views.PuzzleLevelEditView;
import kabasuji.views.ReleaseLevelEditView;
/**
 * Test that a piece can be added to the Bullpen from the Palette.
 * @author Ian Jacoway
 * @since 4/30/16
 * @ERY_1 Didn't get much further than Chase...
 *
 */
public class TestFlipXCon extends TestCase {
	SuperModel sm;
	Screen pls, lls, rls;
	Application app;
	Level pl, ll, rl;
	Point p0, p1, p2, p3, p4, p5, p6;
	Piece testPiece;
	PieceTile[] arr;
	

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		sm = new SuperModel();
		pls = new PuzzleLevelEditView("PuzzleTest", sm);
		lls = new LightningLevelEditView("PuzzleTest", sm);
		rls = new ReleaseLevelEditView("PuzzleTest", sm);
		
		/** set up super model and level*/
		pl = new PuzzleLevel("P_testyd");
		ll = new LightningLevel("L_testyd");
		rl = new ReleaseLevel("R_testyd");
		
		/** Set up a test piece. */
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
		
		/** Set up a test Tiles. */
		testPiece = new Piece(1, arr);
		
		/** Set up Points. */
		p0 = new Point(1,1);
		p1 = new Point(55,1);
		p2 = new Point(70,1);
		p3 = new Point(100,1);
		p4 = new Point(132,1);
		p5 = new Point(164,1);
		p6 = new Point(1, 55);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPressLogic() {
		app = new Application(pls);
		/** Select test Tiles. */
		Move stm0 = new SelectTileMove(pl, p0);
		stm0.execute();
		Move stm1 = new SelectTileMove(pl, p1);
		stm1.execute();
		Move stm2 = new SelectTileMove(pl, p2);
		stm2.execute();
		Move stm3 = new SelectTileMove(pl, p3);
		stm3.execute();
		Move stm4 = new SelectTileMove(pl, p4);
		stm4.execute();
		Move stm5 = new SelectTileMove(pl, p5);
		stm5.execute();
		
		//check that we start empty
		assertTrue(pl.getBullpen().getPieces().isEmpty());
		
		FlipXController plc = new FlipXController(app, pl);
		// create mouse press at (0,0) within the PaletteVew; should Select Piece then double click in BullpenView to place 
		// I'm going to need to go fishing for the point that's actually clicking the piece..
//		MouseEvent press = this.createPressed(scr, scrn.getBullpenView(), 0, 0);
//		scr.getBullpenView().getMouseManager().handleMouseEvent(press);
//		doClick();
//		plc.actionPerformed(btn.doClick());
		
		// double check a piece is added to the bullpen
		List<Piece> pieceArr = pl.getBullpen().getPieces();
		assertEquals(1, pieceArr.size());
	}
}
