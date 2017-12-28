package techProgr;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SecondPanel {

	private JFrame frame;
	private ICallBack scb;
	
	public SecondPanel(ICallBack scb) {
		initialize();
		this.scb = scb;
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 681, 278);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panelka panel = new Panelka();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(142, 11, 382, 217);
		frame.getContentPane().add(panel);
		
		MagicLabel lblNewLabel = new MagicLabel("");
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(534, 22, 46, 26);
		lblNewLabel.setOpaque(true);
		frame.getContentPane().add(lblNewLabel);
		
		MagicLabel label = new MagicLabel("");
		label.setBackground(Color.GREEN);
		label.setBounds(590, 22, 46, 26);
		label.setOpaque(true);
		frame.getContentPane().add(label);
		
		MagicLabel label_1 = new MagicLabel("");
		label_1.setOpaque(true);
		label_1.setBackground(Color.YELLOW);
		label_1.setBounds(534, 59, 46, 26);
		frame.getContentPane().add(label_1);
		
		MagicLabel label_2 = new MagicLabel("");
		label_2.setOpaque(true);
		label_2.setBackground(Color.ORANGE);
		label_2.setBounds(590, 59, 46, 26);
		frame.getContentPane().add(label_2);
		
		MagicLabel label_3 = new MagicLabel("");
		label_3.setOpaque(true);
		label_3.setBackground(Color.RED);
		label_3.setBounds(534, 96, 46, 26);
		frame.getContentPane().add(label_3);
		
		MagicLabel label_4 = new MagicLabel("");
		label_4.setOpaque(true);
		label_4.setBackground(Color.CYAN);
		label_4.setBounds(590, 96, 46, 26);
		frame.getContentPane().add(label_4);
		
		MagicLabel label_5 = new MagicLabel("");
		label_5.setOpaque(true);
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(534, 133, 46, 26);
		frame.getContentPane().add(label_5);
		
		MagicLabel label_6 = new MagicLabel("");
		label_6.setOpaque(true);
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(590, 133, 46, 26);
		frame.getContentPane().add(label_6);
		
		MagicLabel label_7 = new MagicLabel("MotorShip");
		label_7.setText("SimpleUFO");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(23, 11, 73, 48);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		label_7.setBorder(border);
		frame.getContentPane().add(label_7);
		
		MagicLabel lblUltraship = new MagicLabel("UltraShip");
		lblUltraship.setText("MegaUFO");
		lblUltraship.setHorizontalAlignment(SwingConstants.CENTER);
		lblUltraship.setBounds(23, 70, 73, 48);
		lblUltraship.setBorder(border);
		frame.getContentPane().add(lblUltraship);
		
		JButton btnNewButton = new JButton("\u041E\u041A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(scb != null) {
					if(panel.getUFO()!=null) {
						scb.takeUFO(panel.getUFO());
					}
				}
				frame.dispose();
			}
		});
		btnNewButton.setBounds(23, 136, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(23, 170, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
		
		
	}
}