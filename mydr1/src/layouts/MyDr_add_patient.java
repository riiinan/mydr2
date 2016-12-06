package layouts;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

import javax.swing.ButtonGroup;
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
	private JTextField textField_9;

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

	/**
	 * Create the application.
	 */
	public MyDr_add_patient() {
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
		middleNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(middleNameTextField);
		middleNameTextField.setColumns(10);

		JLabel familyNameLabel = new JLabel("Family Name *");
		familyNameLabel.setBounds(286, 64, 99, 15);
		familyNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(familyNameLabel);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(285, 90, 100, 20);
		lastNameTextField.setHorizontalAlignment(SwingConstants.RIGHT);
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
		
		JLabel dayLabel = new JLabel("Day");
		dayLabel.setBounds(20, 130, 100, 14);
		panel.add(dayLabel);
		
		JLabel monthLabel = new JLabel("Month");
		monthLabel.setBounds(150, 130, 102, 14);
		panel.add(monthLabel);
		
		JLabel yearLabel = new JLabel("Year");
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
	     
	     JLabel countryLabel = new JLabel("Finland");
	     countryLabel.setForeground(Color.GRAY);
	     countryLabel.setBounds(444, 268, 46, 14);
	     panel.add(countryLabel);
	     
	     JLabel emailLabel = new JLabel("Email:");
	     emailLabel.setBounds(201, 325, 120, 14);
	     panel.add(emailLabel);
	     
	     JLabel phoneTextField = new JLabel("Phone number:");
	     phoneTextField.setBounds(20, 325, 100, 14);
	     panel.add(phoneTextField);
	     
	     emailTextField = new JTextField();
	     emailTextField.setBounds(201, 351, 120, 20);
	     panel.add(emailTextField);
	     emailTextField.setColumns(10);
	     
	     textField_9 = new JTextField();
	     textField_9.setBounds(20, 351, 100, 20);
	     panel.add(textField_9);
	     textField_9.setColumns(10);
	     
	     JLabel genderLabel = new JLabel("Gender *");
	     genderLabel.setBounds(20, 206, 65, 19);
	     panel.add(genderLabel);
	     
	     JButton btnSubmit = new JButton("Submit");
	     btnSubmit.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		System.out.println("Have a nice day!");
	     	}
	     });
	     btnSubmit.setBounds(413, 375, 155, 36);
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
