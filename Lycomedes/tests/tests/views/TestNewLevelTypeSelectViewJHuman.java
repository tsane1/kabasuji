package tests.views;

import junit.framework.TestCase;
import kabasuji.entities.PuzzleLevel;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelEndView;
import kabasuji.views.LevelPlaySelectView;
import kabasuji.views.NewLevelTypeSelectView;

public class TestNewLevelTypeSelectViewJHuman extends TestCase {
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
		NewLevelTypeSelectView v = new NewLevelTypeSelectView(sm);
		v.populate();
		v.installControllers();
		v.refresh();
		assertEquals("NewLevelTypeSelectView", v.getName());
	}

}
