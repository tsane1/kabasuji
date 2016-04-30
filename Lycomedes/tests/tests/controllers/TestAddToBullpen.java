package tests.controllers;

import java.awt.event.MouseEvent;
import java.util.List;

import junit.framework.TestCase;
import kabasuji.controllers.AddToBullpenController;
import kabasuji.entities.Piece;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;
import kabasuji.views.BullpenView;
/**
 * Test that a piece can be added to the Bullpen from the Palette.
 * @author Ian Jacoway
 * @since 4/30/16
 * @ERY_1 Didn't get much further than Chase...
 *
 */
public class TestAddToBullpen extends TestCase {
	SuperModel sm;
	Screen scr;
	Application app;
	Level lvl;
	

	@Override
	protected void setUp() {
		sm = new SuperModel();
		app = new Application(scr);
		scr = app.getCurrScreen();
		lvl = sm.getActiveLevel();
	}

	@Override
	protected void tearDown() { 
//		gw.dispose();
	}

	public void testPressLogic() {
		//check that we start empty
		assertTrue(lvl.getBullpen().getPieces().isEmpty());
		
		AddToBullpenController atbp = new AddToBullpenController(app, sm);
		// create mouse press at (0,0) within the PaletteVew; should Select Piece then double click in BullpenView to place 
		// I'm going to need to go fishing for the point that's actually clicking the piece..
//		MouseEvent press = this.createPressed(scr, scrn.getBullpenView(), 0, 0);
//		scr.getBullpenView().getMouseManager().handleMouseEvent(press);
		
		// double check a piece is added to the bullpen
		List<Piece> pieceArr = lvl.getBullpen().getPieces();
		assertEquals(1, pieceArr.size());
	}
}
