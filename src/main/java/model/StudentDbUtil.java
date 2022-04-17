package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	
	DataSource dataSource;
	
	public StudentDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Student> getStudents() throws SQLException{
		//create empty array
		List<Student> students = new ArrayList<Student>();
		
		//
		Connection myCo = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myCo = dataSource.getConnection();
			
			String sql = "select * from student" ;
			
			myStmt = myCo.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			
			
			while(myRs.next()) {
	    int id = myRs.getInt("id");
		String nom = myRs.getString("nom");
		String prnom = myRs.getString("prenom");
		String group = myRs.getString("groupe");
		Student std = new Student(id, nom, prnom, group);
		students.add(std);

			}
			
			return students;
		}
		finally {
			close(myCo , myStmt , myRs);
		}
		
		
		
		
	}


	private void close(Connection myCo, Statement myStmt, ResultSet myRs) {
		try {
			if (myCo != null) {
				myCo.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myRs != null) {
				myRs.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addStudent(Student std) throws SQLException{
		
	Connection myCo = null;
	PreparedStatement myStmt = null;
		
	
	try {
	myCo = dataSource.getConnection();
	String sql = "insert into student"
			   + "(nom,prenom,groupe)"
			   + "values (?, ?, ?)";
	
	myStmt = myCo.prepareStatement(sql);
	

	
	myStmt.setString(1, std.getFirstName());
	myStmt.setString(2, std.getLastName());
	myStmt.setString(3, std.getGroup());
	
	myStmt.execute();
	}finally {
		close(myCo , myStmt , null);
	}
	}

	public Student getStudent(String studentId) throws Exception{
		Student student = null;
		Connection myCo = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int id ;
		
		try {
			myCo = dataSource.getConnection();
			id = Integer.parseInt(studentId);
			String sql = "select * from student where id=? ";
			
			myStmt = myCo.prepareStatement(sql);
			myStmt.setInt(1, id);
			
			myRs = myStmt.executeQuery();
			
			if(myRs.next()) {
				String nom = myRs.getString("nom");
				String prenom = myRs.getString("prenom");
				String group = myRs.getString("groupe");
				student = new Student(id, nom, prenom, group);
			}else {
		        throw new Exception("no student");
			}
			
			
		}finally {
			close(myCo , myStmt , myRs);
		}
		
		
		return student;
	}

	public void updateStudent(Student std) throws Exception {
		Connection myCo = null;
		PreparedStatement myStmt =null;
		try {
			
			myCo = dataSource.getConnection();
			String sql = "update student "
					+ "set nom=?, prenom=?, groupe? "
					+ "where id=? ";
			
			myStmt = myCo.prepareStatement(sql);
			myStmt.setString(1, std.getFirstName());
			myStmt.setString(2, std.getLastName());
			myStmt.setString(3, std.getGroup());
			myStmt.setInt(4, std.getId());
			
			myStmt.execute();
			
		}finally {
			close(myCo , myStmt , null);
		}
		
	}

	public void deleteStudent(int id) throws Exception{
	Connection myCo = null;
	PreparedStatement myStmt = null;
	
	try {
		myCo = dataSource.getConnection();
		
		String sql = "delete from student where id=? ";
		
		myStmt = myCo.prepareStatement(sql);
		myStmt.setInt(1, id);
		
		myStmt.execute();
		
	}finally {
		close(myCo , myStmt , null);
	}	
		
	}

	public List<Student> getStudentsByGroup(String group) throws Exception {
		List<Student> students = new ArrayList<Student>();
		Connection myCo = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
				int gp = Integer.parseInt(group);
		try {
			myCo = dataSource.getConnection();
			String sql= "select * from student where groupe=? ";
			
			myStmt = myCo.prepareStatement(sql);
			
			myStmt.setInt(1, gp);
			
			myRs = myStmt.executeQuery();
			
			while(myRs.next()) {
				students.add(new Student(myRs.getInt("id"), myRs.getString("nom") , myRs.getString("prenom"), null));
			}
			return students;
			
		}finally {
			close(myCo , myStmt ,myRs);
		}
		
		
	}

}
