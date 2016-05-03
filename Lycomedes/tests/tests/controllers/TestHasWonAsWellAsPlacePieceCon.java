package tests.controllers;

import java.awt.AWTException;
import java.awt.Component;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

import junit.framework.TestCase;
import kabasuji.controllers.HasWonController;
import kabasuji.controllers.PlacePieceController;
import kabasuji.controllers.RotateRightController;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.Progress;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseLevel;
import kabasuji.moves.SelectTileMove;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
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
public class TestHasWonAsWellAsPlacePieceCon extends TestCase {
	SuperModel sm;
	Screen pls, lls, rls;
	Application app;
	Level pl, ll, rl;
	Point p0, p1, p2, p3, p4, p5, p6;
	Piece testPiece, tpcopy, flip, changed;
	PieceTile[] arr, arr2;
	Progress pro;
	

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		sm = new SuperModel();
		pls = new PuzzleLevelEditView("PuzzleTest", sm);
		lls = new LightningLevelEditView("LightningTest", sm);
		rls = new ReleaseLevelEditView("RealeaseTest", sm);
		
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
		tpcopy = new Piece(1, arr);

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

//	public void testPlacePiecePL() throws AWTException {
//		LevelPlayView lpv = new LevelPlayView("PuzzleTest", sm);
////		lpv.populate();
////		lpv.installControllers();
//		sm.setActiveLevel(pl);
//		pl.setActivePiece(testPiece);
//		pl.setSelected(testPiece);
//		pl.setSelectedPiece(testPiece);
//		app = new Application(pls);
//		PlacePieceController ppc = new PlacePieceController(app, sm);
//		
////		Robot bot = new Robot();
////		int mask = InputEvent.BUTTON1_DOWN_MASK;
////		bot.mouseMove(5, 5);           
////		bot.mousePress(mask);     
////		bot.mouseRelease(mask);
//		
////		lpv.getRotateRightBtn().addActionListener(new RotateRightController(app, sm.getActiveLevel()));
////		lpv.getRotateRightBtn().doClick();
////		ppc.mousePressed(mask);
//		pl.getBoard().getProgress("puzzle");
//	}

	public void testPlacePiecePL() throws Exception{
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
		LevelPlayView lpv = new LevelPlayView("PuzzleTest", sm);
//		lpv.populate();
//		lpv.installControllers();
		sm.setActiveLevel(pl);
		pl.setLevelType("Puzzle");
		app = new Application(pls);
		pro = new Progress(pl.getBoard());
		
		pl.getBoard().createBoardTile(0, 0, "Puzzle");
		pl.getBoard().createBoardTile(1, 0, "Puzzle");
		pl.getBoard().createBoardTile(2, 0, "Puzzle");
		pl.getBoard().createBoardTile(3, 0, "Puzzle");
		pl.getBoard().createBoardTile(4, 0, "Puzzle");
		pl.getBoard().createBoardTile(5, 0, "Puzzle");
		
		assertEquals("P_testyd", pl.getLevelName());
		
		// Set test piece as selected FOR REAL who knows which is which
		pl.setActivePiece(testPiece);
		pl.setSelected(testPiece);
		pl.setSelectedPiece(testPiece);
		pl.setDraggingPiece(tpcopy);
		
		PlacePieceController rpc = new PlacePieceController(app, sm);
//		Component source = new Component();
//		MouseEvent me = new MouseEvent(source, int id, long when, int modifiers,
//                      int x, int y, int clickCount, boolean popupTrigger,
//                      int button);
//		MouseEvent me = new MousePress();
		rpc.doPlace(5, 5);
		
		pl.getBoard().place(0, 0, testPiece);
//		assertEquals(100, pl.getBoard().getProgress("puzzle"));
		pl.getBoard().uncoverPieceArea(0, 0, testPiece);
		pl.getBoard().coverPieceArea(0, 0, testPiece);
		assertTrue(pl.getBoard().pieceCovering(0, 0, testPiece));
		
		HasWonController hwc = new HasWonController(app, sm);
		pl.progress = new Progress(pl.getBoard());
		System.out.println(pro.updateProgressPuzzle());
		System.out.print(pl.progress.updateProgressPuzzle());
//		assertTrue(hwc.hasWon());
	}
	
