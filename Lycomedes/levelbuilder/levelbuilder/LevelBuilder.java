package levelbuilder;

import java.awt.EventQueue;

import model.LevelBuilderModel;
import view.BuilderSplashScreen;
import view.BuilderLevelSelect;

public class LevelBuilder {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		LevelBuilderModel m = new LevelBuilderModel();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Load the Splash Screen
					BuilderSplashScreen sc = new BuilderSplashScreen();
					//Sleep
					Thread.sleep(500);
					//Launch into the main builder
					BuilderLevelSelect frame = new BuilderLevelSelect(m);
					//Thread.sleep(500);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
