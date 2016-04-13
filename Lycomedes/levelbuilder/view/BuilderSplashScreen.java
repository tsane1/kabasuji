package view;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import model.LevelBuilderModel;

import javax.swing.*;
import java.awt.Container;

public class BuilderSplashScreen extends JWindow {

	/**
	 * Create the panel.
	 */
	
	 static boolean isRegistered;
	    private static JProgressBar progressBar = new JProgressBar();
	    private static BuilderSplashScreen execute;
	    private static int count;
	    private static Timer timer1;
	    
	public BuilderSplashScreen() {
		getContentPane().setLayout(null);

		Container container = getContentPane();
        container.setLayout(null);
        
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIconTextGap(10);
		lblNewLabel.setIcon(new ImageIcon(BuilderSplashScreen.class.getResource("/imgs/BuilderSplashScreen.png")));
		lblNewLabel.setBounds(0, 0, 900, 700);
		getContentPane().add(lblNewLabel);
		
		progressBar.setMaximum(50);
        progressBar.setBounds(150, 670, 600, 15);
        container.add(progressBar);
        loadProgressBar();
        setSize(900, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        
	}
	
	  private void loadProgressBar() {
	        ActionListener al = new ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                count++;
	                progressBar.setValue(count);
	                System.out.println(count);
	                if (count == 60) {
	                	//createFrame();
	                	setVisible(false);
	                	timer1.stop();
	                }
	            }
	            /*
	            private void createFrame() throws HeadlessException {
	      				try {
	      					BuilderScreen frame = new BuilderScreen(new LevelBuilderModel());
	      					frame.setVisible(true);
	      				} catch (Exception e) {
	      					e.printStackTrace();
	      				}
	      			}
	      			*/
	        };
	        timer1 = new Timer(50, al);
	        timer1.start();
	    }
	    public static void main(String[] args) {
	        execute = new BuilderSplashScreen();
	    }
	  
	  public int splashScreenDelay()
	  {
		  return timer1.getDelay();
	  }
	  
	}
