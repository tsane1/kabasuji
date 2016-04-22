package kabasuji.executables;

import kabasuji.supers.Application;

//import java.awt.EventQueue;

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
		//edit s
		Thread t1 = new Thread(new Runnable() {
		     public void run() {
		          // code goes here.
		    	 try {
					//Load the Splash Screen
					BuilderSplashScreen sc = new BuilderSplashScreen();
					//Sleep
					//Thread.sleep(500);
					//Launch into the main builder

					//Thread.sleep(500);
					//frame.setVisible(true);
					wait();
					sc.setVisible(false);
                    sc.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
		     }
		});  
		
		Thread t2 = new Thread(new Runnable() {
		     public void run() {
		          // code goes here.
		 		try {
					Application frame = new Application(new LevelEditSelectView(m));
					frame.setVisible(false);
					notify();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		     }
		});
		
//		private void createFrame() throws HeadlessException {
//		try {
//			Application frame = new Application(new LevelEditSelectView(new Model()));
//			frame.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
		
//		@override //try to stop, end, detonate, destroy t1
//	    public void stop() {
//	        t1 = null;
//	    }


		t1.start();
		t2.start();
//		t1.join();
//		t2.join();
//		t2.wait();
//		t1.notify();
		//t1.interrupt();
//		try { // Attempt to kill t1
//			t1.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		//edit e

//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					//Load the Splash Screen
//					BuilderSplashScreen sc = new BuilderSplashScreen();
//					//Sleep
//					//Thread.sleep(500);
//					//Launch into the main builder
//					LevelEditSelectView frame = new LevelEditSelectView(m);
//					//Thread.sleep(500);
//					//frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

}