	public void testPlacePieceLL() throws Exception{
		/** Select test Tiles. */
		Move stm0 = new SelectTileMove(ll, p0);
		stm0.execute();
		Move stm1 = new SelectTileMove(ll, p1);
		stm1.execute();
		Move stm2 = new SelectTileMove(ll, p2);
		stm2.execute();
		Move stm3 = new SelectTileMove(ll, p3);
		stm3.execute();
		Move stm4 = new SelectTileMove(ll, p4);
		stm4.execute();
		Move stm5 = new SelectTileMove(ll, p5);
		stm5.execute();
		LevelPlayView lpv = new LevelPlayView("LightningTest", sm);
//		lpv.populate();
//		lpv.installControllers();
		sm.setActiveLevel(ll);
		ll.setLevelType("Lightning");
		app = new Application(lls);
		pro = new Progress(ll.getBoard());
		
		ll.getBoard().createBoardTile(0, 0, "Lightning");
		ll.getBoard().createBoardTile(1, 0, "Lightning");
		ll.getBoard().createBoardTile(2, 0, "Lightning");
		ll.getBoard().createBoardTile(3, 0, "Lightning");
		ll.getBoard().createBoardTile(4, 0, "Lightning");
		ll.getBoard().createBoardTile(5, 0, "Lightning");
		
		assertEquals("L_testyd", ll.getLevelName());
		
		// Set test piece as selected FOR REAL who knows which is which
		ll.setActivePiece(testPiece);
		ll.setSelected(testPiece);
		ll.setSelectedPiece(testPiece);
		
		PlacePieceController rpc = new PlacePieceController(app, sm);
		
		ll.getBoard().place(0, 0, testPiece);
//		assertEquals(100, ll.getBoard().getProgress("lightning"));
		ll.getBoard().uncoverPieceArea(0, 0, testPiece);
		ll.getBoard().coverPieceArea(0, 0, testPiece);
		assertTrue(ll.getBoard().pieceCovering(0, 0, testPiece));
		
		HasWonController hwc = new HasWonController(app, sm);
		ll.progress = new Progress(ll.getBoard());
		System.out.println(pro.updateProgressLightning());
		System.out.print(ll.progress.updateProgressLightning());
//		assertTrue(hwc.hasWon());
	}
	
	public void testPlacePieceRL() throws Exception{
		/** Select test Tiles. */
		Move stm0 = new SelectTileMove(rl, p0);
		stm0.execute();
		Move stm1 = new SelectTileMove(rl, p1);
		stm1.execute();
		Move stm2 = new SelectTileMove(rl, p2);
		stm2.execute();
		Move stm3 = new SelectTileMove(rl, p3);
		stm3.execute();
		Move stm4 = new SelectTileMove(rl, p4);
		stm4.execute();
		Move stm5 = new SelectTileMove(rl, p5);
		stm5.execute();
		LevelPlayView lpv = new LevelPlayView("ReleaseTest", sm);
//		lpv.populate();
//		lpv.installControllers();
		sm.setActiveLevel(rl);
		rl.setLevelType("Release");
		app = new Application(rls);
		pro = new Progress(rl.getBoard());
		
		rl.getBoard().createBoardTile(0, 0, "Release");
		rl.getBoard().createBoardTile(1, 0, "Release");
		rl.getBoard().createBoardTile(2, 0, "Release");
		rl.getBoard().createBoardTile(3, 0, "Release");
		rl.getBoard().createBoardTile(4, 0, "Release");
		rl.getBoard().createBoardTile(5, 0, "Release");
		
		assertEquals("R_testyd", rl.getLevelName());
		
		// Set test piece as selected FOR REAL who knows which is which
		rl.setActivePiece(testPiece);
		rl.setSelected(testPiece);
		rl.setSelectedPiece(testPiece);
		assertTrue(testPiece.contains(0, 0));
		assertTrue(testPiece.containsy(0, 0));
		PlacePieceController rpc = new PlacePieceController(app, sm);
		
//		Robot bot = new Robot();
//		int mask = InputEvent.BUTTON1_DOWN_MASK;
//		bot.mouseMove(5, 5); // this is a point not row/col        
//		bot.mousePress(mask);     
//		bot.mouseRelease(mask);
		
		rl.getBoard().place(0, 0, testPiece);
		assertEquals(100, rl.getBoard().getReleaseProgress());
		rl.getBoard().uncoverPieceArea(0, 0, testPiece);
		rl.getBoard().coverPieceArea(0, 0, testPiece);
		assertTrue(rl.getBoard().pieceCovering(0, 0, testPiece));
		
		HasWonController hwc = new HasWonController(app, sm);
		rl.progress = new Progress(rl.getBoard());
		System.out.println(pro.updateProgressRelease());
		System.out.print(rl.progress.updateProgressRelease());
		assertTrue(hwc.hasWon());
		rl.setNumStars();
		assertEquals(3, rl.getNumStars());
	}
}
