package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class AbsenseDbUtil {

	DataSource dataSource;
	StudentDbUtil studentDbUtil ;

	public AbsenseDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addSeance(Absense a) throws Exception {

		Connection myCo = null;
		PreparedStatement myStmt = null;

		try {

			int id = Integer.valueOf(a.getTeacher());

			myCo = dataSource.getConnection();
			String sql = "insert into absense (dateSeance, groupe, students, teacherId) values (?, ?, ?, ? ) ";

			myStmt = myCo.prepareStatement(sql);

			myStmt.setString(1, a.getDate());
			myStmt.setInt(2, a.getGroup());
			myStmt.setString(3, a.getStudents());
			myStmt.setInt(4, id);

			myStmt.execute();

		} finally {
			close(myCo, myStmt, null);
		}

	}

	private void close(Connection myCo, PreparedStatement myStmt, ResultSet myRs) {
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

	public boolean checkSeance(String date, String teacherId) throws Exception {

		Connection myCo = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myCo = dataSource.getConnection();

			String sql = "select * from absense where dateSeance =? and teacherId =?";

			myStmt = myCo.prepareStatement(sql);

			myStmt.setString(1, date);
			myStmt.setInt(2, Integer.parseInt(teacherId));


			myRs = myStmt.executeQuery();

			return myRs.next();
		} finally {
			close(myCo, myStmt, myRs);
		}

	}

	public String showAbsense(String date , int id) throws Exception {
		String reponse ;
		Connection myCo = null;
		PreparedStatement mySt = null;
		ResultSet myRs = null;
		
		try {
			String sql = "select * from absense where dateSeance =? and teacherId =? ";
		myCo = dataSource.getConnection();
		mySt =  myCo.prepareStatement(sql);
		mySt.setString(1,date);
		mySt.setInt(2,id);
		myRs = mySt.executeQuery();
		if(myRs.next()) {
		reponse = myRs.getString("students");
		}else {
			reponse = "chouaibe is ";
		}
		
		}finally {
			close(myCo , mySt , myRs);
		}
		
		return reponse;
		
		
		
	}

}
