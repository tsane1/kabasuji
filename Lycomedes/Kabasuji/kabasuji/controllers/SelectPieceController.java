package kabasuji.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.Piece;
import kabasuji.supers.SuperModel;
import kabasuji.views.BullpenView;


public class SelectPieceController extends MouseAdapter{
	
	SuperModel model;
	BullpenView view;
	
	public SelectPieceController(SuperModel model, BullpenView view){
		this.model = model;
		this.view = view;
	}
	
	public void mousePressed(MouseEvent me) {
//		int idx = 0;
//		for(Polygon p : view.getPolygonPieces()) {
//			if(p.contains(me.getPoint())) {
//				if(model.getSelected() == model.getAllPieces().get(idx)){
//					model.setSelectedPiece(null);
//				}
//				else { 
//					Piece selected = model.getAllPieces().get(idx);
//					
//					for(PlayedPiece pp : model.getPlayedPieces()) {
//						if(pp.getPiece() == selected) {
//							model.setSelectedPiece(null);
//						}
//					}
//					model.setSelectedPiece(selected);
//				}
//				view.refresh();
//				return;
//			}
//			idx++;
//		}
	}
	
	
	
}

