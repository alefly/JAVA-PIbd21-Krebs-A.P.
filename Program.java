package techProgr;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Program {

	private JFrame frame;
	private MyPanel panel;
	private JFormattedTextField formattedTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Program() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1175, 907);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new MyPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(21, 24, 904, 834);
		frame.getContentPane().add(panel);
		
		JButton bodyColorSwitcher = new JButton("");
		bodyColorSwitcher.setBackground(Color.BLUE);
	bodyColorSwitcher.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		Color tmp = JColorChooser.showDialog(frame, "Выберите цвет", null);
				bodyColorSwitcher.setBackground(tmp);
			}
		});
		bodyColorSwitcher.setBounds(966, 73, 46, 23);
		frame.getContentPane().add(bodyColorSwitcher);
		
		JButton dopColorSwitcher = new JButton("");
		dopColorSwitcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color tmp = JColorChooser.showDialog(frame, "Выберите цвет", null);
dopColorSwitcher.setBackground(tmp);
	}
		});
	dopColorSwitcher.setBackground(Color.BLUE);
		dopColorSwitcher.setBounds(966, 138, 46, 23);
		frame.getContentPane().add(dopColorSwitcher);
		
		JButton btnNewButton = new JButton("UFO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ITechnique s = new UFO(50, 5, 100, bodyColorSwitcher.getBackground());
				panel.setUFO(s);
				panel.repaint();
			}
		});
		btnNewButton.setBounds(935, 209, 214, 51);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CatUFO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ITechnique s = new BombUFO(50, 5, 100, bodyColorSwitcher. getBackground(), true, true, dopColorSwitcher.getBackground());
				panel.setUFO(new BombUFO(50,5,100,bodyColorSwitcher.getBackground(), true,true,dopColorSwitcher.getBackground()));
				panel.repaint();
			}
		});
		btnNewButton_1.setBounds(935, 271, 214, 51);
		frame.getContentPane().add(btnNewButton_1);
		
		SelectPanel panel_1 = new SelectPanel();
				panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0422\u0430\u0440\u0435\u043B\u043A\u0430", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 		panel_1.setBounds(919, 351, 230, 221);
		 		frame.getContentPane().add(panel_1);
		 		panel_1.setLayout(null);
		 		
		 		JPanel panel_2 = new JPanel();
		 		panel_2.setBounds(10, 62, 210, 148);
		 		panel_1.add(panel_2);
		 		
		 		JButton btnNewButton_2 = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setShip(panel.getUFO(Integer.parseInt(formattedTextField.getText())-1));
				panel.repaint();
			}
		});
		btnNewButton_2.setBounds(135, 28, 85, 23);
		 		panel_1.add(btnNewButton_2);
		 		
		 		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		 		label.setBounds(10, 35, 46, 14);
		 		panel_1.add(label);
		 		
		 		formattedTextField = new JFormattedTextField();
		 		formattedTextField.setBounds(66, 29, 46, 20);
		 		panel_1.add(formattedTextField);
		 		
		 		JLabel label_1 = new JLabel("Базовый цвет");
		 		label_1.setBounds(1031, 73, 88, 14);
		 		frame.getContentPane().add(label_1);
		 		
		 		JLabel label_2 = new JLabel("Дополнительный");
		 		label_2.setBounds(1032, 138, 117, 14);
		 		frame.getContentPane().add(label_2);
		 		
		 		JLabel label_3 = new JLabel("  цвет");
		 		label_3.setBounds(1058, 152, 46, 14);
		 		frame.getContentPane().add(label_3);
	}
}