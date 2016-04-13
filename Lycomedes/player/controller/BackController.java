package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import supers.Application;
import supers.Model;
import view.LevelSelectView;
import view.LevelView;

public class BackController implements ActionListener {
	private Application view;
	private Model model;
		
	public BackController(Application view, Model m) {
		this.view = view;
		this.model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(view.getCurrentScreenID().contains(":")) {
			view.getContentPane().removeAll();
			view.getContentPane().repaint();
			view.paintScreen(new LevelSelectView());
		}
		else if(view.getCurrentScreenID().equals("Select a Level")); 
	}
}
