package layouts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Button;
import java.awt.FlowLayout;
import org.sqlite.JDBC;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.MonthDay;
import java.sql.*;
import javax.swing.*;
public class MyDr_add_patient implements ActionListener {

	private JFrame frame;
	private JTextField firstNameTextField;
	private JTextField middleNameTextField;
	private JTextField lastNameTextField;
	private JTextField dateDayTextField;
	private JTextField dateMonthTextField;
	private JTextField dateYearTextField;
	private JTextField SSNTextField;
	private JTextField streetAddressTextField;
	private JTextField cityTextField;
	private JTextField postalCodeTextField;
	private JTextField emailTextField;
	private JTextField phoneTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyDr_add_patient window = new MyDr_add_patient();
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
	public MyDr_add_patient() {
		initialize();
		connection=sqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//connection=sqliteConnection.dbConnector();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 750, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Button logOutButton = new Button("Log Out");
		logOutButton.setBounds(630, 0, 104, 22);
		frame.getContentPane().add(logOutButton);

		JPanel panel = new JPanel();
		panel.setBounds(73, 51, 598, 439);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel firstNameLabel = new JLabel("First Name *");
		firstNameLabel.setBounds(20, 64, 100, 15);
		firstNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(firstNameLabel);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(20, 90, 100, 20);
		firstNameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(firstNameTextField);
		firstNameTextField.setColumns(10);

		JLabel middleNameLabel = new JLabel("Middle Name:");
		middleNameLabel.setBounds(150, 64, 102, 15);
		middleNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(middleNameLabel);

		middleNameTextField = new JTextField();
		middleNameTextField.setBounds(150, 90, 100, 20);
		middleNameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(middleNameTextField);
		middleNameTextField.setColumns(10);

		JLabel familyNameLabel = new JLabel("Family Name *");
		familyNameLabel.setBounds(286, 64, 99, 15);
		familyNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(familyNameLabel);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(285, 90, 100, 20);
		lastNameTextField.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lastNameTextField);
		lastNameTextField.setColumns(10);

		JLabel requirementFieldsLabel = new JLabel("* Fields are Required");
		requirementFieldsLabel.setBounds(454, 11, 144, 14);
		panel.add(requirementFieldsLabel);

		dateDayTextField = new JTextField();
		dateDayTextField.setBounds(20, 155, 100, 20);
		panel.add(dateDayTextField);
		dateDayTextField.setColumns(10);

		dateMonthTextField = new JTextField();
		dateMonthTextField.setBounds(150, 155, 100, 20);
		panel.add(dateMonthTextField);
		dateMonthTextField.setColumns(10);

		dateYearTextField = new JTextField();
		dateYearTextField.setBounds(286, 155, 100, 20);
		panel.add(dateYearTextField);
		dateYearTextField.setColumns(10);

		JLabel dayLabel = new JLabel("Day *");
		dayLabel.setBounds(20, 130, 100, 14);
		panel.add(dayLabel);

		JLabel monthLabel = new JLabel("Month *");
		monthLabel.setBounds(150, 130, 102, 14);
		panel.add(monthLabel);

		JLabel yearLabel = new JLabel("Year *");
		yearLabel.setBounds(286, 130, 99, 14);
		panel.add(yearLabel);

		JLabel label = new JLabel("-");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(396, 157, 25, 17);
		panel.add(label);

		SSNTextField = new JTextField();
		SSNTextField.setBounds(444, 155, 100, 20);
		panel.add(SSNTextField);
		SSNTextField.setColumns(10);

		JLabel SSNLabel = new JLabel("SSN");
		SSNLabel.setBounds(444, 130, 100, 14);
		panel.add(SSNLabel);

		JRadioButton male = new JRadioButton("Male");


		male.setBounds(150, 202, 80, 23);
		panel.add(male);

		JRadioButton female = new JRadioButton("Female");
		female.setBounds(286, 202, 99, 23);
		panel.add(female);
		ButtonGroup bG = new ButtonGroup();
		bG.add(male);
		bG.add(female);
		male.addActionListener(this);
		female.addActionListener(this);


		streetAddressTextField = new JTextField();
		streetAddressTextField.setBounds(20, 265, 150, 20);
		panel.add(streetAddressTextField);
		streetAddressTextField.setColumns(10);

		cityTextField = new JTextField();
		cityTextField.setBounds(201, 265, 100, 20);
		panel.add(cityTextField);
		cityTextField.setColumns(10);

		postalCodeTextField = new JTextField();
		postalCodeTextField.setBounds(335, 265, 80, 20);
		panel.add(postalCodeTextField);
		postalCodeTextField.setColumns(10);

		JLabel streetAddressLabel = new JLabel("Street address:");
		streetAddressLabel.setBounds(20, 240, 150, 14);
		panel.add(streetAddressLabel);

		JLabel cityLabel = new JLabel("City:");
		cityLabel.setBounds(201, 240, 100, 14);
		panel.add(cityLabel);

		JLabel postalCodeLabel = new JLabel("Postal code:");
		postalCodeLabel.setBounds(335, 240, 86, 14);
		panel.add(postalCodeLabel);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(201, 325, 120, 14);
		panel.add(emailLabel);

		JLabel phoneLabel = new JLabel("Phone number:");
		phoneLabel.setBounds(20, 325, 100, 14);
		panel.add(phoneLabel);

		emailTextField = new JTextField();
		emailTextField.setBounds(201, 351, 200, 20);
		panel.add(emailTextField);
		emailTextField.setColumns(10);

		phoneTextField = new JTextField();
		phoneTextField.setBounds(20, 351, 120, 20);
		panel.add(phoneTextField);
		phoneTextField.setColumns(10);

		JLabel genderLabel = new JLabel("Gender *");
		genderLabel.setBounds(20, 206, 65, 19);
		panel.add(genderLabel);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query="insert into PatientInfo (name,gender,birthdate,birthplace,telephone_number,social_security_number,email) values (?,?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, firstNameTextField.getText()+" "+middleNameTextField.getText()+" "+lastNameTextField.getText());
					if(male.isSelected())
					{
						pst.setString(2, "M");
					}
					else
					{
						pst.setString(2, "F");
					}
					pst.setString(3, dateYearTextField.getText()+"-"+dateMonthTextField.getText()+"-"+dateDayTextField.getText());
					pst.setString(4, cityTextField.getText());
					pst.setString(5, phoneTextField.getText());
					pst.setString(6, dateDayTextField.getText()+dateMonthTextField.getText()+dateYearTextField.getText().substring(dateYearTextField.getText().length()-2)+"-"+SSNTextField.getText());
					pst.setString(7, emailTextField.getText());
					pst.executeUpdate();
	
					JOptionPane.showMessageDialog(null,  "Data Saved");
					
					pst.close();
					//rs.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(433, 392, 155, 36);
		panel.add(btnSubmit);

		JLabel lblRegisterANew = new JLabel("Register a patient");
		lblRegisterANew.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
		lblRegisterANew.setForeground(Color.DARK_GRAY);
		lblRegisterANew.setBounds(20, 11, 188, 36);
		panel.add(lblRegisterANew);
		male.setVisible(true);




}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub

}
}
