package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import junit.framework.TestCase;

class TestTeacher extends TestCase {

	private TeacherDbUtil teacherDb;
	private Teacher t;

	public TestTeacher() {

		t = new Teacher();

		t.setId(1);
		t.setFirstName("chouach");
		t.setLastName("chouaib");
		t.setEmail("chouaibe261@gmail.com");
		t.setGroups("1,2");
		t.setImage("images/chouaib.jpg");
		t.setModule("DAAC");

	}

	@Test
	// chekc login

	public void testLogIn() throws Exception { // test checkLogin Admin ====> userName = a , pass = 1 ===> true;

		MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();

		ds.setURL("jdbc:mysql://localhost:3306/presense");
		ds.setUser("root");
		ds.setPassword("chouaibe19");

		TeacherDbUtil teacherDb = new TeacherDbUtil(ds);

		assertNotEquals(t.toString(), teacherDb.getTeacher("1").toString());

	}

	@Test // getTeacher by Id
	void testTeacher() throws Exception {
		MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
		ds.setURL("jdbc:mysql://localhost:3306/presense");
		ds.setUser("root");
		ds.setPassword("chouaibe19");

		teacherDb = new TeacherDbUtil(ds);

		assertNotEquals(t.toString(), teacherDb.getTeacher("1").toString()); // meme Att ms @defirent

	}


	@Test //addTest 
	
//	void addTeacher() throws Exception {
//        MysqlConnectionPoolDataSource	ds = new MysqlConnectionPoolDataSource();
//
//      ds.setURL("jdbc:mysql://localhost:3306/presense");
//      ds.setUser("root");
//      ds.setPassword("chouaibe19");
//         
//      Teacher tch = new Teacher();
//      tch.setFirstName("test add");
//     
//      int id = 44;
//      
//		teacherDb = new TeacherDbUtil(ds);
//         teacherDb.addTeacher(tch);
//
////verfier si add 
//
//assertEquals(tch.getFirstName(), teacherDb.getTeacher(Integer.toString(id)).getFirstName());
//
//
//
//teacherDb.deleteTeacher(id);
//
//assertNotEquals(tch.getFirstName(), teacherDb.getTeacher(Integer.toString(id)).getFirstName());
//        
//
//	}
	
	public void getTeachers() throws Exception { // test checkLogin Admin ====> userName = a , pass = 1 ===> true;

		MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();

		ds.setURL("jdbc:mysql://localhost:3306/presense");
		ds.setUser("root");
		ds.setPassword("chouaibe19");

		
		List<Teacher> teachers = new ArrayList<Teacher>();
		
		          int sizeBaseDonne  =   7;
		TeacherDbUtil teacherDb = new TeacherDbUtil(ds);
		
		

		assertNotEquals(sizeBaseDonne, teacherDb.getTeacher().size());

	}
	
	


}
