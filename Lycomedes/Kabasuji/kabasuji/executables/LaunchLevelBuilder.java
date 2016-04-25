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
		//edit s
		Thread t1;
		Thread t2;

		t1 = new Thread(new Runnable() {
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
					//wait(50);
					
					
					//wait(); //action not allowed inside definition??
					sc.setVisible(false);
                    sc.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
		     }
		});  
		
		t2 = new Thread(new Runnable() {
		     public void run() {
		          // code goes here.
		 		try {
					Application frame = new Application(new LevelEditSelectView(m));
					frame.setVisible(false);
					
					
					//wait(); // whyyyyyyyyyyyyyy..
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		     }
		});
		


		t1.start();
		t2.start();
		//t1.sleep(500);
//		t1.notify();
//		t2.notify();
//		t1.notifyAll(); // fook-a-niggs
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

