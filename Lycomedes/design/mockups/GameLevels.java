package mockups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class GameLevels {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameLevels window = new GameLevels();
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
	public GameLevels() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 950, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane txtpnKabasuji = new JTextPane();
		txtpnKabasuji.setForeground(SystemColor.textHighlight);
		txtpnKabasuji.setFont(new Font("Kristen ITC", Font.BOLD, 32));
		txtpnKabasuji.setText("Kabasuji");
		
		JButton btnNewButton = new JButton("User Levels");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Michael\\Pictures\\Saved Pictures\\forward arrow.JPG"));
		btnNewButton.setToolTipText("User levels");
		
		JButton btnNewButton_1 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t1");
		btnNewButton_1.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setBackground(SystemColor.controlLtHighlight);
		
		JButton button = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t2");
		button.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button.setForeground(SystemColor.textHighlight);
		button.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_1 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t3");
		button_1.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_2 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t4");
		button_2.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_2.setForeground(SystemColor.textHighlight);
		button_2.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_3 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t5");
		button_3.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_3.setForeground(SystemColor.textHighlight);
		button_3.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_4 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t6");
		button_4.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_4.setForeground(SystemColor.textHighlight);
		button_4.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_5 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t7");
		button_5.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_5.setForeground(SystemColor.textHighlight);
		button_5.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_6 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t8");
		button_6.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_6.setForeground(SystemColor.textHighlight);
		button_6.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_7 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t9");
		button_7.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_7.setForeground(SystemColor.textHighlight);
		button_7.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_8 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t10");
		button_8.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_8.setForeground(SystemColor.textHighlight);
		button_8.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_9 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t11");
		button_9.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_9.setForeground(SystemColor.textHighlight);
		button_9.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_10 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t12");
		button_10.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_10.setForeground(SystemColor.textHighlight);
		button_10.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_11 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t13");
		button_11.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_11.setForeground(SystemColor.textHighlight);
		button_11.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_12 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t14");
		button_12.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_12.setForeground(SystemColor.textHighlight);
		button_12.setBackground(SystemColor.controlLtHighlight);
		
		JButton button_13 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t15");
		button_13.setFont(new Font("Kristen ITC", Font.BOLD, 16));
		button_13.setForeground(SystemColor.textHighlight);
		button_13.setBackground(SystemColor.controlLtHighlight);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Michael\\Pictures\\Saved Pictures\\back arrow.JPG"));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(285)
					.addComponent(txtpnKabasuji, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(399, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(221)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 465, Short.MAX_VALUE)
							.addGap(246))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnKabasuji, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(124)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
