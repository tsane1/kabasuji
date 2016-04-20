package kabasuji.executables;

import java.awt.EventQueue;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;
import kabasuji.views.BuilderSplashScreen;
import kabasuji.views.LevelPlay;

public class LaunchLevelBuilder {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		SuperModel m = new SuperModel();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Load the Splash Screen
					BuilderSplashScreen sc = new BuilderSplashScreen();
					//Sleep
					//Thread.sleep(500);
					//Launch into the main builder
					//Application frame = new Application(new LevelPlay("YO", new Model()));
					//Thread.sleep(500);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

