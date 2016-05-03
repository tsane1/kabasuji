package tests.controllers;

import javax.swing.JButton;

import junit.framework.TestCase;
import kabasuji.controllers.DeleteLevelController;
import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;
import kabasuji.views.PuzzleLevelEditView;

public class TestDeleteLevelController extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void TestCon(){
		SuperModel sm = new SuperModel();
		PuzzleLevelEditView pv = new PuzzleLevelEditView("test", sm);
		pv.populate();
		pv.installControllers();
		Application app = new Application(pv);
		DeleteLevelController dlc = new DeleteLevelController(app, sm);
		
	}
}
