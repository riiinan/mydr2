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
import java.awt.List;
import javax.swing.JScrollPane;

public class MyDr_find_patients {

	private JFrame frame;
	private JTextField textField_1;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(32, 58, 152, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnHae = new JButton("Hae");
		btnHae.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnHae.setBounds(206, 57, 89, 23);
		frame.getContentPane().add(btnHae);
		
		JTextPane txtpnHaePotilastaNimell = new JTextPane();
		txtpnHaePotilastaNimell.setText("Hae potilasta nimell\u00E4 tai henkilotunnuksella");
		txtpnHaePotilastaNimell.setBounds(32, 27, 209, 20);
		frame.getContentPane().add(txtpnHaePotilastaNimell);
		
		table = new JTable();
		table.setBounds(46, 226, 333, -103);
		frame.getContentPane().add(table);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 112, 327, 120);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
	}
}
