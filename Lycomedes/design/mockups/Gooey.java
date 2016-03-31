package mockups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Gooey {

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
					Gooey window = new Gooey();
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
	public Gooey() {
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
				System.out.println("Ella stella eh eh");
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
