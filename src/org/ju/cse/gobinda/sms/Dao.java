package org.ju.cse.gobinda.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * While running this program please add user for login
 * 
 * You can add user by calling addUser function
 */
public class Dao {

	static {

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("CREATE TABLE IF NOT EXISTS student(");
			sql.append("id INTEGER not NULL, ");
			sql.append("name VARCHAR(255), ");
			sql.append("fathername VARCHAR(255), ");
			sql.append("mothername VARCHAR(255), ");
			sql.append("dob VARCHAR(255), ");
			sql.append("bloodgroup VARCHAR(255), ");
			sql.append("gender VARCHAR(255), ");
			sql.append("phonenumber VARCHAR(255), ");
			sql.append("PRIMARY KEY(id))");

			Connection conn = getDatabaseConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql.toString());

			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("probelm occurs in the dao static block! 1");
		}

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("CREATE TABLE IF NOT EXISTS user(");
			sql.append("username VARCHAR(255), ");
			sql.append("password VARCHAR(255), ");
			sql.append("PRIMARY KEY(username))");

			Connection conn = getDatabaseConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql.toString());

			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("probelm occurs in the dao static block! 2");
		}

		addUserNamePassword("a", "a");

	}

	public static boolean addStudent(Student s) {

		try {
			Connection connection = getDatabaseConnection();
			PreparedStatement insertPreparedStatement = null;
			String InsertQuery = "INSERT INTO student (id, name,fathername,mothername,dob,bloodgroup,gender,phonenumber) values (?,?,?,?,?,?,?,?)";

			connection.setAutoCommit(false);

			insertPreparedStatement = connection.prepareStatement(InsertQuery);
			insertPreparedStatement.setInt(1, s.getId());
			insertPreparedStatement.setString(2, s.getName());
			insertPreparedStatement.setString(3, s.getFatherName());
			insertPreparedStatement.setString(4, s.getMotherName());
			insertPreparedStatement.setString(5, s.getDateOfBirth());
			insertPreparedStatement.setString(6, s.getBloodGroup());
			insertPreparedStatement.setString(7, s.getGender());
			insertPreparedStatement.setString(8, s.getPhnNumber());

			insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();

			connection.commit();
			connection.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private static void addUserNamePassword(String name, String password) {
		Connection connection = null;
		try {
			connection = getDatabaseConnection();
			PreparedStatement insertPreparedStatement = null;
			String InsertQuery = "INSERT INTO user (username, password) values (?,?)";

			connection.setAutoCommit(false);

			insertPreparedStatement = connection.prepareStatement(InsertQuery);
			insertPreparedStatement.setString(1, name);
			insertPreparedStatement.setString(2, password);

			insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();

			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static Connection getDatabaseConnection() {

		try {
			String dbUrl = "jdbc:h2:~/student_db";
			String dbUserName = "";
			String dbPassword = "";
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static boolean updateStudent(Student student) {

		try {
			Connection conn = getDatabaseConnection();
			String sql = "UPDATE student SET name=?,fathername=?,mothername=?,dob=?,bloodgroup=?,gender=?,phonenumber=? WHERE id=?";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getFatherName());
			preparedStatement.setString(3, student.getMotherName());
			preparedStatement.setString(4, student.getDateOfBirth());
			preparedStatement.setString(5, student.getBloodGroup());
			preparedStatement.setString(6, student.getGender());
			preparedStatement.setString(7, student.getPhnNumber());
			preparedStatement.setInt(8, student.getId());
			preparedStatement.execute();

			preparedStatement.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.err.println("problem occurs in the update student method!");
			e.printStackTrace();
		}

		return false;

	}

	public static boolean deleteStudentWhereId(int x) {
		try {
			Connection conn = getDatabaseConnection();
			String sql = "DELETE FROM student WHERE id = ?";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, x);
			preparedStatement.execute();

			preparedStatement.close();
			conn.close();
			return true;
		} catch (Exception e) {
			System.err.println("problem occurs in the delete sutdent method!");
		}
		return false;
	}

	public static ArrayList<Student> getAllTheStudent() {
		ArrayList<Student> students = new ArrayList<>();
		try {
			String sql = null;
			Connection conn = getDatabaseConnection();
			Statement stmt = conn.createStatement();

			sql = "SELECT * FROM student";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String fatherName = rs.getString(3);
				String motherName = rs.getString(4);
				String dateOfBirth = rs.getString(5);
				String bloodGroup = rs.getString(6);
				String gender = rs.getString(7);
				String phnNumber = rs.getString(8);
				Student s = new Student(id, name, fatherName, motherName, dateOfBirth, bloodGroup, gender, phnNumber);
				students.add(s);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	public static boolean isUserNamePasswordExist(String username, String password) {
		try {
			String sql = null;
			Connection conn = getDatabaseConnection();
			Statement stmt = conn.createStatement();

			sql = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String dbUsername = rs.getString(1);
				String dbPassword = rs.getString(2);
				if (username.equals(dbUsername) && password.equals(dbPassword)) {
					return true;
				}
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Student getStudentDetailsWhereId(int x) {

		Student s = new Student(x, "Not Found!", "Not Found!", "Not Found!", "Not Found!", "Not Found!", "Not Found!",
				"Not Found!");
		try {
			Connection conn = getDatabaseConnection();
			String sql = "SELECT * FROM student WHERE id = " + x;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String fatherName = rs.getString(3);
				String motherName = rs.getString(4);
				String dateOfBirth = rs.getString(5);
				String bloodGroup = rs.getString(6);
				String gender = rs.getString(7);
				String phnNumber = rs.getString(8);
				s = new Student(id, name, fatherName, motherName, dateOfBirth, bloodGroup, gender, phnNumber);
				System.out.println("hello");
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println("problem occurs in the get student detaile where id method!!");
			e.printStackTrace();
		}
		return s;
	}

	/*
	 * private static void addUserNamePassword(String username, String password)
	 * { try { Connection connection = getDatabaseConnection();
	 * PreparedStatement insertPreparedStatement = null; String InsertQuery =
	 * "INSERT INTO user (username,password) values (?,?)";
	 * 
	 * connection.setAutoCommit(false);
	 * 
	 * insertPreparedStatement = connection.prepareStatement(InsertQuery);
	 * insertPreparedStatement.setString(1, username);
	 * insertPreparedStatement.setString(2, password);
	 * 
	 * insertPreparedStatement.executeUpdate(); insertPreparedStatement.close();
	 * 
	 * connection.commit(); connection.close(); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */

}
