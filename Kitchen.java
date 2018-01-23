package l1Alyona;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerNumberModel;

public class Kitchen {

	private JFrame frame;
	 private Potato[] potatos;

     private Salt salt;

     private Oil oil;

     private WaterTap waterTap;

     private Knife knife;

     private Fryer fryer;

     private int ingr = 0;

     private boolean ready;
     private final ButtonGroup buttonGroup = new ButtonGroup();
     private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kitchen window = new Kitchen();
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
	public Kitchen() {
		initialize();
		waterTap = new WaterTap();
        knife = new Knife();
        fryer = new Fryer();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(85, 30, 64, 20);
		frame.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1.setBounds(85, 56, 64, 20);
		frame.getContentPane().add(spinner_1);
		
		JLabel label = new JLabel("\u041A\u0430\u0440\u0442\u043E\u0448\u043A\u0430");
		label.setBounds(10, 33, 65, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u0421\u043E\u043B\u044C");
		label_1.setBounds(10, 59, 46, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u0418\u043D\u0433\u0440\u0438\u0434\u0438\u0435\u043D\u0442\u044B ");
		label_2.setBounds(38, 8, 100, 14);
		frame.getContentPane().add(label_2);
		
		JRadioButton radioButton = new JRadioButton("\u041E\u0442\u043A\u0440\u044B\u0442");
		buttonGroup.add(radioButton);
		radioButton.setBounds(293, 29, 109, 23);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u0417\u0430\u043A\u0440\u044B\u0442");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(293, 55, 109, 23);
		frame.getContentPane().add(radioButton_1);
		
		JLabel label_3 = new JLabel("\u041A\u0440\u0430\u043D");
		label_3.setBounds(263, 8, 46, 14);
		frame.getContentPane().add(label_3);
		
		JButton button = new JButton("\u041F\u043E\u043C\u044B\u0442\u044C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//ïîìûòü
				if(radioButton.isSelected() == true)
					waterTap.State = true;
				else 
					waterTap.State = false;
				if (Integer.parseInt(spinner.getValue().toString()) > 0)
	            {
	                if (!waterTap.State)
	                {
	                	JOptionPane.showMessageDialog(null, "Êðàí çàêðûò, êàê ìûòü?");
	                    return;
	                }
	                potatos = new Potato[Integer.parseInt(spinner.getValue().toString())];
	                fryer.Init(Integer.parseInt(spinner.getValue().toString()));
	                for (int i = 0; i < potatos.length; ++i)
	                {
	                    potatos[i] = new Potato();
	                }
	                for (int i = 0; i < potatos.length; ++i)
	                {
	                    potatos[i].Dirty(0);
	                }
	                JOptionPane.showMessageDialog(null, "Êàðòîøêó ïîìûëè, ìîæíî ÷èñòèòü");
	            }
	            else
	            {
	            	JOptionPane.showMessageDialog(null, "Êàðòîøêè òî íåò, ÷òî ìûòü?");
	            }
			}
		});
		button.setBounds(198, 30, 89, 43);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u041F\u043E\u0447\u0438\u0441\u0442\u0438\u0442\u044C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//ïî÷èñòèòü
				if (potatos == null)
	            {
					JOptionPane.showMessageDialog(null, "Êàðòîøêè òî íåò, ÷òî ÷èñòèòü?");
	                return;
	            }
	            if (potatos.length == 0)
	            {
	            	JOptionPane.showMessageDialog(null, "Êàðòîøêè òî íåò, ÷òî ÷èñòèòü?");
	                return;
	            }
	            for (int i = 0; i < potatos.length; ++i)
	            {
	                if (potatos[i].dirty > 0)
	                {
	                	JOptionPane.showMessageDialog(null, "Êàðòîøêà ãðÿçíàÿ!!! Ïîìûòü áû åå ñíà÷àëà, à óæ ïîòîì ÷èñòèòü");
	                    return;
	                }
	            }
	            for (int i = 0; i < potatos.length; ++i)
	            {
	                knife.Clean(potatos[i]);
	            }
	            JOptionPane.showMessageDialog(null, "Êàðòîøêó î÷èñòèëè, ìîæíî ðåçàòü");

			}
		});
		button_1.setBounds(419, 29, 89, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u041F\u043E\u0440\u0435\u0437\u0430\u0442\u044C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//ïîðåçàòü
				if (potatos == null)
	            {
					JOptionPane.showMessageDialog(null, "Êàðòîøêè òî íåò, ÷òî ðåçàòü?");
	                return;
	            }
	            if (potatos.length == 0)
	            {
	            	JOptionPane.showMessageDialog(null, "Êàðòîøêè òî íåò, ÷òî ðåçàòü?");
	                return;
	            }
	            for (int i = 0; i < potatos.length; ++i)
	            {
	                if (potatos[i].dirty > 0)
	                {
	                	JOptionPane.showMessageDialog(null, "Êàðòîøêà ãðÿçíàÿ!!! Ïîìûòü áû åå ñíà÷àëà, à óæ ïîòîì ðåçàòü");
	                    return;
	                }
	            }
	            for (int i = 0; i < potatos.length; ++i)
	            {
	                knife.Cut(potatos[i]);
	            }
	            JOptionPane.showMessageDialog(null, "Êàðòîøêó ïîðåçàëè, ìîæíî äîáàâëÿòü â ôðèòþðíèöó");
	        }
		});
		button_2.setBounds(419, 55, 89, 23);
		frame.getContentPane().add(button_2);
		
		JLabel label_4 = new JLabel("\u041D\u043E\u0436");
		label_4.setBounds(448, 8, 46, 14);
		frame.getContentPane().add(label_4);
		
		JButton button_3 = new JButton("\u041D\u0430\u043B\u0438\u0442\u044C \u043C\u0430\u0441\u043B\u043E");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//ìàñëî
				oil = new Oil();
	            fryer.AddOil(oil);
	            ingr += 5;
	            JOptionPane.showMessageDialog(null, "Ìàñëî äîáàâèëè");
	           
			}
		});
		button_3.setBounds(109, 152, 147, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043A\u0430\u0440\u0442\u043E\u0448\u043A\u0443");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//êàðòîøêà
				if (potatos == null)
	            {
					JOptionPane.showMessageDialog(null, "Êàðòîøêè òî íåò, ÷òî æàðèòü ñîáðàëèñü?");
	                return;
	            }
	            if (potatos.length == 0)
	            {
	            	JOptionPane.showMessageDialog(null, "Êàðòîøêè òî íåò, ÷òî æàðèòü ñîáðàëèñü?");
	                return;
	            }
	            for (int i = 0; i < potatos.length; ++i)
	            {
	                if (potatos[i].dirty > 0)
	                {
	                	JOptionPane.showMessageDialog(null, "Êàðòîøêà ãðÿçíàÿ!!! Êàê åå æàðèòü, à íó ìûòü åå áûñòðî!");
	                    return;
	                }
	                if (potatos[i].Have_skin)
	                {
	                	JOptionPane.showMessageDialog(null, "Ó íàñ îáû÷íàÿ êàðòîøêà, íå â ìóíäèðå. Íàäî ïî÷èñòèòü!");
	                    return;
	                }
	                if (potatos[i].Have_wholeness)
	                {
	                	JOptionPane.showMessageDialog(null, "Ó íàñ îáû÷íàÿ êàðòîøêà, íå ïîðåçàííàÿ. Íàäî ïîðåçàòü!");
	                    return;
	                }
	            }
	            for (int i = 0; i < potatos.length; ++i)
	            {
	                fryer.AddPotato(potatos[i]);
	            }
	            ingr += 1;
	            JOptionPane.showMessageDialog(null, "Êàðòîøêó ïîëîæèëè, ìîæíî ãîòîâèòü");
			}
		});
		button_4.setBounds(109, 178, 147, 23);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0441\u043E\u043B\u044C");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//ñîëü
				 salt = new Salt();
		            salt.count = Integer.parseInt(spinner_1.getValue().toString());
		            if (salt.count > 0)
		            {
		                fryer.AddSalt(salt);
		                ingr += 10;
		                JOptionPane.showMessageDialog(null, "Ñîëü äîáàâèëè");
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "Ñîëè æå íåò, ÷òî äîáàâëÿòü?");
		            }
			}
		});
		button_5.setBounds(109, 203, 147, 23);
		frame.getContentPane().add(button_5);
		
		JRadioButton radioButton_2 = new JRadioButton("\u0412\u043A\u043B");
		buttonGroup_1.add(radioButton_2);
		radioButton_2.setBounds(10, 152, 109, 23);
		frame.getContentPane().add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("\u0412\u044B\u043A\u043B");
		buttonGroup_1.add(radioButton_3);
		radioButton_3.setBounds(10, 182, 109, 23);
		frame.getContentPane().add(radioButton_3);
		
		JButton btnNewButton = new JButton("\u041F\u0440\u0438\u0433\u043E\u0442\u043E\u0432\u0438\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//ïðèãîòîâèòü
				if(radioButton_2.isSelected() == true)
					fryer.power = true;
				else 
					fryer.power = false;
				 if (!fryer.power)
		            {
					 JOptionPane.showMessageDialog(null, "Ôðèòþðíèöà íå âêëþ÷åíà.");
		                return;
		            }
		         
		            fryer.Cook();
		            if (ingr == 16)
		            {
		                ready = true;
		                JOptionPane.showMessageDialog(null, "Ïðèãîòîâèëîñü!");
		            }
		            else
		            {
		            	JOptionPane.showMessageDialog(null, "×òî-òî ïîøëî íå òàê, êàðòîøêà íå ñâàðèëàñü");
		                return;
		            }
			}
		});
		btnNewButton.setBounds(10, 250, 246, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label_5 = new JLabel("\u0424\u0440\u0438\u0442\u044E\u0440\u043D\u0438\u0446\u0430");
		label_5.setBounds(10, 131, 119, 14);
		frame.getContentPane().add(label_5);
		
		JButton button_6 = new JButton("\u0414\u043E\u0441\u0442\u0430\u0442\u044C \u0438\u0437 \u0444\u0440\u0438\u0442\u044E\u0440\u043D\u0438\u0446\u044B");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//äîñòàòü
				if (ready)
	            {
					JOptionPane.showMessageDialog(null, "Ïðèÿòíîãî àïïåòèòà");
	            }
	            else
	            {
	            	JOptionPane.showMessageDialog(null, "Êàðòîøêà íå ïðèãîòîâèëàñü!");
	                return;
	            }
			}
		});
		button_6.setBounds(319, 152, 208, 132);
		frame.getContentPane().add(button_6);
		
		
	}
}
