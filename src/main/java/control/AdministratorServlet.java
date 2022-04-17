package control;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import model.Student;
import model.StudentDbUtil;
import model.Teacher;
import model.TeacherDbUtil;

@WebServlet("/AdministratorServlet")
public class AdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// declaration states

	private TeacherDbUtil teacherDbUtil;
	private StudentDbUtil studentDbUtil;

	// resource jdbc

	@Resource(name = "jdbc/presense")

	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();
		try {

			teacherDbUtil = new TeacherDbUtil(dataSource);
			studentDbUtil = new StudentDbUtil(dataSource);

		} catch (Exception e) {
			throw new ServletException();

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		// get parameter command
		String command = request.getParameter("command");

		try {
			if (command == null) {
				command = "LIST";
			}

			switch (command) {
			case "LIST":
				listTeacher(request, response);
				break;
			case "ADDTEACHER":
				addTeacher(request, response);
				break;
			case "ADDSTUDENT":
				addStudent(request, response);
				break;
			case "LOADTEACHER":
				loadTeacher(request, response);
				break;
			case "LOADSTUDENT":
				loadStudent(request, response);
				break;
			case "UPDATETEACHER":
				upadateTeacher(request, response);
				break;
			case "UPDATESTUDENT":
				upadateStudent(request, response);
				break;

			case "DELETETEACHER":
				deleteTeacher(request, response);
				break;

			case "DELETESTUDENT":
				deleteStudent(request, response);
				break;

			default:
				listTeacher(request, response);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("TeacherID"));

		teacherDbUtil.deleteTeacher(id);

		listTeacher(request, response);

	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read data
		int id = Integer.parseInt(request.getParameter("StudentID"));

		studentDbUtil.deleteStudent(id);

		listTeacher(request, response);

	}

	private void upadateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("StudentID"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String group = request.getParameter("group");

		Student std = new Student(id, nom, prenom, group);

		studentDbUtil.updateStudent(std);
		listTeacher(request, response);

	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentId = request.getParameter("StudentID");
		Student std = studentDbUtil.getStudent(studentId);

		request.setAttribute("The_Student", std);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student.jsp");
		dispatcher.forward(request, response);

	}

	private void upadateTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Read info
		int id = Integer.parseInt(request.getParameter("teacherID"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String groups = request.getParameter("groups");
		String module = request.getParameter("module");
		String password = request.getParameter("password");
		// create obj
		Teacher t = new Teacher(id, nom, prenom,null, groups,null, module , password,null);

		// update
		teacherDbUtil.updateTeacher(t);
		listTeacher(request, response);

	}

	private void loadTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String teacherId = request.getParameter("TeacherID");

		Teacher t = teacherDbUtil.getTeacher(teacherId);

		request.setAttribute("The_Teacher", t);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-teacher.jsp");
		dispatcher.forward(request, response);

	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String group = request.getParameter("group");

		Student std = new Student(0, nom, prenom, group);

		studentDbUtil.addStudent(std);

		listTeacher(request, response);

	}

	private void addTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read data from form
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String groups = request.getParameter("groups");
		String module = request.getParameter("module");

		// creat obj
		Teacher t = new Teacher(0,nom, prenom,null, groups,null, module,null,null);

		// add obj to db
		teacherDbUtil.addTeacher(t);
		// send back to list
		listTeacher(request, response);
	}

	private void listTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get Teacher from base donne
		List<Teacher> teachers = teacherDbUtil.getTeacher();
		List<Student> students = studentDbUtil.getStudents();
		// ajouter result to request attr
		request.setAttribute("TEACHERS", teachers);
		request.setAttribute("STUDENTS", students);
		// send jsp disptcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-Teachers.jsp");
		dispatcher.forward(request, response);

	}


}
