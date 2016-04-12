package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import model.LevelBuilderModel;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuilderScreen extends JFrame {

	LevelBuilderModel model;
	MainBuilderScreen prevScreen;
	
	private JPanel contentPane;

	/**
	 * Launch the application. This is evidently not needed as we will launch from the main screen
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuilderScreen frame = new BuilderScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public BuilderScreen(LevelBuilderModel m) {
		this.model = m;
		
		initWindow();
		populate();
	}
	
	private void initWindow() {
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setTitle("Kabasuji");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKabasuji = new JLabel("Level Builder");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setForeground(SystemColor.textHighlight);
		lblKabasuji.setFont(new Font("Kristen ITC", Font.BOLD, 32));
		lblKabasuji.setBounds(350, 13, 249, 97);
		contentPane.add(lblKabasuji);
		
	}
	
	private void populate() {
		JPanel board = new JPanel();
		board.setBounds(283, 125, 384, 384);
		contentPane.add(board);
		
		JPanel bullpen = new JPanel();
		bullpen.setBounds(12, 522, 908, 218);
		contentPane.add(bullpen);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Kristen ITC", Font.PLAIN, 12));
		tabbedPane.setBounds(673, 38, 250, 484);
		contentPane.add(tabbedPane);
		
		JPanel puzzle = new JPanel();
		puzzle.setBackground(Color.WHITE);
		tabbedPane.addTab("Puzzle", null, puzzle, null);
		tabbedPane.setForegroundAt(0, new Color(255, 0, 0));
		tabbedPane.setBackgroundAt(0, SystemColor.textHighlight);
		
		JLabel label = new JLabel("Puzzle Level Builder");
		label.setBounds(20, 20, 210, 33);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(31, 103, 188, 41);
		
		JLabel label_1 = new JLabel("Total Number of Moves:");
		label_1.setBounds(31, 57, 188, 28);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		puzzle.setLayout(null);
		puzzle.add(label);
		puzzle.add(formattedTextField);
		puzzle.add(label_1);
		
		JPanel lightning = new JPanel();
		lightning.setBackground(Color.WHITE);
		tabbedPane.addTab("Lightning", null, lightning, null);
		tabbedPane.setForegroundAt(1, new Color(255, 215, 0));
		
		JLabel label_2 = new JLabel("Lightning Level Builder");
		label_2.setBounds(10, 20, 230, 25);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(255, 215, 0));
		label_2.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		
		JLabel label_3 = new JLabel("Total Time Allowed (in seconds):");
		label_3.setBounds(8, 57, 234, 20);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		lightning.setLayout(null);
		lightning.add(label_2);
		lightning.add(label_3);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(31, 103, 188, 41);
		lightning.add(formattedTextField_1);
		
		JPanel release = new JPanel();
		release.setBackground(Color.WHITE);
		tabbedPane.addTab("Release", null, release, null);
		tabbedPane.setForegroundAt(2, new Color(50, 205, 50));
		
		JLabel label_4 = new JLabel("4");
		label_4.setBounds(130, 256, 27, 25);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_5 = new JLabel("5");
		label_5.setBounds(167, 256, 27, 25);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_6 = new JLabel("6");
		label_6.setBounds(204, 256, 27, 25);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_7 = new JLabel("4");
		label_7.setBounds(130, 288, 27, 25);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(new Color(0, 128, 0));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_8 = new JLabel("5");
		label_8.setBounds(167, 288, 27, 25);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(new Color(0, 128, 0));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_9 = new JLabel("3");
		label_9.setBounds(93, 320, 27, 25);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(new Color(255, 215, 0));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_10 = new JLabel("4");
		label_10.setBounds(130, 320, 27, 25);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(new Color(255, 215, 0));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_11 = new JLabel("5");
		label_11.setBounds(167, 320, 27, 25);
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(new Color(255, 215, 0));
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_12 = new JLabel("6");
		label_12.setBounds(204, 320, 27, 25);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(new Color(255, 215, 0));
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_13 = new JLabel("6");
		label_13.setBounds(204, 288, 27, 25);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(new Color(0, 128, 0));
		label_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_14 = new JLabel("1");
		label_14.setBounds(19, 256, 27, 25);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(Color.RED);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_15 = new JLabel("2");
		label_15.setBounds(56, 256, 27, 25);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setForeground(Color.RED);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_16 = new JLabel("3");
		label_16.setBounds(93, 256, 27, 25);
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.RED);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_17 = new JLabel("1");
		label_17.setBounds(19, 288, 27, 25);
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setForeground(new Color(0, 128, 0));
		label_17.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_18 = new JLabel("2");
		label_18.setBounds(56, 288, 27, 25);
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setForeground(new Color(0, 128, 0));
		label_18.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_19 = new JLabel("3");
		label_19.setBounds(93, 288, 27, 25);
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setForeground(new Color(0, 128, 0));
		label_19.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_20 = new JLabel("1");
		label_20.setBounds(19, 320, 27, 25);
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setForeground(new Color(255, 215, 0));
		label_20.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_21 = new JLabel("2");
		label_21.setBounds(56, 320, 27, 25);
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setForeground(new Color(255, 215, 0));
		label_21.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_22 = new JLabel("Pieces To Place");
		label_22.setBounds(57, 223, 136, 20);
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		
		JLabel label_23 = new JLabel("Release Level Builder");
		label_23.setBounds(20, 20, 210, 25);
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setForeground(new Color(50, 205, 50));
		label_23.setFont(new Font("Kristen ITC", Font.BOLD, 18));
		
		JLabel label_24 = new JLabel("Total Allowed Moves:");
		label_24.setBounds(46, 57, 158, 20);
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		release.setLayout(null);
		release.add(label_4);
		release.add(label_5);
		release.add(label_6);
		release.add(label_7);
		release.add(label_8);
		release.add(label_9);
		release.add(label_10);
		release.add(label_11);
		release.add(label_12);
		release.add(label_13);
		release.add(label_14);
		release.add(label_15);
		release.add(label_16);
		release.add(label_17);
		release.add(label_18);
		release.add(label_19);
		release.add(label_20);
		release.add(label_21);
		release.add(label_22);
		release.add(label_23);
		release.add(label_24);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(31, 103, 188, 41);
		release.add(formattedTextField_2);
		
		JButton button = new JButton("Save Level");
		button.setBounds(34, 34, 115, 37);
		contentPane.add(button);
		button.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		
		JButton BackBtn = new JButton("Back");
		BackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BackBtn.setBounds(34, 85, 115, 37);
		contentPane.add(BackBtn);
	}
	

	public void setPreviousFrame(MainBuilderScreen screen) {
		prevScreen = screen;
	}

	public MainBuilderScreen getPreviousFrame() {
		return prevScreen;
	}
	
}
