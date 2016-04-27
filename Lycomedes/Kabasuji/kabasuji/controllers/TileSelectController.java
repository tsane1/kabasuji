package kabasuji.controllers;


import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import kabasuji.moves.ChangeReleaseNumColorMove;
import kabasuji.moves.IncrementReleaseTileMove;
import kabasuji.moves.SelectTileMove;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;
import kabasuji.views.BoardView;

/**
 * A controller to select tiles as active on a Board with one <+/+/+SUPPOSE TO BE: "LEFT click"+/+/+> click, 
 * up to the following 6 clicks it then increment a number to appear on the tile (for release).
 * @author Ian Jacoway
 */

public class TileSelectController extends MouseAdapter{
	BoardView boardView;
	Level level;
	int rNum = -1, rcNum = -1;
	Point p; //This may be a hassel, it might corrupt the actual p we need
	
	public TileSelectController(SuperModel model, BoardView bv){
		this.boardView = bv;
		this.level = model.getActiveLevel();
	}
	
	public boolean selectTile(Point p){
		Move m = new SelectTileMove(level);

		if(m.execute(p)){ 
			level.trackMove(m);
			boardView.refresh();
			return true;
		}
		return false;
	}

	public boolean incrementRelease(Point p){
		Move m = new IncrementReleaseTileMove(level);

		if(m.execute(p)){ 
			level.trackMove(m);
			rNum = level.getBoard().getReleaseNum(p);
			// "Color" num in tile with paintComponet()?????
			boardView.refresh();
			return true;
		}
		return false;
	}

	public boolean changeNumColor(Point p){
		Move m = new ChangeReleaseNumColorMove(level);

		if(m.execute(p)){ 
			level.trackMove(m);
			rcNum = level.getBoard().getReleaseColor(p);
			// Color num in tile with paintComponet()?????
			boardView.refresh();
			return true;
		}
		return false;
	}
	
//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		
//		Font font = new Font("Comic Sans MS", Font.PLAIN, 28); // 28 size of a Tile -4
//		g.setFont(font);
//		
////		ArrayList<int> rNums = level.getRNums(); // an idea
////		for (int n : rNums) {
//		if(rcNum == -1){ try {
//			throw new Exception("EXCEPTION CAUGHT : TileSelectController: paintComponent(): rcNum = -1");
//		} catch (Exception e) {
//			System.err.println("EXCEPTION CAUGHT : TileSelectController: <<EXCEPTION INCEPTION>>");
//			e.printStackTrace();
//		} }
//		switch (rcNum) {
//			case 1: g.setColor(Color.pink); case 2: g.setColor(Color.red); case 3: g.setColor(Color.orange);
//			case 4: g.setColor(Color.green); case 5: g.setColor(Color.cyan); case 6: g.setColor(Color.blue);
//			default: g.setColor(Color.black);
//				g.drawString(""+rNum, p.x, p.y);
//		}
//	}
	
	@Override
	public void mousePressed(MouseEvent e) {
//		try{ // +++LEFT PRESSED INSIDE BOARD+++
//			// increment a counter in selectTile for every tile being selected that is already selected
//			if((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK){
//				if (e.getSource() == boardView){
//					p = e.getPoint(); // returns the X and Y with respect to the source object (board) yeah!!
//					if (e.getClickCount() == 1){ // will be helpful for incrementing release
//						selectTile(p); 
//					}
//					if (e.getClickCount() > 1){
//						incrementRelease(p);
//					}
//				}
//			} // +++RIGHT PRESSED INSIDE BOARD+++
//			if((e.getModifiers() & InputEvent.BUTTON2_MASK) == InputEvent.BUTTON2_MASK){
//				if (e.getSource() == boardView){
//					Point p = e.getPoint(); // returns the X and Y with respect to the source object (board) yeah!!
////					changeNumColor(p); // How many colors do we want?? Not random right cuz too hard to match to piece
//				}
//			}
//		}
//		catch(Exception ex){
//			System.err.println("EXCEPTION CAUGHT : TileSelectController");
//			ex.printStackTrace();
//		}
		
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		Point clicked = e.getPoint();
		
		if(SwingUtilities.isRightMouseButton(e)){
			changeNumColor(clicked);
		}
		else if(SwingUtilities.isLeftMouseButton(e)){
			if (e.getClickCount() == 1){ // will be helpful for incrementing release
				selectTile(clicked); 
			}
			if (e.getClickCount() > 1){
				incrementRelease(clicked);
			}
		}
		else{
			System.err.println("Button not supported on tile select.");
		}
	}

//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// Do nothing, otherwise releasing dragged pieces will be weird.
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// Do nothing
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// Do nothing
//	}
}


