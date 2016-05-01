package kabasuji.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;
import kabasuji.supers.Screen;
import kabasuji.views.LevelEditSelectView;
import kabasuji.views.LevelPlaySelectView;
import kabasuji.views.LevelPlayView;

/** 
 * 
 * test again
 *
 */
public class BackController implements ActionListener {
	private SuperModel model;
	private Application app;
		
	public BackController(Application a, SuperModel m) {
		this.app = a;
		this.model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(app.getCurrScreen().getName()) {
		case "LevelPlaySelect": case "LevelEditSelect": 
			app.setVisible(false);
			app.dispose();
			break;
		case "LevelPlay": case "LevelEnd":
			if(app.getCurrScreen().getLevel().getLevelType().equals("Lightning")) ((LevelPlayView)app.getCurrScreen()).stopTimer();
			app.setCurrScreen(new LevelPlaySelectView(model));
			break;
		case "LightningLevelEditView": case "PuzzleLevelEditView": case "ReleaseLevelEditView": case "NewLevelTypeSelectView": 
			app.setCurrScreen(new LevelEditSelectView(model));
			break;
		default:
				System.out.println("Error 404: Screen not found.");
		}
	}
}
