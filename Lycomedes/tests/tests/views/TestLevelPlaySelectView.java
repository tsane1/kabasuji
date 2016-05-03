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
import kabasuji.views.LevelPlaySelectView;
import kabasuji.views.LightningLevelEditView;
import kabasuji.views.PuzzleLevelEditView;
import kabasuji.views.ReleaseLevelEditView;

public class TestLevelPlaySelectView extends TestCase {
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
