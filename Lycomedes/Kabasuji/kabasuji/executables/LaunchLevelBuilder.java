package kabasuji.executables;

import kabasuji.supers.Application;

import java.awt.EventQueue;

import kabasuji.supers.Application;
import kabasuji.supers.SuperModel;
import kabasuji.views.BuilderSplashScreen;
import kabasuji.views.LevelEditSelectView;
import kabasuji.views.LevelPlayView;

public class LaunchLevelBuilder {

	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		SuperModel m = new SuperModel();
		Thread t1;
		
		final BuilderSplashScreen sc = new BuilderSplashScreen();

		t1 = new Thread(new Runnable() {
			public void run() {
				try {
					sc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});  

		t1.start();
		Thread.sleep(3200);
		sc.setVisible(false);
		sc.dispose();
		Application frame = new Application(new LevelEditSelectView(m));
		frame.setVisible(true);
	}
}

