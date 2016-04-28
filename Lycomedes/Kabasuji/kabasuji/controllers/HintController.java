package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;

public class HintController implements ActionListener{

	Application app;
	SuperModel sm;
	
	public HintController(Application a, SuperModel sm) {
		this.app = a;
		this.sm = sm;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			showHint();
		}
		catch(Exception ex){
			System.err.println("EXCEPTION CAUGHT : FlipXController");
			ex.printStackTrace();
		}
	}

	private void showHint() {
		// TODO Auto-generated method stub
		
	}

}
