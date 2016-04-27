package kabasuji.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.Piece;
import kabasuji.moves.PaletteToBullpenMove;
import kabasuji.supers.Level;
import kabasuji.supers.Move;
import kabasuji.supers.SuperModel;
import kabasuji.views.BullpenView;


public class SelectPieceController extends MouseAdapter{
	
	Level currLevel;
	BullpenView bullpenView;
	
	public SelectPieceController(Level l, BullpenView view){
		this.currLevel = l;
		this.bullpenView = view;
	}
	
	public void mousePressed(MouseEvent me) {
		int idx = 0;
		for(Piece p : bullpenView.getPiecesInBullpen())
		{
			if(p.contains(me.getX(), idx))
			{
				if (currLevel.getSelected() == currLevel.getBullpen().getPieces().get(idx)) {
					currLevel.setSelected(null); // deselect
				}
				else {
					Piece temp = currLevel.getBullpen().getPieces().get(idx);
					currLevel.setSelected(temp);
					System.out.println("Selected Piece: " + temp.getPieceName());
				}
				bullpenView.refresh();
				return;
			}
			idx++;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent me){
		if(currLevel.getSelected() == null) { return; }

		if(me.getClickCount() == 2){
			System.out.println("Made it...You double clicked");
			Move m = new PaletteToBullpenMove(currLevel, currLevel.getSelected());
			m.execute();
		}

		bullpenView.refresh();
		if(currLevel.getBullpen().isEmpty()){
			System.out.println("Bullpen empty");
		}
		else {
			for(Piece p: currLevel.getBullpen().getPieces()){
				System.out.println("Size of Bullpen:" + currLevel.getBullpen().numPiecesInBullpen());
			}
		}
	}
	
	
	
}

