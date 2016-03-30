package mockups;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class mockupLevel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mockupLevel window = new mockupLevel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mockupLevel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 980, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(290, 84, 384, 384);
		
		Button button = new Button("Restart Level");
		button.setBounds(802, 698, 152, 53);
		button.setIgnoreRepaint(true);
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		button.setBackground(Color.GRAY);
		button.setActionCommand("Restart Level\r\n");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblNewLabel = new JLabel("Level X - Puzzle");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(269, 29, 425, 44);
		lblNewLabel.setFont(new Font("Eras Bold ITC", Font.BOLD | Font.ITALIC, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		Button button_1 = new Button("Back");
		button_1.setBounds(10, 10, 70, 22);
		button_1.setBackground(Color.GRAY);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(123, 515, 717, 128);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setForeground(Color.BLUE);
		lblScore.setBounds(41, 149, 127, 44);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Impact", Font.PLAIN, 24));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(59, 196, 102, 76);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setForeground(Color.BLUE);
		lblTime.setBounds(802, 84, 127, 44);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Impact", Font.PLAIN, 24));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(812, 149, 117, 86);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 707, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 207, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(button_1);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(panel_2);
		frame.getContentPane().add(lblScore);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\John\\Documents\\CS 3431 - Databases\\Window_Builder_Sandbox\\12x12gridedit.jpg"));
		panel.add(lblNewLabel_1);
		frame.getContentPane().add(lblTime);
		frame.getContentPane().add(panel_3);
		frame.getContentPane().add(panel_1);
		frame.getContentPane().add(button);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(812, 292, 117, 76);
		frame.getContentPane().add(panel_4);
		
		JLabel lblRemaining = new JLabel("Remaining Moves\r\n");
		lblRemaining.setForeground(Color.BLUE);
		lblRemaining.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemaining.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRemaining.setBounds(790, 246, 152, 49);
		frame.getContentPane().add(lblRemaining);
	}
}
