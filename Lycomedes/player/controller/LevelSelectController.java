package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Level;
import supers.Application;
import supers.Model;
import supers.Screen;
import view.LevelSelectView;
import view.LevelView;

public class LevelSelectController implements ActionListener {
	private Screen screen;
	private Model model;
		
	public LevelSelectController(Screen s, Model m) {
		this.screen = s;
		this.model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
