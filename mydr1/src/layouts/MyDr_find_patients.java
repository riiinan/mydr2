package layouts;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextPane;

import net.proteanit.sql.DbUtils;

import java.awt.List;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyDr_find_patients extends JFrame {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyDr_find_patients window = new MyDr_find_patients();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField textField;
	
	/**
	 * Create the application.
	 */
	public MyDr_find_patients() {
		initialize();
		connection=sqliteConnection.dbConnector();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		connection=sqliteConnection.dbConnector();
		frame = new JFrame();
		frame.setBounds(100, 100, 681, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnHae = new JButton("Valitse");
		btnHae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					frame.dispose();//h‰vitt‰‰ vanhan sivun 
					MyDr_patientview patientview = new MyDr_patientview(); //tekee olion seuraavaksi avattavasta framesta
					patientview(true);//asettaa n‰kym‰n olioon
					
				} catch (Exception e){
					e.printStackTrace();
				}
				
			}
		});
		btnHae.setBounds(462, 243, 89, 23);
		frame.getContentPane().add(btnHae);
		
		JTextPane txtpnHaePotilastaNimell = new JTextPane();
		txtpnHaePotilastaNimell.setText("Hae potilasta nimell\u00E4");
		txtpnHaePotilastaNimell.setBounds(32, 27, 556, 20);
		frame.getContentPane().add(txtpnHaePotilastaNimell);
		
		table = new JTable();
		table.setBounds(46, 226, 333, -103);
		frame.getContentPane().add(table);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 112, 584, 120);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try{
					String query="select * from PatientInfo where name=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textField.getText()  );
					ResultSet rs = pst.executeQuery();
						
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
				} catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		textField.setBounds(32, 58, 143, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
