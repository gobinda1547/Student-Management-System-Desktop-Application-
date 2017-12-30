package org.ju.cse.gobinda.sms;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class StudentManager {

	public boolean addStudent(Student student) {
		if (Dao.addStudent(student)) {
			MainFrame.refreshTableModel();
			return true;
		}
		return false;
	}

	public boolean updateStudent(Student student) {
		if (Dao.updateStudent(student)) {
			MainFrame.refreshTableModel();
			return true;
		}
		return false;
	}

	public boolean deleteStudentWhereId(int x) {
		if (Dao.deleteStudentWhereId(x)) {
			MainFrame.refreshTableModel();
			return true;
		}
		return false;
	}

	public ArrayList<Student> getAllTheStudent() {
		return Dao.getAllTheStudent();
	}

	public DefaultTableModel getTableModel() {
		ArrayList<Student> students = getAllTheStudent();
		String[] str = { "Id", "Name", "F_Name", "M_Name", "date of birth", "blood group", "gender", "Phn_NUm" };
		DefaultTableModel dtm = new DefaultTableModel(str, 0);

		int len = students.size();
		for (int i = 0; i < len; i++) {
			String[] strings = new String[8];
			strings[0] = String.valueOf(students.get(i).getId());
			strings[1] = students.get(i).getName();
			strings[2] = students.get(i).getFatherName();
			strings[3] = students.get(i).getMotherName();
			strings[4] = students.get(i).getDateOfBirth();
			strings[5] = students.get(i).getBloodGroup();
			strings[6] = students.get(i).getGender();
			strings[7] = students.get(i).getPhnNumber();
			dtm.addRow(strings);
		}
		return dtm;
	}

	public Student getStudentWhereId(int id) {
		return Dao.getStudentDetailsWhereId(id);
	}

	public boolean isUserExist(String userName, String pass) {
		return Dao.isUserNamePasswordExist(userName, pass);
	}

}
