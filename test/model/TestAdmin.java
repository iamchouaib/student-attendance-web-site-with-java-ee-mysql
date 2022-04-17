package model;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

class TestAdmin{
	
//	private TeacherDbUtil teacherDbUtil;
//	private StudentDbUtil studentDbUtil;
//	private AbsenseDbUtil absentDbUtil;
	private AdminDbUtil adminDb ;
	
	
	

   
	@Test

	public void testLogIn() throws Exception {    // test checkLogin Admin   ====> userName = a , pass = 1 ===> true;
		
        MysqlConnectionPoolDataSource	ds = new MysqlConnectionPoolDataSource();

      ds.setURL("jdbc:mysql://localhost:3306/presense");
      ds.setUser("root");
      ds.setPassword("chouaibe19");
      
     adminDb = new AdminDbUtil(ds);
	
		  assertTrue(adminDb.checkLogin("a", "1")); 
	      assertFalse(adminDb.checkLogin("err", "err"));
	
	}
	
	

}
