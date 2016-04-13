package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import supers.Application;
import supers.Model;
import view.LevelSelectView;
import view.LevelView;

public class SelectLevelController implements ActionListener {
	private Application view;
	private Model model;
		
	public SelectLevelController(Application view, Model m) {
		this.view = view;
		this.model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println();
	}
	
}
