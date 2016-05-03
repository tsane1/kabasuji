package tests.views;

import junit.framework.TestCase;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.PuzzleLevel;
import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelPlayView;

/** 
 * 
 * @author Michael
 *
 */
public class TestLevelPlayPuzzle extends TestCase {
	LevelPlayView play;
	Application app;
	PieceTile[] arr;
	Piece piece;
	protected void setUp(){
		SuperModel sm = new SuperModel();
		sm.setActiveLevel(new PuzzleLevel("Test"));
		((PuzzleLevel)sm.getActiveLevel()).setMovesLeft(10);
		play = new LevelPlayView("test", sm);
		
		play.getLevel().getBoard().createBoardTile(0, 0, "Puzzle");
		play.getLevel().getBoard().createBoardTile(1, 0, "Puzzle");
		play.getLevel().getBoard().createBoardTile(2, 0, "Puzzle");
		play.getLevel().getBoard().createBoardTile(3, 0, "Puzzle");
		play.getLevel().getBoard().createBoardTile(4, 0, "Puzzle");
		play.getLevel().getBoard().createBoardTile(5, 0, "Puzzle");
		
		app = new Application(play);
		app.setVisible(true);
		
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
		
		piece = new Piece(1, arr);
		try {
			Thread.sleep(250);
		} catch (Exception ex) {
			
		}
		
	}
	
	protected void tearDown(){
		app.setVisible(false);
		app.dispose();
	}

	public void testViews(){
//		assertFalse(app.getCurrScreen().getLevel().getBoard().getBoardArray()[0][0].isCovered());
//		assertFalse(app.getCurrScreen().getLevel().getBoard().getBoardArray()[1][0].isCovered());
//		assertFalse(app.getCurrScreen().getLevel().getBoard().getBoardArray()[2][0].isCovered());
//		assertFalse(app.getCurrScreen().getLevel().getBoard().getBoardArray()[3][0].isCovered());
//		assertFalse(app.getCurrScreen().getLevel().getBoard().getBoardArray()[4][0].isCovered());
//		assertFalse(app.getCurrScreen().getLevel().getBoard().getBoardArray()[5][0].isCovered());
		assertTrue(app.getCurrScreen().getLevel().getBoard().place(0, 0, piece));
		app.getCurrScreen().getBoardView().redraw();
//		app.getCurrScreen().getBoardView().repaint();
//		app.getCurrScreen().getBoardView().redraw();
//		assertTrue(app.getCurrScreen().getLevel().getBoard().createBoardTile(0, 0, "Puzzle"));
//		assertTrue(app.getCurrScreen().getLevel().getBoard().createBoardTile(1, 1, "Lightning"));
//		assertTrue(app.getCurrScreen().getLevel().getBoard().createBoardTile(2, 2, "Release"));
//		
//		assertTrue(app.getCurrScreen().getBoardView() != null);
//		assertFalse(app.getCurrScreen().getPaletteView() != null);
//		assertTrue(app.getCurrScreen().getBullpenView() != null);
		app.getCurrScreen().refresh();
//		assertTrue (true);
	}
}
