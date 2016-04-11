package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class LevelSelect extends JFrame implements ActionListener{

	private JPanel contentPane;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelSelect frame = new LevelSelect();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LevelSelect() {
		initWindow();
		populate();
	}
	
	public JButton getLevelSelectBtn(int i){
		return buttons.get(i);
	}
	public void setAction(){
		for(int i = 0; i<=(buttons.size() - 1); i++){
			JButton btn = buttons.get(i);
			String command = "select level" + i;
			btn.setActionCommand(command);
			btn.addActionListener(this);
		}
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
		
		JLabel lblKabasuji = new JLabel("Kabasuji - Level Selection");
		lblKabasuji.setHorizontalAlignment(SwingConstants.CENTER);
		lblKabasuji.setForeground(SystemColor.textHighlight);
		lblKabasuji.setFont(new Font("Kristen ITC", Font.BOLD, 32));
		lblKabasuji.setBounds(235, 30, 480, 97);
		contentPane.add(lblKabasuji);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 153, 604, 450);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		JButton button = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t1");
		buttons.add(button);
		button.setBackground(new Color(240, 240, 240));
		
		JButton button_1 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t2");
		buttons.add(button_1);
		
		JButton button_2 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t3");
		buttons.add(button_2);
		
		JButton button_3 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t4");
		buttons.add(button_3);
		
		JButton button_4 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t5");
		buttons.add(button_4);
		
		JButton button_5 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t10");
		buttons.add(button_5);
		
		JButton button_6 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t9");
		buttons.add(button_6);
		
		JButton button_7 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t8");
		buttons.add(button_7);
		
		JButton button_8 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t7");
		buttons.add(button_8);
		
		JButton button_9 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t6");
		buttons.add(button_9);
		
		JButton button_10 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t11");
		buttons.add(button_10);
		
		JButton button_11 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t12");
		buttons.add(button_11);
		
		JButton button_12 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t13");
		buttons.add(button_12);
		
		JButton button_13 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t14");
		buttons.add(button_13);
		
		JButton button_14 = new JButton("\t\t\t\t\t\t\t\t\t\t\t\t\t15");
		buttons.add(button_14);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(button_14, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_8, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_7, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button_10, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_11, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_12, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_13, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_14, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		this.setAction();
	}
	
	public void populate() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		LevelScreenTest level = new LevelScreenTest();
		level.setVisible(true);
		
	}
}
