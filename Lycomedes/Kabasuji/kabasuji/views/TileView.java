package kabasuji.views;

import javax.swing.JFrame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import kabasuji.entities.Tile;

public class TileView extends Rectangle{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8850061383392129811L;
	
	int width = Tile.width;
	int height = Tile.height;
	
	public TileView() {
		setWidth(width);
		setHeight(height);
		setFill(Color.AQUAMARINE);
		setStroke(Color.BLACK);
	}

}
