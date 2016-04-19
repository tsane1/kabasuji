package kabasuji.controllers;

import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kabasuji.entities.Piece;
import kabasuji.entities.PlayedPiece;
import kabasuji.supers.Model;
import kabasuji.views.BullpenView;


public class SelectPieceController extends MouseAdapter{
	
	Model model;
	BullpenView view;
	
	public SelectPieceController(Model model, BullpenView view){
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

