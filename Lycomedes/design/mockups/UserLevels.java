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

public class UserLevels extends AppView {

	/**
	 * 
	 */
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLevels window = new UserLevels();
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
	public UserLevels() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 524, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextPane txtpnKabasuji = new JTextPane();
		txtpnKabasuji.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtpnKabasuji.setText("Kabasuji");
		
		JTextPane txtpnGameMode = new JTextPane();
		txtpnGameMode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtpnGameMode.setText("User Levels");
		
		JButton btnNewButton = new JButton("Game Mode");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Michael\\Pictures\\Saved Pictures\\forward arrow.JPG"));
		btnNewButton.setToolTipText("Go back to game mode");
		
		JButton btnNewButton_1 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t1");
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		
		JButton button = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t2");
		
		JButton button_1 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t3");
		
		JButton button_2 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t4");
		
		JButton button_3 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t5");
		
		JButton button_4 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t6");
		
		JButton button_5 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t7");
		
		JButton button_6 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t8");
		
		JButton button_7 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t9");
		
		JButton button_8 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t10");
		
		JButton button_9 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t11");
		
		JButton button_10 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t12");
		
		JButton button_11 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t13");
		
		JButton button_12 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t14");
		
		JButton button_13 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t15");
		
		JButton button_14 = new JButton("");
		button_14.setIcon(new ImageIcon("C:\\Users\\Michael\\Pictures\\Saved Pictures\\back arrow.JPG"));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
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
							.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
							.addGap(5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_14, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(104)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addComponent(txtpnGameMode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtpnKabasuji, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(51, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(51, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(txtpnKabasuji, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtpnGameMode, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(21)
									.addComponent(button_14, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
							.addGap(81)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
								.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(169)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
