package org.ju.cse.gobinda.sms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static StudentManager sm;
	private static JPanel contentPane;
	private static CardLayout cardLayout;

	private JTextField userNameField;
	private JPasswordField passwordField;
	private JTextField idTextFiledForAdd;
	private JTextField nameTextFiledForAdd;
	private JTextField motherNameTextFiledForAdd;
	private JTextField dateOfBirthTextFiledForAdd;
	private JTextField td;

	private JTextField fatherNameTextFiledForAdd;
	private static JTable table;
	private JTextField bloodGroupTextFiledForAdd;
	private JTextField genderTextFiledForAdd;
	private JTextField phoneNumberTextFiledForAdd;
	private JTextField idTextFiledForUpdate;
	private JTextField nameTextFiledForUpdate;
	private JTextField fatherNameTextFiledForUpdate;
	private JTextField motherNameTextFiledForUpdate;
	private JTextField dateOfBirthTextFiledForUpdate;
	private JTextField bloodGroupTextFiledForUpdate;
	private JTextField genderTextFiledForUpdate;
	private JTextField phoneNumberTextFiledForUpdate;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		super();
		setTitle("Student Management System");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 550);

		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);

		JPanel loginPanel = new JPanel();
		contentPane.add(loginPanel, "loginPanel");
		loginPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("UDVASH COACHING CENTRE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(175, 107, 436, 34);
		loginPanel.add(lblNewLabel);

		userNameField = new JTextField();
		userNameField.setBounds(279, 217, 237, 34);
		loginPanel.add(userNameField);
		userNameField.setColumns(10);

		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(279, 172, 237, 34);
		loginPanel.add(lblUsername);

		JLabel lblPasword = new JLabel("PASWORD");
		lblPasword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPasword.setBounds(279, 262, 237, 34);
		loginPanel.add(lblPasword);

		passwordField = new JPasswordField();
		passwordField.setBounds(279, 307, 237, 34);
		loginPanel.add(passwordField);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String userName = userNameField.getText();
				String pass = new String(passwordField.getPassword());
				if (sm.isUserExist(userName, pass)) {
					showPanel("allPanel");
					return;
				}
				JOptionPane.showMessageDialog(null, "UserName & Password MisMatch!");

			}
		});
		btnNewButton.setBounds(279, 352, 237, 34);
		loginPanel.add(btnNewButton);

		JPanel allPanel = new JPanel();
		contentPane.add(allPanel, "allPanel");
		allPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JTabbedPane allOptionPane = new JTabbedPane(JTabbedPane.TOP);
		allPanel.add(allOptionPane);

		JPanel showPanel = new JPanel();
		allOptionPane.addTab("SHOW ALL", null, showPanel, null);
		showPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		showPanel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel addStudentPanel = new JPanel();
		allOptionPane.addTab("ADD", null, addStudentPanel, null);
		addStudentPanel.setLayout(null);

		idTextFiledForAdd = new JTextField();
		idTextFiledForAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idTextFiledForAdd.setBounds(294, 82, 343, 31);
		addStudentPanel.add(idTextFiledForAdd);
		idTextFiledForAdd.setColumns(10);

		nameTextFiledForAdd = new JTextField();
		nameTextFiledForAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameTextFiledForAdd.setColumns(10);
		nameTextFiledForAdd.setBounds(294, 124, 343, 31);
		addStudentPanel.add(nameTextFiledForAdd);

		fatherNameTextFiledForAdd = new JTextField();
		fatherNameTextFiledForAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fatherNameTextFiledForAdd.setColumns(10);
		fatherNameTextFiledForAdd.setBounds(294, 166, 343, 31);
		addStudentPanel.add(fatherNameTextFiledForAdd);

		motherNameTextFiledForAdd = new JTextField();
		motherNameTextFiledForAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		motherNameTextFiledForAdd.setColumns(10);
		motherNameTextFiledForAdd.setBounds(294, 208, 343, 31);
		addStudentPanel.add(motherNameTextFiledForAdd);

		dateOfBirthTextFiledForAdd = new JTextField();
		dateOfBirthTextFiledForAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateOfBirthTextFiledForAdd.setColumns(10);
		dateOfBirthTextFiledForAdd.setBounds(294, 250, 343, 31);
		addStudentPanel.add(dateOfBirthTextFiledForAdd);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(132, 82, 152, 31);
		addStudentPanel.add(lblNewLabel_1);

		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(132, 124, 152, 31);
		addStudentPanel.add(lblName);

		JLabel lblFatherName = new JLabel("FATHER NAME");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFatherName.setBounds(132, 166, 152, 31);
		addStudentPanel.add(lblFatherName);

		JLabel lblCollege = new JLabel("MOTHER NAME");
		lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCollege.setBounds(132, 208, 152, 31);
		addStudentPanel.add(lblCollege);

		JLabel lblPhoneNumber = new JLabel("DATE OF BIRTH");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(132, 250, 152, 31);
		addStudentPanel.add(lblPhoneNumber);

		JButton btnSubmitForAddStudent = new JButton("SUBMIT");
		btnSubmitForAddStudent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmitForAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(idTextFiledForAdd.getText());
				String name = nameTextFiledForAdd.getText();
				String fatherName = fatherNameTextFiledForAdd.getText();
				String motherName = motherNameTextFiledForAdd.getText();
				String dateOfBirth = dateOfBirthTextFiledForAdd.getText();
				String bloodGroup = bloodGroupTextFiledForAdd.getText();
				String gender = genderTextFiledForAdd.getText();
				String phnNumber = phoneNumberTextFiledForAdd.getText();
				Student s = new Student(id, name, fatherName, motherName, dateOfBirth, bloodGroup, gender, phnNumber);
				if (sm.addStudent(s)) {
					JOptionPane.showMessageDialog(null, "added successfully");
					nameTextFiledForAdd.setText("");
					idTextFiledForAdd.setText("");
					fatherNameTextFiledForAdd.setText("");
					motherNameTextFiledForAdd.setText("");
					dateOfBirthTextFiledForAdd.setText("");
					bloodGroupTextFiledForAdd.setText("");
					genderTextFiledForAdd.setText("");
					phoneNumberTextFiledForAdd.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "can not added successfully");
				}

			}
		});
		btnSubmitForAddStudent.setBounds(506, 424, 131, 31);
		addStudentPanel.add(btnSubmitForAddStudent);

		JLabel lblBloodGroup = new JLabel("BLOOD GROUP");
		lblBloodGroup.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBloodGroup.setBounds(132, 292, 152, 31);
		addStudentPanel.add(lblBloodGroup);

		bloodGroupTextFiledForAdd = new JTextField();
		bloodGroupTextFiledForAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bloodGroupTextFiledForAdd.setColumns(10);
		bloodGroupTextFiledForAdd.setBounds(294, 292, 343, 31);
		addStudentPanel.add(bloodGroupTextFiledForAdd);

		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGender.setBounds(132, 334, 152, 31);
		addStudentPanel.add(lblGender);

		genderTextFiledForAdd = new JTextField();
		genderTextFiledForAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		genderTextFiledForAdd.setColumns(10);
		genderTextFiledForAdd.setBounds(294, 334, 343, 31);
		addStudentPanel.add(genderTextFiledForAdd);

		JLabel label_2 = new JLabel("PHONE NUMBER");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(132, 376, 152, 31);
		addStudentPanel.add(label_2);

		phoneNumberTextFiledForAdd = new JTextField();
		phoneNumberTextFiledForAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneNumberTextFiledForAdd.setColumns(10);
		phoneNumberTextFiledForAdd.setBounds(294, 376, 343, 31);
		addStudentPanel.add(phoneNumberTextFiledForAdd);

		JLabel lblAddAllThe = new JLabel("FILL ALL THE INFORMATION TO ADD");
		lblAddAllThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddAllThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAllThe.setBounds(132, 38, 505, 28);
		addStudentPanel.add(lblAddAllThe);

		JPanel deleteStudentPane = new JPanel();
		allOptionPane.addTab("DELETE", null, deleteStudentPane, null);
		deleteStudentPane.setLayout(null);

		td = new JTextField();
		td.setColumns(10);
		td.setBounds(170, 205, 395, 31);
		deleteStudentPane.add(td);

		JLabel lblEnterId_1 = new JLabel("ENTER ID");
		lblEnterId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterId_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterId_1.setBounds(170, 163, 395, 31);
		deleteStudentPane.add(lblEnterId_1);

		JButton btnDeleteForDeleteStudent = new JButton("DELETE");
		btnDeleteForDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x = Integer.parseInt(td.getText());
				if (sm.deleteStudentWhereId(x)) {
					JOptionPane.showMessageDialog(null, "deleted successfully");
					td.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "deletetion not possible, try again!!");
				}
			}
		});
		btnDeleteForDeleteStudent.setBounds(170, 247, 395, 38);
		deleteStudentPane.add(btnDeleteForDeleteStudent);

		JPanel updateStudent = new JPanel();
		allOptionPane.addTab("UPDATE", null, updateStudent, null);
		updateStudent.setLayout(null);

		JButton btnSubmitForUpdateStudent = new JButton("SUBMIT");
		btnSubmitForUpdateStudent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSubmitForUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(idTextFiledForUpdate.getText());
				String name = nameTextFiledForUpdate.getText();
				String fatherName = fatherNameTextFiledForUpdate.getText();
				String motherName = motherNameTextFiledForUpdate.getText();
				String dateOfBirth = dateOfBirthTextFiledForUpdate.getText();
				String bloodGroup = bloodGroupTextFiledForUpdate.getText();
				String gender = genderTextFiledForUpdate.getText();
				String phnNumber = phoneNumberTextFiledForUpdate.getText();
				Student s = new Student(id, name, fatherName, motherName, dateOfBirth, bloodGroup, gender, phnNumber);
				if (sm.updateStudent(s)) {
					JOptionPane.showMessageDialog(null, "updated successfully");
					nameTextFiledForUpdate.setText("");
					idTextFiledForAdd.setText("");
					fatherNameTextFiledForUpdate.setText("");
					motherNameTextFiledForUpdate.setText("");
					dateOfBirthTextFiledForUpdate.setText("");
					bloodGroupTextFiledForUpdate.setText("");
					genderTextFiledForUpdate.setText("");
					phoneNumberTextFiledForUpdate.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "updated not posible, try again!");
				}
			}
		});
		btnSubmitForUpdateStudent.setBounds(499, 423, 137, 36);
		updateStudent.add(btnSubmitForUpdateStudent);

		JLabel lblNewLabel_2 = new JLabel("WHOSE INFORMATON WILL BE UPDATE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(131, 42, 505, 28);
		updateStudent.add(lblNewLabel_2);

		idTextFiledForUpdate = new JTextField();
		idTextFiledForUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = idTextFiledForUpdate.getText();
				if (str.trim().length() == 0) {
					return;
				}
				int id = Integer.parseInt(str);
				Student s = sm.getStudentWhereId(id);
				nameTextFiledForUpdate.setText(s.getName());
				fatherNameTextFiledForUpdate.setText(s.getFatherName());
				motherNameTextFiledForUpdate.setText(s.getMotherName());
				dateOfBirthTextFiledForUpdate.setText(s.getDateOfBirth());
				bloodGroupTextFiledForUpdate.setText(s.getBloodGroup());
				genderTextFiledForUpdate.setText(s.getGender());
				phoneNumberTextFiledForUpdate.setText(s.getPhnNumber());
			}
		});
		idTextFiledForUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idTextFiledForUpdate.setColumns(10);
		idTextFiledForUpdate.setBounds(293, 81, 343, 31);
		updateStudent.add(idTextFiledForUpdate);

		nameTextFiledForUpdate = new JTextField();
		nameTextFiledForUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameTextFiledForUpdate.setColumns(10);
		nameTextFiledForUpdate.setBounds(293, 123, 343, 31);
		updateStudent.add(nameTextFiledForUpdate);

		fatherNameTextFiledForUpdate = new JTextField();
		fatherNameTextFiledForUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fatherNameTextFiledForUpdate.setColumns(10);
		fatherNameTextFiledForUpdate.setBounds(293, 165, 343, 31);
		updateStudent.add(fatherNameTextFiledForUpdate);

		motherNameTextFiledForUpdate = new JTextField();
		motherNameTextFiledForUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		motherNameTextFiledForUpdate.setColumns(10);
		motherNameTextFiledForUpdate.setBounds(293, 207, 343, 31);
		updateStudent.add(motherNameTextFiledForUpdate);

		dateOfBirthTextFiledForUpdate = new JTextField();
		dateOfBirthTextFiledForUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateOfBirthTextFiledForUpdate.setColumns(10);
		dateOfBirthTextFiledForUpdate.setBounds(293, 249, 343, 31);
		updateStudent.add(dateOfBirthTextFiledForUpdate);

		JLabel label = new JLabel("ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(131, 81, 152, 31);
		updateStudent.add(label);

		JLabel label_1 = new JLabel("NAME");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(131, 123, 152, 31);
		updateStudent.add(label_1);

		JLabel label_3 = new JLabel("FATHER NAME");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(131, 165, 152, 31);
		updateStudent.add(label_3);

		JLabel label_4 = new JLabel("MOTHER NAME");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(131, 207, 152, 31);
		updateStudent.add(label_4);

		JLabel label_5 = new JLabel("DATE OF BIRTH");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(131, 249, 152, 31);
		updateStudent.add(label_5);

		JLabel label_6 = new JLabel("BLOOD GROUP");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(131, 291, 152, 31);
		updateStudent.add(label_6);

		bloodGroupTextFiledForUpdate = new JTextField();
		bloodGroupTextFiledForUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bloodGroupTextFiledForUpdate.setColumns(10);
		bloodGroupTextFiledForUpdate.setBounds(293, 291, 343, 31);
		updateStudent.add(bloodGroupTextFiledForUpdate);

		JLabel label_7 = new JLabel("GENDER");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(131, 333, 152, 31);
		updateStudent.add(label_7);

		genderTextFiledForUpdate = new JTextField();
		genderTextFiledForUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		genderTextFiledForUpdate.setColumns(10);
		genderTextFiledForUpdate.setBounds(293, 333, 343, 31);
		updateStudent.add(genderTextFiledForUpdate);

		JLabel label_8 = new JLabel("PHONE NUMBER");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(131, 375, 152, 31);
		updateStudent.add(label_8);

		phoneNumberTextFiledForUpdate = new JTextField();
		phoneNumberTextFiledForUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneNumberTextFiledForUpdate.setColumns(10);
		phoneNumberTextFiledForUpdate.setBounds(293, 375, 343, 31);
		updateStudent.add(phoneNumberTextFiledForUpdate);

		sm = new StudentManager();
		refreshTableModel();
	}

	public static void showPanel(String panelName) {
		cardLayout.show(contentPane, panelName);
	}

	public static void refreshTableModel() {
		table.setModel(sm.getTableModel());
	}
}
