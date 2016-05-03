package tests.views;

import junit.framework.TestCase;
import kabasuji.supers.SuperModel;
import kabasuji.views.NewLevelTypeSelectView;

public class TestNewLevelTypeSelectView extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testView(){
		
		SuperModel sm = new SuperModel();
		NewLevelTypeSelectView nv = new NewLevelTypeSelectView(sm);
		
		nv.refresh();
		nv.installControllers();
		nv.populate();
		assertTrue(nv.getName().equals("NewLevelTypeSelectView"));
		
		assertNull(nv.getBoardView());
		assertNull(nv.getBullpenView());
		assertNull(nv.getLevel());
		assertNull(nv.getPaletteView());
	}

}
