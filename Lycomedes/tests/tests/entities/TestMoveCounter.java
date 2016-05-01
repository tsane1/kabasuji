package tests.entities;

import junit.framework.TestCase;
import kabasuji.entities.MoveCounter;
import kabasuji.entities.PuzzleLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;
/** 
 * 
 * @author Chase St. Laurent
 *
 */
public class TestMoveCounter extends TestCase {
//	SuperModel sm;
//	Screen scr;
//	Application app;
//	Level lvl;
	PuzzleLevel pl;
	MoveCounter mc;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
//		sm = new SuperModel();
		pl = new PuzzleLevel("PuzzleLevel");
		mc = new MoveCounter(pl);
//		app = new Application(scr);
//		scr = app.getCurrScreen();
//		lvl = sm.getActiveLevel();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void TestMoveCounter(){
//	assertTrue();
	assertTrue(mc.isPuzzle(pl));
	assertEquals(0, mc.moveCount());
	}
}
