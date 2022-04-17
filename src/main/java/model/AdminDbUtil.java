package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class AdminDbUtil {
	private DataSource dataSource;
	
	public AdminDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	
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





	public  boolean checkLogin(String userName, String password) throws Exception{
		Connection myco = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		boolean check = false;
		try {
			
				myco = dataSource.getConnection();
		
			
			String sql = "select * from admins where ( username=? and password=? ) ";
			
			myStmt = myco.prepareStatement(sql);
			
			myStmt.setString(1, userName);
			myStmt.setString(2, password);
			
			myRs = myStmt.executeQuery();
			
check = myRs.next();
		return check;	

		}finally{
			close(myco , myStmt ,myRs);
		}
		
	}
}
