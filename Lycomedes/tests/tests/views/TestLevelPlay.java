package tests.views;

import junit.framework.TestCase;
import kabasuji.entities.PuzzleLevel;
import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelEndView;
import kabasuji.views.LevelPlaySelectView;
import kabasuji.views.LevelPlayView;

public class TestLevelPlay extends TestCase {
	SuperModel sm;
	PuzzleLevel pl;
	Application app;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		sm = new SuperModel();
		pl = new PuzzleLevel("Puzzle");
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testLevelPlaySelectView(){
		sm.setActiveLevel(pl);
		assertEquals(0, pl.getNumStars());
		LevelPlayView v = new LevelPlayView(pl.getLevelName(), sm);
		app = new Application(v);
		v.populate();
		v.installControllers();
		v.refresh();
		assertEquals("LevelPlay", v.getName());
	}

}
