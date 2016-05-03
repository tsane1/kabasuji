package tests.views;

import java.awt.Point;

import junit.framework.TestCase;
import kabasuji.entities.LightningLevel;
import kabasuji.entities.Piece;
import kabasuji.entities.PieceTile;
import kabasuji.entities.Progress;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseLevel;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.Screen;
import kabasuji.supers.SuperModel;
import kabasuji.views.LevelEditSelectView;
import kabasuji.views.LevelPlaySelectView;
import kabasuji.views.LightningLevelEditView;
import kabasuji.views.PuzzleLevelEditView;
import kabasuji.views.ReleaseLevelEditView;

public class TestLevelSelectEditView extends TestCase {
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
		LevelEditSelectView lesv = new LevelEditSelectView(sm);
		lesv.populate();
		lesv.installControllers();
		lesv.refresh();
		assertEquals("LevelEditSelect", lesv.getName());
	}

}
