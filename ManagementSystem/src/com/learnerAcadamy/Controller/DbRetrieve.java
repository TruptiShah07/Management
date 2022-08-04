package com.learnerAcadamy.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.sql.DataSource;

import com.learnerAcadamy.model.*;

public class DbRetrieve {
	
	private DataSource dataSource;
	
	public DbRetrieve(DataSource datasource1) {
		this.dataSource = datasource1;
	}

	public List<Students> getStudents() {

		List<Students> studentList= new ArrayList<Students>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM Administration.Students";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Students students = new Students();
				students.setStudId(rs.getInt("id"));
				students.setStudFirstName(rs.getString("firstName"));
				students.setStudLastName(rs.getString("lastName"));
				students.setAge(rs.getInt("age"));
				students.setClassId(rs.getInt("classId"));
				studentList.add(students);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return studentList;

	}

	public List<Teachers> getTeachers() {

		List<Teachers> teacherList = new ArrayList<Teachers>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = dataSource.getConnection();
			String sql = "SELECT * FROM Administration.Teachers";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Teachers teachers = new Teachers();
				teachers.setTeacherId(rs.getInt("id"));
				teachers.setTeachFirstName(rs.getString("tfirstName"));
				teachers.setTeachLastName(rs.getString("tlastName"));
				teacherList.add(teachers);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return teacherList;
	}

	public List<Subjects> getSubjects() {

		List<Subjects> subjectList = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = dataSource.getConnection();
			String sql = "SELECT * FROM Administration.Subjects";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Subjects subjects = new Subjects();
				subjects.setSubId(rs.getInt("id"));
				subjects.setSubjectName(rs.getString("subjectName"));
				subjectList.add(subjects);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return subjectList;
	}

	public List<Classes> getClasses() {

		List<Classes> classeList = new ArrayList<Classes>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = dataSource.getConnection();

			String sql = "SELECT * FROM Administration.Classes";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Classes classes = new Classes();
				classes.setClassId(rs.getInt("classId"));
				classes.setSection(rs.getInt("section"));
				classes.setSubjectId(rs.getInt("subjectId"));
				Subjects subjects =getSubjectsInfo(classes.getSubjectId());
				classes.setSubject(subjects.getSubjectName());
				classes.setTeacherId(rs.getInt("techerId"));
				Teachers teachers = getTeachersInfo(classes.getTeacherId());
				classes.setTeacher(teachers.getTeachFirstName() + " " + teachers.getTeachLastName());
				classes.setTime(rs.getString("time"));

				classeList.add(classes);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return classeList;
	}

	private Teachers getTeachersInfo(int teacherId) {

		Teachers teachers = new Teachers();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = dataSource.getConnection();
			String sql = "SELECT * FROM Administration.Teachers WHERE id = " + teacherId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				teachers.setTeacherId(rs.getInt("id"));
				teachers.setTeachFirstName(rs.getString("tfirstName"));
				teachers.setTeachLastName(rs.getString("tlastName"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return teachers;
	}

	private Subjects getSubjectsInfo(int subjectId) {
		Subjects subjects = new Subjects();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM Administration.Subjects WHERE id = " + subjectId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				subjects.setSubId(rs.getInt("id"));
				subjects.setSubjectName(rs.getString("subjectName"));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return subjects;
	}

	public Classes getClassInfo(int classId) {

		Classes classes = new Classes();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM Administration.Clasess WHERE classId = " + classId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				classes.setClassId(rs.getInt("classId"));
				classes.setSection(rs.getInt("section"));
				classes.setSubjectId(rs.getInt("subjectId"));
				Subjects subjects =getSubjectsInfo(classes.getSubjectId());
				classes.setSubject(subjects.getSubjectName());
				classes.setTeacherId(rs.getInt("techerId"));
				Teachers teachers = getTeachersInfo(classes.getTeacherId());
				classes.setTeacher(teachers.getTeachFirstName() + " " + teachers.getTeachLastName());
				classes.setTime(rs.getString("time"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return classes;

	}

	public List<Students> getStudentListOfClass(int classId) {

		List<Students> studentList = new ArrayList<Students>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			String sql = "SELECT * FROM Administration.Students WHERE classId = " + classId;
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Students students = new Students();
				students.setStudId(rs.getInt("id"));
				students.setStudFirstName(rs.getString("firstName"));
				students.setStudLastName(rs.getString("lastName"));
				students.setAge(rs.getInt("age"));
				students.setClassId(rs.getInt("classId"));
				studentList.add(students);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, stmt, rs);
		}
		return studentList;
	}
	
	private void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
