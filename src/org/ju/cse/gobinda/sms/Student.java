package org.ju.cse.gobinda.sms;

public class Student {

	private int id;
	private String name;
	private String fatherName;
	private String motherName;
	private String dateOfBirth;
	private String bloodGroup;
	private String gender;
	private String phnNumber;

	public Student(int id, String name, String fatherName, String motherName, String dateOfBirth, String bloodGroup,
			String gender, String phnNumber) {
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.dateOfBirth = dateOfBirth;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.phnNumber = phnNumber;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public String getGender() {
		return gender;
	}

	public String getPhnNumber() {
		return phnNumber;
	}

	public boolean isEqual(Student s) {
		if (this.id == s.id)
			return true;
		return false;
	}

}
