package layouts;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Button;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;

public class MyDr_start_view extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyDr_start_view window = new MyDr_start_view();
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
	public MyDr_start_view() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 750, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Button logOutButton = new Button("Kirjaudu ulos");
		logOutButton.setBounds(630, 0, 104, 22);
		frame.getContentPane().add(logOutButton);
		
		Button findPatientButton = new Button("Etsi potilastiedoista");
		findPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
						frame.dispose();//h‰vitt‰‰ vanhan sivun 
						MyDr_find_patients findPatientsView = new MyDr_find_patients(); //tekee olion seuraavaksi avattavasta framesta
						findPatientsView(true);//asettaa n‰kym‰n olioon
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		findPatientButton.setBounds(168, 231, 105, 80);
		frame.getContentPane().add(findPatientButton);
		
		Button registerPatientButton = new Button("Kirjaa uusi potilas");
		registerPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
						frame.dispose();//h‰vitt‰‰ vanhan sivun 
						MyDr_add_patient addPatientView = new MyDr_add_patient(); //tekee olion seuraavaksi avattavasta framesta
						addPatientView(true);//asettaa n‰kym‰n olioon
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		registerPatientButton.setBounds(474, 231, 105, 80);
		frame.getContentPane().add(registerPatientButton);
		
	}
}
