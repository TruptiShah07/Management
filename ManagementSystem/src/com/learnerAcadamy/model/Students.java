package com.learnerAcadamy.model;

public class Students {
	private int studId;
	private String StudFirstName;
	private String StudLastName;
	private int age;
	private int classId;
	
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudFirstName() {
		return StudFirstName;
	}
	public void setStudFirstName(String studFirstName) {
		StudFirstName = studFirstName;
	}
	public String getStudLastName() {
		return StudLastName;
	}
	public void setStudLastName(String studLastName) {
		StudLastName = studLastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
}
