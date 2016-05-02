package tests.views;

import junit.framework.TestCase;
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
	protected void setUp(){
		SuperModel sm = new SuperModel();
		sm.setActiveLevel(new PuzzleLevel("Test"));
		((PuzzleLevel)sm.getActiveLevel()).setMovesLeft(10);
		play = new LevelPlayView("test", sm);
		app = new Application(play);
		app.setVisible(true);
		
	}
	
	protected void tearDown(){
		app.setVisible(false);
		app.dispose();
	}

	public void testViews(){
		
//		assertTrue(app.getCurrScreen().getLevel().getBoard().createBoardTile(0, 0, "Puzzle"));
//		assertTrue(app.getCurrScreen().getLevel().getBoard().createBoardTile(1, 1, "Lightning"));
//		assertTrue(app.getCurrScreen().getLevel().getBoard().createBoardTile(1, 1, "Release"));
//		
//		assertTrue(app.getCurrScreen().getBoardView() != null);
//		assertFalse(app.getCurrScreen().getPaletteView() != null);
//		assertTrue(app.getCurrScreen().getBullpenView() != null);
		
	}
}
