package tests.controllers;

import java.awt.Point;
import junit.framework.TestCase;
import kabasuji.controllers.RotateLeftController;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelPlayView;
import kabasuji.views.LightningLevelEditView;
import kabasuji.views.PuzzleLevelEditView;
import kabasuji.views.ReleaseLevelEditView;
/**
 * Test that a piece can be added to the Bullpen from the Palette.
 * @author Ian Jacoway
 * @since 4/30/16
 *
 */
public class TestRotateLeftCon extends TestCase {
	SuperModel sm;
	Screen pls, lls, rls;
	Application app;
	Level pl, ll, rl;
	Point p0, p1, p2, p3, p4, p5, p6;
	Piece testPiece, flip, changed;
	PieceTile[] arr, arr2;
	

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
		PieceTile pt3 = new PieceTile(1,1);
		arr[2] = pt3;
		PieceTile pt4 = new PieceTile(2,0);
		arr[3] = pt4;
		PieceTile pt5 = new PieceTile(3,0);
		arr[4] = pt5;
		PieceTile pt6 = new PieceTile(4,0);
		arr[5] = pt6;
		
		/** Set up a test Tiles. */
		testPiece = new Piece(1, arr);

		/** Set up a test piece. */
		arr2 = new PieceTile[6];
		PieceTile p1t = new PieceTile(1,0);
		arr2[0] = p1t;
		PieceTile p2t = new PieceTile(2,0);
		arr2[1] = p2t;
		PieceTile p3t = new PieceTile(3,0);
		arr2[2] = p3t;
		PieceTile p4t = new PieceTile(4,1);
		arr2[3] = p4t;
		PieceTile p5t = new PieceTile(4,0);
		arr2[4] = p5t;
		PieceTile p6t = new PieceTile(5,0);
		arr2[5] = p6t;
		
		/** Set up a flip y Tiles. */
		changed = testPiece;
		flip = new Piece(2, arr2);
		
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
		LevelPlayView lpv = new LevelPlayView("PuzzleTest", sm);
//		lpv.populate();
//		lpv.installControllers();
		sm.setActiveLevel(pl);
		pl.setActivePiece(testPiece);
		pl.setSelected(testPiece);
		pl.setSelectedPiece(testPiece);
		app = new Application(pls);
		RotateLeftController plc = new RotateLeftController(app, pl);
		
		lpv.getRotateLeftBtn().addActionListener(new RotateLeftController(app, sm.getActiveLevel()));
		lpv.getRotateLeftBtn().doClick();
		plc.doRotateLeft();
		assertEquals(testPiece, changed);
	}
}
