package tests.views;

import junit.framework.TestCase;
import kabasuji.entities.PuzzleLevel;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelEndView;
import kabasuji.views.LevelPlaySelectView;

public class TestLevelEndViewJHuman extends TestCase {
	SuperModel sm;
	PuzzleLevel pl;

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
		LevelEndView lpsv = new LevelEndView(sm);
		lpsv.populate();
		lpsv.installControllers();
		lpsv.refresh();
		assertEquals("LevelEnd", lpsv.getName());
	}

}
