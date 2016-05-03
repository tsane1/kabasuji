package tests.views;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import junit.framework.TestCase;
import kabasuji.controllers.FlipXController;
import kabasuji.controllers.FlipYController;
import kabasuji.controllers.PaletteSelectController;
import kabasuji.controllers.PlacePieceController;
import kabasuji.controllers.RotateLeftController;
import kabasuji.controllers.RotateRightController;
import kabasuji.controllers.SelectPieceController;
import kabasuji.entities.Board;
import kabasuji.entities.Bullpen;
import kabasuji.entities.Palette;
import kabasuji.entities.PuzzleLevel;
import kabasuji.entities.ReleaseBoardTile;
import kabasuji.supers.Application;
import kabasuji.supers.Level;
import kabasuji.supers.SuperModel;
import kabasuji.views.BoardView;
import kabasuji.views.BullpenView;
import kabasuji.views.LightningLevelEditView;
import kabasuji.views.PaletteView;
import kabasuji.views.PuzzleLevelEditView;
import kabasuji.views.ReleaseLevelEditView;

public class TestLightningEditView extends TestCase {
private JPanel contentPane;
	
	SuperModel sm = new SuperModel("test");
	Level level = new PuzzleLevel("no name");
	JFrame frame = new JFrame();
	LightningLevelEditView play;
	Application a;
	BoardView bView;
	BullpenView bpView;
	Palette pal;
	PaletteView pview;
	
	protected void setUp() throws Exception {
		play = new LightningLevelEditView("Test", sm);
//		Bullpen bp = level.getBullpen();
//		Board board = level.getBoard();
//		Palette pal = level.getPalette();
		a = new Application(play);
		a.setVisible(true);
	}


	protected void tearDown() throws Exception {
		frame.setVisible(false);
		frame.dispose();
	}
	public void testBoardView(){
//		bView.refresh();
//		bpView.refresh();
//		pview.refresh();
	}
}
