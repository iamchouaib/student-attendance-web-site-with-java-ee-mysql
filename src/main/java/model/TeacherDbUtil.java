package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class TeacherDbUtil {

	private DataSource dataSource;

	public TeacherDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Teacher> getTeacher() throws Exception {

		List<Teacher> teachers = new ArrayList<Teacher>();

		Connection myCon = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		// add teacher to array

		try {
			myCon = dataSource.getConnection();

			String sql = "select * from teacher";
			myStmt = myCon.createStatement();

			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {
				int id = myRs.getInt("idTeacher");
				String fname = myRs.getString("nom");
				String lname = myRs.getString("prenom");
				String module = myRs.getString("module");

				teachers.add(new Teacher(id, fname, lname,null,null,null, module,null,null));
				

			}

			return teachers;
		} finally {
			close(myCon, myStmt, myRs);
		}

	}

	private void close(Connection myCon, Statement myStmt, ResultSet myRs) {
		try {
			if (myCon != null) {
				myCon.close();
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

	public void addTeacher(Teacher t) throws SQLException {
		Connection myCo = null;
		PreparedStatement mySmt = null;

		try {
			myCo = dataSource.getConnection();

			String sql = "insert into teacher" + "(nom,prenom,module) " + "values (?, ?, ?)";

			// set param for stmt
			mySmt = myCo.prepareStatement(sql);

			mySmt.setString(1, t.getFirstName());
			mySmt.setString(2, t.getLastName());
			mySmt.setString(3, t.getModule());

			mySmt.execute();
		} finally {
			close(myCo, mySmt, null);
		}

	}

	public Teacher getTeacher(String teacherId) throws Exception {
       Teacher te =null;
		Connection myCo = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int id;

		try {
			//convert sting to int
			id = Integer.parseInt(teacherId);
			//get connection
myCo = dataSource.getConnection();
//sql
String sql = "select * from teacher where idTeacher=? ";
//creat pre

myStmt = myCo.prepareStatement(sql);

myStmt.setInt(1, id);

myRs = myStmt.executeQuery();

//get the information 

if(myRs.next()) {
	String nom = myRs.getString("nom");
	String prenom = myRs.getString("prenom");
	String groups = myRs.getString("groupes");
	String module = myRs.getString("module");
	String image = myRs.getString("image");
	String email = myRs.getString("email");
	
	 te = new Teacher(id ,nom, prenom, email,groups,null, module, null , image);
	 
}else {
	throw new Exception(" No Teacher");
}

			return te;
		} finally {
			close(myCo, myStmt, myRs);
		}
	}

	public void updateTeacher(Teacher t) throws Exception{
		
		Connection myCo = null;
		PreparedStatement myStmt = null;
		
		try {
			myCo = dataSource.getConnection();

			
			String sql = "update teacher "
					+ "set nom=?, prenom=?, module=? , groupes=? , email=? "
					+ "where idTeacher=?";
			myStmt = myCo.prepareStatement(sql);
			
			//set par
			
			myStmt.setString(1, t.getFirstName());
			myStmt.setString(2, t.getLastName());
			myStmt.setString(3, t.getModule());
			myStmt.setString(4, t.getGroups());
			myStmt.setString(5, t.getEmail());
			myStmt.setInt(6, t.getId());
			
			myStmt.execute();
			
			
			
			
		}finally {
			close(myCo , myStmt , null);
		}
		
	}

	public void deleteTeacher(int id) throws Exception{
		Connection myCo = null;
		PreparedStatement myStmt = null;
		
		try {
			myCo = dataSource.getConnection();
			String sql = "delete from teacher where idTeacher=? ";
			myStmt = myCo.prepareStatement(sql);
			myStmt.setInt(1, id);
			
			myStmt.execute();
		}finally {
			close(myCo , myStmt , null);
		}
		
	}



	public Teacher checkLogin(String userName, String passWord) throws Exception{

		Connection myCo = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Teacher t = null;

		try {
			
			myCo = dataSource.getConnection();
			
			String sql = "select * from teacher where (nom=? and password=?) ";
			
			myStmt = myCo.prepareStatement(sql);
			
			myStmt.setString(1, userName);
			myStmt.setString(2, passWord);
			
			myRs = myStmt.executeQuery();
			
			if(myRs.next()) {

	t = new Teacher(myRs.getInt("idTeacher"), myRs.getString("nom"), myRs.getString("prenom"),myRs.getString("email"), myRs.getString("groupes") , myRs.getString("about"),myRs.getString("module") ,null ,myRs.getString("image"));
			}
		
			
			
			
			
			return t;
		}finally {
			close(myCo , myStmt , myRs);
		}
		
		
		
		
		
	
		
		
	}
	
	
	
	
	
	
	

}
