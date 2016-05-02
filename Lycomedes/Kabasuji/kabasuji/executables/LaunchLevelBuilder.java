package kabasuji.executables;

import kabasuji.supers.Application;

import java.awt.EventQueue;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;
import kabasuji.views.BuilderSplashScreen;
import kabasuji.views.LevelEditSelectView;
import kabasuji.views.LevelPlayView;

/**
 * Class for launching the level builder entity of Kabasuji.
 * @author Ian Jacoway - threading
 */
public class LaunchLevelBuilder {

	/**
	 * Launch the Builder application.
	 * @throws InterruptedException
	 * @author Ian
	 * @author Tanuj
	 */
	public static void main(String[] args) throws InterruptedException {

		SuperModel m = new SuperModel();
		final BuilderSplashScreen sc = new BuilderSplashScreen();


		Thread t = new Thread(new Runnable() {

			public void run() {
				try {
					sc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});  

		t.start();
		Thread.sleep(3200);
		sc.setVisible(false);
		sc.dispose();
		Application frame = new Application(new LevelEditSelectView(m));
		frame.setVisible(true);
	}
}

