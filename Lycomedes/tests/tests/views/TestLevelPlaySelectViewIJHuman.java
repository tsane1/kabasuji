package tests.views;

import junit.framework.TestCase;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelPlaySelectView;

public class TestLevelPlaySelectViewIJHuman extends TestCase {
	SuperModel sm;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		sm = new SuperModel();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testLevelPlaySelectView(){
		LevelPlaySelectView lpsv = new LevelPlaySelectView(sm);
		lpsv.populate();
		lpsv.installControllers();
		lpsv.refresh();
		assertEquals("LevelEditSelect", lpsv.getName());
	}

}
