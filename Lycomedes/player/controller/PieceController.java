package controller;

import java.awt.event.MouseEvent;
import supers.Application;
import supers.Model;

public class PieceController extends java.awt.event.MouseAdapter{
	private Model model;
	private Application app;
	
	public PieceController(Model model, Application app){
		this.model = model;
		this.app = app;	
	}
	
	
	
}
