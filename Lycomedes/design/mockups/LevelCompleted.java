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
import javax.swing.JButton;

public class LevelCompleted {

	private JFrame frame;
	private JLabel lblKabasuji;
	private JButton btnPuzzle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelCompleted window = new LevelCompleted();
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
	public LevelCompleted() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblKabasuji = new JLabel("Level 2 Completed");
		lblKabasuji.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblKabasuji.setBounds(143, 14, 145, 40);
		frame.getContentPane().setLayout(null);
		
		btnPuzzle = new JButton("Restart");
		btnPuzzle.setBackground(new Color(0, 153, 255));
		btnPuzzle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPuzzle.setBounds(119, 126, 90, 40);
		frame.getContentPane().add(btnPuzzle);
		frame.getContentPane().add(lblKabasuji);
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.setBounds(210, 126, 90, 40);
		btnNewButton.setToolTipText("sticky gooey fingers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ella illa eh eh");
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("/Users/KaliLine/Documents/Workspace/back.png"));
		btnNewButton_1.setBounds(0, 0, 52, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/Users/KaliLine/Documents/Workspace/Star.png"));
		lblNewLabel.setBounds(150, 66, 59, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("/Users/KaliLine/Documents/Workspace/Star.png"));
		label.setBounds(210, 66, 59, 48);
		frame.getContentPane().add(label);
	}
}
