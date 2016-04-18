package kabasuji.executables;

import java.awt.EventQueue;

import kabasuji.supers.Model;
import kabasuji.views.BuilderSplashScreen;
import kabasuji.views.LevelEditSelectView;

public class LaunchLevelBuilder {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Model m = new Model();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Load the Splash Screen
					BuilderSplashScreen sc = new BuilderSplashScreen();
					//Sleep
					//Thread.sleep(500);
					//Launch into the main builder
					LevelEditSelectView frame = new LevelEditSelectView(m);
					//Thread.sleep(500);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

