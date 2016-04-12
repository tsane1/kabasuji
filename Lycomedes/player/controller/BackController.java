package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import supers.Application;
import supers.Model;

public class BackController implements ActionListener {
	private Application view;
	private Model model;
		
	public BackController(Application view, Model m) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Back button pressed!");
	}
}
